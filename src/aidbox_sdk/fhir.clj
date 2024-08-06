(ns aidbox-sdk.fhir)

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

(defmulti  data-type? :package)
(defmethod data-type? "hl7.fhir.r4.core"  [schema] (= (:base schema) "http://hl7.org/fhir/StructureDefinition/Element"))
(defmethod data-type? "hl7.fhir.r4b.core" [schema] (= (:base schema) "http://hl7.org/fhir/StructureDefinition/Element"))
(defmethod data-type? "hl7.fhir.r5.core"  [schema] (or (= (:base schema) "http://hl7.org/fhir/StructureDefinition/DataType")
                                                       (= (:base schema) "http://hl7.org/fhir/StructureDefinition/PrimitiveType")))
(defmethod data-type? :default [_] false)

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
(defn data-types        [schemas] (filter data-type? schemas))
(defn resources         [schemas] (filter resource? schemas))
(defn backbone-elements [schemas] (filter backbone-element? schemas))
