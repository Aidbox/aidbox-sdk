(ns user
  (:require
   [aidbox-sdk.core :as sdk]
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.converter :as converter]
   [aidbox-sdk.models :as models]
   [aidbox-sdk.fixtures.schemas :as fixtures]
   [aidbox-sdk.generator :as gen]
   [aidbox-sdk.generator.python :as gen.python]
   [aidbox-sdk.schema :as import]
   [aidbox-sdk.cli :as cli]
   [malli.core :as m]
   [meander.match.epsilon :as mme]
   [clojure.spec.alpha :as s]
   [clojure.data]
   [clojure.java.io :as io]))

(defonce r4-schemas  (import/retrieve (import/resource "resources/r4") {}))
(defonce r4b-schemas (import/retrieve (import/resource "resources/r4b") {}))
(defonce r5-schemas  (import/retrieve (import/resource "resources/r5") {}))

(defonce aidbox-schemas (import/retrieve
                         (import/resource "http://localhost:8765/api/sdk/fhir-packages")
                         {:auth "YmFzaWM6c2VjcmV0"}))

(def target (io/file "out/"))

(defn kinds          [schemas] (distinct (map :kind schemas)))
(defn resource-types [schemas] (distinct (map :resourceType schemas)))
(defn packages       [schemas] (distinct (map :package schemas)))

(defn exclude-keys [m keys]
  (apply dissoc m keys))

