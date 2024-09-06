(ns aidbox-sdk.fixtures.schemas)

(def schemas-with-element-reference
  [{:package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/TestReport/4.0.1",
    :derivation "specialization",
    :fhirVersion nil,
    :name "TestReport",
    :type "TestReport",
    :resourceType "FHIRSchema",
    :elements
    {:tester {:type "string", :scalar true, :summary true},
     :name {:type "string", :scalar true, :summary true},
     :testScript
     {:type "Reference",
      :refers ["http://hl7.org/fhir/StructureDefinition/TestScript"],
      :scalar true,
      :summary true},
     :participant
     {:type "BackboneElement",
      :array true,
      :elements
      {:uri {:type "uri", :scalar true},
       :type
       {:type "code",
        :scalar true,
        :binding
        {:strength "required",
         :valueSet "http://hl7.org/fhir/ValueSet/report-participant-type",
         :codesystems ["http://hl7.org/fhir/report-participant-type"]}},
       :display {:type "string", :scalar true}},
      :required ["type" "uri"]},
     :setup
     {:type "BackboneElement",
      :scalar true,
      :elements
      {:action
       {:type "BackboneElement",
        :array true,
        :elements
        {:assert
         {:type "BackboneElement",
          :scalar true,
          :elements
          {:detail {:type "string", :scalar true},
           :result
           {:type "code",
            :scalar true,
            :binding
            {:strength "required",
             :valueSet "http://hl7.org/fhir/ValueSet/report-action-result-codes",
             :codesystems ["http://hl7.org/fhir/report-action-result-codes"]}},
           :message {:type "markdown", :scalar true}},
          :required ["result"]},
         :operation
         {:type "BackboneElement",
          :scalar true,
          :elements
          {:detail {:type "uri", :scalar true},
           :result
           {:type "code",
            :scalar true,
            :binding
            {:strength "required",
             :valueSet "http://hl7.org/fhir/ValueSet/report-action-result-codes",
             :codesystems ["http://hl7.org/fhir/report-action-result-codes"]}},
           :message {:type "markdown", :scalar true}},
          :required ["result"]}},
        :constraints
        {:inv-1
         {:human
          "Setup action SHALL contain either an operation or assert but not both.",
          :severity "error",
          :expression "operation.exists() xor assert.exists()"}}}},
      :required ["action"]},
     :status
     {:type "code",
      :scalar true,
      :binding
      {:strength "required",
       :valueSet "http://hl7.org/fhir/ValueSet/report-status-codes",
       :codesystems ["http://hl7.org/fhir/report-status-codes"]},
      :summary true,
      :modifier true},
     :result
     {:type "code",
      :scalar true,
      :binding
      {:strength "required",
       :valueSet "http://hl7.org/fhir/ValueSet/report-result-codes",
       :codesystems ["http://hl7.org/fhir/report-result-codes"]},
      :summary true},
     :score {:type "decimal", :scalar true, :summary true},
     :identifier {:type "Identifier", :scalar true, :summary true},
     :issued {:type "dateTime", :scalar true, :summary true},
     :teardown
     {:type "BackboneElement",
      :scalar true,
      :elements
      {:action
       {:type "BackboneElement",
        :array true,
        :elements
        {:operation
         {:scalar true,
          :elementReference
          ["http://hl7.org/fhir/StructureDefinition/TestReport"
           "elements"
           "setup"
           "elements"
           "action"
           "elements"
           "operation"]}},
        :required ["operation"]}},
      :required ["action"]},
     :test
     {:type "BackboneElement",
      :array true,
      :elements
      {:name {:type "string", :scalar true},
       :action
       {:type "BackboneElement",
        :array true,
        :elements
        {:assert
         {:scalar true,
          :elementReference
          ["http://hl7.org/fhir/StructureDefinition/TestReport"
           "elements"
           "setup"
           "elements"
           "action"
           "elements"
           "assert"]},
         :operation
         {:scalar true,
          :elementReference
          ["http://hl7.org/fhir/StructureDefinition/TestReport"
           "elements"
           "setup"
           "elements"
           "action"
           "elements"
           "operation"]}},
        :constraints
        {:inv-2
         {:human
          "Test action SHALL contain either an operation or assert but not both.",
          :severity "error",
          :expression "operation.exists() xor assert.exists()"}}},
       :description {:type "string", :scalar true}},
      :required ["action"]}},
    :id "TestReport",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/TestReport",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource",
    :version "4.0.1",
    :required ["status" "testScript" "result"]}])

(def schemas-with-element-reference-resolved
  [{:package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/TestReport/4.0.1",
    :derivation "specialization",
    :fhirVersion nil,
    :name "TestReport",
    :type "TestReport",
    :resourceType "FHIRSchema",
    :elements
    {:tester {:type "string", :scalar true, :summary true},
     :name {:type "string", :scalar true, :summary true},
     :testScript
     {:type "Reference",
      :refers ["http://hl7.org/fhir/StructureDefinition/TestScript"],
      :scalar true,
      :summary true},
     :participant
     {:type "BackboneElement",
      :array true,
      :elements
      {:uri {:type "uri", :scalar true},
       :type
       {:type "code",
        :scalar true,
        :binding
        {:strength "required",
         :valueSet "http://hl7.org/fhir/ValueSet/report-participant-type",
         :codesystems ["http://hl7.org/fhir/report-participant-type"]}},
       :display {:type "string", :scalar true}},
      :required ["type" "uri"]},
     :setup
     {:type "BackboneElement",
      :scalar true,
      :elements
      {:action
       {:type "BackboneElement",
        :array true,
        :elements
        {:assert
         {:type "BackboneElement",
          :scalar true,
          :elements
          {:detail {:type "string", :scalar true},
           :result
           {:type "code",
            :scalar true,
            :binding
            {:strength "required",
             :valueSet "http://hl7.org/fhir/ValueSet/report-action-result-codes",
             :codesystems ["http://hl7.org/fhir/report-action-result-codes"]}},
           :message {:type "markdown", :scalar true}},
          :required ["result"]},
         :operation
         {:type "BackboneElement",
          :scalar true,
          :elements
          {:detail {:type "uri", :scalar true},
           :result
           {:type "code",
            :scalar true,
            :binding
            {:strength "required",
             :valueSet "http://hl7.org/fhir/ValueSet/report-action-result-codes",
             :codesystems ["http://hl7.org/fhir/report-action-result-codes"]}},
           :message {:type "markdown", :scalar true}},
          :required ["result"]}},
        :constraints
        {:inv-1
         {:human
          "Setup action SHALL contain either an operation or assert but not both.",
          :severity "error",
          :expression "operation.exists() xor assert.exists()"}}}},
      :required ["action"]},
     :status
     {:type "code",
      :scalar true,
      :binding
      {:strength "required",
       :valueSet "http://hl7.org/fhir/ValueSet/report-status-codes",
       :codesystems ["http://hl7.org/fhir/report-status-codes"]},
      :summary true,
      :modifier true},
     :result
     {:type "code",
      :scalar true,
      :binding
      {:strength "required",
       :valueSet "http://hl7.org/fhir/ValueSet/report-result-codes",
       :codesystems ["http://hl7.org/fhir/report-result-codes"]},
      :summary true},
     :score {:type "decimal", :scalar true, :summary true},
     :identifier {:type "Identifier", :scalar true, :summary true},
     :issued {:type "dateTime", :scalar true, :summary true},
     :teardown
     {:type "BackboneElement",
      :scalar true,
      :elements
      {:action
       {:type "BackboneElement",
        :array true,
        :elements
        {:operation
         {:scalar true,
          :type "BackboneElement",
          :elements
          {:detail {:type "uri", :scalar true},
           :result
           {:type "code",
            :scalar true,
            :binding
            {:strength "required",
             :valueSet "http://hl7.org/fhir/ValueSet/report-action-result-codes",
             :codesystems ["http://hl7.org/fhir/report-action-result-codes"]}},
           :message {:type "markdown", :scalar true}},
          :required ["result"]}},
        :required ["operation"]}},
      :required ["action"]},
     :test
     {:type "BackboneElement",
      :array true,
      :elements
      {:name {:type "string", :scalar true},
       :action
       {:type "BackboneElement",
        :array true,
        :elements
        {:assert
         {:scalar true,
          :type "BackboneElement",
          :elements
          {:detail {:type "string", :scalar true},
           :result
           {:type "code",
            :scalar true,
            :binding
            {:strength "required",
             :valueSet "http://hl7.org/fhir/ValueSet/report-action-result-codes",
             :codesystems ["http://hl7.org/fhir/report-action-result-codes"]}},
           :message {:type "markdown", :scalar true}},
          :required ["result"]},
         :operation
         {:scalar true,
          :type "BackboneElement",
          :elements
          {:detail {:type "uri", :scalar true},
           :result
           {:type "code",
            :scalar true,
            :binding
            {:strength "required",
             :valueSet "http://hl7.org/fhir/ValueSet/report-action-result-codes",
             :codesystems ["http://hl7.org/fhir/report-action-result-codes"]}},
           :message {:type "markdown", :scalar true}},
          :required ["result"]}},
        :constraints
        {:inv-2
         {:human
          "Test action SHALL contain either an operation or assert but not both.",
          :severity "error",
          :expression "operation.exists() xor assert.exists()"}}},
       :description {:type "string", :scalar true}},
      :required ["action"]}},
    :id "TestReport",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/TestReport",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource",
    :version "4.0.1",
    :required ["status" "testScript" "result"]}])

