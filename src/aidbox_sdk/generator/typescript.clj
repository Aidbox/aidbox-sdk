(ns aidbox-sdk.generator.typescript
  (:require
   [aidbox-sdk.generator :as generator]
   [aidbox-sdk.generator.helpers :refer [->pascal-case ->camel-case]]
   [aidbox-sdk.generator.utils :as u]
   [clojure.java.io :as io]
   [clojure.string :as str]
   [aidbox-sdk.fhir :as fhir])
  (:import
   [aidbox_sdk.generator CodeGenerator]))

(def reserved-names #{"RequestPriority"})
(def valuset-exception #{"SubscriptionStatus"})

(defn package->directory
  "Generates directory name from package name.
  Example:
  hl7.fhir.r4.core -> hl7-fhir-r4-core"
  [x]
  (str/replace x #"[\.#]" "-"))

(defn resource-file-path [ir-schema]
  (io/file "types"
           (package->directory (:package ir-schema))
           (str (->pascal-case (:resource-name ir-schema)) ".ts")))

(defn search-param-filepath [ir-schema]
  (io/file "types" "search" (str (:name ir-schema) "SearchParameters.ts")))

(defn ->lang-type [fhir-type]
  (case fhir-type
    ;; Primitive Types
    "boolean"      "boolean"
    "instant"      "string"
    "time"         "string"
    "date"         "string"
    "dateTime"     "string"
    "decimal"      "number"

    "integer"      "number"
    "unsignedInt"  "number"
    "positiveInt"  "number"

    "integer64"    "number"
    "base64Binary" "string"

    "uri"          "string"
    "url"          "string"
    "canonical"    "string"
    "oid"          "string"
    "uuid"         "string"

    "string"       "string"
    "code"         "string"
    "markdown"     "string"
    "id"           "string"
    "xhtml"        "string"

    ;; hardcoded just in case
    "Meta"         "Meta"
    ;; else
    fhir-type))

(defn class-name
  "Generate class name from schema resource name."
  [resource-name]
  (let [name' (->pascal-case resource-name)]
    (if (contains? reserved-names name')
      (str name' "_")
      name')))

(defn valueset-name [type-name]
  (let [name' (class-name type-name)]
    (if (contains? valuset-exception name')
      (str name' "VS")
      name')))

(defn generate-polymorphic-property [{:keys [name required choices]}]
  (let [type (->> choices
                  (map :type)
                  (map ->lang-type)
                  distinct
                  (str/join " | "))]
    (str name (when-not required "?") ": " type ";")))

(defn ->backbone-type [element]
  (str/replace (str (:base element) (->pascal-case (:name element))) #"[_-]" ""))

(defn generate-property [{:keys [name array required type choices profile fhir-version] :as element}]
  (let [optional (if required "" "?")]
    (cond choices
          (generate-polymorphic-property element)

          (= type "Meta")
          (if profile
            (format "%s%s: Meta & { profile: [\"%s\"] };" name optional profile)
            (format "%s%s: Meta;" name optional))

          :else
          (let [type' (cond
                        (= "BackboneElement" type)
                        (->backbone-type element)

                        (:valueset element)
                        (valueset-name (:valueset element))

                        :else
                        (->lang-type (:type element)))
                primitive-type? (fhir/primitive-element? fhir-version element)]
            (str (str (->camel-case name) optional ": " type' (when array "[]") ";")
                 (when primitive-type?
                   (str "\n" u/indent "_" (->camel-case name) "?: Element;")))))))

(defn generate-class
  "Generates TypeScript type from IR (intermediate representation) schema."
  [ir-schema & [inner-classes]]
  (let [base-class (class-name (or (:base-resource-name ir-schema)
                                   ;; need for BackboneElement
                                   (:base ir-schema)
                                   ""))
        class-name' (class-name (or (:resource-name ir-schema)
                                    ;; need for BackboneElement
                                    (:name ir-schema)
                                    ""))
        properties (->> (:elements ir-schema)
                        (remove #(:choices %))
                        (map #(assoc % :fhir-version (:fhir-version ir-schema)))
                        (map generate-property)
                        (flatten)
                        (remove nil?)
                        ((fn [props] (if (or
                                         (fhir/base-type? ir-schema)
                                         (not (fhir/resource? ir-schema))
                                         (contains? (set (map :name (:elements ir-schema))) "resourceType"))
                                       props
                                       (conj props (format "resourceType: '%s'" class-name')))))
                        (map u/add-indent)
                        (str/join "\n"))]

    (str
     (when (seq inner-classes)
       (str (str/join "\n\n" inner-classes) "\n\n"))

     "export type " class-name' " = "
     (cond
       ;; base class and properties
       (and (seq properties)
            (not (str/blank? base-class)))
       (str base-class " & {\n" properties "\n}")

       ;; no base class / yes properties
       ;; export type Something = { ... }
       (and (seq properties)
            (str/blank? base-class))
       (str "{\n" properties "\n}")

       ;; yes base class / no properties
       ;; export type DataType = Element;
       (and (empty? properties)
            (not (str/blank? base-class)))
       base-class

       ;; no base class / no propeties
       ;; export type Base = {};
       (and (empty? properties)
            (str/blank? base-class))
       "{}")

     ";")))

(defn- path->name [path]
  (str/replace path #"(\.ts)|[\.\/]" ""))

(defn generate-deps
  "Takes an IR schema generates import declarations."
  [ir-schema]
  (let [relative-path (if (fhir/base-package? ir-schema)
                        "./"
                        (str "../" (package->directory (:fhir-version ir-schema)) "/"))
        valueset-deps (when
                       (seq (:valueset-deps ir-schema))
                        (format "import { %s } from '%svaluesets';"
                                (->> (:valueset-deps ir-schema)
                                     (map valueset-name)
                                     (str/join ", "))
                                relative-path))]
    (str (->> (:deps ir-schema)
              (map class-name)
              (map (fn [d] {:module (str relative-path d) :members [d]}))
              (map (fn [{:keys [module members]}]
                     (if (seq members)
                       (format "import { %s } from \"%s\";"
                               (str/join ", " members)
                               module)
                       (format "import * as %s from \"%s\";"
                               (path->name module)
                               module))))
              (str/join "\n"))
         (when valueset-deps
           (str
            "\n"
            valueset-deps)))))

(defn generate-module
  [& {:keys [deps classes]
      :or {classes []}}]
  (->> (conj []
             deps
             classes)
       (flatten)
       (str/join "\n\n")))

(defn index-exports [schemas]
  (let [names (->> schemas
                   (remove fhir/primitive-type?)
                   (remove fhir/extension?)
                   (remove fhir/logical?)
                   (map (fn [schema] (class-name (:resource-name schema))))
                   sort)]
    (conj (mapv (fn [class-name']
                  (format "import { %s } from './%s';" class-name' class-name'))
                names)
          (format "export { %s };" (str/join ", " names)))))

(defn resource-type-map [schemas]
  (flatten ["export type ResourceTypeMap = {"
            (u/add-indent "User: Record<string, any>;")
            (->> schemas
                 (remove fhir/primitive-type?)
                 (remove fhir/extension?)
                 (remove fhir/logical?)
                 (map (fn [schema] (class-name (:resource-name schema))))
                 sort
                 (map (fn [name']
                        (format "%s: %s;" name' name')))
                 (map u/add-indent))
            "};"
            "export type ResourceType = keyof ResourceTypeMap;"
            (str/split-lines "export interface SearchParams extends Record<ResourceType, unknown> {\n    'DeviceRequest': {\n        'device': `${ResourceType}/${string}`;\n        'based-on': `${ResourceType}/${string}`;\n        'requester': `${ResourceType}/${string}`;\n        'instantiates-uri': string;\n        'prior-request': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'group-identifier': string;\n        'status': string;\n        'insurance': `${ResourceType}/${string}`;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'event-date': string;\n        'intent': string;\n        'patient': `${ResourceType}/${string}`;\n        'instantiates-canonical': `${ResourceType}/${string}`;\n        'code': string;\n        'performer': `${ResourceType}/${string}`;\n        'authored-on': string;\n    };\n    'ServiceRequest': {\n        'priority': string;\n        'based-on': `${ResourceType}/${string}`;\n        'requester': `${ResourceType}/${string}`;\n        'body-site': string;\n        'instantiates-uri': string;\n        'authored': string;\n        'requisition': string;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'specimen': `${ResourceType}/${string}`;\n        'occurrence': string;\n        'intent': string;\n        'replaces': `${ResourceType}/${string}`;\n        'category': string;\n        'instantiates-canonical': `${ResourceType}/${string}`;\n        'performer-type': string;\n        'performer': `${ResourceType}/${string}`;\n    };\n    'DeviceMetric': {\n        'parent': `${ResourceType}/${string}`;\n        'identifier': string;\n        'source': `${ResourceType}/${string}`;\n        'type': string;\n        'category': string;\n    };\n    'CarePlan': {\n        'activity-code': string;\n        'based-on': `${ResourceType}/${string}`;\n        'instantiates-uri': string;\n        'condition': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'part-of': `${ResourceType}/${string}`;\n        'activity-reference': `${ResourceType}/${string}`;\n        'care-team': `${ResourceType}/${string}`;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'intent': string;\n        'date': string;\n        'replaces': `${ResourceType}/${string}`;\n        'category': string;\n        'instantiates-canonical': `${ResourceType}/${string}`;\n        'activity-date': string;\n        'performer': `${ResourceType}/${string}`;\n        'goal': `${ResourceType}/${string}`;\n    };\n    'Observation': {\n        'dna-variant': string;\n        'component-value-quantity': string;\n        'device': `${ResourceType}/${string}`;\n        'amino-acid-change': string;\n        'component-value-concept': string;\n        'code-value-quantity': string;\n        'based-on': `${ResourceType}/${string}`;\n        'combo-data-absent-reason': string;\n        'gene-dnavariant': string;\n        'code-value-date': string;\n        'has-member': `${ResourceType}/${string}`;\n        'component-code-value-quantity': string;\n        'component-data-absent-reason': string;\n        'method': string;\n        'focus': `${ResourceType}/${string}`;\n        'component-code-value-concept': string;\n        'code-value-string': string;\n        'value-date': string;\n        'combo-code': string;\n        'value-quantity': string;\n        'part-of': `${ResourceType}/${string}`;\n        'combo-value-concept': string;\n        'component-code': string;\n        'gene-identifier': string;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'specimen': `${ResourceType}/${string}`;\n        'combo-value-quantity': string;\n        'value-string': string;\n        'gene-amino-acid-change': string;\n        'combo-code-value-quantity': string;\n        'category': string;\n        'data-absent-reason': string;\n        'value-concept': string;\n        'code-value-concept': string;\n        'derived-from': `${ResourceType}/${string}`;\n        'combo-code-value-concept': string;\n        'performer': `${ResourceType}/${string}`;\n    };\n    'EnrollmentRequest': {\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n    };\n    'Group': {\n        'member': `${ResourceType}/${string}`;\n        'managing-entity': `${ResourceType}/${string}`;\n        'value': string;\n        'identifier': string;\n        'characteristic': string;\n        'type': string;\n        'exclude': string;\n        'characteristic-value': string;\n        'actual': string;\n        'code': string;\n    };\n    'MessageDefinition': {\n        'context-quantity': string;\n        'url': string;\n        'context-type': string;\n        'context-type-quantity': string;\n        'parent': `${ResourceType}/${string}`;\n        'focus': string;\n        'event': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'category': string;\n        'description': string;\n        'context-type-value': string;\n    };\n    'Appointment': {\n        'specialty': string;\n        'based-on': `${ResourceType}/${string}`;\n        'service-category': string;\n        'reason-reference': `${ResourceType}/${string}`;\n        'slot': `${ResourceType}/${string}`;\n        'practitioner': `${ResourceType}/${string}`;\n        'service-type': string;\n        'location': `${ResourceType}/${string}`;\n        'appointment-type': string;\n        'status': string;\n        'identifier': string;\n        'supporting-info': `${ResourceType}/${string}`;\n        'date': string;\n        'patient': `${ResourceType}/${string}`;\n        'part-status': string;\n        'reason-code': string;\n        'actor': `${ResourceType}/${string}`;\n    };\n    'QuestionnaireResponse': {\n        'based-on': `${ResourceType}/${string}`;\n        'author': `${ResourceType}/${string}`;\n        'authored': string;\n        'encounter': `${ResourceType}/${string}`;\n        'part-of': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'item-subject': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'questionnaire': `${ResourceType}/${string}`;\n        'source': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n    };\n    'EffectEvidenceSynthesis': {\n        'context-quantity': string;\n        'url': string;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'effective': string;\n        'description': string;\n        'context-type-value': string;\n    };\n    'MedicinalProductContraindication': {\n        'subject': `${ResourceType}/${string}`;\n    };\n    'EpisodeOfCare': {\n        'condition': `${ResourceType}/${string}`;\n        'status': string;\n        'incoming-referral': `${ResourceType}/${string}`;\n        'organization': `${ResourceType}/${string}`;\n        'care-manager': `${ResourceType}/${string}`;\n    };\n    'Evidence': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'SupplyDelivery': {\n        'status': string;\n        'receiver': `${ResourceType}/${string}`;\n        'supplier': `${ResourceType}/${string}`;\n    };\n    'AdverseEvent': {\n        'resultingcondition': `${ResourceType}/${string}`;\n        'event': string;\n        'seriousness': string;\n        'location': `${ResourceType}/${string}`;\n        'study': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'recorder': `${ResourceType}/${string}`;\n        'substance': `${ResourceType}/${string}`;\n        'actuality': string;\n        'date': string;\n        'category': string;\n        'severity': string;\n    };\n    'Endpoint': {\n        'connection-type': string;\n        'name': string;\n        'status': string;\n        'identifier': string;\n        'organization': `${ResourceType}/${string}`;\n        'payload-type': string;\n    };\n    'CompartmentDefinition': {\n        'resource': string;\n        'code': string;\n    };\n    'DetectedIssue': {\n        'implicated': `${ResourceType}/${string}`;\n        'identified': string;\n        'author': `${ResourceType}/${string}`;\n        'code': string;\n    };\n    'MedicationAdministration': {\n        'device': `${ResourceType}/${string}`;\n        'context': `${ResourceType}/${string}`;\n        'status': string;\n        'request': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'reason-given': string;\n        'medication': `${ResourceType}/${string}`;\n        'reason-not-given': string;\n        'effective-time': string;\n        'performer': `${ResourceType}/${string}`;\n    };\n    'EvidenceVariable': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'ImplementationGuide': {\n        'resource': `${ResourceType}/${string}`;\n        'experimental': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'global': `${ResourceType}/${string}`;\n    };\n    'Goal': {\n        'target-date': string;\n        'achievement-status': string;\n        'lifecycle-status': string;\n        'subject': `${ResourceType}/${string}`;\n        'category': string;\n        'start-date': string;\n    };\n    'Communication': {\n        'sent': string;\n        'based-on': `${ResourceType}/${string}`;\n        'instantiates-uri': string;\n        'recipient': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'medium': string;\n        'part-of': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'received': string;\n        'patient': `${ResourceType}/${string}`;\n        'category': string;\n        'instantiates-canonical': `${ResourceType}/${string}`;\n        'sender': `${ResourceType}/${string}`;\n    };\n    'Schedule': {\n        'specialty': string;\n        'service-category': string;\n        'service-type': string;\n        'identifier': string;\n        'date': string;\n        'active': string;\n        'actor': `${ResourceType}/${string}`;\n    };\n    'DocumentReference': {\n        'author': `${ResourceType}/${string}`;\n        'related': `${ResourceType}/${string}`;\n        'security-label': string;\n        'event': string;\n        'setting': string;\n        'relationship': string;\n        'location': string;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'authenticator': `${ResourceType}/${string}`;\n        'facility': string;\n        'date': string;\n        'category': string;\n        'contenttype': string;\n        'period': string;\n        'custodian': `${ResourceType}/${string}`;\n        'language': string;\n        'description': string;\n        'format': string;\n        'relation': string;\n        'relatesto': `${ResourceType}/${string}`;\n    };\n    'OrganizationAffiliation': {\n        'role': string;\n        'specialty': string;\n        'email': string;\n        'network': `${ResourceType}/${string}`;\n        'location': `${ResourceType}/${string}`;\n        'identifier': string;\n        'phone': string;\n        'date': string;\n        'endpoint': `${ResourceType}/${string}`;\n        'telecom': string;\n        'service': `${ResourceType}/${string}`;\n        'active': string;\n        'participating-organization': `${ResourceType}/${string}`;\n        'primary-organization': `${ResourceType}/${string}`;\n    };\n    'DeviceDefinition': {\n        'parent': `${ResourceType}/${string}`;\n        'identifier': string;\n        'type': string;\n    };\n    'Coverage': {\n        'class-type': string;\n        'policy-holder': `${ResourceType}/${string}`;\n        'class-value': string;\n        'beneficiary': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'payor': `${ResourceType}/${string}`;\n        'type': string;\n        'patient': `${ResourceType}/${string}`;\n        'subscriber': `${ResourceType}/${string}`;\n        'dependent': string;\n    };\n    'AuditEvent': {\n        'agent-name': string;\n        'entity-role': string;\n        'subtype': string;\n        'agent': `${ResourceType}/${string}`;\n        'entity-type': string;\n        'altid': string;\n        'entity-name': string;\n        'address': string;\n        'action': string;\n        'site': string;\n        'policy': string;\n        'source': `${ResourceType}/${string}`;\n        'agent-role': string;\n        'type': string;\n        'date': string;\n        'patient': `${ResourceType}/${string}`;\n        'entity': `${ResourceType}/${string}`;\n        'outcome': string;\n    };\n    'MessageHeader': {\n        'destination': string;\n        'source-uri': string;\n        'author': `${ResourceType}/${string}`;\n        'focus': `${ResourceType}/${string}`;\n        'event': string;\n        'responsible': `${ResourceType}/${string}`;\n        'enterer': `${ResourceType}/${string}`;\n        'receiver': `${ResourceType}/${string}`;\n        'response-id': string;\n        'destination-uri': string;\n        'source': string;\n        'target': `${ResourceType}/${string}`;\n        'sender': `${ResourceType}/${string}`;\n        'code': string;\n    };\n    'Contract': {\n        'url': string;\n        'signer': `${ResourceType}/${string}`;\n        'authority': `${ResourceType}/${string}`;\n        'issued': string;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'domain': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n        'instantiates': string;\n    };\n    'TestReport': {\n        'issued': string;\n        'tester': string;\n        'participant': string;\n        'identifier': string;\n        'testscript': `${ResourceType}/${string}`;\n        'result': string;\n    };\n    'CodeSystem': {\n        'supplements': `${ResourceType}/${string}`;\n        'identifier': string;\n        'system': string;\n        'content-mode': string;\n        'language': string;\n        'code': string;\n    };\n    'PlanDefinition': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'definition': `${ResourceType}/${string}`;\n        'jurisdiction': string;\n        'title': string;\n        'type': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'Invoice': {\n        'totalnet': string;\n        'participant-role': string;\n        'issuer': `${ResourceType}/${string}`;\n        'recipient': `${ResourceType}/${string}`;\n        'participant': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'account': `${ResourceType}/${string}`;\n        'totalgross': string;\n        'type': string;\n        'date': string;\n        'patient': `${ResourceType}/${string}`;\n    };\n    'ClaimResponse': {\n        'created': string;\n        'requestor': `${ResourceType}/${string}`;\n        'payment-date': string;\n        'insurer': `${ResourceType}/${string}`;\n        'disposition': string;\n        'status': string;\n        'request': `${ResourceType}/${string}`;\n        'identifier': string;\n        'patient': `${ResourceType}/${string}`;\n        'use': string;\n        'outcome': string;\n    };\n    'ChargeItem': {\n        'performing-organization': `${ResourceType}/${string}`;\n        'requesting-organization': `${ResourceType}/${string}`;\n        'performer-function': string;\n        'performer-actor': `${ResourceType}/${string}`;\n        'entered-date': string;\n        'quantity': string;\n        'context': `${ResourceType}/${string}`;\n        'enterer': `${ResourceType}/${string}`;\n        'price-override': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'account': `${ResourceType}/${string}`;\n        'occurrence': string;\n        'patient': `${ResourceType}/${string}`;\n        'service': `${ResourceType}/${string}`;\n        'code': string;\n        'factor-override': number;\n    };\n    'CoverageEligibilityResponse': {\n        'created': string;\n        'requestor': `${ResourceType}/${string}`;\n        'insurer': `${ResourceType}/${string}`;\n        'disposition': string;\n        'status': string;\n        'request': `${ResourceType}/${string}`;\n        'identifier': string;\n        'patient': `${ResourceType}/${string}`;\n        'outcome': string;\n    };\n    'BodyStructure': {\n        'location': string;\n        'identifier': string;\n        'morphology': string;\n        'patient': `${ResourceType}/${string}`;\n    };\n    'ClinicalImpression': {\n        'assessor': `${ResourceType}/${string}`;\n        'finding-code': string;\n        'encounter': `${ResourceType}/${string}`;\n        'investigation': `${ResourceType}/${string}`;\n        'previous': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'finding-ref': `${ResourceType}/${string}`;\n        'supporting-info': `${ResourceType}/${string}`;\n        'problem': `${ResourceType}/${string}`;\n    };\n    'FamilyMemberHistory': {\n        'instantiates-uri': string;\n        'relationship': string;\n        'status': string;\n        'sex': string;\n        'instantiates-canonical': `${ResourceType}/${string}`;\n    };\n    'MedicinalProductAuthorization': {\n        'holder': `${ResourceType}/${string}`;\n        'country': string;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n    };\n    'Composition': {\n        'entry': `${ResourceType}/${string}`;\n        'related-id': string;\n        'author': `${ResourceType}/${string}`;\n        'related-ref': `${ResourceType}/${string}`;\n        'confidentiality': string;\n        'attester': `${ResourceType}/${string}`;\n        'section': string;\n        'context': string;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'title': string;\n        'category': string;\n        'period': string;\n    };\n    'PractitionerRole': {\n        'role': string;\n        'specialty': string;\n        'practitioner': `${ResourceType}/${string}`;\n        'location': `${ResourceType}/${string}`;\n        'identifier': string;\n        'date': string;\n        'endpoint': `${ResourceType}/${string}`;\n        'service': `${ResourceType}/${string}`;\n        'active': string;\n        'organization': `${ResourceType}/${string}`;\n    };\n    'HealthcareService': {\n        'specialty': string;\n        'service-category': string;\n        'coverage-area': `${ResourceType}/${string}`;\n        'service-type': string;\n        'name': string;\n        'location': `${ResourceType}/${string}`;\n        'identifier': string;\n        'characteristic': string;\n        'endpoint': `${ResourceType}/${string}`;\n        'active': string;\n        'organization': `${ResourceType}/${string}`;\n        'program': string;\n    };\n    'Patient': {\n        'address-use': string;\n        'address-country': string;\n        'part-agree': `${ResourceType}/${string}`;\n        'death-date': string;\n        'mothersMaidenName': string;\n        'gender': string;\n        'email': string;\n        'address-city': string;\n        'name': string;\n        'general-practitioner': `${ResourceType}/${string}`;\n        'address-state': string;\n        'address': string;\n        'identifier': string;\n        'given': string;\n        'link': `${ResourceType}/${string}`;\n        'family': string;\n        'phone': string;\n        'phonetic': string;\n        'birthdate': string;\n        'telecom': string;\n        'active': string;\n        'language': string;\n        'organization': `${ResourceType}/${string}`;\n        'deceased': string;\n        'address-postalcode': string;\n    };\n    'MedicationDispense': {\n        'destination': `${ResourceType}/${string}`;\n        'prescription': `${ResourceType}/${string}`;\n        'whenprepared': string;\n        'context': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'receiver': `${ResourceType}/${string}`;\n        'type': string;\n        'whenhandedover': string;\n        'performer': `${ResourceType}/${string}`;\n        'responsibleparty': `${ResourceType}/${string}`;\n    };\n    'DeviceUseStatement': {\n        'device': `${ResourceType}/${string}`;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n    };\n    'ImmunizationEvaluation': {\n        'dose-status': string;\n        'status': string;\n        'identifier': string;\n        'target-disease': string;\n        'date': string;\n        'patient': `${ResourceType}/${string}`;\n        'immunization-event': `${ResourceType}/${string}`;\n    };\n    'Library': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'content-type': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'type': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'Basic': {\n        'created': string;\n        'author': `${ResourceType}/${string}`;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n        'code': string;\n    };\n    'Slot': {\n        'specialty': string;\n        'service-category': string;\n        'service-type': string;\n        'schedule': `${ResourceType}/${string}`;\n        'appointment-type': string;\n        'status': string;\n        'start': string;\n        'identifier': string;\n    };\n    'ActivityDefinition': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'Bundle': {\n        'message': `${ResourceType}/${string}`;\n        'timestamp': string;\n        'identifier': string;\n        'composition': `${ResourceType}/${string}`;\n        'type': string;\n    };\n    'MedicinalProductInteraction': {\n        'subject': `${ResourceType}/${string}`;\n    };\n    'MolecularSequence': {\n        'chromosome': string;\n        'window-end': number;\n        'chromosome-window-coordinate': string;\n        'window-start': number;\n        'referenceseqid': string;\n        'variant-start': number;\n        'identifier': string;\n        'referenceseqid-variant-coordinate': string;\n        'chromosome-variant-coordinate': string;\n        'type': string;\n        'variant-end': number;\n        'patient': `${ResourceType}/${string}`;\n        'referenceseqid-window-coordinate': string;\n    };\n    'Specimen': {\n        'parent': `${ResourceType}/${string}`;\n        'accession': string;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'collected': string;\n        'bodysite': string;\n        'type': string;\n        'patient': `${ResourceType}/${string}`;\n        'container-id': string;\n        'container': string;\n        'collector': `${ResourceType}/${string}`;\n    };\n    'DiagnosticReport': {\n        'media': `${ResourceType}/${string}`;\n        'based-on': `${ResourceType}/${string}`;\n        'issued': string;\n        'conclusion': string;\n        'status': string;\n        'assessed-condition': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'specimen': `${ResourceType}/${string}`;\n        'category': string;\n        'result': `${ResourceType}/${string}`;\n        'results-interpreter': `${ResourceType}/${string}`;\n        'performer': `${ResourceType}/${string}`;\n    };\n    'Subscription': {\n        'url': string;\n        'status': string;\n        'type': string;\n        'criteria': string;\n        'payload': string;\n        'contact': string;\n    };\n    'RequestGroup': {\n        'priority': string;\n        'instantiates-uri': string;\n        'author': `${ResourceType}/${string}`;\n        'authored': string;\n        'encounter': `${ResourceType}/${string}`;\n        'group-identifier': string;\n        'participant': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'intent': string;\n        'patient': `${ResourceType}/${string}`;\n        'instantiates-canonical': `${ResourceType}/${string}`;\n        'code': string;\n    };\n    'Provenance': {\n        'agent': `${ResourceType}/${string}`;\n        'recorded': string;\n        'agent-type': string;\n        'location': `${ResourceType}/${string}`;\n        'when': string;\n        'signature-type': string;\n        'agent-role': string;\n        'target': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n        'entity': `${ResourceType}/${string}`;\n    };\n    'MedicinalProduct': {\n        'name': string;\n        'identifier': string;\n        'name-language': string;\n    };\n    'ChargeItemDefinition': {\n        'context-quantity': string;\n        'url': string;\n        'context-type': string;\n        'context-type-quantity': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'effective': string;\n        'description': string;\n        'context-type-value': string;\n    };\n    'Practitioner': {\n        'name': string;\n        'identifier': string;\n        'communication': string;\n        'active': string;\n    };\n    'MedicinalProductPackaged': {\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n    };\n    'Flag': {\n        'author': `${ResourceType}/${string}`;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n    };\n    'ExplanationOfBenefit': {\n        'coverage': `${ResourceType}/${string}`;\n        'created': string;\n        'payee': `${ResourceType}/${string}`;\n        'detail-udi': `${ResourceType}/${string}`;\n        'subdetail-udi': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'disposition': string;\n        'provider': `${ResourceType}/${string}`;\n        'procedure-udi': `${ResourceType}/${string}`;\n        'claim': `${ResourceType}/${string}`;\n        'care-team': `${ResourceType}/${string}`;\n        'enterer': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'facility': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n        'item-udi': `${ResourceType}/${string}`;\n    };\n    'Linkage': {\n        'author': `${ResourceType}/${string}`;\n        'item': `${ResourceType}/${string}`;\n        'source': `${ResourceType}/${string}`;\n    };\n    'MedicinalProductPharmaceutical': {\n        'target-species': string;\n        'route': string;\n        'identifier': string;\n    };\n    'Immunization': {\n        'reason-reference': `${ResourceType}/${string}`;\n        'manufacturer': `${ResourceType}/${string}`;\n        'reaction': `${ResourceType}/${string}`;\n        'location': `${ResourceType}/${string}`;\n        'status': string;\n        'target-disease': string;\n        'reaction-date': string;\n        'status-reason': string;\n        'series': string;\n        'vaccine-code': string;\n        'reason-code': string;\n        'lot-number': string;\n        'performer': `${ResourceType}/${string}`;\n    };\n    'MedicationKnowledge': {\n        'manufacturer': `${ResourceType}/${string}`;\n        'ingredient-code': string;\n        'monitoring-program-name': string;\n        'status': string;\n        'monitoring-program-type': string;\n        'ingredient': `${ResourceType}/${string}`;\n        'monograph-type': string;\n        'doseform': string;\n        'classification-type': string;\n        'code': string;\n        'source-cost': string;\n        'monograph': `${ResourceType}/${string}`;\n        'classification': string;\n    };\n    'ResearchSubject': {\n        'individual': `${ResourceType}/${string}`;\n        'status': string;\n        'study': `${ResourceType}/${string}`;\n        'identifier': string;\n        'date': string;\n        'patient': `${ResourceType}/${string}`;\n    };\n    'MedicinalProductIndication': {\n        'subject': `${ResourceType}/${string}`;\n    };\n    'PaymentNotice': {\n        'created': string;\n        'payment-status': string;\n        'provider': `${ResourceType}/${string}`;\n        'status': string;\n        'request': `${ResourceType}/${string}`;\n        'identifier': string;\n        'response': `${ResourceType}/${string}`;\n    };\n    'NamingSystem': {\n        'id-type': string;\n        'responsible': string;\n        'value': string;\n        'kind': string;\n        'type': string;\n        'telecom': string;\n        'period': string;\n        'contact': string;\n    };\n    'MedicationStatement': {\n        'part-of': `${ResourceType}/${string}`;\n        'context': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'source': `${ResourceType}/${string}`;\n        'category': string;\n        'effective': string;\n    };\n    'EnrollmentResponse': {\n        'status': string;\n        'request': `${ResourceType}/${string}`;\n        'identifier': string;\n    };\n    'NutritionOrder': {\n        'supplement': string;\n        'oraldiet': string;\n        'instantiates-uri': string;\n        'provider': `${ResourceType}/${string}`;\n        'status': string;\n        'datetime': string;\n        'additive': string;\n        'instantiates-canonical': `${ResourceType}/${string}`;\n        'formula': string;\n    };\n    'Questionnaire': {\n        'context-quantity': string;\n        'url': string;\n        'context-type': string;\n        'context-type-quantity': string;\n        'subject-type': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'definition': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'code': string;\n        'effective': string;\n        'description': string;\n        'context-type-value': string;\n    };\n    'Account': {\n        'owner': `${ResourceType}/${string}`;\n        'name': string;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'type': string;\n        'patient': `${ResourceType}/${string}`;\n        'period': string;\n    };\n    'EventDefinition': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'MedicinalProductUndesirableEffect': {\n        'subject': `${ResourceType}/${string}`;\n    };\n    'SubstanceSpecification': {\n        'code': string;\n    };\n    'CommunicationRequest': {\n        'priority': string;\n        'based-on': `${ResourceType}/${string}`;\n        'requester': `${ResourceType}/${string}`;\n        'recipient': `${ResourceType}/${string}`;\n        'authored': string;\n        'encounter': `${ResourceType}/${string}`;\n        'medium': string;\n        'group-identifier': string;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'occurrence': string;\n        'replaces': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n        'category': string;\n        'sender': `${ResourceType}/${string}`;\n    };\n    'SpecimenDefinition': {\n        'identifier': string;\n        'type': string;\n        'container': string;\n    };\n    'VerificationResult': {\n        'target': `${ResourceType}/${string}`;\n    };\n    'DocumentManifest': {\n        'related-id': string;\n        'created': string;\n        'author': `${ResourceType}/${string}`;\n        'related-ref': `${ResourceType}/${string}`;\n        'recipient': `${ResourceType}/${string}`;\n        'status': string;\n        'item': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'source': string;\n        'description': string;\n    };\n    'Task': {\n        'owner': `${ResourceType}/${string}`;\n        'priority': string;\n        'based-on': `${ResourceType}/${string}`;\n        'requester': `${ResourceType}/${string}`;\n        'focus': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'part-of': `${ResourceType}/${string}`;\n        'group-identifier': string;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'intent': string;\n        'modified': string;\n        'patient': `${ResourceType}/${string}`;\n        'period': string;\n        'code': string;\n        'performer': string;\n        'authored-on': string;\n        'business-status': string;\n    };\n    'RiskEvidenceSynthesis': {\n        'context-quantity': string;\n        'url': string;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'effective': string;\n        'description': string;\n        'context-type-value': string;\n    };\n    'ValueSet': {\n        'expansion': string;\n        'reference': string;\n        'code': string;\n    };\n    'Claim': {\n        'created': string;\n        'priority': string;\n        'payee': `${ResourceType}/${string}`;\n        'insurer': `${ResourceType}/${string}`;\n        'detail-udi': `${ResourceType}/${string}`;\n        'subdetail-udi': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'provider': `${ResourceType}/${string}`;\n        'procedure-udi': `${ResourceType}/${string}`;\n        'care-team': `${ResourceType}/${string}`;\n        'enterer': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'facility': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n        'use': string;\n        'item-udi': `${ResourceType}/${string}`;\n    };\n    'InsurancePlan': {\n        'address-use': string;\n        'owned-by': `${ResourceType}/${string}`;\n        'address-country': string;\n        'address-city': string;\n        'name': string;\n        'address-state': string;\n        'address': string;\n        'status': string;\n        'identifier': string;\n        'type': string;\n        'phonetic': string;\n        'endpoint': `${ResourceType}/${string}`;\n        'administered-by': `${ResourceType}/${string}`;\n        'address-postalcode': string;\n    };\n    'ExampleScenario': {\n        'context-quantity': string;\n        'url': string;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'context-type-value': string;\n    };\n    'ResearchStudy': {\n        'protocol': `${ResourceType}/${string}`;\n        'partof': `${ResourceType}/${string}`;\n        'principalinvestigator': `${ResourceType}/${string}`;\n        'focus': string;\n        'location': string;\n        'status': string;\n        'identifier': string;\n        'keyword': string;\n        'sponsor': `${ResourceType}/${string}`;\n        'site': `${ResourceType}/${string}`;\n        'title': string;\n        'date': string;\n        'category': string;\n    };\n    'MedicationRequest': {\n        'intended-performertype': string;\n        'priority': string;\n        'requester': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'intended-performer': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'authoredon': string;\n        'intent': string;\n        'date': string;\n        'category': string;\n        'intended-dispenser': `${ResourceType}/${string}`;\n    };\n    'Measure': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'List': {\n        'status': string;\n        'item': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'title': string;\n        'source': `${ResourceType}/${string}`;\n        'notes': string;\n        'empty-reason': string;\n    };\n    'Resource': {\n        '_source': string;\n        '_lastUpdated': string;\n        '_profile': string;\n        '_tag': string;\n        '_id': string;\n        '_security': string;\n    };\n    'Encounter': {\n        'based-on': `${ResourceType}/${string}`;\n        'reason-reference': `${ResourceType}/${string}`;\n        'service-provider': `${ResourceType}/${string}`;\n        'class': string;\n        'practitioner': `${ResourceType}/${string}`;\n        'diagnosis': `${ResourceType}/${string}`;\n        'part-of': `${ResourceType}/${string}`;\n        'special-arrangement': string;\n        'location': `${ResourceType}/${string}`;\n        'participant': `${ResourceType}/${string}`;\n        'episode-of-care': `${ResourceType}/${string}`;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'account': `${ResourceType}/${string}`;\n        'length': string;\n        'appointment': `${ResourceType}/${string}`;\n        'location-period': string;\n        'reason-code': string;\n        'participant-type': string;\n    };\n    'CapabilityStatement': {\n        'fhirversion': string;\n        'resource': string;\n        'supported-profile': `${ResourceType}/${string}`;\n        'guide': `${ResourceType}/${string}`;\n        'software': string;\n        'mode': string;\n        'security-service': string;\n        'resource-profile': `${ResourceType}/${string}`;\n        'format': string;\n    };\n    'VisionPrescription': {\n        'status': string;\n        'datewritten': string;\n        'prescriber': `${ResourceType}/${string}`;\n    };\n    'RiskAssessment': {\n        'probability': number;\n        'method': string;\n        'condition': `${ResourceType}/${string}`;\n        'subject': `${ResourceType}/${string}`;\n        'risk': string;\n        'performer': `${ResourceType}/${string}`;\n    };\n    'ImmunizationRecommendation': {\n        'vaccine-type': string;\n        'support': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'target-disease': string;\n        'date': string;\n        'information': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n    };\n    'RelatedPerson': {\n        'relationship': string;\n        'name': string;\n        'identifier': string;\n        'patient': `${ResourceType}/${string}`;\n        'active': string;\n    };\n    'Medication': {\n        'form': string;\n        'manufacturer': `${ResourceType}/${string}`;\n        'ingredient-code': string;\n        'expiration-date': string;\n        'status': string;\n        'identifier': string;\n        'ingredient': `${ResourceType}/${string}`;\n        'lot-number': string;\n    };\n    'AppointmentResponse': {\n        'practitioner': `${ResourceType}/${string}`;\n        'location': `${ResourceType}/${string}`;\n        'identifier': string;\n        'appointment': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n        'part-status': string;\n        'actor': `${ResourceType}/${string}`;\n    };\n    'ResearchElementDefinition': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'Substance': {\n        'container-identifier': string;\n        'substance-reference': `${ResourceType}/${string}`;\n        'quantity': string;\n        'status': string;\n        'identifier': string;\n        'expiry': string;\n        'category': string;\n        'code': string;\n    };\n    'PaymentReconciliation': {\n        'created': string;\n        'requestor': `${ResourceType}/${string}`;\n        'disposition': string;\n        'status': string;\n        'request': `${ResourceType}/${string}`;\n        'identifier': string;\n        'payment-issuer': `${ResourceType}/${string}`;\n        'outcome': string;\n    };\n    'TestScript': {\n        'context-quantity': string;\n        'url': string;\n        'testscript-capability': string;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'description': string;\n        'context-type-value': string;\n    };\n    'ConceptMap': {\n        'source-code': string;\n        'source-uri': `${ResourceType}/${string}`;\n        'target-uri': `${ResourceType}/${string}`;\n        'target-system': string;\n        'dependson': string;\n        'source-system': string;\n        'product': string;\n        'source': `${ResourceType}/${string}`;\n        'other': `${ResourceType}/${string}`;\n        'target': `${ResourceType}/${string}`;\n        'target-code': string;\n    };\n    'Person': {\n        'practitioner': `${ResourceType}/${string}`;\n        'relatedperson': `${ResourceType}/${string}`;\n        'name': string;\n        'identifier': string;\n        'link': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n        'organization': `${ResourceType}/${string}`;\n    };\n    'Condition': {\n        'recorded-date': string;\n        'body-site': string;\n        'onset-age': string;\n        'encounter': `${ResourceType}/${string}`;\n        'clinical-status': string;\n        'evidence-detail': `${ResourceType}/${string}`;\n        'abatement-age': string;\n        'abatement-string': string;\n        'subject': `${ResourceType}/${string}`;\n        'asserter': `${ResourceType}/${string}`;\n        'category': string;\n        'onset-date': string;\n        'severity': string;\n        'onset-info': string;\n        'evidence': string;\n        'verification-status': string;\n        'abatement-date': string;\n        'stage': string;\n    };\n    'CareTeam': {\n        'encounter': `${ResourceType}/${string}`;\n        'participant': `${ResourceType}/${string}`;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'category': string;\n    };\n    'StructureDefinition': {\n        'abstract': string;\n        'experimental': string;\n        'path': string;\n        'valueset': `${ResourceType}/${string}`;\n        'base': `${ResourceType}/${string}`;\n        'keyword': string;\n        'ext-context': string;\n        'kind': string;\n        'type': string;\n        'derivation': string;\n        'base-path': string;\n    };\n    'Procedure': {\n        'based-on': `${ResourceType}/${string}`;\n        'reason-reference': `${ResourceType}/${string}`;\n        'instantiates-uri': string;\n        'part-of': `${ResourceType}/${string}`;\n        'location': `${ResourceType}/${string}`;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'category': string;\n        'instantiates-canonical': `${ResourceType}/${string}`;\n        'reason-code': string;\n        'performer': `${ResourceType}/${string}`;\n    };\n    'Consent': {\n        'security-label': string;\n        'consentor': `${ResourceType}/${string}`;\n        'status': string;\n        'scope': string;\n        'action': string;\n        'category': string;\n        'period': string;\n        'source-reference': `${ResourceType}/${string}`;\n        'data': `${ResourceType}/${string}`;\n        'organization': `${ResourceType}/${string}`;\n        'actor': `${ResourceType}/${string}`;\n        'purpose': string;\n    };\n    'Location': {\n        'address-use': string;\n        'partof': `${ResourceType}/${string}`;\n        'address-country': string;\n        'operational-status': string;\n        'address-city': string;\n        'name': string;\n        'address-state': string;\n        'address': string;\n        'status': string;\n        'identifier': string;\n        'type': string;\n        'endpoint': `${ResourceType}/${string}`;\n        'organization': `${ResourceType}/${string}`;\n        'address-postalcode': string;\n        'near': string;\n    };\n    'Organization': {\n        'address-use': string;\n        'partof': `${ResourceType}/${string}`;\n        'address-country': string;\n        'address-city': string;\n        'name': string;\n        'address-state': string;\n        'address': string;\n        'identifier': string;\n        'type': string;\n        'phonetic': string;\n        'endpoint': `${ResourceType}/${string}`;\n        'active': string;\n        'address-postalcode': string;\n    };\n    'Device': {\n        'url': string;\n        'model': string;\n        'device-name': string;\n        'manufacturer': string;\n        'location': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'din': string;\n        'udi-carrier': string;\n        'type': string;\n        'patient': `${ResourceType}/${string}`;\n        'udi-di': string;\n        'organization': `${ResourceType}/${string}`;\n    };\n    'SupplyRequest': {\n        'requester': `${ResourceType}/${string}`;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'supplier': `${ResourceType}/${string}`;\n        'category': string;\n    };\n    'AllergyIntolerance': {\n        'onset': string;\n        'last-date': string;\n        'route': string;\n        'clinical-status': string;\n        'criticality': string;\n        'recorder': `${ResourceType}/${string}`;\n        'asserter': `${ResourceType}/${string}`;\n        'type': string;\n        'category': string;\n        'severity': string;\n        'manifestation': string;\n        'verification-status': string;\n    };\n    'SearchParameter': {\n        'component': `${ResourceType}/${string}`;\n        'base': string;\n        'type': string;\n        'target': string;\n        'code': string;\n        'derived-from': `${ResourceType}/${string}`;\n    };\n    'ResearchDefinition': {\n        'context-quantity': string;\n        'url': string;\n        'depends-on': `${ResourceType}/${string}`;\n        'context-type': string;\n        'context-type-quantity': string;\n        'name': string;\n        'context': string;\n        'status': string;\n        'identifier': string;\n        'jurisdiction': string;\n        'title': string;\n        'publisher': string;\n        'version': string;\n        'date': string;\n        'predecessor': `${ResourceType}/${string}`;\n        'derived-from': `${ResourceType}/${string}`;\n        'effective': string;\n        'description': string;\n        'composed-of': `${ResourceType}/${string}`;\n        'successor': `${ResourceType}/${string}`;\n        'context-type-value': string;\n        'topic': string;\n    };\n    'OperationDefinition': {\n        'base': `${ResourceType}/${string}`;\n        'input-profile': `${ResourceType}/${string}`;\n        'instance': string;\n        'kind': string;\n        'type': string;\n        'output-profile': `${ResourceType}/${string}`;\n        'system': string;\n        'code': string;\n    };\n    'ImagingStudy': {\n        'started': string;\n        'referrer': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'modality': string;\n        'status': string;\n        'subject': `${ResourceType}/${string}`;\n        'instance': string;\n        'bodysite': string;\n        'dicom-class': string;\n        'series': string;\n        'interpreter': `${ResourceType}/${string}`;\n        'reason': string;\n        'endpoint': `${ResourceType}/${string}`;\n        'basedon': `${ResourceType}/${string}`;\n        'performer': `${ResourceType}/${string}`;\n    };\n    'CoverageEligibilityRequest': {\n        'created': string;\n        'provider': `${ResourceType}/${string}`;\n        'enterer': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'facility': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n    };\n    'GuidanceResponse': {\n        'request': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'patient': `${ResourceType}/${string}`;\n    };\n    'Media': {\n        'created': string;\n        'device': `${ResourceType}/${string}`;\n        'based-on': `${ResourceType}/${string}`;\n        'operator': `${ResourceType}/${string}`;\n        'encounter': `${ResourceType}/${string}`;\n        'modality': string;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'site': string;\n        'type': string;\n        'patient': `${ResourceType}/${string}`;\n        'view': string;\n    };\n    'MeasureReport': {\n        'evaluated-resource': `${ResourceType}/${string}`;\n        'reporter': `${ResourceType}/${string}`;\n        'measure': `${ResourceType}/${string}`;\n        'status': string;\n        'identifier': string;\n        'subject': `${ResourceType}/${string}`;\n        'date': string;\n        'patient': `${ResourceType}/${string}`;\n        'period': string;\n    };\n    'GraphDefinition': {\n        'start': string;\n    };\n}\n")
            ]))

(defn generate-types-index [packages]
  (into (into ["export * from './workflow';"
               "export * from './task';"]
              (for [pkg packages]
                (format "export * from './%s';" (package->directory pkg))))

        ["export interface SubsSubscription {"
         "  status: \"active\" | \"off\";"
         "  trigger: { event: Array<\"all\" | \"create\" | \"update\" | \"delete\">; filter?: unknown };"
         "  channel: { type: \"rest-hook\" };"
         "}"
         ""
         "export type TaskDefinitionsMap = {"
         "  \"placeholder-1\": { params: {}; result: {} };"
         "  \"placeholder-2\": { params: {}; result: {} };"
         "};"
         ""
         "export type WorkflowDefinitionsMap = {"
         "  \"placeholder-1\": { params: {}; result: {} };"
         "  \"placeholder-2\": { params: {}; result: {} };"
         "};"
         ""
         "export const TaskDefinitionsNameMap: Record<keyof TaskDefinitionsMap, string> = {"
         "  \"placeholder-1\": \"my-workflows/placeholder-1\","
         "  \"placeholder-2\": \"my-workflows/placeholder-2\","
         "};"
         ""
         "export const WorkflowDefinitionsNameMap: Record<keyof WorkflowDefinitionsMap, string> = {"
         "  \"placeholder-1\": \"my-workflows/placeholder-1\","
         "  \"placeholder-2\": \"my-workflows/placeholder-2\","
         "};"]))

(defrecord TypeScriptCodeGenerator []
  CodeGenerator
  (generate-datatypes [_ ir-schemas]
    (let [ir-schemas (sort-by :base ir-schemas)]
      (map (fn [ir-schema]
             {:path (resource-file-path ir-schema)
              :content (generate-module
                        :deps (generate-deps ir-schema)
                        :classes [(generate-class ir-schema (map generate-class (:backbone-elements ir-schema)))])})
           ir-schemas)))

  (generate-resource-module [_ ir-schema]
    {:path (resource-file-path ir-schema)
     :content (generate-module
               {:deps (generate-deps ir-schema)
                :classes [(generate-class ir-schema
                                          (map generate-class (:backbone-elements ir-schema)))]})})

  (generate-search-params [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (search-param-filepath ir-schema)
            :content (generate-module
                      :deps (generate-deps {:package "hl7.fhir.r4.core"
                                            :deps (map #(format "%sSearchParameters" %) (:deps ir-schema))})
                      :classes [(generate-class
                                 {:name (format "%sSearchParameters" (:name ir-schema))
                                  :base (when (:base ir-schema)
                                          (format "%sSearchParameters" (:base ir-schema)))
                                  :elements (:elements ir-schema)})])})
         ir-schemas))

  (generate-constraints [_ ir-schemas]
    (map (fn [ir-schema]
           {:path (resource-file-path ir-schema)
            :content (generate-module
                      {:deps (generate-deps ir-schema)
                       :classes [(generate-class ir-schema
                                                 (map generate-class (:backbone-elements ir-schema)))]})})
         ir-schemas))

  (generate-sdk-files [_ ir-schemas]
    (let [packages (group-by :package (filter fhir/base-package? ir-schemas))
          package-indexes (for [[package schemas] packages]
                            {:path (io/file "types" (package->directory package) "index.ts")
                             :content (str/join "\n" (into (index-exports schemas)
                                                           (resource-type-map schemas)))})
          types-index      [{:path (io/file "types" "index.ts")
                             :content (str/join "\n" (generate-types-index (keys packages)))}]
          common-sdk-files (generator/prepare-sdk-files
                            :typescript
                            ["index.ts"
                             "eslint.config.mjs"
                             "http-client.ts"
                             "package.json"
                             "package-lock.json"
                             "tsconfig.json"
                             "types/workflow/SystemCheckOutWorkflow.ts"
                             "types/workflow/index.ts"
                             "types/task/SystemSendMessage.ts"
                             "types/task/index.ts"])]
      (into (into common-sdk-files package-indexes) types-index)))

  (generate-valuesets [_ vs-schemas]
    (->> vs-schemas
         (map (fn [[fhir-version schemas]]
                {:path (io/file "types" (package->directory fhir-version) "valuesets.ts")
                 :content
                 (->> schemas
                      (mapv (fn [vs]
                              (let [type-name (valueset-name (:name vs))
                                    values (->> (:values vs)
                                                (map #(format "\"%s\"" %))
                                                (str/join " | "))]
                                (str "export type " type-name " = " values ";"))))
                      (str/join "\n"))})))))

(def generator (->TypeScriptCodeGenerator))
