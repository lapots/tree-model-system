(ns tree-model-system.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [tree-model-system.layout :refer [error-page]]
            [tree-model-system.routes.home :refer [home-routes]]
            [compojure.route :as route]
            [tree-model-system.env :refer [defaults]]
            [mount.core :as mount]
            [tree-model-system.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
    (-> #'home-routes
        (wrap-routes middleware/wrap-csrf)
        (wrap-routes middleware/wrap-formats))
    (route/not-found
      (:body
        (error-page {:status 404
                     :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
