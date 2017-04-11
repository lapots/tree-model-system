(ns user
  (:require [mount.core :as mount]
            [tree-model-system.figwheel :refer [start-fw stop-fw cljs]]
            tree-model-system.core))

(defn start []
  (mount/start-without #'tree-model-system.core/repl-server))

(defn stop []
  (mount/stop-except #'tree-model-system.core/repl-server))

(defn restart []
  (stop)
  (start))