(comment

  (kinds r4-schemas)
  ;; => (nil "complex-type" "resource" "primitive-type" "logical")

  (resource-types r4b-schemas)
  ;; => ("SearchParameter" "ValueSet" "StructureDefinition" "CompartmentDefinition")

  (resource-types r5-schemas)
  ;; => ("SearchParameter" "ValueSet" "StructureDefinition" "CompartmentDefinition")

  (resource-types r4-schemas)
  ;; => ("ValueSet" "SearchParameter" nil "StructureDefinition")

  (resource-types aidbox-schemas)
  ;; => ("FHIRSchema"
  ;;     "SearchParameter"
  ;;     "CompartmentDefinition"
  ;;     "ValueSet"
  ;;     "StructureDefinition")

  (->> aidbox-schemas
       (filter #(= "Patient" (:id %)))
       (converter/convert))

  (converter/convert-search-params
   (->> aidbox-schemas
        (filter fhir/search-parameter?)
        (remove fhir/search-parameter-from-extension?))
   (->> aidbox-schemas
        (filter fhir/fhir-schema?)))

  (let [all-schemas      aidbox-schemas

        base-type?       (every-pred fhir/fhir-schema? fhir/base-type?)
        datatype?        (every-pred fhir/fhir-schema? fhir/datatype? (complement fhir/primitive-type?))
        domain-resource? (every-pred fhir/fhir-schema? fhir/domain-resource?)
        constraint?      (every-pred fhir/fhir-schema? fhir/constraint? (complement fhir/extension?))
        search-param?    (every-pred fhir/search-parameter? (complement fhir/search-parameter-from-extension?))

        fhir-schemas         (filter fhir/fhir-schema? all-schemas)
        base-schemas         (filter base-type?        all-schemas)
        datatype-schemas     (filter datatype?         all-schemas)
        resource-schemas     (filter domain-resource?  all-schemas)
        constraint-schemas   (filter constraint?       all-schemas)
        search-param-schemas [filter search-param?     all-schemas]

        ir-schemas              (converter/convert fhir-schemas)
        base-ir-schemas         (converter/convert base-schemas)
        datatype-ir-schemas     (converter/convert datatype-schemas)
        resource-ir-schemas     (converter/convert resource-schemas)
        search-param-ir-schemas (converter/convert-search-params search-param-schemas
                                                                 fhir-schemas)
        constraint-ir-schemas   (converter/convert-constraints constraint-schemas
                                                               ir-schemas)]

    ;; (converter/convert-constraints
    ;;  (->> constraint-schemas
    ;;       (filter #(= "http://hl7.org/fhir/StructureDefinition/vitalsigns" (:url %))))
    ;;  ir-schemas)

    ;; (->> fhir-schemas
    ;;      (filter #(= "http://hl7.org/fhir/StructureDefinition/Observation" (:url %))))

    ;
    )

    ;; TODO
  :rcf)

(comment

  (defn matcher [{:keys [pattern expression]}]
    (eval `(fn [data#]
             (let [~'data data#]
               ~(mme/compile-match-args
                 (list 'data pattern expression)
                 nil)))))

  (def transform (matcher
                  {:pattern '{:derivation ?derivation}
                   :expression '{:derivation ?derivation}}))

  (def transform-element
    (matcher
     {:pattern '{:elementReference ?elementReference}
      :expression '[{:type "Reference"} ...]}))

  (def observation
    {:package "hl7.fhir.r5.core",
     :technical-id
     "hl7.fhir.r5.core/5.0.0/FHIRSchema/http://hl7.org/fhir/StructureDefinition/Observation/5.0.0",
     :derivation "specialization",
     :fhirVersion nil,
     :name "Observation",
     :type "Observation",
     :resourceType "FHIRSchema",
     :elements
     {:category
      {:type "CodeableConcept",
       :array true,
       :binding
       {:strength "preferred",
        :valueSet "http://hl7.org/fhir/ValueSet/observation-category"}},
      :referenceRange
      {:type "BackboneElement",
       :array true,
       :elements
       {:age {:type "Range", :scalar true},
        :low {:type "Quantity", :scalar true},
        :high {:type "Quantity", :scalar true},
        :text {:type "markdown", :scalar true},
        :type
        {:type "CodeableConcept",
         :scalar true,
         :binding
         {:strength "preferred",
          :valueSet "http://hl7.org/fhir/ValueSet/referencerange-meaning"}},
        :appliesTo
        {:type "CodeableConcept",
         :array true,
         :binding
         {:strength "example",
          :valueSet "http://hl7.org/fhir/ValueSet/referencerange-appliesto"}},
        :normalValue
        {:type "CodeableConcept",
         :scalar true,
         :binding
         {:strength "extensible",
          :valueSet
          "http://hl7.org/fhir/ValueSet/observation-referencerange-normalvalue"}}},
       :constraints
       {:obs-3
        {:human "Must have at least a low or a high or text",
         :severity "error",
         :expression "low.exists() or high.exists() or text.exists()"}}},
      :hasMember
      {:type "Reference",
       :array true,
       :refers
       ["http://hl7.org/fhir/StructureDefinition/Observation"
        "http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse"
        "http://hl7.org/fhir/StructureDefinition/MolecularSequence"],
       :summary true},
      :instantiatesCanonical
      {:type "canonical",
       :refers ["http://hl7.org/fhir/StructureDefinition/ObservationDefinition"],
       :scalar true,
       :summary true,
       :choiceOf "instantiates"},
      :valueReference
      {:type "Reference",
       :refers ["http://hl7.org/fhir/StructureDefinition/MolecularSequence"],
       :scalar true,
       :summary true,
       :choiceOf "value"},
      :instantiatesReference
      {:type "Reference",
       :refers ["http://hl7.org/fhir/StructureDefinition/ObservationDefinition"],
       :scalar true,
       :summary true,
       :choiceOf "instantiates"},
      :instantiates
      {:scalar true, :choices ["instantiatesCanonical" "instantiatesReference"]},
      :derivedFrom
      {:type "Reference",
       :array true,
       :refers
       ["http://hl7.org/fhir/StructureDefinition/DocumentReference"
        "http://hl7.org/fhir/StructureDefinition/ImagingStudy"
        "http://hl7.org/fhir/StructureDefinition/ImagingSelection"
        "http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse"
        "http://hl7.org/fhir/StructureDefinition/Observation"
        "http://hl7.org/fhir/StructureDefinition/MolecularSequence"
        "http://hl7.org/fhir/StructureDefinition/GenomicStudy"],
       :summary true},
      :interpretation
      {:type "CodeableConcept",
       :array true,
       :binding
       {:strength "extensible",
        :valueSet "http://hl7.org/fhir/ValueSet/observation-interpretation"}},
      :encounter
      {:type "Reference",
       :refers ["http://hl7.org/fhir/StructureDefinition/Encounter"],
       :scalar true,
       :summary true},
      :method
      {:type "CodeableConcept",
       :scalar true,
       :binding
       {:strength "example",
        :valueSet "http://hl7.org/fhir/ValueSet/observation-methods"}},
      :valueTime {:type "time", :scalar true, :summary true, :choiceOf "value"},
      :specimen
      {:type "Reference",
       :refers
       ["http://hl7.org/fhir/StructureDefinition/Specimen"
        "http://hl7.org/fhir/StructureDefinition/Group"],
       :scalar true,
       :constraints
       {:obs-9
        {:human
         "If Observation.specimen is a reference to Group, the group can only have specimens",
         :severity "error",
         :expression
         "(reference.resolve().exists() and reference.resolve() is Group) implies reference.resolve().member.entity.resolve().all($this is Specimen)"}}},
      :valueQuantity
      {:type "Quantity", :scalar true, :summary true, :choiceOf "value"},
      :value
      {:scalar true,
       :choices
       ["valueQuantity"
        "valueCodeableConcept"
        "valueString"
        "valueBoolean"
        "valueInteger"
        "valueRange"
        "valueRatio"
        "valueSampledData"
        "valueTime"
        "valueDateTime"
        "valuePeriod"
        "valueAttachment"
        "valueReference"]},
      :valueString
      {:type "string", :scalar true, :summary true, :choiceOf "value"},
      :valueRatio {:type "Ratio", :scalar true, :summary true, :choiceOf "value"},
      :valueBoolean
      {:type "boolean", :scalar true, :summary true, :choiceOf "value"},
      :valueDateTime
      {:type "dateTime", :scalar true, :summary true, :choiceOf "value"},
      :component
      {:type "BackboneElement",
       :array true,
       :summary true,
       :elements
       {:referenceRange
        {:array true,
         :elementReference
         ["http://hl7.org/fhir/StructureDefinition/Observation"
          "elements"
          "referenceRange"]},
        :valueReference
        {:type "Reference",
         :refers ["http://hl7.org/fhir/StructureDefinition/MolecularSequence"],
         :scalar true,
         :summary true,
         :choiceOf "value"},
        :interpretation
        {:type "CodeableConcept",
         :array true,
         :binding
         {:strength "extensible",
          :valueSet "http://hl7.org/fhir/ValueSet/observation-interpretation"}},
        :valueTime {:type "time", :scalar true, :summary true, :choiceOf "value"},
        :valueQuantity
        {:type "Quantity", :scalar true, :summary true, :choiceOf "value"},
        :value
        {:scalar true,
         :choices
         ["valueQuantity"
          "valueCodeableConcept"
          "valueString"
          "valueBoolean"
          "valueInteger"
          "valueRange"
          "valueRatio"
          "valueSampledData"
          "valueTime"
          "valueDateTime"
          "valuePeriod"
          "valueAttachment"
          "valueReference"]},
        :valueString
        {:type "string", :scalar true, :summary true, :choiceOf "value"},
        :valueRatio
        {:type "Ratio", :scalar true, :summary true, :choiceOf "value"},
        :valueBoolean
        {:type "boolean", :scalar true, :summary true, :choiceOf "value"},
        :valueDateTime
        {:type "dateTime", :scalar true, :summary true, :choiceOf "value"},
        :valueSampledData
        {:type "SampledData", :scalar true, :summary true, :choiceOf "value"},
        :code
        {:type "CodeableConcept",
         :scalar true,
         :binding
         {:strength "example",
          :valueSet "http://hl7.org/fhir/ValueSet/observation-codes"},
         :summary true},
        :valueCodeableConcept
        {:type "CodeableConcept", :scalar true, :summary true, :choiceOf "value"},
        :valuePeriod
        {:type "Period", :scalar true, :summary true, :choiceOf "value"},
        :valueRange
        {:type "Range", :scalar true, :summary true, :choiceOf "value"},
        :valueInteger
        {:type "integer", :scalar true, :summary true, :choiceOf "value"},
        :valueAttachment
        {:type "Attachment", :scalar true, :summary true, :choiceOf "value"},
        :dataAbsentReason
        {:type "CodeableConcept",
         :scalar true,
         :binding
         {:strength "extensible",
          :valueSet "http://hl7.org/fhir/ValueSet/data-absent-reason"}}},
       :required ["code"]},
      :note {:type "Annotation", :array true},
      :valueSampledData
      {:type "SampledData", :scalar true, :summary true, :choiceOf "value"},
      :effectiveDateTime
      {:type "dateTime", :scalar true, :summary true, :choiceOf "effective"},
      :status
      {:type "code",
       :scalar true,
       :binding
       {:strength "required",
        :valueSet "http://hl7.org/fhir/ValueSet/observation-status"},
       :summary true,
       :modifier true},
      :effective
      {:scalar true,
       :choices
       ["effectiveDateTime"
        "effectivePeriod"
        "effectiveTiming"
        "effectiveInstant"]},
      :code
      {:type "CodeableConcept",
       :scalar true,
       :binding
       {:strength "example",
        :valueSet "http://hl7.org/fhir/ValueSet/observation-codes"},
       :summary true},
      :identifier {:type "Identifier", :array true, :summary true},
      :effectiveTiming
      {:type "Timing", :scalar true, :summary true, :choiceOf "effective"},
      :valueCodeableConcept
      {:type "CodeableConcept", :scalar true, :summary true, :choiceOf "value"},
      :bodySite
      {:type "CodeableConcept",
       :scalar true,
       :binding
       {:strength "example", :valueSet "http://hl7.org/fhir/ValueSet/body-site"}},
      :focus
      {:type "Reference",
       :array true,
       :refers ["http://hl7.org/fhir/StructureDefinition/Resource"],
       :summary true},
      :issued {:type "instant", :scalar true, :summary true},
      :valuePeriod
      {:type "Period", :scalar true, :summary true, :choiceOf "value"},
      :device
      {:type "Reference",
       :refers
       ["http://hl7.org/fhir/StructureDefinition/Device"
        "http://hl7.org/fhir/StructureDefinition/DeviceMetric"],
       :scalar true},
      :effectiveInstant
      {:type "instant", :scalar true, :summary true, :choiceOf "effective"},
      :basedOn
      {:type "Reference",
       :array true,
       :refers
       ["http://hl7.org/fhir/StructureDefinition/CarePlan"
        "http://hl7.org/fhir/StructureDefinition/DeviceRequest"
        "http://hl7.org/fhir/StructureDefinition/ImmunizationRecommendation"
        "http://hl7.org/fhir/StructureDefinition/MedicationRequest"
        "http://hl7.org/fhir/StructureDefinition/NutritionOrder"
        "http://hl7.org/fhir/StructureDefinition/ServiceRequest"],
       :summary true},
      :valueRange {:type "Range", :scalar true, :summary true, :choiceOf "value"},
      :partOf
      {:type "Reference",
       :array true,
       :refers
       ["http://hl7.org/fhir/StructureDefinition/MedicationAdministration"
        "http://hl7.org/fhir/StructureDefinition/MedicationDispense"
        "http://hl7.org/fhir/StructureDefinition/MedicationStatement"
        "http://hl7.org/fhir/StructureDefinition/Procedure"
        "http://hl7.org/fhir/StructureDefinition/Immunization"
        "http://hl7.org/fhir/StructureDefinition/ImagingStudy"
        "http://hl7.org/fhir/StructureDefinition/GenomicStudy"],
       :summary true},
      :bodyStructure
      {:type "Reference",
       :refers ["http://hl7.org/fhir/StructureDefinition/BodyStructure"],
       :scalar true},
      :valueInteger
      {:type "integer", :scalar true, :summary true, :choiceOf "value"},
      :valueAttachment
      {:type "Attachment", :scalar true, :summary true, :choiceOf "value"},
      :triggeredBy
      {:type "BackboneElement",
       :array true,
       :elements
       {:type
        {:type "code",
         :scalar true,
         :binding
         {:strength "required",
          :valueSet "http://hl7.org/fhir/ValueSet/observation-triggeredbytype"},
         :summary true},
        :reason {:type "string", :scalar true},
        :observation
        {:type "Reference",
         :refers ["http://hl7.org/fhir/StructureDefinition/Observation"],
         :scalar true,
         :summary true}},
       :required ["observation" "type"]},
      :subject
      {:type "Reference",
       :refers
       ["http://hl7.org/fhir/StructureDefinition/Patient"
        "http://hl7.org/fhir/StructureDefinition/Group"
        "http://hl7.org/fhir/StructureDefinition/Device"
        "http://hl7.org/fhir/StructureDefinition/Location"
        "http://hl7.org/fhir/StructureDefinition/Organization"
        "http://hl7.org/fhir/StructureDefinition/Procedure"
        "http://hl7.org/fhir/StructureDefinition/Practitioner"
        "http://hl7.org/fhir/StructureDefinition/Medication"
        "http://hl7.org/fhir/StructureDefinition/Substance"
        "http://hl7.org/fhir/StructureDefinition/BiologicallyDerivedProduct"
        "http://hl7.org/fhir/StructureDefinition/NutritionProduct"],
       :scalar true,
       :summary true},
      :performer
      {:type "Reference",
       :array true,
       :refers
       ["http://hl7.org/fhir/StructureDefinition/Practitioner"
        "http://hl7.org/fhir/StructureDefinition/PractitionerRole"
        "http://hl7.org/fhir/StructureDefinition/Organization"
        "http://hl7.org/fhir/StructureDefinition/CareTeam"
        "http://hl7.org/fhir/StructureDefinition/Patient"
        "http://hl7.org/fhir/StructureDefinition/RelatedPerson"],
       :summary true},
      :dataAbsentReason
      {:type "CodeableConcept",
       :scalar true,
       :binding
       {:strength "extensible",
        :valueSet "http://hl7.org/fhir/ValueSet/data-absent-reason"}},
      :effectivePeriod
      {:type "Period", :scalar true, :summary true, :choiceOf "effective"}},
     :id "Observation",
     :kind "resource",
     :url "http://hl7.org/fhir/StructureDefinition/Observation",
     :packageVersion "5.0.0",
     :base "http://hl7.org/fhir/StructureDefinition/DomainResource",
     :version "5.0.0",
     :required ["status" "code"]})

  (transform observation)

  (m/validate models/FHIRSchema observation)

  (m/explain models/FHIRElement (:category (:elements observation)))

  ;; malli experimenting
  )
