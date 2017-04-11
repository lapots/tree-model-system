(ns tree-model-system.app
  (:require [tree-model-system.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
