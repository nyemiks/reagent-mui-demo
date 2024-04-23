(ns react-mui-demo.core
    (:require
     ; [reagent.core :as r]
      [reagent.dom :as d]
      ["@mui/material" :as mui]
      [react-mui-demo.components.muitypography :refer [mui-typography]]
      [react-mui-demo.components.muibutton :refer [mui-button]]
      [react-mui-demo.components.muitextfield :refer [mui-textfield]]
      [react-mui-demo.components.muiselect :refer [mui-select]]
      [react-mui-demo.components.muiradiobutton :refer [mui-radio-btn]]
      [react-mui-demo.components.muicheckbox :refer [mui-checkbox]]
      [react-mui-demo.components.muiswitch :refer [mui-switch]]
      [react-mui-demo.components.muirating :refer [mui-rating]]
      [react-mui-demo.components.muiautocomplete :refer [mui-autocomplete]]
      [react-mui-demo.components.muilayout :refer[mui-layout]]
      [react-mui-demo.components.muicard :refer [mui-card]]
      [react-mui-demo.components.muiaccordion :refer [mui-accordion]]
     [react-mui-demo.components.muiimagelist :refer [mui-imagelist]]
     )
  )

;; -------------------------
;; Views

(defn text-button
 [label]
 [:> mui/Button {:variant "text"} label]) ; <--- here we use MUI component


(defn home-page []
   [:div.App [:h2 ]
  ; [text-button "Click me!"]
   ; [mui-typography]
   ; [mui-button]
   ; [:f> mui-button]
   ;  [mui-textfield]
    ;  [:f> mui-textfield]
    ; [:f> mui-select]
   ;  [mui-radio-btn]
     ; [:f> mui-radio-btn]   
      ; [mui-checkbox]
     ; [:f> mui-checkbox]
    ;  [:f> mui-switch]
      ; [:f> mui-rating]
     ;  [:f> mui-autocomplete]

     ; [mui-layout]
     ; [mui-card]
     ;  [:f> mui-accordion]
        [mui-imagelist]
    ]
  )

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn ^:export init! []
  (mount-root))
