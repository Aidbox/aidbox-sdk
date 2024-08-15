(ns aidbox-sdk.generator
  (:refer-clojure :exclude [namespace])
  (:require
   [aidbox-sdk.fhir :as fhir]
   [aidbox-sdk.generator.dotnet.templates :as dotnettpl]
   [aidbox-sdk.generator.helpers :refer [->pascal-case uppercase-first-letter
                                         vector-to-map]]
   [clojure.java.io :as io]
   [clojure.set :as set]
   [clojure.string :as str]
   [clojure.walk]))

;;
;; FHIR
;;

(defn resource? [schema]
  (= (:kind schema) "resource"))

(defn datatype-schema? [definition]
  (not= (:base definition)
        "http://hl7.org/fhir/StructureDefinition/DomainResource"))

(defn base-schema? [schema]
  (or (= (:url schema) "http://hl7.org/fhir/StructureDefinition/BackboneElement")
      (= (:url schema) "http://hl7.org/fhir/StructureDefinition/Resource")
      (= (:url schema) "http://hl7.org/fhir/StructureDefinition/Element")
      (= (:derivation schema) "specialization")))

(defn search-parameter-from-extension? [search-parameter]
  (str/includes? (:id search-parameter) "-extensions-"))

(defn domain-resource?
  "Is derived from DomainResource?"
  [schema]
  (= (:base schema) "http://hl7.org/fhir/StructureDefinition/DomainResource"))

;;
;; Generator
;;

