(ns bookmarks.views
  (:require 
    [reagent.core  :as reagent]
    [re-frame.core :as re-frame]            
    [re-com.core   :refer [h-box v-box box gap line title label hyperlink-href input-textarea p p-span]]))

(defn github-hyperlink
  "given a label and a relative path, return a component which hyperlinks to the GitHub URL in a new tab"
  [label src-path]
  (let [base-url (str "https://github.com/usametov/motherbox/tree/master/")]
    [hyperlink-href
     :label  label
     ;:style  {:font-size    "13px"}
     :href   (str base-url src-path)
     :target "_blank"]))

(defn panel-title
  "Shown across the top of each page"
  [panel-name box-style title-style]
  [v-box   
   :children [[h-box
               :margin "4px 4px 9px 4px"
               :height "54px"
               :align :center               
               :children [[title
                           :label         panel-name
                           :level         :level2
                           :style         title-style
                           :margin-bottom "0px"
                           :margin-top    "2px"]
                          [gap :size "25px"]]
               :style box-style]
              ]])

(defn bookmark-card [bookmark]
  ; [ui/card {:class "bookmark-tile"}
  ;  [ui/card-title {:title (:title bookmark)}]
  ;  [ui/list
  ;   (for [link (:items bookmark)]
  ;     ^{:key link} [ui/list-item {:on-click #(navigate-to (:href link))
  ;                                 :class    "link"}
  ;                   (:title link)])]]
 )

(comment 
"bookmarks-cards"
(let [bookmarks (re-frame/subscribe [:filtered-bookmarks])]  
  [:section {:class "bookmarks"}
   (for [bookmark @bookmarks]
     ^{:key bookmark} [bookmark-card bookmark])])
 )

(defn bookmarks-cards []
 )

(defn search-bar []  
  (let [search-term (reagent/atom nil)]
    [input-textarea     
     :model search-term
     :width "480px"
     :placeholder  "Search bookmarks"
     :on-change    #(re-frame/dispatch [:filter-by search-term])
     ]))

(defn header []
  ; (let [name (re-frame/subscribe [:name])]
  ;   [:header
  ;    [ui/app-bar {:title                 (str @name " Bookmarks")
  ;                 :show-menu-icon-button false}]])
  )

(defn main-panel []
  [v-box   
   :children [[panel-title "Bookmarks Explorer"
               {:background-color "#008080" :padding-left "12px"} 
               {:color "#fff" :font-weight "bold"}]
              [line :color "#008080"]
              [gap :size "15px"]
              [search-bar]
              [bookmarks-cards]
              ]
   ]
  ; [ui/mui-theme-provider
  ;  {:mui-theme (get-mui-theme {:palette {:primary1Color (color :teal500)}})}
  ;  [:div
  ;   [header]
  ;   [:main
  ; ]]]
  )

