(ns aidbox-sdk.fhir
  (:require
   [clojure.set :as set]
   [clojure.string :as str]))

;; Base Types and Datatypes

(def r4-base-types #{"Element" "Resource" "DomainResource"})

(def r4-primitive-types
  #{"boolean" "integer" "string" "decimal" "uri" "url" "canonical" "base64Binary"
    "instant" "date" "dateTime" "time" "code" "oid" "id" "markdown" "unsignedInt"
    "positiveInt" "uuid" "xhtml"})

(def r4-general-purpose-datatypes
  #{"Ratio" "Period" "Range" "Attachment" "Identifier" "HumanName" "ContactPoint"
    "Address" "Signature" "SampledData" "Quantity" "Age" "Distance" "Duration"
    "Count" "MoneyQuantity" "SimpleQuantity" "BackboneElement" "Timing" "Money"
    "Coding" "CodeableConcept" "Annotation"})

(def r4-metadata-types
  #{"ContactDetail" "Contributor" "DataRequirement" "UsageContext"
    "TriggerDefinition" "Expression" "ParameterDefinition" "RelatedArtifact"})

(def r4-special-purpose-datatypes
  #{"Reference" "Meta" "Dosage" "BackboneElement" "ElementDefinition" "Extension"
    "Narrative" "xhtml"})

(def r4-datatypes
  (set/union r4-primitive-types
             r4-general-purpose-datatypes
             r4-metadata-types
             r4-special-purpose-datatypes))

(def r4b-base-types r4-base-types)

(def r4b-primitive-types r4-primitive-types)

(def r4b-general-purpose-datatypes
  (into r4-general-purpose-datatypes #{"RatioRange" "Identifier"}))

(def r4b-metadata-types r4-metadata-types)

(def r4b-special-purpose-datatypes
  (into r4-special-purpose-datatypes #{"CodeableReference" "ProductShelfLife"
                                       "MarketingStatus"}))

(def r4b-datatypes
  (set/union r4b-primitive-types
             r4b-general-purpose-datatypes
             r4b-metadata-types
             r4b-special-purpose-datatypes))

(def r5-base-types
  #{"Base" "Element" "BackboneElement" "DataType" "PrimitiveType" "BackboneType"
    "Resource" "DomainResource" "CanonicalResource" "MetadataResource"})

(def r5-primitive-types (set/union r4b-primitive-types #{"integer64"}))

(def r5-general-purpose-datatypes r4b-general-purpose-datatypes)

(def r5-metadata-types
  (set/union r4b-metadata-types #{"Availability" "ExtendedContactDetail"
                                  "MonetaryComponent" "VirtualServiceDetail"}))

(def r5-special-purpose-datatypes
  #{"CodeableReference" "Meta" "Reference" "Dosage" "xhtml" "Narrative"
    "Extension" "ElementDefinition" "BackboneType"})

(def r5-datatypes
  (set/union r5-primitive-types
             r5-general-purpose-datatypes
             r5-metadata-types
             r5-special-purpose-datatypes))

;; Predicates
(defn resource-type-pred [rt]   (fn [schema] (= rt (:resourceType schema))))
(defn kind-pred          [kind] (fn [schema] (= kind (:kind schema))))

;; Kinds
(def primitive-type? (kind-pred "primitive-type"))
(def complex-type?   (kind-pred "complex-type"))
(def resource?       (kind-pred "resource"))
(def logical?        (kind-pred "logical"))

;; Resource Types
(def structure-definition? (resource-type-pred "StructureDefinition"))
(def search-parameter?     (resource-type-pred "SearchParameter"))
(def value-set?            (resource-type-pred "ValueSet"))
(def fhir-schema?          (resource-type-pred "FHIRSchema"))

;; Derivations
(defn constraint?     [schema] (= (:derivation schema) "constraint"))
(defn specialization? [schema] (= (:derivation schema) "specialization"))

;; Misc
(defn extension? [schema] (= (:type schema) "Extension"))

