(ns aidbox-sdk.utils)

(defn list-files
  "List files recursively."
  [dir]
  (remove #(.isDirectory %) (file-seq dir)))

(defn get-relative-path
  "Returns path of file relative to directory. "
  [dir file]
  (.relativize (.toPath dir) (.toPath file)))
