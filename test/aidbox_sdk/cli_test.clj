(ns aidbox-sdk.cli-test
  (:require [aidbox-sdk.cli :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest cli-helpers-test

  (testing "validate-args"
    (is (= ["Please provide one of the supported commands: generate"
            "Please provide one of the supported target languages: dotnet, python"
            "Please provide a source of fhir packages"]
           (sut/validate-args [])))

    (is (= ["Please provide one of the supported commands: generate"
            "Please provide one of the supported target languages: dotnet, python"
            "Please provide a source of fhir packages"]
           (sut/validate-args ["resource/schemas"])))

    (is (= ["Please provide one of the supported target languages: dotnet, python"
            "Please provide a source of fhir packages"]
           (sut/validate-args ["generate"])))

    (is (= ["Please provide a source of fhir packages"]
           (sut/validate-args ["generate" "dotnet"])))

    (is (= (sut/validate-args ["generate" "dotnet" "http://localhost:8765/api/sdk/fhir-packages"])
           []))

    #_(is (= (sut/validate-args ["resource/schemas" "-h"])
             ["Please provide output argument"]))))
