((nil . ((cider-clojure-cli-aliases . ":dev")))
 (clojure-mode
  (eval . (defun aidbox-sdk-generate ()
            (interactive)
            (let ((language (completing-read "Select the language to generate: "
                                             '("dotnet" "java" "python" "typescript"))))
              (cider-interactive-eval
               (format "(sdk/generate! :%s
               \"http://localhost:3333/r4/fhir-packages\"
               {:output-dir \"dist/%s\"
                :auth-token \"YmFzaWM6c2VjcmV0\"
                :exit (fn [_] nil)})"
                       language language)))))))