(def schemas-with-element-choices
  [{:package "hl7.fhir.r4.core",
    :derivation "specialization",
    :name "Patient",
    :type "Patient",
    :elements
    [{:name "multipleBirthBoolean",
      :base "Patient",
      :array false,
      :required false,
      :value "bool"}
     {:name "address",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.Address"}
     {:name "deceasedDateTime",
      :base "Patient",
      :array false,
      :required false,
      :value "string"}
     {:name "managingOrganization",
      :base "Patient",
      :array false,
      :required false,
      :value "Base.ResourceReference"}
     {:name "deceasedBoolean",
      :base "Patient",
      :array false,
      :required false,
      :value "bool"}
     {:name "name",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.HumanName"}
     {:name "birthDate",
      :base "Patient",
      :array false,
      :required false,
      :value "string"}
     {:name "multipleBirthInteger",
      :base "Patient",
      :array false,
      :required false,
      :value "int"}
     {:name "multipleBirth",
      :choices ["multipleBirthBoolean" "multipleBirthInteger"]}
     {:name "deceased", :choices ["deceasedBoolean" "deceasedDateTime"]}
     {:name "photo",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.Attachment"}
     {:name "link",
      :base "Patient",
      :array true,
      :required false,
      :value "Patient_Link"}
     {:name "active",
      :base "Patient",
      :array false,
      :required false,
      :value "bool"}
     {:name "communication",
      :base "Patient",
      :array true,
      :required false,
      :value "Patient_Communication"}
     {:name "identifier",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.Identifier"}
     {:name "telecom",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.ContactPoint"}
     {:name "generalPractitioner",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.ResourceReference"}
     {:name "gender",
      :base "Patient",
      :array false,
      :required false,
      :value "string"}
     {:name "maritalStatus",
      :base "Patient",
      :array false,
      :required false,
      :value "Base.CodeableConcept"}
     {:name "contact",
      :base "Patient",
      :array true,
      :required false,
      :value "Patient_Contact"}],
    :url "http://hl7.org/fhir/StructureDefinition/Patient",
    :backbone-elements
    [{:elements
      [{:name "type",
        :base "Patient_Link",
        :array false,
        :required true,
        :value "string"}
       {:name "other",
        :base "Patient_Link",
        :array false,
        :required true,
        :value "Base.ResourceReference"}],
      :backbone-elements [],
      :name "Patient_Link"}
     {:elements
      [{:name "language",
        :base "Patient_Communication",
        :array false,
        :required true,
        :value "Base.CodeableConcept"}
       {:name "preferred",
        :base "Patient_Communication",
        :array false,
        :required false,
        :value "bool"}],
      :backbone-elements [],
      :name "Patient_Communication"}
     {:elements
      [{:name "name",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "Base.HumanName"}
       {:name "gender",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "string"}
       {:name "period",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "Base.Period"}
       {:name "address",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "Base.Address"}
       {:name "telecom",
        :base "Patient_Contact",
        :array true,
        :required false,
        :value "Base.ContactPoint"}
       {:name "organization",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "Base.ResourceReference"}
       {:name "relationship",
        :base "Patient_Contact",
        :array true,
        :required false,
        :value "Base.CodeableConcept"}],
      :backbone-elements [],
      :name "Patient_Contact"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"}])

(def schemas-with-element-choices-resolved
  [{:package "hl7.fhir.r4.core",
    :derivation "specialization",
    :name "Patient",
    :type "Patient",
    :elements
    [{:name "multipleBirthBoolean",
      :base "Patient",
      :array false,
      :required false,
      :value "bool"}
     {:name "address",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.Address"}
     {:name "deceasedDateTime",
      :base "Patient",
      :array false,
      :required false,
      :value "string"}
     {:name "managingOrganization",
      :base "Patient",
      :array false,
      :required false,
      :value "Base.ResourceReference"}
     {:name "deceasedBoolean",
      :base "Patient",
      :array false,
      :required false,
      :value "bool"}
     {:name "name",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.HumanName"}
     {:name "birthDate",
      :base "Patient",
      :array false,
      :required false,
      :value "string"}
     {:name "multipleBirthInteger",
      :base "Patient",
      :array false,
      :required false,
      :value "int"}
     {:name "multipleBirth",
      :choices
      [{:name "multipleBirthBoolean",
        :base "Patient",
        :array false,
        :required false,
        :value "bool"}
       {:name "multipleBirthInteger",
        :base "Patient",
        :array false,
        :required false,
        :value "int"}],
      :base "Patient",
      :array false,
      :required false}
     {:name "deceased",
      :choices
      [{:name "deceasedDateTime",
        :base "Patient",
        :array false,
        :required false,
        :value "string"}
       {:name "deceasedBoolean",
        :base "Patient",
        :array false,
        :required false,
        :value "bool"}],
      :base "Patient",
      :array false,
      :required false}
     {:name "photo",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.Attachment"}
     {:name "link",
      :base "Patient",
      :array true,
      :required false,
      :value "Patient_Link"}
     {:name "active",
      :base "Patient",
      :array false,
      :required false,
      :value "bool"}
     {:name "communication",
      :base "Patient",
      :array true,
      :required false,
      :value "Patient_Communication"}
     {:name "identifier",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.Identifier"}
     {:name "telecom",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.ContactPoint"}
     {:name "generalPractitioner",
      :base "Patient",
      :array true,
      :required false,
      :value "Base.ResourceReference"}
     {:name "gender",
      :base "Patient",
      :array false,
      :required false,
      :value "string"}
     {:name "maritalStatus",
      :base "Patient",
      :array false,
      :required false,
      :value "Base.CodeableConcept"}
     {:name "contact",
      :base "Patient",
      :array true,
      :required false,
      :value "Patient_Contact"}],
    :url "http://hl7.org/fhir/StructureDefinition/Patient",
    :backbone-elements
    [{:elements
      [{:name "type",
        :base "Patient_Link",
        :array false,
        :required true,
        :value "string"}
       {:name "other",
        :base "Patient_Link",
        :array false,
        :required true,
        :value "Base.ResourceReference"}],
      :backbone-elements [],
      :name "Patient_Link"}
     {:elements
      [{:name "language",
        :base "Patient_Communication",
        :array false,
        :required true,
        :value "Base.CodeableConcept"}
       {:name "preferred",
        :base "Patient_Communication",
        :array false,
        :required false,
        :value "bool"}],
      :backbone-elements [],
      :name "Patient_Communication"}
     {:elements
      [{:name "name",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "Base.HumanName"}
       {:name "gender",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "string"}
       {:name "period",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "Base.Period"}
       {:name "address",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "Base.Address"}
       {:name "telecom",
        :base "Patient_Contact",
        :array true,
        :required false,
        :value "Base.ContactPoint"}
       {:name "organization",
        :base "Patient_Contact",
        :array false,
        :required false,
        :value "Base.ResourceReference"}
       {:name "relationship",
        :base "Patient_Contact",
        :array true,
        :required false,
        :value "Base.CodeableConcept"}],
      :backbone-elements [],
      :name "Patient_Contact"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"}])

(def patient-fhir-schema
  {:package "hl7.fhir.r4.core",
   :technical-id
   "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/Patient/4.0.1",
   :derivation "specialization",
   :fhirVersion nil,
   :name "Patient",
   :type "Patient",
   :resourceType "FHIRSchema",
   :elements
   {:multipleBirthBoolean
    {:type "boolean", :scalar true, :choiceOf "multipleBirth"},
    :address {:type "Address", :array true, :summary true},
    :deceasedDateTime
    {:type "dateTime",
     :scalar true,
     :summary true,
     :choiceOf "deceased",
     :modifier true},
    :managingOrganization
    {:type "Reference",
     :refers ["http://hl7.org/fhir/StructureDefinition/Organization"],
     :scalar true,
     :summary true},
    :deceasedBoolean
    {:type "boolean",
     :scalar true,
     :summary true,
     :choiceOf "deceased",
     :modifier true},
    :name {:type "HumanName", :array true, :summary true},
    :birthDate {:type "date", :scalar true, :summary true},
    :multipleBirthInteger
    {:type "integer", :scalar true, :choiceOf "multipleBirth"},
    :multipleBirth
    {:scalar true, :choices ["multipleBirthBoolean" "multipleBirthInteger"]},
    :deceased {:scalar true, :choices ["deceasedBoolean" "deceasedDateTime"]},
    :photo {:type "Attachment", :array true},
    :link
    {:type "BackboneElement",
     :array true,
     :summary true,
     :elements
     {:type
      {:type "code",
       :scalar true,
       :binding
       {:strength "required",
        :valueSet "http://hl7.org/fhir/ValueSet/link-type",
        :codesystems ["http://hl7.org/fhir/link-type"]},
       :summary true},
      :other
      {:type "Reference",
       :refers
       ["http://hl7.org/fhir/StructureDefinition/Patient"
        "http://hl7.org/fhir/StructureDefinition/RelatedPerson"],
       :scalar true,
       :summary true}},
     :modifier true,
     :required ["other" "type"]},
    :active {:type "boolean", :scalar true, :summary true, :modifier true},
    :communication
    {:type "BackboneElement",
     :array true,
     :elements
     {:language
      {:type "CodeableConcept",
       :scalar true,
       :binding
       {:strength "preferred",
        :valueSet "http://hl7.org/fhir/ValueSet/languages"}},
      :preferred {:type "boolean", :scalar true}},
     :required ["language"]},
    :identifier {:type "Identifier", :array true, :summary true},
    :telecom {:type "ContactPoint", :array true, :summary true},
    :generalPractitioner
    {:type "Reference",
     :array true,
     :refers
     ["http://hl7.org/fhir/StructureDefinition/Organization"
      "http://hl7.org/fhir/StructureDefinition/Practitioner"
      "http://hl7.org/fhir/StructureDefinition/PractitionerRole"]},
    :gender
    {:type "code",
     :scalar true,
     :binding
     {:strength "required",
      :valueSet "http://hl7.org/fhir/ValueSet/administrative-gender",
      :codesystems ["http://hl7.org/fhir/administrative-gender"]},
     :summary true},
    :maritalStatus
    {:type "CodeableConcept",
     :scalar true,
     :binding
     {:strength "extensible",
      :valueSet "http://hl7.org/fhir/ValueSet/marital-status"}},
    :contact
    {:type "BackboneElement",
     :array true,
     :elements
     {:name {:type "HumanName", :scalar true},
      :gender
      {:type "code",
       :scalar true,
       :binding
       {:strength "required",
        :valueSet "http://hl7.org/fhir/ValueSet/administrative-gender",
        :codesystems ["http://hl7.org/fhir/administrative-gender"]}},
      :period {:type "Period", :scalar true},
      :address {:type "Address", :scalar true},
      :telecom {:type "ContactPoint", :array true},
      :organization
      {:type "Reference",
       :refers ["http://hl7.org/fhir/StructureDefinition/Organization"],
       :scalar true},
      :relationship
      {:type "CodeableConcept",
       :array true,
       :binding
       {:strength "extensible",
        :valueSet "http://hl7.org/fhir/ValueSet/patient-contactrelationship"}}},
     :constraints
     {:pat-1
      {:human
       "SHALL at least contain a contact's details or a reference to an organization",
       :severity "error",
       :expression
       "name.exists() or telecom.exists() or address.exists() or organization.exists()"}}}},
   :id "Patient",
   :kind "resource",
   :url "http://hl7.org/fhir/StructureDefinition/Patient",
   :packageVersion "4.0.1",
   :base "http://hl7.org/fhir/StructureDefinition/DomainResource",
   :version "4.0.1"})

(def patient-ir-schema
  {:package "hl7.fhir.r4.core",
  :derivation "specialization",
  :name "Patient",
  :type "Patient",
  :elements
  [{:name "multipleBirthBoolean",
    :base "Patient",
    :array false,
    :required false,
    :value "bool",
    :type "boolean",
    :choice-option true}
   {:name "address",
    :base "Patient",
    :array true,
    :required false,
    :value "Base.Address",
    :type "Address",
    :choice-option false}
   {:name "deceasedDateTime",
    :base "Patient",
    :array false,
    :required false,
    :value "string",
    :type "dateTime",
    :choice-option true}
   {:name "managingOrganization",
    :base "Patient",
    :array false,
    :required false,
    :value "Base.ResourceReference",
    :type "Reference",
    :choice-option false}
   {:name "deceasedBoolean",
    :base "Patient",
    :array false,
    :required false,
    :value "bool",
    :type "boolean",
    :choice-option true}
   {:name "name",
    :base "Patient",
    :array true,
    :required false,
    :value "Base.HumanName",
    :type "HumanName",
    :choice-option false}
   {:name "birthDate",
    :base "Patient",
    :array false,
    :required false,
    :value "string",
    :type "date",
    :choice-option false}
   {:name "multipleBirthInteger",
    :base "Patient",
    :array false,
    :required false,
    :value "int",
    :type "integer",
    :choice-option true}
   {:name "multipleBirth",
    :choices
    [{:name "multipleBirthBoolean",
      :base "Patient",
      :array false,
      :required false,
      :value "bool",
      :type "boolean",
      :choice-option true}
     {:name "multipleBirthInteger",
      :base "Patient",
      :array false,
      :required false,
      :value "int",
      :type "integer",
      :choice-option true}],
    :base "Patient",
    :array false,
    :required false}
   {:name "deceased",
    :choices
    [{:name "deceasedDateTime",
      :base "Patient",
      :array false,
      :required false,
      :value "string",
      :type "dateTime",
      :choice-option true}
     {:name "deceasedBoolean",
      :base "Patient",
      :array false,
      :required false,
      :value "bool",
      :type "boolean",
      :choice-option true}],
    :base "Patient",
    :array false,
    :required false}
   {:name "photo",
    :base "Patient",
    :array true,
    :required false,
    :value "Base.Attachment",
    :type "Attachment",
    :choice-option false}
   {:name "link",
    :base "Patient",
    :array true,
    :required false,
    :value "Patient_Link",
    :type "BackboneElement",
    :choice-option false}
   {:name "active",
    :base "Patient",
    :array false,
    :required false,
    :value "bool",
    :type "boolean",
    :choice-option false}
   {:name "communication",
    :base "Patient",
    :array true,
    :required false,
    :value "Patient_Communication",
    :type "BackboneElement",
    :choice-option false}
   {:name "identifier",
    :base "Patient",
    :array true,
    :required false,
    :value "Base.Identifier",
    :type "Identifier",
    :choice-option false}
   {:name "telecom",
    :base "Patient",
    :array true,
    :required false,
    :value "Base.ContactPoint",
    :type "ContactPoint",
    :choice-option false}
   {:name "generalPractitioner",
    :base "Patient",
    :array true,
    :required false,
    :value "Base.ResourceReference",
    :type "Reference",
    :choice-option false}
   {:name "gender",
    :base "Patient",
    :array false,
    :required false,
    :value "string",
    :type "code",
    :choice-option false}
   {:name "maritalStatus",
    :base "Patient",
    :array false,
    :required false,
    :value "Base.CodeableConcept",
    :type "CodeableConcept",
    :choice-option false}
   {:name "contact",
    :base "Patient",
    :array true,
    :required false,
    :value "Patient_Contact",
    :type "BackboneElement",
    :choice-option false}],
  :url "http://hl7.org/fhir/StructureDefinition/Patient",
  :base-resource-name "DomainResource",
  :backbone-elements
  [{:elements
    [{:name "type",
      :base "Patient_Link",
      :array false,
      :required true,
      :value "string",
      :type "code",
      :choice-option false}
     {:name "other",
      :base "Patient_Link",
      :array false,
      :required true,
      :value "Base.ResourceReference",
      :type "Reference",
      :choice-option false}],
    :name "Patient_Link"}
   {:elements
    [{:name "language",
      :base "Patient_Communication",
      :array false,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept",
      :choice-option false}
     {:name "preferred",
      :base "Patient_Communication",
      :array false,
      :required false,
      :value "bool",
      :type "boolean",
      :choice-option false}],
    :name "Patient_Communication"}
   {:elements
    [{:name "name",
      :base "Patient_Contact",
      :array false,
      :required false,
      :value "Base.HumanName",
      :type "HumanName",
      :choice-option false}
     {:name "gender",
      :base "Patient_Contact",
      :array false,
      :required false,
      :value "string",
      :type "code",
      :choice-option false}
     {:name "period",
      :base "Patient_Contact",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period",
      :choice-option false}
     {:name "address",
      :base "Patient_Contact",
      :array false,
      :required false,
      :value "Base.Address",
      :type "Address",
      :choice-option false}
     {:name "telecom",
      :base "Patient_Contact",
      :array true,
      :required false,
      :value "Base.ContactPoint",
      :type "ContactPoint",
      :choice-option false}
     {:name "organization",
      :base "Patient_Contact",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference",
      :choice-option false}
     {:name "relationship",
      :base "Patient_Contact",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept",
      :choice-option false}],
    :name "Patient_Contact"}],
  :base "http://hl7.org/fhir/StructureDefinition/DomainResource",
  :deps
  #{"Address"
    "Attachment"
    "Period"
    "CodeableConcept"
    "ContactPoint"
    "HumanName"
    "DomainResource"
    "Reference"
    "Identifier"
    "BackboneElement"}})

(def organization-preferred-contact-fhir-schema
  {:package "hl7.fhir.r4.core",
   :technical-id
   "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/organization-preferredContact/4.0.1",
   :derivation "constraint",
   :fhirVersion nil,
   :excluded ["extension"],
   :name "organization-preferredContact",
   :type "Extension",
   :resourceType "FHIRSchema",
   :elements
   {:url
    {:fixed
     "http://hl7.org/fhir/StructureDefinition/organization-preferredContact"},
    :value {:choices ["valueBoolean"]},
    :valueBoolean {:type "boolean", :choiceOf "value", :required-element true}},
   :id "organization-preferredContact",
   :kind "complex-type",
   :url "http://hl7.org/fhir/StructureDefinition/organization-preferredContact",
   :packageVersion "4.0.1",
   :base "http://hl7.org/fhir/StructureDefinition/Extension",
   :version "4.0.1",
   :required ["value"]})

(def organization-preferred-contact-ir-schema
  {:package "hl7.fhir.r4.core",
   :derivation "constraint",
   :name "Extension",
   :type "Extension",
   :elements
   [{:name "url",
     :base "Extension",
     :array false,
     :required false,
     :value "string",
     :type nil,
     :choice-option false}
    {:name "value",
     :choices
     [{:name "valueBoolean",
       :base "Extension",
       :array false,
       :required false,
       :value "bool",
       :type "boolean",
       :choice-option true}],
     :base "Extension",
     :array false,
     :required false}
    {:name "valueBoolean",
     :base "Extension",
     :array false,
     :required false,
     :value "bool",
     :type "boolean",
     :choice-option true}],
   :url "http://hl7.org/fhir/StructureDefinition/organization-preferredContact",
   :base-resource-name "Extension",
   :backbone-elements (),
   :base "http://hl7.org/fhir/StructureDefinition/Extension",
   :deps #{"Extension"}})

(def unflattened-backbone-elements
  [{:elements
    [{:name "uri",
      :base "TestReport_Participant",
      :array false,
      :required true,
      :value "string"}
     {:name "type",
      :base "TestReport_Participant",
      :array false,
      :required true,
      :value "string"}
     {:name "display",
      :base "TestReport_Participant",
      :array false,
      :required false,
      :value "string"}],
    :backbone-elements [],
    :name "TestReport_Participant"}
   {:elements
    [{:name "action",
      :base "TestReport_Setup",
      :array true,
      :required true,
      :value "TestReport_Setup_Action"}],
    :backbone-elements
    [{:elements
      [{:name "assert_",
        :base "TestReport_Setup_Action",
        :array false,
        :required false,
        :value "TestReport_Setup_Action_Assert"}
       {:name "operation",
        :base "TestReport_Setup_Action",
        :array false,
        :required false,
        :value "TestReport_Setup_Action_Operation"}],
      :backbone-elements
      ({:elements
        [{:name "detail",
          :base "TestReport_Setup_Action_Assert",
          :array false,
          :required false,
          :value "string"}
         {:name "result",
          :base "TestReport_Setup_Action_Assert",
          :array false,
          :required true,
          :value "string"}
         {:name "message",
          :base "TestReport_Setup_Action_Assert",
          :array false,
          :required false,
          :value "string"}],
        :backbone-elements [],
        :name "TestReport_Setup_Action_Assert"}
       {:elements
        [{:name "detail",
          :base "TestReport_Setup_Action_Operation",
          :array false,
          :required false,
          :value "string"}
         {:name "result",
          :base "TestReport_Setup_Action_Operation",
          :array false,
          :required true,
          :value "string"}
         {:name "message",
          :base "TestReport_Setup_Action_Operation",
          :array false,
          :required false,
          :value "string"}],
        :backbone-elements [],
        :name "TestReport_Setup_Action_Operation"}),
      :name "TestReport_Setup_Action"}],
    :name "TestReport_Setup"}
   {:elements
    [{:name "action",
      :base "TestReport_Teardown",
      :array true,
      :required true,
      :value "TestReport_Teardown_Action"}],
    :backbone-elements
    [{:elements
      [{:name "operation",
        :base "TestReport_Teardown_Action",
        :array false,
        :required true,
        :value "TestReport_Teardown_Action_Operation"}],
      :backbone-elements
      [{:elements
        [{:name "detail",
          :base "TestReport_Teardown_Action_Operation",
          :array false,
          :required false,
          :value "string"}
         {:name "result",
          :base "TestReport_Teardown_Action_Operation",
          :array false,
          :required true,
          :value "string"}
         {:name "message",
          :base "TestReport_Teardown_Action_Operation",
          :array false,
          :required false,
          :value "string"}],
        :backbone-elements [],
        :name "TestReport_Teardown_Action_Operation"}],
      :name "TestReport_Teardown_Action"}],
    :name "TestReport_Teardown"}
   {:elements
    [{:name "name",
      :base "TestReport_Test",
      :array false,
      :required false,
      :value "string"}
     {:name "action",
      :base "TestReport_Test",
      :array true,
      :required true,
      :value "TestReport_Test_Action"}
     {:name "description",
      :base "TestReport_Test",
      :array false,
      :required false,
      :value "string"}],
    :backbone-elements
    [{:elements
      [{:name "assert_",
        :base "TestReport_Test_Action",
        :array false,
        :required false,
        :value "TestReport_Test_Action_Assert"}
       {:name "operation",
        :base "TestReport_Test_Action",
        :array false,
        :required false,
        :value "TestReport_Test_Action_Operation"}],
      :backbone-elements
      [{:elements
        [{:name "detail",
          :base "TestReport_Test_Action_Assert",
          :array false,
          :required false,
          :value "string"}
         {:name "result",
          :base "TestReport_Test_Action_Assert",
          :array false,
          :required true,
          :value "string"}
         {:name "message",
          :base "TestReport_Test_Action_Assert",
          :array false,
          :required false,
          :value "string"}],
        :backbone-elements [],
        :name "TestReport_Test_Action_Assert"}
       {:elements
        [{:name "detail",
          :base "TestReport_Test_Action_Operation",
          :array false,
          :required false,
          :value "string"}
         {:name "result",
          :base "TestReport_Test_Action_Operation",
          :array false,
          :required true,
          :value "string"}
         {:name "message",
          :base "TestReport_Test_Action_Operation",
          :array false,
          :required false,
          :value "string"}],
        :backbone-elements [],
        :name "TestReport_Test_Action_Operation"}],
      :name "TestReport_Test_Action"}],
    :name "TestReport_Test"}])

(def flattened-backbone-elements
  [{:elements
    [{:name "uri",
      :base "TestReport_Participant",
      :array false,
      :required true,
      :value "string"}
     {:name "type",
      :base "TestReport_Participant",
      :array false,
      :required true,
      :value "string"}
     {:name "display",
      :base "TestReport_Participant",
      :array false,
      :required false,
      :value "string"}],
    :name "TestReport_Participant"}
   {:elements
    [{:name "assert_",
      :base "TestReport_Setup_Action",
      :array false,
      :required false,
      :value "TestReport_Setup_Action_Assert"}
     {:name "operation",
      :base "TestReport_Setup_Action",
      :array false,
      :required false,
      :value "TestReport_Setup_Action_Operation"}],
    :name "TestReport_Setup_Action"}
   {:elements
    [{:name "action",
      :base "TestReport_Setup",
      :array true,
      :required true,
      :value "TestReport_Setup_Action"}],
    :name "TestReport_Setup"}
   {:elements
    [{:name "detail",
      :base "TestReport_Teardown_Action_Operation",
      :array false,
      :required false,
      :value "string"}
     {:name "result",
      :base "TestReport_Teardown_Action_Operation",
      :array false,
      :required true,
      :value "string"}
     {:name "message",
      :base "TestReport_Teardown_Action_Operation",
      :array false,
      :required false,
      :value "string"}],
    :name "TestReport_Teardown_Action_Operation"}
   {:elements
    [{:name "operation",
      :base "TestReport_Teardown_Action",
      :array false,
      :required true,
      :value "TestReport_Teardown_Action_Operation"}],
    :name "TestReport_Teardown_Action"}
   {:elements
    [{:name "action",
      :base "TestReport_Teardown",
      :array true,
      :required true,
      :value "TestReport_Teardown_Action"}],
    :name "TestReport_Teardown"}
   {:elements
    [{:name "detail",
      :base "TestReport_Test_Action_Assert",
      :array false,
      :required false,
      :value "string"}
     {:name "result",
      :base "TestReport_Test_Action_Assert",
      :array false,
      :required true,
      :value "string"}
     {:name "message",
      :base "TestReport_Test_Action_Assert",
      :array false,
      :required false,
      :value "string"}],
    :name "TestReport_Test_Action_Assert"}
   {:elements
    [{:name "detail",
      :base "TestReport_Test_Action_Operation",
      :array false,
      :required false,
      :value "string"}
     {:name "result",
      :base "TestReport_Test_Action_Operation",
      :array false,
      :required true,
      :value "string"}
     {:name "message",
      :base "TestReport_Test_Action_Operation",
      :array false,
      :required false,
      :value "string"}],
    :name "TestReport_Test_Action_Operation"}
   {:elements
    [{:name "assert_",
      :base "TestReport_Test_Action",
      :array false,
      :required false,
      :value "TestReport_Test_Action_Assert"}
     {:name "operation",
      :base "TestReport_Test_Action",
      :array false,
      :required false,
      :value "TestReport_Test_Action_Operation"}],
    :name "TestReport_Test_Action"}
   {:elements
    [{:name "name",
      :base "TestReport_Test",
      :array false,
      :required false,
      :value "string"}
     {:name "action",
      :base "TestReport_Test",
      :array true,
      :required true,
      :value "TestReport_Test_Action"}
     {:name "description",
      :base "TestReport_Test",
      :array false,
      :required false,
      :value "string"}],
    :name "TestReport_Test"}])

(def coding-ir-schema {:package "hl7.fhir.r4.core",
                       :derivation "specialization",
                       :name "Coding",
                       :type "Coding",
                       :elements
                       [{:name "code",
                         :base "Coding",
                         :array false,
                         :required false,
                         :value "string"
                         :type "string"}
                        {:name "system",
                         :base "Coding",
                         :array false,
                         :required false,
                         :value "string"
                         :type "string"}
                        {:name "display",
                         :base "Coding",
                         :array false,
                         :required false,
                         :type "string"
                         :value "string"}
                        {:name "version",
                         :base "Coding",
                         :array false,
                         :required false,
                         :type "string"
                         :value "string"}
                        {:name "userSelected",
                         :base "Coding",
                         :array false,
                         :required false,
                         :type "boolean"
                         :value "bool"}],
                       :url "http://hl7.org/fhir/StructureDefinition/Coding",
                       :backbone-elements (),
                       :base "http://hl7.org/fhir/StructureDefinition/Element"})

(def patient-search-params-schemas
  [{:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A portion of either family or given name using some kind of phonetic matching algorithm\r\n* [Person](person.html): A portion of name using some kind of phonetic matching algorithm\r\n* [Practitioner](practitioner.html): A portion of either family or given name using some kind of phonetic matching algorithm\r\n* [RelatedPerson](relatedperson.html): A portion of name using some kind of phonetic matching algorithm\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-phonetic/4.0.1",
    :expression
    "Patient.name | Person.name | Practitioner.name | RelatedPerson.name",
    :fhirVersion nil,
    :name "phonetic",
    :xpath
    "f:Patient/f:name | f:Person/f:name | f:Practitioner/f:name | f:RelatedPerson/f:name",
    :xpathUsage "phonetic",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-phonetic",
    :url "http://hl7.org/fhir/SearchParameter/individual-phonetic",
    :code "phonetic",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-phonetic"}
   {:description "Whether the patient record is active",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-active/4.0.1",
    :expression "Patient.active",
    :fhirVersion nil,
    :name "active",
    :xpath "f:Patient/f:active",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-active",
    :url "http://hl7.org/fhir/SearchParameter/Patient-active",
    :code "active",
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-active"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A state specified in an address\r\n* [Person](person.html): A state specified in an address\r\n* [Practitioner](practitioner.html): A state specified in an address\r\n* [RelatedPerson](relatedperson.html): A state specified in an address\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-address-state/4.0.1",
    :expression
    "Patient.address.state | Person.address.state | Practitioner.address.state | RelatedPerson.address.state",
    :fhirVersion nil,
    :name "address-state",
    :xpath
    "f:Patient/f:address/f:state | f:Person/f:address/f:state | f:Practitioner/f:address/f:state | f:RelatedPerson/f:address/f:state",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-address-state",
    :url "http://hl7.org/fhir/SearchParameter/individual-address-state",
    :code "address-state",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-address-state"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A portion of the given name of the patient\r\n* [Practitioner](practitioner.html): A portion of the given name\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-given/4.0.1",
    :expression "Patient.name.given | Practitioner.name.given",
    :fhirVersion nil,
    :name "given",
    :xpath "f:Patient/f:name/f:given | f:Practitioner/f:name/f:given",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-given",
    :url "http://hl7.org/fhir/SearchParameter/individual-given",
    :code "given",
    :packageVersion "4.0.1",
    :base ["Patient" "Practitioner"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-given"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): Gender of the patient\r\n* [Person](person.html): The gender of the person\r\n* [Practitioner](practitioner.html): Gender of the practitioner\r\n* [RelatedPerson](relatedperson.html): Gender of the related person\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-gender/4.0.1",
    :expression
    "Patient.gender | Person.gender | Practitioner.gender | RelatedPerson.gender",
    :fhirVersion nil,
    :name "gender",
    :xpath
    "f:Patient/f:gender | f:Person/f:gender | f:Practitioner/f:gender | f:RelatedPerson/f:gender",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-gender",
    :url "http://hl7.org/fhir/SearchParameter/individual-gender",
    :code "gender",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-gender"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A city specified in an address\r\n* [Person](person.html): A city specified in an address\r\n* [Practitioner](practitioner.html): A city specified in an address\r\n* [RelatedPerson](relatedperson.html): A city specified in an address\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-address-city/4.0.1",
    :expression
    "Patient.address.city | Person.address.city | Practitioner.address.city | RelatedPerson.address.city",
    :fhirVersion nil,
    :name "address-city",
    :xpath
    "f:Patient/f:address/f:city | f:Person/f:address/f:city | f:Practitioner/f:address/f:city | f:RelatedPerson/f:address/f:city",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-address-city",
    :url "http://hl7.org/fhir/SearchParameter/individual-address-city",
    :code "address-city",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-address-city"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A portion of the family name of the patient\r\n* [Practitioner](practitioner.html): A portion of the family name\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-family/4.0.1",
    :expression "Patient.name.family | Practitioner.name.family",
    :fhirVersion nil,
    :name "family",
    :xpath "f:Patient/f:name/f:family | f:Practitioner/f:name/f:family",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-family",
    :url "http://hl7.org/fhir/SearchParameter/individual-family",
    :code "family",
    :packageVersion "4.0.1",
    :base ["Patient" "Practitioner"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-family"}
   {:description
    "Search based on whether a patient was part of a multiple birth or not.",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-birthOrderBoolean/4.0.1",
    :fhirVersion nil,
    :name "birthOrderBoolean",
    :xpath "f:Patient/f:multipleBirthBoolean | f:Patient/f:multipleBirthInteger",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "patient-extensions-Patient-birthOrderBoolean",
    :url
    "http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-birthOrderBoolean",
    :code "birthOrderBoolean",
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/patient-extensions-Patient-birthOrderBoolean"}
   {:description "The organization that is the custodian of the patient record",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-organization/4.0.1",
    :expression "Patient.managingOrganization",
    :fhirVersion nil,
    :name "organization",
    :xpath "f:Patient/f:managingOrganization",
    :xpathUsage "normal",
    :type "reference",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-organization",
    :url "http://hl7.org/fhir/SearchParameter/Patient-organization",
    :code "organization",
    :packageVersion "4.0.1",
    :target ["Organization"],
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-organization"}
   {:description
    "A server defined search that may match any of the string fields in the HumanName, including family, give, prefix, suffix, suffix, and/or text",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-name/4.0.1",
    :expression "Patient.name",
    :fhirVersion nil,
    :name "name",
    :xpath "f:Patient/f:name",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-name",
    :url "http://hl7.org/fhir/SearchParameter/Patient-name",
    :code "name",
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-name"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): The patient's date of birth\r\n* [Person](person.html): The person's date of birth\r\n* [RelatedPerson](relatedperson.html): The Related Person's date of birth\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-birthdate/4.0.1",
    :expression "Patient.birthDate | Person.birthDate | RelatedPerson.birthDate",
    :fhirVersion nil,
    :name "birthdate",
    :xpath
    "f:Patient/f:birthDate | f:Person/f:birthDate | f:RelatedPerson/f:birthDate",
    :xpathUsage "normal",
    :type "date",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-birthdate",
    :url "http://hl7.org/fhir/SearchParameter/individual-birthdate",
    :code "birthdate",
    :comparator ["eq" "ne" "gt" "ge" "lt" "le" "sa" "eb" "ap"],
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-birthdate"}
   {:description
    "Search by url for a participation agreement, which is stored in a DocumentReference",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/example-extension/4.0.1",
    :expression
    "DocumentReference.extension('http://example.org/fhir/StructureDefinition/participation-agreement')",
    :fhirVersion nil,
    :name "Example Search Parameter on an extension",
    :xpath
    "f:DocumentReference/f:extension[@url='http://example.org/fhir/StructureDefinition/participation-agreement']",
    :xpathUsage "normal",
    :type "reference",
    :resourceType "SearchParameter",
    :status "draft",
    :id "example-extension",
    :url "http://hl7.org/fhir/SearchParameter/example-extension",
    :code "part-agree",
    :packageVersion "4.0.1",
    :target ["DocumentReference"],
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/example-extension"}
   {:description "Language code (irrespective of use value)",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-language/4.0.1",
    :expression "Patient.communication.language",
    :fhirVersion nil,
    :name "language",
    :xpath "f:Patient/f:communication/f:language",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-language",
    :url "http://hl7.org/fhir/SearchParameter/Patient-language",
    :code "language",
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-language"}
   {:description
    "This patient has been marked as deceased, or as a death date entered",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-deceased/4.0.1",
    :expression "Patient.deceased.exists() and Patient.deceased != false",
    :fhirVersion nil,
    :name "deceased",
    :xpath "f:Patient/f:deceasedBoolean | f:Patient/f:deceasedDateTime",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-deceased",
    :url "http://hl7.org/fhir/SearchParameter/Patient-deceased",
    :code "deceased",
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-deceased"}
   {:description "A patient identifier",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-identifier/4.0.1",
    :expression "Patient.identifier",
    :fhirVersion nil,
    :name "identifier",
    :xpath "f:Patient/f:identifier",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-identifier",
    :url "http://hl7.org/fhir/SearchParameter/Patient-identifier",
    :code "identifier",
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-identifier"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A use code specified in an address\r\n* [Person](person.html): A use code specified in an address\r\n* [Practitioner](practitioner.html): A use code specified in an address\r\n* [RelatedPerson](relatedperson.html): A use code specified in an address\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-address-use/4.0.1",
    :expression
    "Patient.address.use | Person.address.use | Practitioner.address.use | RelatedPerson.address.use",
    :fhirVersion nil,
    :name "address-use",
    :xpath
    "f:Patient/f:address/f:use | f:Person/f:address/f:use | f:Practitioner/f:address/f:use | f:RelatedPerson/f:address/f:use",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-address-use",
    :url "http://hl7.org/fhir/SearchParameter/individual-address-use",
    :code "address-use",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-address-use"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text\r\n* [Person](person.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text\r\n* [Practitioner](practitioner.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text\r\n* [RelatedPerson](relatedperson.html): A server defined search that may match any of the string fields in the Address, including line, city, district, state, country, postalCode, and/or text\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-address/4.0.1",
    :expression
    "Patient.address | Person.address | Practitioner.address | RelatedPerson.address",
    :fhirVersion nil,
    :name "address",
    :xpath
    "f:Patient/f:address | f:Person/f:address | f:Practitioner/f:address | f:RelatedPerson/f:address",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-address",
    :url "http://hl7.org/fhir/SearchParameter/individual-address",
    :code "address",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-address"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): The value in any kind of telecom details of the patient\r\n* [Person](person.html): The value in any kind of contact\r\n* [Practitioner](practitioner.html): The value in any kind of contact\r\n* [PractitionerRole](practitionerrole.html): The value in any kind of contact\r\n* [RelatedPerson](relatedperson.html): The value in any kind of contact\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-telecom/4.0.1",
    :expression
    "Patient.telecom | Person.telecom | Practitioner.telecom | PractitionerRole.telecom | RelatedPerson.telecom",
    :fhirVersion nil,
    :name "telecom",
    :xpath
    "f:Patient/f:telecom | f:Person/f:telecom | f:Practitioner/f:telecom | f:PractitionerRole/f:telecom | f:RelatedPerson/f:telecom",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-telecom",
    :url "http://hl7.org/fhir/SearchParameter/individual-telecom",
    :code "telecom",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "PractitionerRole" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-telecom"}
   {:description "All patients linked to the given patient",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-link/4.0.1",
    :expression "Patient.link.other",
    :fhirVersion nil,
    :name "link",
    :xpath "f:Patient/f:link/f:other",
    :xpathUsage "normal",
    :type "reference",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-link",
    :url "http://hl7.org/fhir/SearchParameter/Patient-link",
    :code "link",
    :packageVersion "4.0.1",
    :target ["Patient" "RelatedPerson"],
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-link"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A value in an email contact\r\n* [Person](person.html): A value in an email contact\r\n* [Practitioner](practitioner.html): A value in an email contact\r\n* [PractitionerRole](practitionerrole.html): A value in an email contact\r\n* [RelatedPerson](relatedperson.html): A value in an email contact\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-email/4.0.1",
    :expression
    "Patient.telecom.where(system='email') | Person.telecom.where(system='email') | Practitioner.telecom.where(system='email') | PractitionerRole.telecom.where(system='email') | RelatedPerson.telecom.where(system='email')",
    :fhirVersion nil,
    :name "email",
    :xpath
    "f:Patient/f:telecom[system/@value='email'] | f:Person/f:telecom[system/@value='email'] | f:Practitioner/f:telecom[system/@value='email'] | f:PractitionerRole/f:telecom[system/@value='email'] | f:RelatedPerson/f:telecom[system/@value='email']",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-email",
    :url "http://hl7.org/fhir/SearchParameter/individual-email",
    :code "email",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "PractitionerRole" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-email"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A country specified in an address\r\n* [Person](person.html): A country specified in an address\r\n* [Practitioner](practitioner.html): A country specified in an address\r\n* [RelatedPerson](relatedperson.html): A country specified in an address\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-address-country/4.0.1",
    :expression
    "Patient.address.country | Person.address.country | Practitioner.address.country | RelatedPerson.address.country",
    :fhirVersion nil,
    :name "address-country",
    :xpath
    "f:Patient/f:address/f:country | f:Person/f:address/f:country | f:Practitioner/f:address/f:country | f:RelatedPerson/f:address/f:country",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-address-country",
    :url "http://hl7.org/fhir/SearchParameter/individual-address-country",
    :code "address-country",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-address-country"}
   {:description
    "The date of death has been provided and satisfies this search value",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-death-date/4.0.1",
    :expression "(Patient.deceased as dateTime)",
    :fhirVersion nil,
    :name "death-date",
    :xpath "f:Patient/f:deceasedDateTime",
    :xpathUsage "normal",
    :type "date",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-death-date",
    :url "http://hl7.org/fhir/SearchParameter/Patient-death-date",
    :code "death-date",
    :comparator ["eq" "ne" "gt" "ge" "lt" "le" "sa" "eb" "ap"],
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-death-date"}
   {:description "Search based on patient's mother's maiden name",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-mothersMaidenName/4.0.1",
    :expression
    "Patient.extension('http://hl7.org/fhir/StructureDefinition/patient-extensions-Patient-mothersMaidenName')",
    :fhirVersion nil,
    :name "mothersMaidenName",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "patient-extensions-Patient-mothersMaidenName",
    :url
    "http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-mothersMaidenName",
    :code "mothersMaidenName",
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/patient-extensions-Patient-mothersMaidenName"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A value in a phone contact\r\n* [Person](person.html): A value in a phone contact\r\n* [Practitioner](practitioner.html): A value in a phone contact\r\n* [PractitionerRole](practitionerrole.html): A value in a phone contact\r\n* [RelatedPerson](relatedperson.html): A value in a phone contact\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-phone/4.0.1",
    :expression
    "Patient.telecom.where(system='phone') | Person.telecom.where(system='phone') | Practitioner.telecom.where(system='phone') | PractitionerRole.telecom.where(system='phone') | RelatedPerson.telecom.where(system='phone')",
    :fhirVersion nil,
    :name "phone",
    :xpath
    "f:Patient/f:telecom[system/@value='phone'] | f:Person/f:telecom[system/@value='phone'] | f:Practitioner/f:telecom[system/@value='phone'] | f:PractitionerRole/f:telecom[system/@value='phone'] | f:RelatedPerson/f:telecom[system/@value='phone']",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-phone",
    :url "http://hl7.org/fhir/SearchParameter/individual-phone",
    :code "phone",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "PractitionerRole" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-phone"}
   {:description
    "Searches for patients based on age as calculated based on current date and date of birth.  Deceased patients are excluded from the search.",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-age/4.0.1",
    :fhirVersion nil,
    :name "age",
    :xpath "f:Patient/f:birthDate",
    :xpathUsage "normal",
    :type "number",
    :resourceType "SearchParameter",
    :status "draft",
    :id "patient-extensions-Patient-age",
    :url "http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-age",
    :code "age",
    :packageVersion "4.0.1",
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/patient-extensions-Patient-age"}
   {:description
    "Patient's nominated general practitioner, not the organization that manages the record",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/Patient-general-practitioner/4.0.1",
    :expression "Patient.generalPractitioner",
    :fhirVersion nil,
    :name "general-practitioner",
    :xpath "f:Patient/f:generalPractitioner",
    :xpathUsage "normal",
    :type "reference",
    :resourceType "SearchParameter",
    :status "draft",
    :id "Patient-general-practitioner",
    :url "http://hl7.org/fhir/SearchParameter/Patient-general-practitioner",
    :code "general-practitioner",
    :packageVersion "4.0.1",
    :target ["Practitioner" "Organization" "PractitionerRole"],
    :base ["Patient"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/Patient-general-practitioner"}
   {:description
    "Multiple Resources: \r\n\r\n* [Patient](patient.html): A postalCode specified in an address\r\n* [Person](person.html): A postal code specified in an address\r\n* [Practitioner](practitioner.html): A postalCode specified in an address\r\n* [RelatedPerson](relatedperson.html): A postal code specified in an address\r\n",
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/SearchParameter/http://hl7.org/fhir/SearchParameter/individual-address-postalcode/4.0.1",
    :expression
    "Patient.address.postalCode | Person.address.postalCode | Practitioner.address.postalCode | RelatedPerson.address.postalCode",
    :fhirVersion nil,
    :name "address-postalcode",
    :xpath
    "f:Patient/f:address/f:postalCode | f:Person/f:address/f:postalCode | f:Practitioner/f:address/f:postalCode | f:RelatedPerson/f:address/f:postalCode",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "draft",
    :id "individual-address-postalcode",
    :url "http://hl7.org/fhir/SearchParameter/individual-address-postalcode",
    :code "address-postalcode",
    :packageVersion "4.0.1",
    :base ["Patient" "Person" "Practitioner" "RelatedPerson"],
    :version "4.0.1",
    :fqn "hl7.fhir.r4.core#4.0.1/individual-address-postalcode"}
   {:description
    "Returns patients with a race extension matching the specified code.",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-race/4.0.0",
    :expression
    "Patient.extension.where(url = 'http://hl7.org/fhir/us/core/StructureDefinition/us-core-race').extension.value.code",
    :fhirVersion nil,
    :name "USCoreRace",
    :xpath
    "f:Patient/f:extension[@url='http://hl7.org/fhir/us/core/StructureDefinition/us-core-race']/f:extension/f:valueCoding/f:code/@value",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-race",
    :url "http://hl7.org/fhir/us/core/SearchParameter/us-core-race",
    :code "race",
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-race"}
   {:description
    "Returns patients with an ethnicity extension matching the specified code.",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-ethnicity/4.0.0",
    :expression
    "Patient.extension.where(url = 'http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity').extension.value.code",
    :fhirVersion nil,
    :name "USCoreEthnicity",
    :xpath
    "f:Patient/f:extension[@url='http://hl7.org/fhir/us/core/StructureDefinition/us-core-ethnicity']/f:extension/f:valueCoding/f:code/@value",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-ethnicity",
    :url "http://hl7.org/fhir/us/core/SearchParameter/us-core-ethnicity",
    :code "ethnicity",
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-ethnicity"}
   {:description
    "**Gender of the patient**  \n**NOTE**: This US Core SearchParameter definition extends the usage context of the\n[Conformance expectation extension](http://hl7.org/fhir/R4/extension-capabilitystatement-expectation.html)\n - multipleAnd\n - multipleOr\n - comparator\n - modifier\n - chain",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-gender/4.0.0",
    :expression "Patient.gender",
    :multipleAnd true,
    :fhirVersion nil,
    :derivedFrom "http://hl7.org/fhir/SearchParameter/individual-gender",
    :multipleOr true,
    :name "USCorePatientGender",
    :xpath "f:Patient/f:gender",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-patient-gender",
    :_multipleOr
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]},
    :url "http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-gender",
    :code "gender",
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-patient-gender",
    :_multipleAnd
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]}}
   {:description
    "**The patient's date of birth**  \n**NOTE**: This US Core SearchParameter definition extends the usage context of the\n[Conformance expectation extension](http://hl7.org/fhir/R4/extension-capabilitystatement-expectation.html)\n - multipleAnd\n - multipleOr\n - comparator\n - modifier\n - chain",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-birthdate/4.0.0",
    :expression "Patient.birthDate",
    :multipleAnd true,
    :fhirVersion nil,
    :_comparator
    [{:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}
     {:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}
     {:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}
     {:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}
     {:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}
     {:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}
     {:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}
     {:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}
     {:extension
      [{:url
        "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
        :valueCode "MAY"}]}],
    :derivedFrom "http://hl7.org/fhir/SearchParameter/individual-birthdate",
    :multipleOr true,
    :name "USCorePatientBirthdate",
    :xpath "f:Patient/f:birthDate",
    :xpathUsage "normal",
    :type "date",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-patient-birthdate",
    :_multipleOr
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]},
    :url "http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-birthdate",
    :code "birthdate",
    :comparator ["eq" "ne" "gt" "ge" "lt" "le" "sa" "eb" "ap"],
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-patient-birthdate",
    :_multipleAnd
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]}}
   {:description
    "**A patient identifier**  \n**NOTE**: This US Core SearchParameter definition extends the usage context of the\n[Conformance expectation extension](http://hl7.org/fhir/R4/extension-capabilitystatement-expectation.html)\n - multipleAnd\n - multipleOr\n - comparator\n - modifier\n - chain",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-identifier/4.0.0",
    :expression "Patient.identifier",
    :multipleAnd true,
    :fhirVersion nil,
    :derivedFrom "http://hl7.org/fhir/SearchParameter/Patient-identifier",
    :multipleOr true,
    :name "USCorePatientIdentifier",
    :xpath "f:Patient/f:identifier",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-patient-identifier",
    :_multipleOr
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]},
    :url
    "http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-identifier",
    :code "identifier",
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-patient-identifier",
    :_multipleAnd
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]}}
   {:description
    "**A portion of the given name of the patient**  \n**NOTE**: This US Core SearchParameter definition extends the usage context of the\n[Conformance expectation extension](http://hl7.org/fhir/R4/extension-capabilitystatement-expectation.html)\n - multipleAnd\n - multipleOr\n - comparator\n - modifier\n - chain",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-given/4.0.0",
    :expression "Patient.name.given",
    :multipleAnd true,
    :fhirVersion nil,
    :derivedFrom "http://hl7.org/fhir/SearchParameter/individual-given",
    :multipleOr true,
    :name "USCorePatientGiven",
    :xpath "f:Patient/f:name/f:given",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-patient-given",
    :_multipleOr
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]},
    :url "http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-given",
    :code "given",
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-patient-given",
    :_multipleAnd
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]}}
   {:description
    "**A portion of the family name of the patient**  \n**NOTE**: This US Core SearchParameter definition extends the usage context of the\n[Conformance expectation extension](http://hl7.org/fhir/R4/extension-capabilitystatement-expectation.html)\n - multipleAnd\n - multipleOr\n - comparator\n - modifier\n - chain",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-family/4.0.0",
    :expression "Patient.name.family",
    :multipleAnd true,
    :fhirVersion nil,
    :derivedFrom "http://hl7.org/fhir/SearchParameter/individual-family",
    :multipleOr true,
    :name "USCorePatientFamily",
    :xpath "f:Patient/f:name/f:family",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-patient-family",
    :_multipleOr
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]},
    :url "http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-family",
    :code "family",
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-patient-family",
    :_multipleAnd
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]}}
   {:description
    "**Logical id of this artifact**  \n**NOTE**: This US Core SearchParameter definition extends the usage context of the\n[Conformance expectation extension](http://hl7.org/fhir/R4/extension-capabilitystatement-expectation.html)\n - multipleAnd\n - multipleOr\n - comparator\n - modifier\n - chain",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-id/4.0.0",
    :expression "Patient.id",
    :multipleAnd true,
    :fhirVersion nil,
    :derivedFrom "http://hl7.org/fhir/SearchParameter/Resource-id",
    :multipleOr true,
    :name "USCorePatientId",
    :xpath "f:Patient/f:id",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-patient-id",
    :_multipleOr
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]},
    :url "http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-id",
    :code "_id",
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-patient-id",
    :_multipleAnd
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]}}
   {:description
    "**A server defined search that may match any of the string fields in the HumanName, including family, give, prefix, suffix, suffix, and/or text**  \n**NOTE**: This US Core SearchParameter definition extends the usage context of the\n[Conformance expectation extension](http://hl7.org/fhir/R4/extension-capabilitystatement-expectation.html)\n - multipleAnd\n - multipleOr\n - comparator\n - modifier\n - chain",
    :package "hl7.fhir.us.core",
    :technical-id
    "hl7.fhir.us.core/4.0.0/SearchParameter/http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-name/4.0.0",
    :expression "Patient.name",
    :multipleAnd true,
    :fhirVersion nil,
    :derivedFrom "http://hl7.org/fhir/SearchParameter/Patient-name",
    :multipleOr true,
    :name "USCorePatientName",
    :xpath "f:Patient/f:name",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "active",
    :id "us-core-patient-name",
    :_multipleOr
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]},
    :url "http://hl7.org/fhir/us/core/SearchParameter/us-core-patient-name",
    :code "name",
    :packageVersion "4.0.0",
    :base ["Patient"],
    :version "4.0.0",
    :fqn "hl7.fhir.us.core#4.0.0/us-core-patient-name",
    :_multipleAnd
    {:extension
     [{:url
       "http://hl7.org/fhir/StructureDefinition/capabilitystatement-expectation",
       :valueCode "MAY"}]}}
   {:description
    "Search based on whether a patient was part of a multiple birth or not.",
    :package "hl7.fhir.uv.extensions.r4",
    :technical-id
    "hl7.fhir.uv.extensions.r4/1.0.0/SearchParameter/http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-birthOrderBoolean/1.0.0",
    :expression "Patient.multipleBirthBoolean | Patient.multipleBirthInteger",
    :fhirVersion nil,
    :name "BirthOrderBoolean",
    :xpathUsage "normal",
    :type "token",
    :resourceType "SearchParameter",
    :status "active",
    :id "patient-extensions-Patient-birthOrderBoolean",
    :url
    "http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-birthOrderBoolean",
    :code "birthOrderBoolean",
    :packageVersion "1.0.0",
    :base ["Patient"],
    :version "1.0.0",
    :fqn
    "hl7.fhir.uv.extensions.r4#1.0.0/patient-extensions-Patient-birthOrderBoolean"}
   {:description "Search based on patient's mother's maiden name",
    :package "hl7.fhir.uv.extensions.r4",
    :technical-id
    "hl7.fhir.uv.extensions.r4/1.0.0/SearchParameter/http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-mothersMaidenName/1.0.0",
    :expression
    "Patient.extension('http://hl7.org/fhir/StructureDefinition/patient-mothersMaidenName').value",
    :fhirVersion nil,
    :name "MothersMaidenName",
    :xpathUsage "normal",
    :type "string",
    :resourceType "SearchParameter",
    :status "active",
    :id "patient-extensions-Patient-mothersMaidenName",
    :url
    "http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-mothersMaidenName",
    :code "mothersMaidenName",
    :packageVersion "1.0.0",
    :base ["Patient"],
    :version "1.0.0",
    :fqn
    "hl7.fhir.uv.extensions.r4#1.0.0/patient-extensions-Patient-mothersMaidenName"}
   {:description
    "Searches for patients based on age as calculated based on current date and date of birth.  Deceased patients are excluded from the search.",
    :package "hl7.fhir.uv.extensions.r4",
    :technical-id
    "hl7.fhir.uv.extensions.r4/1.0.0/SearchParameter/http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-age/1.0.0",
    :expression "Patient.birthDate",
    :fhirVersion nil,
    :name "Age",
    :xpathUsage "normal",
    :type "number",
    :resourceType "SearchParameter",
    :status "active",
    :id "patient-extensions-Patient-age",
    :url "http://hl7.org/fhir/SearchParameter/patient-extensions-Patient-age",
    :code "age",
    :packageVersion "1.0.0",
    :base ["Patient"],
    :version "1.0.0",
    :fqn "hl7.fhir.uv.extensions.r4#1.0.0/patient-extensions-Patient-age"}])

(def patient-search-params-ir-schemas
  [{:name "Patient"
    :base "DomainResource"
    :elements
    [{:type "string" :name "_id"}
     {:type "string" :name "active"}
     {:type "string" :name "address"}
     {:type "string" :name "address-city"}
     {:type "string" :name "address-country"}
     {:type "string" :name "address-postalcode"}
     {:type "string" :name "address-state"}
     {:type "string" :name "address-use"}
     {:type "string" :name "age"}
     {:type "string" :name "birthOrderBoolean"}
     {:type "string" :name "birthdate"}
     {:type "string" :name "death-date"}
     {:type "string" :name "deceased"}
     {:type "string" :name "email"}
     {:type "string" :name "ethnicity"}
     {:type "string" :name "family"}
     {:type "string" :name "gender"}
     {:type "string" :name "general-practitioner"}
     {:type "string" :name "given"}
     {:type "string" :name "identifier"}
     {:type "string" :name "language"}
     {:type "string" :name "link"}
     {:type "string" :name "mothersMaidenName"}
     {:type "string" :name "name"}
     {:type "string" :name "organization"}
     {:type "string" :name "part-agree"}
     {:type "string" :name "phone"}
     {:type "string" :name "phonetic"}
     {:type "string" :name "race"}
     {:type "string" :name "telecom"}]}])

(def observation-constraints
  [{:package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/ldlcholesterol/4.0.1",
    :derivation "constraint",
    :fhirVersion nil,
    :excluded ["hasMember" "derivedFrom"],
    :name "ldlcholesterol",
    :type "Observation",
    :resourceType "FHIRSchema",
    :elements
    {:code
     {:type "CodeableConcept",
      :binding
      {:strength "required",
       :valueSet "http://hl7.org/fhir/ValueSet/ldlcholesterol-codes"},
      :mustSupport true},
     :note {:type "Annotation", :array true, :mustSupport true},
     :valueQuantity {:max 1, :min 0, :type "Quantity", :mustSupport true},
     :interpretation
     {:max 1, :min 0, :type "CodeableConcept", :mustSupport true},
     :referenceRange
     {:elements
      {:age {:type "Range"},
       :high {:type "Quantity", :fixed {:value 3.0}},
       :type {:type "CodeableConcept"},
       :appliesTo {:type "CodeableConcept"}},
      :excluded ["low" "type" "appliesTo" "age"],
      :required ["high"],
      :mustSupport true}},
    :id "ldlcholesterol",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/ldlcholesterol",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/Observation",
    :version "4.0.1",
    :required ["code" "referenceRange"]}
   {:package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/cholesterol/4.0.1",
    :derivation "constraint",
    :fhirVersion nil,
    :excluded ["hasMember" "derivedFrom"],
    :name "cholesterol",
    :type "Observation",
    :resourceType "FHIRSchema",
    :elements
    {:code
     {:type "CodeableConcept",
      :fixed
      {:coding
       [{:code "35200-5",
         :system "http://loinc.org",
         :display "Cholesterol [Moles/​volume] in Serum or Plasma"}]},
      :mustSupport true},
     :note {:type "Annotation", :array true, :mustSupport true},
     :valueQuantity
     {:max 1,
      :min 0,
      :type "Quantity",
      :elements
      {:code {:type "code", :fixed "mmol/L", :mustSupport true},
       :unit {:type "string", :fixed "mmol/L", :mustSupport true},
       :value {:max 1, :min 0, :type "decimal", :mustSupport true},
       :system
       {:type "uri", :fixed "http://unitsofmeasure.org", :mustSupport true},
       :comparator {:type "code"}},
      :excluded ["comparator"],
      :required ["unit" "system" "code"],
      :mustSupport true},
     :interpretation
     {:max 1, :min 0, :type "CodeableConcept", :mustSupport true},
     :referenceRange
     {:elements
      {:age {:type "Range"},
       :high {:type "Quantity", :fixed {:value 4.5}},
       :type {:type "CodeableConcept"},
       :appliesTo {:type "CodeableConcept"}},
      :excluded ["low" "type" "appliesTo" "age"],
      :required ["high"],
      :mustSupport true}},
    :id "cholesterol",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/cholesterol",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/Observation",
    :version "4.0.1",
    :required ["code" "referenceRange"]}
   {:package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/observation-genetics/4.0.1",
    :derivation "constraint",
    :fhirVersion nil,
    :name "observation-genetics",
    :type "Observation",
    :resourceType "FHIRSchema",
    :elements
    {:extension
     {:slicing
      {:rules "open",
       :slices
       {:CopyNumberEvent
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsCopyNumberEvent"}},
         :schema {:type "Extension"}},
        :DNARegionName
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsDNARegionName"}},
         :schema {:type "Extension"}},
        :Ancestry
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsAncestry"}},
         :schema {:type "Extension"}},
        :Gene
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsGene"}},
         :schema {:type "Extension"}},
        :PhaseSet
        {:max 2147483647,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsPhaseSet"}},
         :schema {:type "Extension"}},
        :Allele
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsAllele"}},
         :schema {:type "Extension"}},
        :Interpretation
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsInterpretation"}},
         :schema {:type "Extension"}},
        :GenomicSourceClass
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsGenomicSourceClass"}},
         :schema {:type "Extension"}},
        :Variant
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsVariant"}},
         :schema {:type "Extension"}},
        :AminoAcidChange
        {:max 1,
         :min 0,
         :match
         {:type "pattern",
          :value
          {:url
           "http://hl7.org/fhir/StructureDefinition/observation-geneticsAminoAcidChange"}},
         :schema {:type "Extension"}}},
       :discriminator [{:path "url", :type "value"}]}}},
    :id "observation-genetics",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/observation-genetics",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/Observation",
    :version "4.0.1"}
   {:package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/devicemetricobservation/4.0.1",
    :derivation "constraint",
    :fhirVersion nil,
    :excluded ["encounter" "issued" "dataAbsentReason" "specimen"],
    :name "devicemetricobservation",
    :type "Observation",
    :resourceType "FHIRSchema",
    :elements
    {:referenceRange {:max 1, :min 0, :mustSupport true},
     :hasMember
     {:type "Reference",
      :array true,
      :refers ["http://hl7.org/fhir/StructureDefinition/Observation"],
      :mustSupport true},
     :derivedFrom
     {:type "Reference",
      :array true,
      :refers ["http://hl7.org/fhir/StructureDefinition/Observation"],
      :mustSupport true},
     :interpretation {:max 1, :min 0, :type "CodeableConcept"},
     :method {:max 1, :min 0, :type "CodeableConcept", :mustSupport true},
     :valueTime
     {:max 1, :min 0, :type "time", :choiceOf "value", :mustSupport true},
     :specimen
     {:type "Reference",
      :refers ["http://hl7.org/fhir/StructureDefinition/Specimen"]},
     :valueQuantity
     {:max 1, :min 0, :type "Quantity", :choiceOf "value", :mustSupport true},
     :value
     {:max 1,
      :min 0,
      :choices
      ["valueQuantity"
       "valueCodeableConcept"
       "valueString"
       "valueRange"
       "valueRatio"
       "valueSampledData"
       "valueTime"
       "valueDateTime"
       "valuePeriod"]},
     :valueString
     {:max 1, :min 0, :type "string", :choiceOf "value", :mustSupport true},
     :valueRatio
     {:max 1, :min 0, :type "Ratio", :choiceOf "value", :mustSupport true},
     :valueDateTime
     {:max 1, :min 0, :type "dateTime", :choiceOf "value", :mustSupport true},
     :note {:type "Annotation", :array true},
     :valueSampledData
     {:max 1, :min 0, :type "SampledData", :choiceOf "value", :mustSupport true},
     :effectiveDateTime {:type "dateTime", :mustSupport true},
     :status {:type "code", :mustSupport true},
     :code {:type "CodeableConcept", :mustSupport true},
     :identifier {:type "Identifier", :array true, :mustSupport true},
     :valueCodeableConcept
     {:max 1,
      :min 0,
      :type "CodeableConcept",
      :choiceOf "value",
      :mustSupport true},
     :bodySite {:max 1, :min 0, :type "CodeableConcept", :mustSupport true},
     :issued {:type "instant"},
     :valuePeriod
     {:max 1, :min 0, :type "Period", :choiceOf "value", :mustSupport true},
     :device
     {:type "Reference",
      :refers ["http://hl7.org/fhir/StructureDefinition/DeviceMetric"],
      :mustSupport true},
     :valueRange
     {:max 1, :min 0, :type "Range", :choiceOf "value", :mustSupport true},
     :subject
     {:type "Reference",
      :refers
      ["http://hl7.org/fhir/StructureDefinition/Patient"
       "http://hl7.org/fhir/StructureDefinition/Device"],
      :mustSupport true},
     :dataAbsentReason {:type "CodeableConcept"}},
    :id "devicemetricobservation",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/devicemetricobservation",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/Observation",
    :version "4.0.1",
    :required ["status" "code" "subject" "effectiveDateTime" "device"]}
   {:package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/triglyceride/4.0.1",
    :derivation "constraint",
    :fhirVersion nil,
    :excluded ["hasMember" "derivedFrom"],
    :name "triglyceride",
    :type "Observation",
    :resourceType "FHIRSchema",
    :elements
    {:code
     {:type "CodeableConcept",
      :pattern
      {:coding
       [{:code "35217-9",
         :system "http://loinc.org",
         :display "Triglyceride [Moles/​volume] in Serum or Plasma"}]},
      :mustSupport true},
     :note {:type "Annotation", :array true, :mustSupport true},
     :valueQuantity {:max 1, :min 0, :type "Quantity", :mustSupport true},
     :interpretation
     {:max 1, :min 0, :type "CodeableConcept", :mustSupport true},
     :referenceRange
     {:elements
      {:age {:type "Range"},
       :type {:type "CodeableConcept"},
       :appliesTo {:type "CodeableConcept"}},
      :excluded ["low" "type" "appliesTo" "age"],
      :required ["high"],
      :mustSupport true}},
    :id "triglyceride",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/triglyceride",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/Observation",
    :version "4.0.1",
    :required ["code" "referenceRange"]}
   {:constraints
    {:vs-2
     {:human
      "If there is no component or hasMember element then either a value[x] or a data absent reason must be present.",
      :severity "error",
      :expression
      "(component.empty() and hasMember.empty()) implies (dataAbsentReason.exists() or value.exists())"}},
    :package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/vitalsigns/4.0.1",
    :derivation "constraint",
    :fhirVersion nil,
    :name "vitalsigns",
    :type "Observation",
    :resourceType "FHIRSchema",
    :elements
    {:category
     {:type "CodeableConcept",
      :array true,
      :slicing
      {:rules "open",
       :slices
       {:VSCat
        {:max 1,
         :min 1,
         :match
         {:type "pattern",
          :value
          {:coding
           {:code "vital-signs",
            :system
            "http://terminology.hl7.org/CodeSystem/observation-category"}}},
         :schema
         {:type "CodeableConcept",
          :elements
          {:coding
           {:type "Coding",
            :array true,
            :elements
            {:code {:type "code", :fixed "vital-signs", :mustSupport true},
             :system
             {:type "uri",
              :fixed
              "http://terminology.hl7.org/CodeSystem/observation-category",
              :mustSupport true}},
            :required ["system" "code"],
            :mustSupport true}},
          :required ["coding"],
          :mustSupport true}}},
       :ordered false,
       :discriminator
       [{:path "coding.code", :type "value"}
        {:path "coding.system", :type "value"}]},
      :mustSupport true},
     :hasMember
     {:type "Reference",
      :refers
      ["http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse"
       "http://hl7.org/fhir/StructureDefinition/MolecularSequence"
       "http://hl7.org/fhir/StructureDefinition/vitalsigns"]},
     :derivedFrom
     {:type "Reference",
      :refers
      ["http://hl7.org/fhir/StructureDefinition/DocumentReference"
       "http://hl7.org/fhir/StructureDefinition/ImagingStudy"
       "http://hl7.org/fhir/StructureDefinition/Media"
       "http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse"
       "http://hl7.org/fhir/StructureDefinition/MolecularSequence"
       "http://hl7.org/fhir/StructureDefinition/vitalsigns"]},
     :value {:max 1, :min 0},
     :component
     {:elements
      {:code
       {:type "CodeableConcept",
        :binding
        {:strength "extensible",
         :valueSet "http://hl7.org/fhir/ValueSet/observation-vitalsignresult"},
        :mustSupport true},
       :value {:max 1, :min 0},
       :dataAbsentReason
       {:max 1, :min 0, :type "CodeableConcept", :mustSupport true}},
      :required ["code"],
      :constraints
      {:vs-3
       {:human "If there is no a value a data absent reason must be present",
        :severity "error",
        :expression "value.exists() or dataAbsentReason.exists()"}},
      :mustSupport true},
     :effectiveDateTime
     {:type "dateTime",
      :choiceOf "effective",
      :constraints
      {:vs-1
       {:human
        "if Observation.effective[x] is dateTime and has a value then that value shall be precise to the day",
        :severity "error",
        :expression "($this as dateTime).toString().length() >= 8"}},
      :mustSupport true,
      :required-element true},
     :status
     {:type "code",
      :binding
      {:strength "required",
       :valueSet "http://hl7.org/fhir/ValueSet/observation-status"},
      :mustSupport true},
     :effective {:choices ["effectiveDateTime" "effectivePeriod"]},
     :code
     {:type "CodeableConcept",
      :binding
      {:strength "extensible",
       :valueSet "http://hl7.org/fhir/ValueSet/observation-vitalsignresult"},
      :mustSupport true},
     :subject
     {:type "Reference",
      :refers ["http://hl7.org/fhir/StructureDefinition/Patient"],
      :mustSupport true},
     :dataAbsentReason
     {:max 1, :min 0, :type "CodeableConcept", :mustSupport true},
     :effectivePeriod
     {:type "Period",
      :choiceOf "effective",
      :constraints
      {:vs-1
       {:human
        "if Observation.effective[x] is dateTime and has a value then that value shall be precise to the day",
        :severity "error",
        :expression "($this as dateTime).toString().length() >= 8"}},
      :mustSupport true,
      :required-element true}},
    :id "vitalsigns",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/vitalsigns",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/Observation",
    :version "4.0.1",
    :required ["status" "category" "code" "subject" "effective" "effective"]}
   {:package "hl7.fhir.r4.core",
    :technical-id
    "hl7.fhir.r4.core/4.0.1/FHIRSchema/http://hl7.org/fhir/StructureDefinition/hdlcholesterol/4.0.1",
    :derivation "constraint",
    :fhirVersion nil,
    :excluded ["hasMember" "derivedFrom"],
    :name "hdlcholesterol",
    :type "Observation",
    :resourceType "FHIRSchema",
    :elements
    {:code
     {:type "CodeableConcept",
      :fixed
      {:coding
       [{:code "2085-9",
         :system "http://loinc.org",
         :display "HDL Cholesterol"}]},
      :mustSupport true},
     :note {:type "Annotation", :array true, :mustSupport true},
     :valueQuantity {:max 1, :min 0, :type "Quantity", :mustSupport true},
     :interpretation
     {:max 1, :min 0, :type "CodeableConcept", :mustSupport true},
     :referenceRange
     {:elements
      {:age {:type "Range"},
       :low {:type "Quantity", :fixed {:value 1.5}},
       :type {:type "CodeableConcept"},
       :appliesTo {:type "CodeableConcept"}},
      :excluded ["high" "type" "appliesTo" "age"],
      :required ["low"],
      :mustSupport true}},
    :id "hdlcholesterol",
    :kind "resource",
    :url "http://hl7.org/fhir/StructureDefinition/hdlcholesterol",
    :packageVersion "4.0.1",
    :base "http://hl7.org/fhir/StructureDefinition/Observation",
    :version "4.0.1",
    :required ["code" "referenceRange"]}])

(def observation-ir-schema
  {:package "hl7.fhir.r4.core",
   :derivation "specialization",
   :name "Observation",
   :type "Observation",
   :elements
   [{:name "category",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.CodeableConcept",
     :type "CodeableConcept"}
    {:name "referenceRange",
     :base "Observation",
     :array true,
     :required false,
     :value "Observation_ReferenceRange",
     :type "BackboneElement"}
    {:name "hasMember",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "derivedFrom",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "interpretation",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.CodeableConcept",
     :type "CodeableConcept"}
    {:name "encounter",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "method",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.CodeableConcept",
     :type "CodeableConcept"}
    {:name "valueTime",
     :base "Observation",
     :array false,
     :required false,
     :value "string",
     :type "time"}
    {:name "specimen",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "valueQuantity",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.Quantity",
     :type "Quantity"}
    {:name "value",
     :choices
     [{:name "valueTime",
       :base "Observation",
       :array false,
       :required false,
       :value "string",
       :type "time"}
      {:name "valueQuantity",
       :base "Observation",
       :array false,
       :required false,
       :value "Base.Quantity",
       :type "Quantity"}
      {:name "valueString",
       :base "Observation",
       :array false,
       :required false,
       :value "string",
       :type "string"}
      {:name "valueRatio",
       :base "Observation",
       :array false,
       :required false,
       :value "Base.Ratio",
       :type "Ratio"}
      {:name "valueBoolean",
       :base "Observation",
       :array false,
       :required false,
       :value "bool",
       :type "boolean"}
      {:name "valueDateTime",
       :base "Observation",
       :array false,
       :required false,
       :value "string",
       :type "dateTime"}
      {:name "valueSampledData",
       :base "Observation",
       :array false,
       :required false,
       :value "Base.SampledData",
       :type "SampledData"}
      {:name "valueCodeableConcept",
       :base "Observation",
       :array false,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}
      {:name "valuePeriod",
       :base "Observation",
       :array false,
       :required false,
       :value "Base.Period",
       :type "Period"}
      {:name "valueRange",
       :base "Observation",
       :array false,
       :required false,
       :value "Base.Range",
       :type "Range"}
      {:name "valueInteger",
       :base "Observation",
       :array false,
       :required false,
       :value "int",
       :type "integer"}]}
    {:name "valueString",
     :base "Observation",
     :array false,
     :required false,
     :value "string",
     :type "string"}
    {:name "valueRatio",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.Ratio",
     :type "Ratio"}
    {:name "valueBoolean",
     :base "Observation",
     :array false,
     :required false,
     :value "bool",
     :type "boolean"}
    {:name "valueDateTime",
     :base "Observation",
     :array false,
     :required false,
     :value "string",
     :type "dateTime"}
    {:name "component",
     :base "Observation",
     :array true,
     :required false,
     :value "Observation_Component",
     :type "BackboneElement"}
    {:name "note",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.Annotation",
     :type "Annotation"}
    {:name "valueSampledData",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.SampledData",
     :type "SampledData"}
    {:name "effectiveDateTime",
     :base "Observation",
     :array false,
     :required false,
     :value "string",
     :type "dateTime"}
    {:name "status",
     :base "Observation",
     :array false,
     :required true,
     :value "string",
     :type "code"}
    {:name "effective",
     :choices
     [{:name "effectiveDateTime",
       :base "Observation",
       :array false,
       :required false,
       :value "string",
       :type "dateTime"}
      {:name "effectiveTiming",
       :base "Observation",
       :array false,
       :required false,
       :value "string",
       :type "Timing"}
      {:name "effectiveInstant",
       :base "Observation",
       :array false,
       :required false,
       :value "string",
       :type "instant"}
      {:name "effectivePeriod",
       :base "Observation",
       :array false,
       :required false,
       :value "Base.Period",
       :type "Period"}]}
    {:name "code",
     :base "Observation",
     :array false,
     :required true,
     :value "Base.CodeableConcept",
     :type "CodeableConcept"}
    {:name "identifier",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.Identifier",
     :type "Identifier"}
    {:name "effectiveTiming",
     :base "Observation",
     :array false,
     :required false,
     :value "string",
     :type "Timing"}
    {:name "valueCodeableConcept",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.CodeableConcept",
     :type "CodeableConcept"}
    {:name "bodySite",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.CodeableConcept",
     :type "CodeableConcept"}
    {:name "focus",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "issued",
     :base "Observation",
     :array false,
     :required false,
     :value "string",
     :type "instant"}
    {:name "valuePeriod",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.Period",
     :type "Period"}
    {:name "device",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "effectiveInstant",
     :base "Observation",
     :array false,
     :required false,
     :value "string",
     :type "instant"}
    {:name "basedOn",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "valueRange",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.Range",
     :type "Range"}
    {:name "partOf",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "valueInteger",
     :base "Observation",
     :array false,
     :required false,
     :value "int",
     :type "integer"}
    {:name "subject",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "performer",
     :base "Observation",
     :array true,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "dataAbsentReason",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.CodeableConcept",
     :type "CodeableConcept"}
    {:name "effectivePeriod",
     :base "Observation",
     :array false,
     :required false,
     :value "Base.Period",
     :type "Period"}],
   :url "http://hl7.org/fhir/StructureDefinition/Observation",
   :backbone-elements
   [{:elements
     [{:name "age",
       :base "Observation_ReferenceRange",
       :array false,
       :required false,
       :value "Base.Range",
       :type "Range"}
      {:name "low",
       :base "Observation_ReferenceRange",
       :array false,
       :required false,
       :value "Base.Quantity",
       :type "Quantity"}
      {:name "high",
       :base "Observation_ReferenceRange",
       :array false,
       :required false,
       :value "Base.Quantity",
       :type "Quantity"}
      {:name "text",
       :base "Observation_ReferenceRange",
       :array false,
       :required false,
       :value "string",
       :type "string"}
      {:name "type",
       :base "Observation_ReferenceRange",
       :array false,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}
      {:name "appliesTo",
       :base "Observation_ReferenceRange",
       :array true,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}],
     :name "Observation_ReferenceRange"}
    {:elements
     [{:name "age",
       :base "Observation_Component_ReferenceRange",
       :array false,
       :required false,
       :value "Base.Range",
       :type "Range"}
      {:name "low",
       :base "Observation_Component_ReferenceRange",
       :array false,
       :required false,
       :value "Base.Quantity",
       :type "Quantity"}
      {:name "high",
       :base "Observation_Component_ReferenceRange",
       :array false,
       :required false,
       :value "Base.Quantity",
       :type "Quantity"}
      {:name "text",
       :base "Observation_Component_ReferenceRange",
       :array false,
       :required false,
       :value "string",
       :type "string"}
      {:name "type",
       :base "Observation_Component_ReferenceRange",
       :array false,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}
      {:name "appliesTo",
       :base "Observation_Component_ReferenceRange",
       :array true,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}],
     :name "Observation_Component_ReferenceRange"}
    {:elements
     [{:name "referenceRange",
       :base "Observation_Component",
       :array true,
       :required false,
       :value "Observation_Component_ReferenceRange",
       :type "BackboneElement"}
      {:name "interpretation",
       :base "Observation_Component",
       :array true,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}
      {:name "valueTime",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "string",
       :type "time"}
      {:name "valueQuantity",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "Base.Quantity",
       :type "Quantity"}
      {:name "value",
       :choices
       [{:name "valueTime",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "string",
         :type "time"}
        {:name "valueQuantity",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "Base.Quantity",
         :type "Quantity"}
        {:name "valueString",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "string",
         :type "string"}
        {:name "valueRatio",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "Base.Ratio",
         :type "Ratio"}
        {:name "valueBoolean",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "bool",
         :type "boolean"}
        {:name "valueDateTime",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "string",
         :type "dateTime"}
        {:name "valueSampledData",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "Base.SampledData",
         :type "SampledData"}
        {:name "valueCodeableConcept",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "Base.CodeableConcept",
         :type "CodeableConcept"}
        {:name "valuePeriod",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "Base.Period",
         :type "Period"}
        {:name "valueRange",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "Base.Range",
         :type "Range"}
        {:name "valueInteger",
         :base "Observation_Component",
         :array false,
         :required false,
         :value "int",
         :type "integer"}]}
      {:name "valueString",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "string",
       :type "string"}
      {:name "valueRatio",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "Base.Ratio",
       :type "Ratio"}
      {:name "valueBoolean",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "bool",
       :type "boolean"}
      {:name "valueDateTime",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "string",
       :type "dateTime"}
      {:name "valueSampledData",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "Base.SampledData",
       :type "SampledData"}
      {:name "code",
       :base "Observation_Component",
       :array false,
       :required true,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}
      {:name "valueCodeableConcept",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}
      {:name "valuePeriod",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "Base.Period",
       :type "Period"}
      {:name "valueRange",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "Base.Range",
       :type "Range"}
      {:name "valueInteger",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "int",
       :type "integer"}
      {:name "dataAbsentReason",
       :base "Observation_Component",
       :array false,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}],
     :name "Observation_Component"}],
   :base "http://hl7.org/fhir/StructureDefinition/DomainResource"})

(def observation-constraints-ir-schema

  {"http://hl7.org/fhir/StructureDefinition/ldlcholesterol"
   {:package "hl7.fhir.r4.core",
    :derivation "constraint",
    :patterns (),
    :name "Observation",
    :type "Observation",
    :elements
    [{:name "meta",
      :required true,
      :value "Meta",
      :profile "http://hl7.org/fhir/StructureDefinition/ldlcholesterol",
      :type "Meta",
      :meta
      " = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/ldlcholesterol\"] };"}
     {:name "category",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "referenceRange",
      :base "Observation",
      :array true,
      :required true,
      :value "Observation_ReferenceRange",
      :type "BackboneElement"}
     {:name "interpretation",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "encounter",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "method",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "valueTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "time"}
     {:name "specimen",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueQuantity",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Quantity",
      :type "Quantity"}
     {:name "value",
      :choices
      [{:name "valueTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "valueString",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "valueCodeableConcept",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation",
        :array false,
        :required false,
        :value "int",
        :type "integer"}]}
     {:name "valueString",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "string"}
     {:name "valueRatio",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Ratio",
      :type "Ratio"}
     {:name "valueBoolean",
      :base "Observation",
      :array false,
      :required false,
      :value "bool",
      :type "boolean"}
     {:name "valueDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "component",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_Component",
      :type "BackboneElement"}
     {:name "note",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Annotation",
      :type "Annotation"}
     {:name "valueSampledData",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.SampledData",
      :type "SampledData"}
     {:name "effectiveDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "status",
      :base "Observation",
      :array false,
      :required true,
      :value "string",
      :type "code"}
     {:name "effective",
      :choices
      [{:name "effectiveDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "effectiveTiming",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "Timing"}
       {:name "effectiveInstant",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "instant"}
       {:name "effectivePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}]}
     {:name "code",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "identifier",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Identifier",
      :type "Identifier"}
     {:name "effectiveTiming",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "Timing"}
     {:name "valueCodeableConcept",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "bodySite",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "focus",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "issued",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "valuePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}
     {:name "device",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "effectiveInstant",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "basedOn",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueRange",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Range",
      :type "Range"}
     {:name "partOf",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueInteger",
      :base "Observation",
      :array false,
      :required false,
      :value "int",
      :type "integer"}
     {:name "subject",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "performer",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "dataAbsentReason",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "effectivePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}],
    :url "http://hl7.org/fhir/StructureDefinition/Observation",
    :backbone-elements
    [{:elements
      [{:name "age",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_ReferenceRange"}
     {:elements
      [{:name "age",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_Component_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component_ReferenceRange"}
     {:elements
      [{:name "referenceRange",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Observation_Component_ReferenceRange",
        :type "BackboneElement"}
       {:name "interpretation",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "value",
        :choices
        [{:name "valueTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "time"}
         {:name "valueQuantity",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Quantity",
          :type "Quantity"}
         {:name "valueString",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "string"}
         {:name "valueRatio",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Ratio",
          :type "Ratio"}
         {:name "valueBoolean",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "bool",
          :type "boolean"}
         {:name "valueDateTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "dateTime"}
         {:name "valueSampledData",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.SampledData",
          :type "SampledData"}
         {:name "valueCodeableConcept",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.CodeableConcept",
          :type "CodeableConcept"}
         {:name "valuePeriod",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Period",
          :type "Period"}
         {:name "valueRange",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Range",
          :type "Range"}
         {:name "valueInteger",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "int",
          :type "integer"}]}
       {:name "valueString",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "code",
        :base "Observation_Component",
        :array false,
        :required true,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueCodeableConcept",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "int",
        :type "integer"}
       {:name "dataAbsentReason",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"},
   "http://hl7.org/fhir/StructureDefinition/cholesterol"
   {:package "hl7.fhir.r4.core",
    :derivation "constraint",
    :patterns (),
    :name "Observation",
    :type "Observation",
    :elements
    [{:name "meta",
      :required true,
      :value "Meta",
      :profile "http://hl7.org/fhir/StructureDefinition/cholesterol",
      :type "Meta",
      :meta
      " = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/cholesterol\"] };"}
     {:name "category",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "referenceRange",
      :base "Observation",
      :array true,
      :required true,
      :value "Observation_ReferenceRange",
      :type "BackboneElement"}
     {:name "interpretation",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "encounter",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "method",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "valueTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "time"}
     {:name "specimen",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueQuantity",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Quantity",
      :type "Quantity"}
     {:name "value",
      :choices
      [{:name "valueTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "valueString",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "valueCodeableConcept",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation",
        :array false,
        :required false,
        :value "int",
        :type "integer"}]}
     {:name "valueString",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "string"}
     {:name "valueRatio",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Ratio",
      :type "Ratio"}
     {:name "valueBoolean",
      :base "Observation",
      :array false,
      :required false,
      :value "bool",
      :type "boolean"}
     {:name "valueDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "component",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_Component",
      :type "BackboneElement"}
     {:name "note",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Annotation",
      :type "Annotation"}
     {:name "valueSampledData",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.SampledData",
      :type "SampledData"}
     {:name "effectiveDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "status",
      :base "Observation",
      :array false,
      :required true,
      :value "string",
      :type "code"}
     {:name "effective",
      :choices
      [{:name "effectiveDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "effectiveTiming",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "Timing"}
       {:name "effectiveInstant",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "instant"}
       {:name "effectivePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}]}
     {:name "code",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "identifier",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Identifier",
      :type "Identifier"}
     {:name "effectiveTiming",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "Timing"}
     {:name "valueCodeableConcept",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "bodySite",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "focus",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "issued",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "valuePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}
     {:name "device",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "effectiveInstant",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "basedOn",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueRange",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Range",
      :type "Range"}
     {:name "partOf",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueInteger",
      :base "Observation",
      :array false,
      :required false,
      :value "int",
      :type "integer"}
     {:name "subject",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "performer",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "dataAbsentReason",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "effectivePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}],
    :url "http://hl7.org/fhir/StructureDefinition/Observation",
    :backbone-elements
    [{:elements
      [{:name "age",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_ReferenceRange"}
     {:elements
      [{:name "age",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_Component_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component_ReferenceRange"}
     {:elements
      [{:name "referenceRange",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Observation_Component_ReferenceRange",
        :type "BackboneElement"}
       {:name "interpretation",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "value",
        :choices
        [{:name "valueTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "time"}
         {:name "valueQuantity",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Quantity",
          :type "Quantity"}
         {:name "valueString",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "string"}
         {:name "valueRatio",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Ratio",
          :type "Ratio"}
         {:name "valueBoolean",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "bool",
          :type "boolean"}
         {:name "valueDateTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "dateTime"}
         {:name "valueSampledData",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.SampledData",
          :type "SampledData"}
         {:name "valueCodeableConcept",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.CodeableConcept",
          :type "CodeableConcept"}
         {:name "valuePeriod",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Period",
          :type "Period"}
         {:name "valueRange",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Range",
          :type "Range"}
         {:name "valueInteger",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "int",
          :type "integer"}]}
       {:name "valueString",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "code",
        :base "Observation_Component",
        :array false,
        :required true,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueCodeableConcept",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "int",
        :type "integer"}
       {:name "dataAbsentReason",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"},
   "http://hl7.org/fhir/StructureDefinition/observation-genetics"
   {:package "hl7.fhir.r4.core",
    :derivation "constraint",
    :patterns (),
    :name "Observation",
    :type "Observation",
    :elements
    [{:name "meta",
      :required true,
      :value "Meta",
      :profile "http://hl7.org/fhir/StructureDefinition/observation-genetics",
      :type "Meta",
      :meta
      " = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/observation-genetics\"] };"}
     {:name "category",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "referenceRange",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_ReferenceRange",
      :type "BackboneElement"}
     {:name "hasMember",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "derivedFrom",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "interpretation",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "encounter",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "method",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "valueTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "time"}
     {:name "specimen",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueQuantity",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Quantity",
      :type "Quantity"}
     {:name "value",
      :choices
      [{:name "valueTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "valueString",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "valueCodeableConcept",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation",
        :array false,
        :required false,
        :value "int",
        :type "integer"}]}
     {:name "valueString",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "string"}
     {:name "valueRatio",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Ratio",
      :type "Ratio"}
     {:name "valueBoolean",
      :base "Observation",
      :array false,
      :required false,
      :value "bool",
      :type "boolean"}
     {:name "valueDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "component",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_Component",
      :type "BackboneElement"}
     {:name "note",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Annotation",
      :type "Annotation"}
     {:name "valueSampledData",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.SampledData",
      :type "SampledData"}
     {:name "effectiveDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "status",
      :base "Observation",
      :array false,
      :required true,
      :value "string",
      :type "code"}
     {:name "effective",
      :choices
      [{:name "effectiveDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "effectiveTiming",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "Timing"}
       {:name "effectiveInstant",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "instant"}
       {:name "effectivePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}]}
     {:name "code",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "identifier",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Identifier",
      :type "Identifier"}
     {:name "effectiveTiming",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "Timing"}
     {:name "valueCodeableConcept",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "bodySite",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "focus",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "issued",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "valuePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}
     {:name "device",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "effectiveInstant",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "basedOn",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueRange",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Range",
      :type "Range"}
     {:name "partOf",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueInteger",
      :base "Observation",
      :array false,
      :required false,
      :value "int",
      :type "integer"}
     {:name "subject",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "performer",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "dataAbsentReason",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "effectivePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}],
    :url "http://hl7.org/fhir/StructureDefinition/Observation",
    :backbone-elements
    [{:elements
      [{:name "age",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_ReferenceRange"}
     {:elements
      [{:name "age",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_Component_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component_ReferenceRange"}
     {:elements
      [{:name "referenceRange",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Observation_Component_ReferenceRange",
        :type "BackboneElement"}
       {:name "interpretation",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "value",
        :choices
        [{:name "valueTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "time"}
         {:name "valueQuantity",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Quantity",
          :type "Quantity"}
         {:name "valueString",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "string"}
         {:name "valueRatio",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Ratio",
          :type "Ratio"}
         {:name "valueBoolean",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "bool",
          :type "boolean"}
         {:name "valueDateTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "dateTime"}
         {:name "valueSampledData",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.SampledData",
          :type "SampledData"}
         {:name "valueCodeableConcept",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.CodeableConcept",
          :type "CodeableConcept"}
         {:name "valuePeriod",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Period",
          :type "Period"}
         {:name "valueRange",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Range",
          :type "Range"}
         {:name "valueInteger",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "int",
          :type "integer"}]}
       {:name "valueString",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "code",
        :base "Observation_Component",
        :array false,
        :required true,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueCodeableConcept",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "int",
        :type "integer"}
       {:name "dataAbsentReason",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"},
   "http://hl7.org/fhir/StructureDefinition/devicemetricobservation"
   {:package "hl7.fhir.r4.core",
    :derivation "constraint",
    :patterns (),
    :name "Observation",
    :type "Observation",
    :elements
    [{:name "meta",
      :required true,
      :value "Meta",
      :profile "http://hl7.org/fhir/StructureDefinition/devicemetricobservation",
      :type "Meta",
      :meta
      " = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/devicemetricobservation\"] };"}
     {:name "category",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "referenceRange",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_ReferenceRange",
      :type "BackboneElement"}
     {:name "hasMember",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "derivedFrom",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "interpretation",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "method",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "valueTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "time"}
     {:name "valueQuantity",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Quantity",
      :type "Quantity"}
     {:name "value",
      :choices
      [{:name "valueTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "valueString",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "valueCodeableConcept",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation",
        :array false,
        :required false,
        :value "int",
        :type "integer"}]}
     {:name "valueString",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "string"}
     {:name "valueRatio",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Ratio",
      :type "Ratio"}
     {:name "valueBoolean",
      :base "Observation",
      :array false,
      :required false,
      :value "bool",
      :type "boolean"}
     {:name "valueDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "component",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_Component",
      :type "BackboneElement"}
     {:name "note",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Annotation",
      :type "Annotation"}
     {:name "valueSampledData",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.SampledData",
      :type "SampledData"}
     {:name "effectiveDateTime",
      :base "Observation",
      :array false,
      :required true,
      :value "string",
      :type "dateTime"}
     {:name "status",
      :base "Observation",
      :array false,
      :required true,
      :value "string",
      :type "code"}
     {:name "effective",
      :choices
      [{:name "effectiveDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "effectiveTiming",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "Timing"}
       {:name "effectiveInstant",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "instant"}
       {:name "effectivePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}]}
     {:name "code",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "identifier",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Identifier",
      :type "Identifier"}
     {:name "effectiveTiming",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "Timing"}
     {:name "valueCodeableConcept",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "bodySite",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "focus",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valuePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}
     {:name "device",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "effectiveInstant",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "basedOn",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueRange",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Range",
      :type "Range"}
     {:name "partOf",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueInteger",
      :base "Observation",
      :array false,
      :required false,
      :value "int",
      :type "integer"}
     {:name "subject",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "performer",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "effectivePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}],
    :url "http://hl7.org/fhir/StructureDefinition/Observation",
    :backbone-elements
    [{:elements
      [{:name "age",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_ReferenceRange"}
     {:elements
      [{:name "age",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_Component_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component_ReferenceRange"}
     {:elements
      [{:name "referenceRange",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Observation_Component_ReferenceRange",
        :type "BackboneElement"}
       {:name "interpretation",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "value",
        :choices
        [{:name "valueTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "time"}
         {:name "valueQuantity",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Quantity",
          :type "Quantity"}
         {:name "valueString",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "string"}
         {:name "valueRatio",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Ratio",
          :type "Ratio"}
         {:name "valueBoolean",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "bool",
          :type "boolean"}
         {:name "valueDateTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "dateTime"}
         {:name "valueSampledData",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.SampledData",
          :type "SampledData"}
         {:name "valueCodeableConcept",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.CodeableConcept",
          :type "CodeableConcept"}
         {:name "valuePeriod",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Period",
          :type "Period"}
         {:name "valueRange",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Range",
          :type "Range"}
         {:name "valueInteger",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "int",
          :type "integer"}]}
       {:name "valueString",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "code",
        :base "Observation_Component",
        :array false,
        :required true,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueCodeableConcept",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "int",
        :type "integer"}
       {:name "dataAbsentReason",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"},
   "http://hl7.org/fhir/StructureDefinition/triglyceride"
   {:package "hl7.fhir.r4.core",
    :derivation "constraint",
    :patterns [""],
    :name "Observation",
    :type "Observation",
    :elements
    [{:name "meta",
      :required true,
      :value "Meta",
      :profile "http://hl7.org/fhir/StructureDefinition/triglyceride",
      :type "Meta",
      :meta
      " = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/triglyceride\"] };"}
     {:name "category",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "referenceRange",
      :base "Observation",
      :array true,
      :required true,
      :value "Observation_ReferenceRange",
      :type "BackboneElement"}
     {:name "interpretation",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "encounter",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "method",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "valueTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "time"}
     {:name "specimen",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueQuantity",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Quantity",
      :type "Quantity"}
     {:name "value",
      :choices
      [{:name "valueTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "valueString",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "valueCodeableConcept",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation",
        :array false,
        :required false,
        :value "int",
        :type "integer"}]}
     {:name "valueString",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "string"}
     {:name "valueRatio",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Ratio",
      :type "Ratio"}
     {:name "valueBoolean",
      :base "Observation",
      :array false,
      :required false,
      :value "bool",
      :type "boolean"}
     {:name "valueDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "component",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_Component",
      :type "BackboneElement"}
     {:name "note",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Annotation",
      :type "Annotation"}
     {:name "valueSampledData",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.SampledData",
      :type "SampledData"}
     {:name "effectiveDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "status",
      :base "Observation",
      :array false,
      :required true,
      :value "string",
      :type "code"}
     {:name "effective",
      :choices
      [{:name "effectiveDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "effectiveTiming",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "Timing"}
       {:name "effectiveInstant",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "instant"}
       {:name "effectivePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}]}
     {:name "code",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "identifier",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Identifier",
      :type "Identifier"}
     {:name "effectiveTiming",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "Timing"}
     {:name "valueCodeableConcept",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "bodySite",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "focus",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "issued",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "valuePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}
     {:name "device",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "effectiveInstant",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "basedOn",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueRange",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Range",
      :type "Range"}
     {:name "partOf",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueInteger",
      :base "Observation",
      :array false,
      :required false,
      :value "int",
      :type "integer"}
     {:name "subject",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "performer",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "dataAbsentReason",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "effectivePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}],
    :url "http://hl7.org/fhir/StructureDefinition/Observation",
    :backbone-elements
    [{:elements
      [{:name "age",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_ReferenceRange"}
     {:elements
      [{:name "age",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_Component_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component_ReferenceRange"}
     {:elements
      [{:name "referenceRange",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Observation_Component_ReferenceRange",
        :type "BackboneElement"}
       {:name "interpretation",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "value",
        :choices
        [{:name "valueTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "time"}
         {:name "valueQuantity",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Quantity",
          :type "Quantity"}
         {:name "valueString",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "string"}
         {:name "valueRatio",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Ratio",
          :type "Ratio"}
         {:name "valueBoolean",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "bool",
          :type "boolean"}
         {:name "valueDateTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "dateTime"}
         {:name "valueSampledData",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.SampledData",
          :type "SampledData"}
         {:name "valueCodeableConcept",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.CodeableConcept",
          :type "CodeableConcept"}
         {:name "valuePeriod",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Period",
          :type "Period"}
         {:name "valueRange",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Range",
          :type "Range"}
         {:name "valueInteger",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "int",
          :type "integer"}]}
       {:name "valueString",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "code",
        :base "Observation_Component",
        :array false,
        :required true,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueCodeableConcept",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "int",
        :type "integer"}
       {:name "dataAbsentReason",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"},
   "http://hl7.org/fhir/StructureDefinition/vitalsigns"
   {:package "hl7.fhir.r4.core",
    :derivation "constraint",
    :patterns (),
    :name "Observation",
    :type "Observation",
    :elements
    [{:name "meta",
      :required true,
      :value "Meta",
      :profile "http://hl7.org/fhir/StructureDefinition/vitalsigns",
      :type "Meta",
      :meta
      " = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/vitalsigns\"] };"}
     {:name "category",
      :base "Observation",
      :array true,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "referenceRange",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_ReferenceRange",
      :type "BackboneElement"}
     {:name "hasMember",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "derivedFrom",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "interpretation",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "encounter",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "method",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "valueTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "time"}
     {:name "specimen",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueQuantity",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Quantity",
      :type "Quantity"}
     {:name "value",
      :choices
      [{:name "valueTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "valueString",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "valueCodeableConcept",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation",
        :array false,
        :required false,
        :value "int",
        :type "integer"}]}
     {:name "valueString",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "string"}
     {:name "valueRatio",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Ratio",
      :type "Ratio"}
     {:name "valueBoolean",
      :base "Observation",
      :array false,
      :required false,
      :value "bool",
      :type "boolean"}
     {:name "valueDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "component",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_Component",
      :type "BackboneElement"}
     {:name "note",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Annotation",
      :type "Annotation"}
     {:name "valueSampledData",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.SampledData",
      :type "SampledData"}
     {:name "effectiveDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "status",
      :base "Observation",
      :array false,
      :required true,
      :value "string",
      :type "code"}
     {:name "effective",
      :choices
      [{:name "effectiveDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "effectiveTiming",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "Timing"}
       {:name "effectiveInstant",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "instant"}
       {:name "effectivePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}],
      :required true}
     {:name "code",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "identifier",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Identifier",
      :type "Identifier"}
     {:name "effectiveTiming",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "Timing"}
     {:name "valueCodeableConcept",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "bodySite",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "focus",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "issued",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "valuePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}
     {:name "device",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "effectiveInstant",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "basedOn",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueRange",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Range",
      :type "Range"}
     {:name "partOf",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueInteger",
      :base "Observation",
      :array false,
      :required false,
      :value "int",
      :type "integer"}
     {:name "subject",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "performer",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "dataAbsentReason",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "effectivePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}],
    :url "http://hl7.org/fhir/StructureDefinition/Observation",
    :backbone-elements
    [{:elements
      [{:name "age",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_ReferenceRange"}
     {:elements
      [{:name "age",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_Component_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component_ReferenceRange"}
     {:elements
      [{:name "referenceRange",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Observation_Component_ReferenceRange",
        :type "BackboneElement"}
       {:name "interpretation",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "value",
        :choices
        [{:name "valueTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "time"}
         {:name "valueQuantity",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Quantity",
          :type "Quantity"}
         {:name "valueString",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "string"}
         {:name "valueRatio",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Ratio",
          :type "Ratio"}
         {:name "valueBoolean",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "bool",
          :type "boolean"}
         {:name "valueDateTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "dateTime"}
         {:name "valueSampledData",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.SampledData",
          :type "SampledData"}
         {:name "valueCodeableConcept",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.CodeableConcept",
          :type "CodeableConcept"}
         {:name "valuePeriod",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Period",
          :type "Period"}
         {:name "valueRange",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Range",
          :type "Range"}
         {:name "valueInteger",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "int",
          :type "integer"}]}
       {:name "valueString",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "code",
        :base "Observation_Component",
        :array false,
        :required true,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueCodeableConcept",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "int",
        :type "integer"}
       {:name "dataAbsentReason",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"},
   "http://hl7.org/fhir/StructureDefinition/hdlcholesterol"
   {:package "hl7.fhir.r4.core",
    :derivation "constraint",
    :patterns (),
    :name "Observation",
    :type "Observation",
    :elements
    [{:name "meta",
      :required true,
      :value "Meta",
      :profile "http://hl7.org/fhir/StructureDefinition/hdlcholesterol",
      :type "Meta",
      :meta
      " = new() { Profile = [\"http://hl7.org/fhir/StructureDefinition/hdlcholesterol\"] };"}
     {:name "category",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "referenceRange",
      :base "Observation",
      :array true,
      :required true,
      :value "Observation_ReferenceRange",
      :type "BackboneElement"}
     {:name "interpretation",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "encounter",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "method",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "valueTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "time"}
     {:name "specimen",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueQuantity",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Quantity",
      :type "Quantity"}
     {:name "value",
      :choices
      [{:name "valueTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "valueString",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "valueCodeableConcept",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation",
        :array false,
        :required false,
        :value "int",
        :type "integer"}]}
     {:name "valueString",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "string"}
     {:name "valueRatio",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Ratio",
      :type "Ratio"}
     {:name "valueBoolean",
      :base "Observation",
      :array false,
      :required false,
      :value "bool",
      :type "boolean"}
     {:name "valueDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "component",
      :base "Observation",
      :array true,
      :required false,
      :value "Observation_Component",
      :type "BackboneElement"}
     {:name "note",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Annotation",
      :type "Annotation"}
     {:name "valueSampledData",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.SampledData",
      :type "SampledData"}
     {:name "effectiveDateTime",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "dateTime"}
     {:name "status",
      :base "Observation",
      :array false,
      :required true,
      :value "string",
      :type "code"}
     {:name "effective",
      :choices
      [{:name "effectiveDateTime",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "effectiveTiming",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "Timing"}
       {:name "effectiveInstant",
        :base "Observation",
        :array false,
        :required false,
        :value "string",
        :type "instant"}
       {:name "effectivePeriod",
        :base "Observation",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}]}
     {:name "code",
      :base "Observation",
      :array false,
      :required true,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "identifier",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.Identifier",
      :type "Identifier"}
     {:name "effectiveTiming",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "Timing"}
     {:name "valueCodeableConcept",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "bodySite",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "focus",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "issued",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "valuePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}
     {:name "device",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "effectiveInstant",
      :base "Observation",
      :array false,
      :required false,
      :value "string",
      :type "instant"}
     {:name "basedOn",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueRange",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Range",
      :type "Range"}
     {:name "partOf",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "valueInteger",
      :base "Observation",
      :array false,
      :required false,
      :value "int",
      :type "integer"}
     {:name "subject",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "performer",
      :base "Observation",
      :array true,
      :required false,
      :value "Base.ResourceReference",
      :type "Reference"}
     {:name "dataAbsentReason",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.CodeableConcept",
      :type "CodeableConcept"}
     {:name "effectivePeriod",
      :base "Observation",
      :array false,
      :required false,
      :value "Base.Period",
      :type "Period"}],
    :url "http://hl7.org/fhir/StructureDefinition/Observation",
    :backbone-elements
    [{:elements
      [{:name "age",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_ReferenceRange"}
     {:elements
      [{:name "age",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "low",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "high",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "text",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "type",
        :base "Observation_Component_ReferenceRange",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "appliesTo",
        :base "Observation_Component_ReferenceRange",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component_ReferenceRange"}
     {:elements
      [{:name "referenceRange",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Observation_Component_ReferenceRange",
        :type "BackboneElement"}
       {:name "interpretation",
        :base "Observation_Component",
        :array true,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "time"}
       {:name "valueQuantity",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Quantity",
        :type "Quantity"}
       {:name "value",
        :choices
        [{:name "valueTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "time"}
         {:name "valueQuantity",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Quantity",
          :type "Quantity"}
         {:name "valueString",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "string"}
         {:name "valueRatio",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Ratio",
          :type "Ratio"}
         {:name "valueBoolean",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "bool",
          :type "boolean"}
         {:name "valueDateTime",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "string",
          :type "dateTime"}
         {:name "valueSampledData",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.SampledData",
          :type "SampledData"}
         {:name "valueCodeableConcept",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.CodeableConcept",
          :type "CodeableConcept"}
         {:name "valuePeriod",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Period",
          :type "Period"}
         {:name "valueRange",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "Base.Range",
          :type "Range"}
         {:name "valueInteger",
          :base "Observation_Component",
          :array false,
          :required false,
          :value "int",
          :type "integer"}]}
       {:name "valueString",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "string"}
       {:name "valueRatio",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Ratio",
        :type "Ratio"}
       {:name "valueBoolean",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "bool",
        :type "boolean"}
       {:name "valueDateTime",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "string",
        :type "dateTime"}
       {:name "valueSampledData",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.SampledData",
        :type "SampledData"}
       {:name "code",
        :base "Observation_Component",
        :array false,
        :required true,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valueCodeableConcept",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}
       {:name "valuePeriod",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Period",
        :type "Period"}
       {:name "valueRange",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.Range",
        :type "Range"}
       {:name "valueInteger",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "int",
        :type "integer"}
       {:name "dataAbsentReason",
        :base "Observation_Component",
        :array false,
        :required false,
        :value "Base.CodeableConcept",
        :type "CodeableConcept"}],
      :name "Observation_Component"}],
    :base "http://hl7.org/fhir/StructureDefinition/DomainResource"}})
