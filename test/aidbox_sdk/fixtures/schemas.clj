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
     :basee "Patient",
     :array false,
     :required false,
     :value "bool",
     :type "boolean"}
    {:name "address",
     :base "Patient",
     :array true,
     :required false,
     :value "Base.Address",
     :type "Address"}
    {:name "deceasedDateTime",
     :base "Patient",
     :array false,
     :required false,
     :value "string",
     :type "dateTime"}
    {:name "managingOrganization",
     :base "Patient",
     :array false,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "deceasedBoolean",
     :base "Patient",
     :array false,
     :required false,
     :value "bool",
     :type "boolean"}
    {:name "name",
     :base "Patient",
     :array true,
     :required false,
     :value "Base.HumanName",
     :type "HumanName"}
    {:name "birthDate",
     :base "Patient",
     :array false,
     :required false,
     :value "string",
     :type "date"}
    {:name "multipleBirthInteger",
     :base "Patient",
     :array false,
     :required false,
     :value "int",
     :type "integer"}
    {:name "multipleBirth",
     :choices
     [{:name "multipleBirthBoolean",
       :base "Patient",
       :array false,
       :required false,
       :value "bool",
       :type "boolean"}
      {:name "multipleBirthInteger",
       :base "Patient",
       :array false,
       :required false,
       :value "int",
       :type "integer"}]}
    {:name "deceased",
     :choices
     [{:name "deceasedDateTime",
       :base "Patient",
       :array false,
       :required false,
       :value "string",
       :type "dateTime"}
      {:name "deceasedBoolean",
       :base "Patient",
       :array false,
       :required false,
       :value "bool",
       :type "boolean"}]}
    {:name "photo",
     :base "Patient",
     :array true,
     :required false,
     :value "Base.Attachment",
     :type "Attachment"}
    {:name "link",
     :base "Patient",
     :array true,
     :required false,
     :value "Patient_Link",
     :type "BackboneElement"}
    {:name "active",
     :base "Patient",
     :array false,
     :required false,
     :value "bool",
     :type "boolean"}
    {:name "communication",
     :base "Patient",
     :array true,
     :required false,
     :value "Patient_Communication",
     :type "BackboneElement"}
    {:name "identifier",
     :base "Patient",
     :array true,
     :required false,
     :value "Base.Identifier",
     :type "Identifier"}
    {:name "telecom",
     :base "Patient",
     :array true,
     :required false,
     :value "Base.ContactPoint",
     :type "ContactPoint"}
    {:name "generalPractitioner",
     :base "Patient",
     :array true,
     :required false,
     :value "Base.ResourceReference",
     :type "Reference"}
    {:name "gender",
     :base "Patient",
     :array false,
     :required false,
     :value "string",
     :type "code"}
    {:name "maritalStatus",
     :base "Patient",
     :array false,
     :required false,
     :value "Base.CodeableConcept",
     :type "CodeableConcept"}
    {:name "contact",
     :base "Patient",
     :array true,
     :required false,
     :value "Patient_Contact",
     :type "BackboneElement"}],
   :url "http://hl7.org/fhir/StructureDefinition/Patient",
   :backbone-elements
   [{:elements
     [{:name "type",
       :base "Patient_Link",
       :array false,
       :required true,
       :value "string",
       :type "code"}
      {:name "other",
       :base "Patient_Link",
       :array false,
       :required true,
       :value "Base.ResourceReference",
       :type "Reference"}],
     :name "Patient_Link"}
    {:elements
     [{:name "language",
       :base "Patient_Communication",
       :array false,
       :required true,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}
      {:name "preferred",
       :base "Patient_Communication",
       :array false,
       :required false,
       :value "bool",
       :type "boolean"}],
     :name "Patient_Communication"}
    {:elements
     [{:name "name",
       :base "Patient_Contact",
       :array false,
       :required false,
       :value "Base.HumanName",
       :type "HumanName"}
      {:name "gender",
       :base "Patient_Contact",
       :array false,
       :required false,
       :value "string",
       :type "code"}
      {:name "period",
       :base "Patient_Contact",
       :array false,
       :required false,
       :value "Base.Period",
       :type "Period"}
      {:name "address",
       :base "Patient_Contact",
       :array false,
       :required false,
       :value "Base.Address",
       :type "Address"}
      {:name "telecom",
       :base "Patient_Contact",
       :array true,
       :required false,
       :value "Base.ContactPoint",
       :type "ContactPoint"}
      {:name "organization",
       :base "Patient_Contact",
       :array false,
       :required false,
       :value "Base.ResourceReference",
       :type "Reference"}
      {:name "relationship",
       :base "Patient_Contact",
       :array true,
       :required false,
       :value "Base.CodeableConcept",
       :type "CodeableConcept"}],
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
     :value "string",
     :type nil}
    {:name "value",
     :choices
     [{:name "valueBoolean",
       :base "Extension",
       :array false,
       :required false,
       :value "bool",
       :type "boolean"}]}
    {:name "valueBoolean",
     :base "Extension",
     :array false,
     :required false,
     :value "bool",
     :type "boolean"}],
   :url "http://hl7.org/fhir/StructureDefinition/organization-preferredContact",
   :backbone-elements (),
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
