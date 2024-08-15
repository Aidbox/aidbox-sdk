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
        :value "int"}]}
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
        :value "bool"}]}
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
     :name "Patient_Contact"}],
   :base "http://hl7.org/fhir/StructureDefinition/DomainResource"})

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
     :value "string"}
    {:name "value", :choices ["valueBoolean"]}
    {:name "valueBoolean",
     :base "Extension",
     :array false,
     :required false,
     :value "bool"}],
   :url "http://hl7.org/fhir/StructureDefinition/organization-preferredContact",
   :backbone-elements [],
   :base "http://hl7.org/fhir/StructureDefinition/Extension"})

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
