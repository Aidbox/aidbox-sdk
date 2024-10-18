(ns mock-server.main
  (:require
   [org.httpkit.server :as server]
   [clojure.java.io :as io]))

(defn not-found []
  {:status 404
   :headers {"Content-Type" "application/json"}
   :body "{\"status\":404}"})

(defn app [req]
  (case (:uri req)
    "/r5/fhir-packages"
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (slurp (io/file "resources/aidbox_schemas/r5/fhir-packages.json"))}

    "/r5/fhir-packages/hl7.fhir.r5.core%235.0.0/schemas"
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (slurp (io/file "resources/aidbox_schemas/r5/schemas.json"))}

    "/r4/fhir-packages"
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (slurp (io/file "resources/aidbox_schemas/r4/fhir-packages.json"))}

    "/r4/fhir-packages/hl7.fhir.r4.core%234.0.1/schemas"
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (slurp (io/file "resources/aidbox_schemas/r4/schemas.json"))}

    "/r4b/fhir-packages"
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (slurp (io/file "resources/aidbox_schemas/r4/fhir-packages.json"))}

    "/r4b/fhir-packages/hl7.fhir.r4b.core%234.3.0/schemas"
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (slurp (io/file "resources/aidbox_schemas/r4/schemas.json"))}


    ;; else
    (not-found)))

(defn run [] (server/run-server app {:port 3333}))

(defn -main [] (run))
