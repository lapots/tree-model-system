(ns tree-model-system.core
    (:require-macros [hiccups.core :as hiccups :refer [html]]))

(defn mount-components []
  (let [content (js/document.getElementById "app")]
    (while (.hasChildNodes content)
      (.removeChild content (.-lastChild content)))
    (.appendChild content (js/document.createTextNode "Welcome to tree-model-system"))))


(defn get-app []
    (or (.-app js/window)
        (set! (.-app js/window) #js {})))

;(defn init! []
 ; (mount-components))

(defn init! []
    (let [app (get-app)
          ; I presume there we should reference to .js component
          c (.Component (.-core js/ng)
                        #js {:selector "my-app"
                             :template (html [:div
                                              [:h1 "My first Angular 2 app"]
                                              [:div [:h2 "test"]]
                                              [:div [:h3 "test2"]]])})
          c (.Class c #js {:constructor (fn [])})]
        (set! (.-AppComponent app) c)))