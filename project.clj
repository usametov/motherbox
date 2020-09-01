(defproject motherbox "0.1.2-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"]
                 [reagent "0.10.0"]
                 [re-frame "1.1.1"]
                 [re-com "2.9.0"]                 
                 ]

  :plugins [[lein-cljsbuild "1.1.4"]]

  :min-lein-version "2.5.3"
  :source-paths ["src/clj"]
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]
  :figwheel {:css-dirs ["resources/public/assets/css"]}
  :profiles {:dev {:dependencies [[http-kit "2.4.0"]
                                  [binaryage/devtools "0.9.7"]]
                   :plugins      [[lein-figwheel "0.5.20"]
                                  [lein-ancient "0.6.15"]]}}
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
