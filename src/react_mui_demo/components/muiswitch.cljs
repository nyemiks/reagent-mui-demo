(ns react-mui-demo.components.muiswitch
  (:require 
   ["react" :as react]
   [reagent.core :as r]
   ["@mui/material" :refer 
    [Box FormControlLabel Switch]
    ]
   )
  )


(defn mui-switch []
  (let 
   [
     [checked setChecked] (react/useState false)
     handleChange         (fn [e]
                             (setChecked (.. e -target -checked))
                            )
   ]
    (.log js/console "checked: " checked)
   [:> Box
   [:> FormControlLabel {
                         :label "Dark Mode"
                         :control (r/as-element [:> Switch {
                                                            :checked checked
                                                            :on-change handleChange
                                                            :size "small"
                                                            :color "success"
                                                            }
                                                 ]
                                                )
                         }
    
    ]
   ])
  )