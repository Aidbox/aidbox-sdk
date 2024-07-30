(ns aidbox-sdk.schema.verify
  (:require [clojure.string :as str]))

(def fhir-version-pattern
  #"^(0|[1-9]\d*)\.(0|[1-9]\d*)(?:\.(0|[1-9]\d*))?(?:-((?:0|[1-9]\d*|\d*[a-zA-Z-][0-9a-zA-Z-]*))?)?$")

(defn versions-match? [v1 v2]
  (let [->groups (fn [v] (->> v (re-matcher fhir-version-pattern) re-find))
        ->map    (fn [[_ major minor patch label]]
                   {:major major, :minor minor, :patch patch, :label label})

        v1-groups (-> v1 ->groups ->map)
        v2-groups (-> v2 ->groups ->map)]

    (if (and v1-groups v2-groups)
      (and (= (:major v1-groups) (:major v2-groups))
           (= (:minor v1-groups) (:minor v2-groups)))
      false)))

(defn simplify-package-meta [package]
  (select-keys package [:name :version]))

;; FIXME: is it reliable to use first element of the list?
;; ! seems like it's not for original packages (without Aidbox processing).
(defn extract-meta-from-package
  "Extracts meta information from the package."
  [package]
  (first package))

(defn core-package? [package]
  (or
   (= "Core" (:type package))
   (= "fhir.core" (:type package))))

(defn find-core-package
  "Finds core package in the list of packages.
   Throws an exception if there are more then one core package."
  [packages]
  (let [cores (filter core-package? packages)
        core  (first cores)]
    (cond
      (= (count cores) 0)
      (throw (ex-info "No core package found" {}))

      (> (count cores) 1)
      (throw (ex-info "Found more then one core package"
                      {:packages (mapv #(simplify-package-meta %) cores)}))

      :else
      core)))

(defn find-extra-packages
  "Finds extra packages in the list of packages.
   Throws an exception if there are a few packages with same name."
  [packages]
  (let [extra      (remove core-package? packages)

        duplicates (reduce (fn [duplicates [k v]]
                             (if (= (count v) 1)
                               duplicates
                               (assoc duplicates k v)))
                           {} (group-by :name extra))]
    (cond
      (> (count duplicates) 0)
      (throw (ex-info "Found more then one package with same name"
                      {:packages (keys duplicates)}))

      :else
      extra))

  (remove core-package? packages))

(defn find-core-package-mismatch
  "Finds packages which do not support a core package version."
  [version packages]
  (->> packages
       (mapv    (fn [package]
                  (assoc package :match-with-core?
                         (if (> (count (:fhirVersions package)) 0)
                           (->> (:fhirVersions package)
                                (map #(versions-match? version %))
                                (some #{true})
                                (boolean))
                           true))))

       (filterv #(not (:match-with-core? %)))))

(defn- find-failed-dependencies
  "Finds failed dependencies for the package looking up in all packages.
   In case of failure will return a vec of failed dependencies."
  [packages {:keys [dependencies]}]
  (reduce (fn [mismatch dependency]
            (let [dependency
                  (if (str/starts-with? dependency ":")
                    (subs dependency 1)
                    dependency)

                  [dep-name dep-version]
                  (str/split dependency #"#")

                  found
                  (->> packages
                       (filterv #(= (:name %) dep-name))
                       (mapv #(simplify-package-meta %)))]

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
    (println "✅ Core package found:" (simplify-package-meta core))

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
