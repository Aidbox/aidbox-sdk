(ns mock-server.main
  (:require [org.httpkit.server :as server]
            [clojure.java.io :as io]
            [clojure.data.json :as json]))

(defn not-found []
  {:status 404
   :headers {"Content-Type" "application/json"}
   :body (json/write-str {:status 404})})

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

    ;; else
    (not-found)))

(defn -main []
  (server/run-server app {:port 3333}))

(comment
  (def my-server (server/run-server app {:port 3333}))

  ;; stop server
  (my-server)

 ;
  )
