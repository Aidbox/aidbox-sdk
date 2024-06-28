(ns build
  (:require [clojure.tools.build.api :as b]))

(def class-dir "target/classes")
(def basis (b/create-basis {:project "deps.edn"}))

(defn clean [_]
  (b/delete {:path "target"}))

(defn uberjar [{:keys [jar-name]
                :or {jar-name "aidbox-sdk"}}]

  (clean nil)

  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})

  (b/compile-clj {:basis basis
                  :ns-compile '[aidbox-sdk.core]
                  :class-dir class-dir})

  (b/uber {:class-dir class-dir
           :uber-file (str "target/" jar-name ".jar")
           :basis basis
           :main 'aidbox-sdk.core}))
