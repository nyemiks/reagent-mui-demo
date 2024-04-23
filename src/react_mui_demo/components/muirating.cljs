(ns react-mui-demo.components.muirating
  (:require 
   ["react" :as react]
   [reagent.core :as r]
   ["@mui/material" :refer [Stack Rating]]
  ["@mui/icons-material" :as mui-icons]
   )
  )


(defn mui-rating []
  (let
      [
        [value setValue]  (react/useState nil)
        handleChange      (fn [evt newValue]
                            (setValue newValue)
                            )
      ]   
      (.log js/console "value: " value)
   [:> Stack {:spacing 2}
     [:> Rating {
                 :value value
                 :on-change handleChange
                 :precision 0.5
                 :size "large"
                 :icon  (r/as-element [:> mui-icons/Favorite {:fontSize "inherit"}])
                 :emptyIcon (r/as-element [:> mui-icons/FavoriteBorder {:fontSize "inherit"}])
                 :readOnly false
                 :highlightSelectedOnly true
                 }
      ]
   ]
    )
  )