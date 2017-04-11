(ns tree-model-system.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [tree-model-system.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[tree-model-system started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[tree-model-system has shut down successfully]=-"))
   :middleware wrap-dev})