(defmulti  datatype? :package)
(defmethod datatype? "hl7.fhir.r4.core"  [schema] (contains? r4-datatypes  (:id schema)))
(defmethod datatype? "hl7.fhir.r4b.core" [schema] (contains? r4b-datatypes (:id schema)))
(defmethod datatype? "hl7.fhir.r5.core"  [schema] (contains? r5-datatypes  (:id schema)))
(defmethod datatype? :default [_] false)

(defmulti  backbone-element? :package)
(defmethod backbone-element? "hl7.fhir.r4.core"  [schema] (= (:base schema) "http://hl7.org/fhir/StructureDefinition/BackboneElement"))
(defmethod backbone-element? "hl7.fhir.r4b.core" [schema] (= (:base schema) "http://hl7.org/fhir/StructureDefinition/BackboneElement"))
(defmethod backbone-element? "hl7.fhir.r5.core"  [schema] (= (:base schema) "http://hl7.org/fhir/StructureDefinition/BackboneType"))
(defmethod backbone-element? :default [_] false)

(defmulti  root-node? :package)
(defmethod root-node? "hl7.fhir.r4.core"  [schema] (= (:url schema) "http://hl7.org/fhir/StructureDefinition/Element"))
(defmethod root-node? "hl7.fhir.r4b.core" [schema] (= (:url schema) "http://hl7.org/fhir/StructureDefinition/Element"))
(defmethod root-node? "hl7.fhir.r5.core"  [schema] (= (:url schema) "http://hl7.org/fhir/StructureDefinition/Base"))
(defmethod root-node? :default [_] false)

(defn root-node [schemas]
  (first (filter root-node? schemas)))

(defn primitive-types   [schemas] (filter primitive-type? schemas))
(defn complex-types     [schemas] (filter complex-type? schemas))
(defn datatypes         [schemas] (filter datatype? schemas))
(defn resources         [schemas] (filter resource? schemas))
(defn backbone-elements [schemas] (filter backbone-element? schemas))

;;

(defmulti  base-type? :package)
(defmethod base-type? "hl7.fhir.r4.core"  [schema] (contains? r4-base-types  (:id schema)))
(defmethod base-type? "hl7.fhir.r4b.core" [schema] (contains? r4b-base-types (:id schema)))
(defmethod base-type? "hl7.fhir.r5.core"  [schema] (contains? r5-base-types  (:id schema)))
(defmethod base-type? :default [_] false)

(defn base-schema? [schema]
  (or (= (:url schema) "http://hl7.org/fhir/StructureDefinition/BackboneElement")
      (= (:url schema) "http://hl7.org/fhir/StructureDefinition/Resource")
      (= (:url schema) "http://hl7.org/fhir/StructureDefinition/Element")
      (= (:derivation schema) "specialization")))

(defn domain-resource?
  "Is derived from DomainResource?"
  [schema]
  (= (:base schema) "http://hl7.org/fhir/StructureDefinition/DomainResource"))

(defn resource-type?
  [schema]
  (= (:base schema) "http://hl7.org/fhir/StructureDefinition/Resource"))

(defn search-parameter-from-extension? [search-parameter]
  (str/includes? (:id search-parameter) "-extensions-"))

(defmulti primitive-element? (fn [package _element] package))
(defmethod primitive-element? "hl7.fhir.r4.core"  [_ {:keys [type]}] (contains? r4-primitive-types type))
(defmethod primitive-element? "hl7.fhir.r4b.core" [_ {:keys [type]}] (contains? r4b-primitive-types type))
(defmethod primitive-element? "hl7.fhir.r5.core"  [_ {:keys [type]}] (contains? r5-primitive-types type))
(defmethod primitive-element? :default [_ _] false)

(defn filter-by-url [url schemas]
  (filter #(= url (:url %)) schemas))

(def find-by-url (comp first filter-by-url))

(defn base-package? [schema]
  (contains? #{"hl7.fhir.r4.core" "hl7.fhir.r4b.core" "hl7.fhir.r5.core"} (:package schema)))
