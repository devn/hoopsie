#!/usr/bin/env boot

#tailrecursion.boot.core/version "2.2.1"

(set-env!
  :project      'foobar
  :version      "0.1.0-SNAPSHOT"
  :dependencies '[[tailrecursion/boot.task   "2.1.0"]
                  [tailrecursion/hoplon      "5.4.0"]
                  [tailrecursion/boot.notify "2.0.0-SNAPSHOT"]
                  [tailrecursion/boot.ring   "0.1.0-SNAPSHOT"]
                  [org.clojure/clojurescript "0.0-2156"]]
  :out-path     "resources/public"
  :src-paths    #{"src"})

;; Static resources (css, images, etc.):
(add-sync! (get-env :out-path) #{"assets"})

(require '[tailrecursion.hoplon.boot :refer :all]
         '[tailrecursion.boot.task.notify :refer [hear]]
         '[tailrecursion.boot.task.ring   :refer [dev-server]])

(deftask development
  "Build foobar for development."
  []
  (comp (watch) (hoplon {:prerender false :pretty-print true})))

(deftask development-more
  "Build development with the new hotness."
  []
  (comp (watch) (hear) (hoplon {:prerender false}) (dev-server)))

(deftask production
  "Build foobar for production."
  []
  (hoplon {:optimizations :advanced}))
