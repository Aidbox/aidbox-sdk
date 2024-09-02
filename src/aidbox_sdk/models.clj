(ns aidbox-sdk.models
  (:require [malli.core :as m]
            [aidbox-sdk.fixtures.schemas :as fix]))

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
