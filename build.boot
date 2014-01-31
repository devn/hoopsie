#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.0.0"

(set-env!
  :project      'hoopsie
  :version      "0.1.0-SNAPSHOT"
  :dependencies '[[tailrecursion/boot.task   "2.0.0"]
                  [tailrecursion/hoplon      "5.0.0"]
                  [org.clojure/clojurescript "0.0-2127"]
                  ;; [org.clojure/clojurescript "0.0-2156"]
                  ]
  :out-path     "resources/public"
  :src-paths    #{"src"})

;; Static resources (css, images, etc.):
(add-sync! (get-env :out-path) #{"assets"})

(require '[tailrecursion.hoplon.boot :refer :all])
