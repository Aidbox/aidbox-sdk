(ns aidbox-sdk.models
  (:require [malli.core :as m]
            [malli.registry :as mr]
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

(def FHIRSchema
  [:map
   [:url :string]
   [:type :string]
   [:name :string]
   [:derivation [:enum "specialization" "constraint"]]
   [:base {:optional true} :string]

   [:excluded {:optional true} [:vector :string]]
   [:required {:optional true} [:vector :string]]

   [:elements {:optional false} [:map-of :keyword FHIRElement]]

   ;; NOTE: shapes of constraints and extensions are not specified here since
   ;; they are not used in generation
   [:constraints {:optional true} :any]
   [:extensions {:optional true} :any]])

(def Type string?)

(def NonPolymorphicElement
  [:map
   [:base string?]
   [:array boolean?]
   [:required boolean?]
   [:value string?]
   [:name string?]
   [:type Type]])

(def PolymorphicElement
  [:map
   [:name string?]
   [:base string?]
   [:array boolean?]
   [:required boolean?]
   [:value string?]
   [:name string?]
   [:choices [:vector NonPolymorphicElement]]])

(def Element
  [:or
   PolymorphicElement
   NonPolymorphicElement])

(def BackboneElement
  [:map
   [:name string?]
   [:elements [:vector Element]]])

(def IRSchema
  "Intermediate Representation Schema."
  [:map {:closed true}
   [:derivation [:enum "specialization" "constraint"]]
   [:base string?]
   [:url string?]
   [:name string?]
   [:type string?]
   [:package string?]
   [:elements
    [:vector Element]]
   [:backbone-elements
    [:vector BackboneElement]]])

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
