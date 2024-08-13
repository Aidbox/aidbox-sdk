(ns aidbox-sdk.models
  (:require [malli.core :as m]
            [aidbox-sdk.fixtures.schemas :as fix]))

(def Element
  [:or
   [:map
    [:name string?]
    [:choices [:vector string?]]]
   [:map
    [:base string?]
    [:array boolean?]
    [:required boolean?]
    [:value string?]
    [:name string?]]])

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

(comment
  (m/validate IRSchema fix/patient-ir-schema)

  ;
  )
