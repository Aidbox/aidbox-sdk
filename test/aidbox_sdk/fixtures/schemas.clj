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
