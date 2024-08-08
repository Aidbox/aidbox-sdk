(ns aidbox-sdk.cli-test
  (:require [aidbox-sdk.cli :as sut]
            [clojure.test :as t :refer [deftest is testing]]))

(deftest cli-helpers-test

  (testing "validate-args"
    (is (= (sut/validate-args [])

           ["Please provide one of the supported commands: generate"
            "Please provide one of the supported target languages: dotnet, java, typescript, python"
            "Please provide input argument"]))

    (is (= (sut/validate-args ["resource/schemas"])

           ["Please provide one of the supported commands: generate"
            "Please provide one of the supported target languages: dotnet, java, typescript, python"
            "Please provide input argument"]))

    (is (= (sut/validate-args ["generate"])

           ["Please provide one of the supported target languages: dotnet, java, typescript, python"
            "Please provide input argument"]))

    (is (= (sut/validate-args ["generate" "dotnet"])

           ["Please provide input argument"]))

    (is (= (sut/validate-args ["generate" "dotnet" "http://localhost:8765/api/sdk/fhir-packages"])
           []))

    #_(is (= (sut/validate-args ["resource/schemas" "-h"])
             ["Please provide output argument"]))))
