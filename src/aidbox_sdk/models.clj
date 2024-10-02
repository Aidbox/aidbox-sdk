(ns aidbox-sdk.models
  (:require [malli.core :as m]
            [malli.util :as mu]
            [aidbox-sdk.fixtures.schemas :as fix]))

(def FHIRElement
  [:schema {:registry {::fhir-element
                       [:map
                        ;; shape
                        [:array {:optional true} :boolean]
                        [:scalar {:optional true} :boolean]

                        ;; cardinality
                        [:min {:optional true} :int]
                        [:max {:optional true} :int]

                        ;; choice type
                        [:choiceOf {:optional true} :string]
                        [:choices {:optional true} [:vector :string]]

                        ;; type reference
                        [:type {:optional true} :string]
                        [:elementReference {:optional true} [:vector :string]]

                        ;; nested elements (for BackboneElement type)
                        [:elements {:optional true} [:map-of :keyword [:ref ::fhir-element]]]
                        [:required {:optional true} [:vector :string]]
                        [:excluded {:optional true} [:vector :string]]

                        [:constraints {:optional true} :any]
                        [:slicing {:optional true} :any]
                        [:binding {:optional true} [:map
                                                    [:valueSet :string]
                                                    [:strength :string]]]

                        ;; constants definition
                        [:fixed {:optional true} :any]
                        [:pattern {:optional true} :any]

                        ;; reference target
                        [:refers {:optional true} [:vector :string]]

                        ;; informational
                        [:modifier {:optional true} :boolean]
                        [:mustSupport {:optional true} :boolean]
                        [:summary {:optional true} :boolean]]}}
   ::fhir-element])

(def BaseFHIRSchema
  [:map
   [:url :string]
   [:type :string]
   [:name :string]

   [:excluded {:optional true} [:vector :string]]
   [:required {:optional true} [:vector :string]]

   [:elements {:optional true} [:map-of :keyword FHIRElement]]

   ;; NOTE: shapes of constraints and extensions are not specified here since
   ;; they are not used in generation
   [:constraints {:optional true} :any]
   [:extensions {:optional true} :any]])

(def FHIRSchema
  [:or BaseFHIRSchema
   (-> BaseFHIRSchema
       (mu/assoc :derivation [:enum "specialization" "constraint"])
       (mu/assoc :base :string))])

(def Type string?)

(def NonPolymorphicElement
  [:map
   [:name string?]
   [:base string?]
   [:array boolean?]
   [:required boolean?]
   [:value string?]
   [:choice-of string?]
   [:type Type]])

(def PolymorphicElement
  [:map
   [:name string?]
   [:base string?]
   [:array boolean?]
   [:required boolean?]
   [:value string?]
   [:choices {:optional true} [:sequential NonPolymorphicElement]]
   [:type Type]])

(def Element
  [:or
   NonPolymorphicElement
   PolymorphicElement])

(def BackboneElement
  [:map
   [:name :string]
   [:elements [:sequential Element]]])

(def IRSchema
  "Intermediate Representation Schema."
  [:map
   [:derivation {:optional true} [:enum "specialization" "constraint"]]
   [:resource-name :string]
   [:base-resource-name :string]
   [:base :string]
   [:url :string]
   [:name :string]
   [:type :string]
   [:package :string]
   [:elements
    [:sequential Element]]
   [:backbone-elements
    [:sequential BackboneElement]]])

(def SearchParamIRSchema
  [:map {:closed true}
   [:name string?]
   [:base string?]
   [:elements [:vector [:map
                        [:type "string"]
                        [:name string?]]]]])

(comment
  (m/validate IRSchema fix/patient-ir-schema)

;
  )
(def validate-fhir-schema (m/coercer FHIRSchema))

(def validate-ir-schema (m/coercer IRSchema))
