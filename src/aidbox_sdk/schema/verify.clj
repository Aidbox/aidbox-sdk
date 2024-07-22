(ns aidbox-sdk.schema.verify
  (:require [clojure.string :as str]))

;; FIXME: is it reliable to use first element of the list?
;; ! seems like it's not for original packages (without Aidbox processing).
(defn extract-meta-from-package
  "Extracts meta information from the package."
  [package]
  (first package))

(defn find-core-package
  "Finds core package in the list of packages.
   Throws an exception if there are more then one core package."
  [packages]
  (let [cores (filter #(= "fhir.core" (:type %)) packages)
        core  (first cores)]
    (cond
      (= (count cores) 0)
      (throw (ex-info "No core package found" {}))

      (> (count cores) 1)
      (throw (ex-info "Found more then one core package"
                      {:packages (mapv :name cores)}))

      :else
      core)))

(defn find-extra-packages
  "Finds extra packages in the list of packages."
  [packages]
  (remove #(= "fhir.core" (:type %)) packages))

(defn find-core-package-mismatch
  "Finds packages which do not support a core package version."
  [version packages]
  (->> packages
       (mapv    #(assoc % :match-with-core? (-> (hash-set version)
                                                (some (:fhirVersions %))
                                                (boolean))))
       (filterv #(not (:match-with-core? %)))))

(defn- find-failed-dependencies
  "Finds failed dependencies for the package looking up in all packages.
   In case of failure will return a vec of failed dependencies."
  [packages {:keys [dependencies]}]
  (reduce (fn [mismatch dependency]
            (let [[dep-name dep-version]
                  (-> (subs dependency 1)
                      (str/split #"#"))

                  found
                  (->> packages
                       (filterv #(= (:name %) dep-name))
                       (mapv #(select-keys % [:name :version])))]

              (if (and (= (count found) 1)
                       (every? #(= (:version %) dep-version) found))
                mismatch
                (conj mismatch {:required {:name    dep-name
                                           :version dep-version}
                                :found    found}))))
          [] dependencies))

(defn find-dependencies-mismatch
  "Finds packages with failed dependencies check."
  [packages]
  (reduce (fn [mismatches package]
            (let [failed-dependencies (find-failed-dependencies packages package)]
              (if-not (empty? failed-dependencies)
                (->> failed-dependencies
                     (assoc package :failed-dependencies)
                     (conj mismatches))
                mismatches)))
          [] packages))

(defn check-compatibility! [packages]
  (println "Verifying compatibility...")
  (let [all   (map extract-meta-from-package packages)
        core  (find-core-package   all)
        extra (find-extra-packages all)]
    (println "✅ Core package found:" (:name core))

    (println "Checking core version match...")
    (let [core-mismatch (find-core-package-mismatch (:version core) extra)]
      (when-not (empty? core-mismatch)
        (throw (ex-info "Some packages do not match with core version"
                        {:version  (:version core)
                         :packages (mapv :name core-mismatch)}))))
    (println "✅ Core version match check passed")

    (println "Checking dependencies match...")
    (let [deps-mismatch (find-dependencies-mismatch all)]
      (when-not (empty? deps-mismatch)
        (throw (ex-info "Some packages failed dependencies check"
                        {:packages (mapv #(select-keys % [:name :failed-dependencies])
                                         deps-mismatch)}))))
    (println "✅ Dependencies match check passed"))
  packages)