(defn url->resource-type [reference]
  (last (str/split (str reference) #"/")))

(defn get-class-name [url]
  (let [n (apply str (map uppercase-first-letter (str/split (url->resource-type url) #"-")))]
    (cond
      (= n "Expression")  "ResourceExpression"
      (= n "Reference")   "ResourceReference" :else n)))

(defn resolve-choices [elements]
  (->> elements
       (map (fn [el]
              (if (:choices el)
                (assoc el :choices
                       (->> elements
                            (filter #(contains? (set (:choices el))
                                                (:name %)))))
                el)))))

;;
;; C# Specific Templates
;;

(defn package->directory
  "Generate directory name from package name.
  hl7.fhir.r4.core#4.0.1 -> hl7-fhir-r4-core"
  [x]
  (-> x
      (str/replace #"[\.#]" "-")))

(defn package->namespace
  "Convert package name to namespace.
  hl7.fhir.r4.core#4.0.1 -> Aidbox.FHIR.R4.Core"
  [x]
  (str "Aidbox.FHIR."
       (->> (-> x
                (str/replace #"hl7.fhir." "")
                (str/split #"\."))
            (map ->pascal-case)
            (str/join "."))))

(defn x2 [s] (apply str (repeat 2 s)))

(def indent
  "Default 4 spaces C# indentation."
  "    ")

(defn using [& nss]
  (->> nss
       (map #(str "using " % ";"))
       (str/join "\n")))

(defn namespace [nsn]
  (str "namespace " nsn ";"))

(defn generate-polymorphic-element [element]
  (str "public object?"
       " "
       (uppercase-first-letter (:name element))
       (->> (str
             "\n"
             "{"
             "\n"
             indent
             "get"
             "\n"
             indent
             "{\n"
             (->> (:choices element)
                  (map (fn [choice]
                         (str (x2 indent)
                              "if (" (->pascal-case (:name choice)) " is not null)\n"
                              (x2 indent)
                              "{"
                              "\n"
                              (x2 indent)
                              indent
                              "return " (->pascal-case (:name choice)) ";"
                              "\n"
                              (x2 indent)
                              "}")))
                  (str/join "\n\n"))
             "\n\n"
             (x2 indent)
             "return null;"
             "\n"
             indent
             "}"
             "\n"
             "\n"
             indent
             "set"
             "\n"
             indent
             "{"
             "\n"
             (->> (:choices element)
                  (map (fn [choice]
                         (str (x2 indent)
                              "if (value?.GetType() == typeof(" (:value choice) "))\n"
                              (x2 indent)
                              "{"
                              "\n"
                              indent
                              (x2 indent)
                              (->pascal-case (:name choice)) " = (" (:value choice) ")value;"
                              "return;"
                              "\n"
                              (x2 indent)
                              "}")))
                  (str/join "\n\n"))
             "\n\n"
             (x2 indent)
             "throw new ArgumentException(\"Invalid type provided\");"
             "\n"
             indent
             "}"
             "\n"
             "}")
            ((fn [s] (str/split s #"\n")))
            (map #(str indent %))
            (str/join "\n"))))

(defn generate-property
  "Takes schema element and generate class property."
  [element]
  (if (not (contains? element :choices))
    ;; generate normal field
    (str "public "
         ;; TODO this is not enough
         ;; In order to properly put "new" modifier we must know if
         ;; there is a same property in ancestor classes
         (when (:meta element)
           "new ")
         (when (and (:required element)
                    (not (:meta element))) "required ")
         (:value element)
         (:generic element)
         (when (:array element) "[]")
         (when (and (not (:required element))
                    (not (:literal element))) "?")
         " "
         (uppercase-first-letter (:name element))
         " "
         (if (or (:meta element)
                 (:codeable-concept-pattern element))
           "{ get; }"
           "{ get; set; }")
         (when (and (:required element)
                    (:codeable-concept-pattern element)) " = new()")
         (:meta element))

    ;; generate polymorphic field
    (generate-polymorphic-element element)))

(defn generate-class [class-name elements parent & [inner-classes]]
  (let [class-properties
        (->> elements
             (map generate-property)
             (map #(str indent %))
             (str/join "\n"))

        base-class-name (when-not (str/blank? parent)
                          (str " : " (uppercase-first-letter parent)))]
    (str "public class " class-name base-class-name "\n{"
         (when-not (str/blank? class-properties) "\n")
         class-properties
         (when (and inner-classes
                    (seq inner-classes))
           "\n\n")
         (str/join "\n\n" inner-classes)
         "\n}")))

(defn generate-class-from-schema [schema & [inner-classes]]
  (let [base-class (url->resource-type (:base schema))
        schema-name (or (:url schema) (:name schema))
        generic (when (= (:type schema) "Bundle") "<T>")]
    (generate-class
     (get-class-name (str schema-name generic))
     (->> (:elements schema)
          (resolve-choices)
          (map #(if (and (= (:base %) "Bundle_Entry")
                         (= (:name %) "resource"))
                  (assoc % :value "T")
                  %)))

     (if (= base-class "Resource") "Base.Resource" base-class)
     (->> inner-classes
          (map (fn [class-string]
                 (->> class-string
                      (str/split-lines)
                      (map #(str indent %))
                      (str/join "\n"))))))))

(defn generate-namespace
  [& {name' :name
      :keys [usings classes interfaces structs enums delegates]
      :or {classes []
           interfaces []
           structs []
           enums []
           delegates []}}]
  (->> (conj []
             (if usings (apply using usings) [])
             (namespace name')
             classes
             interfaces
             structs
             enums
             delegates)
       (flatten)
       (str/join "\n\n")))

(defn generate-base-namespace [schemas]
  (let [datatype-classes
        (->> schemas
             (filter datatype-schema?)
             (map (fn [schema]
                    (generate-class-from-schema
                     schema
                     (->> (schema :backbone-elements)
                          (map #(assoc % :base "BackboneElement"))
                          (map generate-class-from-schema))))))]
    (generate-namespace
     :name "Aidbox.FHIR.Base"
     :classes datatype-classes)))

(defn generate-resource-namespace [schema]
  (let [backbone-elements-classes (->> (schema :backbone-elements)
                                       (map #(assoc % :base "BackboneElement"))
                                       (map generate-class-from-schema))
        resource-class (generate-class-from-schema schema backbone-elements-classes)]

    (generate-namespace
     :name (package->namespace (:package schema))
     :usings ["Aidbox.FHIR.Base" "Aidbox.FHIR.Utils"]
     :classes resource-class)))

(defn generate-constraint-namespace [schema]
  (let [backbone-elements-classes (->> (:backbone-elements schema)
                                       (map #(assoc % :base "BackboneElement"))
                                       (mapv generate-class-from-schema))
        resource-class (generate-class-from-schema schema backbone-elements-classes)]
    (generate-namespace
     :name (package->namespace (:package schema))
     :usings ["Aidbox.FHIR.Base" "Aidbox.FHIR.Utils"]
     :classes resource-class)))

(defn generate-utils-namespace [items]
  (let [resource-map (->> items
                          (sort-by :name)
                          (map
                           #(format "{ typeof(%s), \"%s\" }" (:type %) (:name %))))]
    (str (using "System.Text.Json"
                "System.Text.Json.Serialization")
         "\n\n"
         (namespace "Aidbox.FHIR.Utils")
         "\n\n"
         "public interface IResource { string? Id { get; set; } }"
         "\n\n"
         "public class LowercaseNamingPolicy : JsonNamingPolicy"
         "\n"
         "{"
         "\n"
         indent
         "public override string ConvertName(string name) => name.ToLower();"
         "\n"
         "}"
         "\n\n"
         "public class Config"
         "\n"
         "{"
         "\n"
         indent
         "public static readonly JsonSerializerOptions JsonSerializerOptions = new()"
         "\n"
         indent
         "{"
         "\n"
         (x2 indent)
         "DefaultIgnoreCondition = JsonIgnoreCondition.WhenWritingNull,"
         "\n"
         (x2 indent)
         "PropertyNamingPolicy = JsonNamingPolicy.CamelCase,"
         "\n"
         (x2 indent)
         "Converters = { new JsonStringEnumConverter(new LowercaseNamingPolicy()) },"
         "\n"
         (x2 indent)
         "WriteIndented = true"
         "\n"
         indent
         "};"
         "\n\n"
         indent
         "public static readonly Dictionary<Type, string> ResourceMap = new()"
         "\n"
         indent
         "{"
         "\n"
         (x2 indent)
         (str/join (str ",\n" (x2 indent)) resource-map)
         "\n"
         indent
         "};"
         "\n"
         "}")))

;;
;; Constraints
;;

(defn apply-excluded [excluded schema]
  (filter (fn [field-schema]
            (not (some #(= % (:name field-schema)) excluded))) schema))

(defn apply-required [required elements]
  (->> elements
       (map (fn [element]
              (if (contains? (set required) (:name element))
                (assoc element :required true)
                element)))))

(defn apply-choices [choises schema]
  (->> (map (fn [[key, item]] (set/difference (set (:choices (first (filter #(= (:name %) (name key)) schema)))) (set (:choices item)))) choises)
       (reduce set/union #{})
       ((fn [choises-to-exclude]
          (filter #(not (contains? choises-to-exclude (:name %))) schema)))))

(defn pattern-codeable-concept [name schema]
  (->> (str "}")
       (str "\tpublic new " (str/join ", " (map #(str "Coding" (str/join (str/split (:code %) #"-"))) (get-in schema [:pattern :coding] []))) "[] Coding { get; } = [new()];\n") #_(str/join ", " (map #(str "Coding" (str/join (str/split (:code %) #"-")) "()") (get-in schema [:pattern :coding] [])))
       (str "\nclass " (str/join (map uppercase-first-letter (str/split name #"-"))) " : CodeableConcept\n{\n")
       (str (when-let [coding (:coding (:pattern schema))]
              (str/join (map (fn [code] (->> (str "}")
                                             (str (when (contains? code :code)  (str "\tpublic new string Code { get; } = \"" (:code code) "\";\n")))
                                             (str (when (contains? code :system) (str "\tpublic new string System { get; } = \"" (:system code) "\";\n")))
                                             (str (when (contains? code :display) (str "\tpublic new string Display { get; } = \"" (:display code) "\";\n")))
                                             (str "\n\nclass Coding" (str/join (str/split (:code code) #"-")) " : Coding\n{\n"))) coding))) "\n")))

(defn create-single-pattern [constraint-name, [key, schema], elements]
  (case (url->resource-type (some #(when (= (name key) (:name %)) (:value %)) elements))
    "CodeableConcept" (pattern-codeable-concept (str (uppercase-first-letter (url->resource-type constraint-name)) (uppercase-first-letter (subs (str key) 1))) schema) ""))

(defn apply-patterns [constraint-name patterns schema]
  (->> (map (fn [item]
              (if-let [pattern (some #(when (= (name (first %)) (:name item)) (last %)) patterns)]
                (case (:value item)
                  "str" (assoc item :value (:pattern pattern) :literal true)
                  "CodeableConcept" (conj item (hash-map :value (str (str/join (map uppercase-first-letter (str/split (url->resource-type constraint-name) #"-"))) (str/join (map uppercase-first-letter (str/split (:name item) #"-")))) :codeable-concept-pattern true))
                  "Quantity" item item) item)) (:elements schema))
       (hash-map :elements)
       (conj schema (hash-map :patterns (concat (get schema :patterns []) (map (fn [item] (create-single-pattern constraint-name item (:elements schema))) patterns))))))

(defn add-meta [constraint-name elements]
  (->> (filter #(not (= (:name %) "meta")) elements)
       (concat [{:name "meta" :required true :value (str "Meta") :meta (str " = new() { Profile = [\"" constraint-name "\"] };")}])))

(defn apply-single-constraint [constraint parent-schema]
  (->> (:elements parent-schema)
       (apply-required (:required constraint))
       (apply-excluded (:excluded constraint))
       (apply-choices (filter #(contains? (last %) :choices) (:elements constraint)))
       (add-meta (:url constraint))
       (hash-map :elements)
       (conj parent-schema)
       (apply-patterns (:url constraint) (filter #(contains? (last %) :pattern) (:elements constraint)))))

(defn apply-constraints [constraint-schemas base-schemas]
  (loop [result {}]
    (if (= (count constraint-schemas) (count result))
      result
      (recur
       (reduce (fn [acc constraint-schema]
                 (cond
                   (contains? result (:url constraint-schema))
                   acc

                   (contains? result (:base constraint-schema))
                   (assoc acc
                          (:url constraint-schema)
                          (assoc (apply-single-constraint constraint-schema
                                                          (get result (:base constraint-schema)))
                                 :package (:package constraint-schema)))

                   (contains? base-schemas (:base constraint-schema))
                   (assoc acc
                          (:url constraint-schema)
                          (assoc (apply-single-constraint constraint-schema
                                                          (get base-schemas (:base constraint-schema)))
                                 :package (:package constraint-schema)))

                   :else acc))

               result
               constraint-schemas)))))

;;
;; Search Parameters
;;

(defn search-parameters-for [schemas resource-name]
  (->> schemas
       (filter fhir/search-parameter?)
       (remove search-parameter-from-extension?)
       (filter #(contains? (set (:base %)) resource-name))))

(defn fields-for [schemas resource]
  (->> (search-parameters-for schemas resource)
       (map :code)
       (map ->pascal-case)
       (distinct)
       (sort)))

(defn search-parameters-structures
  [search-parameters-schemas schemas]
  (->> schemas
       (filter resource?)
       (map #(hash-map
              :resource-type (:id %)
              :base-resource-type
              (when-let [base (:base %)]
                (->pascal-case (str/replace base #"http://hl7.org/fhir/StructureDefinition/" "")))

              :fields (fields-for search-parameters-schemas (:id %))))
       (remove #(empty? (:fields %)))))

(defn search-parameters-classes [search-parameters-schemas schemas]
  (for [{:keys [resource-type base-resource-type fields]}
        (search-parameters-structures search-parameters-schemas schemas)]
    {:resource-type resource-type
     :class-file-content
     (generate-namespace
      :name "Aidbox.FHIR.Search"
      :classes (generate-class
                (str resource-type "SearchParameters")
                (map #(hash-map :value "string" :name %) fields)
                (when base-resource-type
                  (str base-resource-type "SearchParameters"))))}))

;;
;; I/O Helpers
;;

(defn save-to-file! [path content]
  (io/make-parents path)
  (spit path content))

(defn create-directory! [dir]
  (when-not (.mkdir dir)
    (throw (Exception. (str "Can't create directory: " dir)))))

(defn delete-directory!
  "Recursively delete a directory."
  [^java.io.File file]
  (when (.exists file)
    (when (.isDirectory file)
      (run! delete-directory! (.listFiles file)))
    (io/delete-file file)))

(defn prepare-target-directory! [dir]
  (delete-directory! dir)
  (create-directory! dir))

;;
;; main
;;

(defmulti generate-resource-module (fn [target-language _schema] target-language))

(defmulti build-all! (fn [& {:keys [target-language]}] target-language))



(defmethod build-all! :default [_]
  (println "SDK generation for this language is not implemented yet"))

#_
(defmethod build-all! :dotnet [& {:keys [auth input output]}]
  (let [output                (io/file output)
        search-parameters-dir (io/file output "search")
        all-schemas           (schema/retrieve
                               (schema/resource input)
                               {:auth auth})
        fhir-schemas          (filter fhir/fhir-schema? all-schemas)
        search-params-schemas (filter fhir/search-parameter? all-schemas)
        constraints           (filter #(and (fhir/constraint? %)
                                            (not (fhir/extension? %))) all-schemas)]

    (gen/prepare-target-directory! output)

    ;; create base namespace (all FHIR datatypes) file
    (println "---")
    (println "Generating Datatypes")
    (->> all-schemas
         (filter base-schema?)
         (converter/convert)
         (sort-by :base)
         (generate-base-namespace)
         (save-to-file!
          (io/file output "Base.cs")))

    ;; create spezialization files
    (println "Generating resource classes")
    (doseq [item (->> fhir-schemas
                      (filter base-schema?)
                      (filter domain-resource?)
                      (converter/convert)
                      ((fn [schemas]
                         (->> schemas
                              (map (fn [schema]
                                     (update schema :base #(str % ", IResource"))))))))]

      (save-to-file!
       (io/file output (package->directory (:package item)) (str (:name item) ".cs"))
       (generate-resource-namespace item)))

    ;; create resource map file
    (println "Generating resource map")
    (->> all-schemas
         (filter base-schema?)
         (filter domain-resource?)
         (into constraints)
         (remove (fn [schema]
                   (= (:base schema) "http://hl7.org/fhir/StructureDefinition/Bundle")))
         (converter/convert)
         (map #(hash-map
                :type (str (package->namespace (:package %))
                           "."
                           (->pascal-case (url->resource-type (:url %))))
                :name (->pascal-case (url->resource-type (:url %)))))
         (generate-utils-namespace)
         (save-to-file!
          (io/file output "ResourceMap.cs")))

    ;; create search parameters classes
    (doseq [item (search-parameters-classes search-params-schemas
                                            all-schemas)]
      (save-to-file!
       (io/file search-parameters-dir (str (:resource-type item) "SearchParameters.cs"))
       (:class-file-content item)))

    ;; create constraints
    (println "Generating constraints classes")
    (doseq [{:keys [name schema file-content]}
            (->> (apply-constraints
                  (filter fhir/fhir-schema? constraints)
                  (->> (filter fhir/fhir-schema? all-schemas)
                       (converter/convert)
                       (vector-to-map)))
                 (mapv (fn [[name' schema]]
                         {:name name'
                          :schema schema
                          :file-content (generate-constraint-namespace
                                         (assoc schema
                                                :url name'))})))]
      (gen/save-to-file!
       (io/file output
                (package->directory (:package schema))
                (str (->pascal-case (url->resource-type name)) ".cs"))
       file-content))

    (println "Generating common SDK files")
    (doseq [file dotnettpl/files]
      (spit (io/file output (:name file)) (:content file)))))
