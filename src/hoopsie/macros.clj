(ns hoopsie.macros
  (:require [clojure.java.io :as io]))

(defmacro read-config [] (read-string (slurp "assets/hoop-map.edn")))
