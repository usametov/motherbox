(defproject motherbox "0.1.2-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.7"]
                 [cljs-react-material-ui "0.2.50"]
                 [cljsjs/react-dom "16.0.0-0"]
                 [cljsjs/react "16.0.0-0"]]

  :plugins [[lein-cljsbuild "1.1.4"]]

  :min-lein-version "2.5.3"
  :source-paths ["src/clj"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :figwheel {:css-dirs ["resources/public/css"]}
  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.7"]]
                   :plugins      [[lein-figwheel "0.5.20"]
                                  [lein-ancient "0.6.10"]]}}
  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src/cljs"]
                        :figwheel     {:on-jsload "bookmarks.core/mount-root"}
                        :compiler     {:main                 bookmarks.core
                                       :output-to            "resources/public/js/compiled/app.js"
                                       :output-dir           "resources/public/js/compiled/out"
                                       :asset-path           "js/compiled/out"
                                       :source-map-timestamp true
                                       :preloads             [devtools.preload]
                                       :external-config      {:devtools/config {:features-to-install :all}}}}
                       {:id           "min"
                        :source-paths ["src/cljs"]
                        :compiler     {:main          bookmarks.core
                                       :output-to     "resources/public/js/compiled/app.js"
                                       :optimizations :advanced
                                       :pretty-print  false}}]})
