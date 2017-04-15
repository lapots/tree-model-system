(defproject tree-model-system "0.1.0-SNAPSHOT"

  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :hooks [lein-typescript.plugin]
  :dependencies [[compojure "1.5.2"]
                 [cprop "0.1.10"]
                 [funcool/struct "1.0.0"]
                 [luminus-immutant "0.2.3"]
                 [luminus-nrepl "0.1.4"]
                 [luminus/ring-ttl-session "0.3.2"]
                 [markdown-clj "0.9.98"]
                 [metosin/muuntaja "0.2.1"]
                 [metosin/ring-http-response "0.8.2"]
                 [mount "0.1.11"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.495" :scope "provided"]
                 [org.clojure/tools.cli "0.3.5"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.webjars.bower/tether "1.4.0"]
                 [org.webjars/bootstrap "4.0.0-alpha.5"]
                 [org.webjars/font-awesome "4.7.0"]
                 [org.webjars/webjars-locator-jboss-vfs "0.1.0"]
                 [ring-webjars "0.1.1"]
                 [ring/ring-core "1.6.0-RC2"]
                 [ring/ring-defaults "0.2.3"]
                 [selmer "1.10.7"]
                 [hiccups "0.3.0"]]

  :min-lein-version "2.0.0"

  :jvm-opts ["-server" "-Dconf=.lein-env"]
  :source-paths ["src/clj" "src/cljc" "src/ts"]
  :test-paths ["test/clj"]
  :resource-paths ["resources" "target/cljsbuild" "resources/public/node_modules"]
  :target-path "target/%s/"
  :main ^:skip-aot tree-model-system.core

  :plugins [[lein-cprop "1.0.1"]
            [lein-cljsbuild "1.1.5"]
            [lein-immutant "2.1.0"]
            [lein-npm "0.6.2"]
            [lein-typescript "0.1.3"]]
  :clean-targets ^{:protect false}
  [:target-path [:cljsbuild :builds :app :compiler :output-dir] [:cljsbuild :builds :app :compiler :output-to]]
  :figwheel
  {:http-server-root "public"
   :nrepl-port 7002
   :css-dirs ["resources/public/css"]
   :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :typescript {:sources ["src/ts"]
               :out-dir "target"
               :module :amd
               :declaration true
               :source-map true
               :remove-comments true
               :preserve-const-enums true
               :supress-implicit-any-index-errors true
               :target :es6
               :debug true}

  :npm {:root "resources/public"
        :dependencies[[systemjs "0.19.40"]
                      [core-js "^2.4.1"]
                      [rxjs "5.0.1"]
                      [zone.js "^0.8.4"]
                      [angular-in-memory-web-api "~0.3.0"]
                      ["@angular/common" "~4.0.0"]
                      ["@angular/compiler" "~4.0.0"]
                      ["@angular/core" "~4.0.0"]
                      ["@angular/forms" "~4.0.0"]
                      ["@angular/http" "~4.0.0"]
                      ["@angular/platform-browser" "~4.0.0"]
                      ["@angular/platform-browser-dynamic" "~4.0.0"]
                      ["@angular/router" "~4.0.0"]]
        :devDependencies[[concurrently "^3.2.0"]
                         [lite-server "^2.2.2"]
                         [typescript "~2.1.0"]
                         [canonical-path "0.0.2"]
                         [tslint "^3.15.1"]
                         [lodash "^4.16.4"]
                         [karma "^1.3.0"]
                         [karma-chrome-launcher "^2.0.0"]
                         [karma-cli "^1.0.1"]
                         [karma-jasmine "^1.0.2"]
                         [karma-jasmine-html-reporter "^0.2.2"]
                         [protractor "~4.0.14"]
                         [rimraf "^2.5.4"]
                         ["@types/node" "^6.0.46"]
                         ["@types/jasmine" "2.5.36"]]}

  :profiles
  {:uberjar {:omit-source true
             :prep-tasks ["compile" ["cljsbuild" "once" "min"]]
             :cljsbuild
             {:builds
              {:min
               {:source-paths ["src/cljc" "src/cljs" "env/prod/cljs"]
                :compiler
                {:output-to "target/cljsbuild/public/js/app.js"
                 :optimizations :advanced
                 :pretty-print false
                 :closure-warnings
                 {:externs-validation :off :non-standard-jsdoc :off}}}}}
             
             
             :aot :all
             :uberjar-name "tree-model-system.jar"
             :source-paths ["env/prod/clj"]
             :resource-paths ["env/prod/resources"]}

   :dev           [:project/dev :profiles/dev]
   :test          [:project/dev :project/test :profiles/test]

   :project/dev  {:dependencies [[prone "1.1.4"]
                                 [ring/ring-mock "0.3.0"]
                                 [ring/ring-devel "1.5.1"]
                                 [pjstadig/humane-test-output "0.8.1"]
                                 [binaryage/devtools "0.9.2"]
                                 [com.cemerick/piggieback "0.2.2-SNAPSHOT"]
                                 [doo "0.1.7"]
                                 [figwheel-sidecar "0.5.9"]]
                  :plugins      [[com.jakemccrary/lein-test-refresh "0.19.0"]
                                 [lein-doo "0.1.7"]
                                 [lein-figwheel "0.5.9"]
                                 [org.clojure/clojurescript "1.9.495"]]
                  :cljsbuild
                  {:builds
                   {:app
                    {:source-paths ["src/cljs" "src/cljc" "env/dev/cljs"]
                     :compiler
                     {:main "tree-model-system.app"
                      :asset-path "/js/out"
                      :output-to "target/cljsbuild/public/js/app.js"
                      :output-dir "target/cljsbuild/public/js/out"
                      :source-map true
                      :optimizations :none
                      :pretty-print true}}}}
                  
                  
                  
                  :doo {:build "test"}
                  :source-paths ["env/dev/clj"]
                  :resource-paths ["env/dev/resources"]
                  :repl-options {:init-ns user}
                  :injections [(require 'pjstadig.humane-test-output)
                               (pjstadig.humane-test-output/activate!)]}
   :project/test {:resource-paths ["env/test/resources"]
                  :cljsbuild
                  {:builds
                   {:test
                    {:source-paths ["src/cljc" "src/cljs" "test/cljs"]
                     :compiler
                     {:output-to "target/test.js"
                      :main "tree-model-system.doo-runner"
                      :optimizations :whitespace
                      :pretty-print true}}}}
                  
                  }
   :profiles/dev {}
   :profiles/test {}})
