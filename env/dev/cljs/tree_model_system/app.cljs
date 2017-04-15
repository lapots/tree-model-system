(ns ^:figwheel-no-load tree-model-system.app
  (:require [tree-model-system.core :as core]
            [devtools.core :as devtools]
            [figwheel.client :as figwheel :include-macros true]))

(enable-console-print!)

(defn reload[]
    (core/init!)
    ((.. js/ng -platform -browser -bootstrap) (.-AppComponent (.-app js/window))))

(figwheel/watch-and-reload
  :websocket-url "ws://localhost:3449/figwheel-ws"
  ; :on-jsload core/mount-components)
  :on-jsload reload)

(devtools/install!)

(core/init!)
(defonce only-attack-listener-once
         (.addEventListener js/document "DOMContentLoaded"
                            (fn []
                                ((.. js/ng -platform -browser -bootstrap) (.-AppComponent (core/get-app))))))