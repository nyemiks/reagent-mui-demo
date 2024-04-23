(ns react-mui-demo.components.muiradiobutton
  (:require 
    ["react" :as react]
    [reagent.core :as r]
    ["@mui/material" :refer 
     [FormHelperText Box FormControl FormLabel FormControlLabel RadioGroup Radio]]   
   )
  )




(defn mui-radio-btn []
  (let 
   [[value setValue]  (react/useState "")]
    (.info js/console "value: " value)
   [:> Box 
    [:> FormControl {:error false}
     [:> FormLabel {:id "job-experience-group-label"}
      "Years of experience"
      ]
     [:> RadioGroup {
                     :name "job-experience-group"
                     :aria-labelledby "job-experience-group-label"
                     :value value
                     :on-change  (fn [e]
                                   (setValue (.. e -target -value))
                                   )
                     :row true
                     }
       [:> FormControlLabel {
                             :control (r/as-element [:> Radio {
                                                               :size "medium"
                                                               :color "secondary"
                                                               }
                                                     ]
                                                    )
                             :label "0-2"
                             :value "0-2"
                             
                             }
        ]
        [:> FormControlLabel {
                             :control (r/as-element [:> Radio])
                             :label "3-5"
                             :value "3-5"
                             }
        ]
        [:> FormControlLabel {
                             :control (r/as-element [:> Radio])
                             :label "6-10"
                             :value "6-10"
                             }
        ]
      ]
      [:> FormHelperText "Invalid selection"]
     ]
   ])
  )