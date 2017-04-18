(ns com.lapots.tree.model.core
    (:use ring.adapter.jetty)
    (:use com.lapots.tree.model.router.core)
    (:require [ring.middleware.reload :refer [wrap-reload]])
    (:import [org.eclipse.jetty.server.handler StatisticsHandler])
    (:gen-class))

(def a-minute 60000)

(defn conf
      [server]
      (let [stats-handler (StatisticsHandler.)
            default-handler (.getHandler server)]
           (.setHandler stats-handler default-handler)
           (.setHandler server stats-handler)
           (.setStopTimeout server a-minute)
           (.setStopAtShutdown server true)))

(def app
    (-> routes
        wrap-reload))

(defn -main [& args]
      (run-jetty app {:port 3000 :configurator conf :join? false}))
