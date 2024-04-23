(ns react-mui-demo.components.muitextfield
  (:require 
     ["react" :as react]
     [reagent.core :as r]
   ["@mui/material" :refer [Stack TextField InputAdornment]]
   )
  )




(defn mui-textfield []
  (let 
   [;value (r/atom "")
    [value setValue] (react/useState "") 
   ]
   
   [:> Stack {:spacing 4} 
   [:> Stack {:direction "row" 
              :spacing 2
              }
      [:> TextField {:label "Name"
                     :variant "outlined"
                     }
       ]
       [:> TextField {:label "Name"
                     :variant "filled"
                     }
       ]
    [:> TextField {:label "Name"
                     :variant "standard"
                     }
       ]
    ]
    [:> Stack {:direction "row" :spacing 2}
       [:> TextField {
                      :label "Small secondary"
                      :variant "standard"
                      :size "small"
                      :color "secondary"
                     }
       ]
     ]
    [:> Stack {:direction "row" :spacing 2}
       [:> TextField {
                      :label "Form Input"
                      :required true
                      :value value
                      :on-change (fn [e]
                                    (setValue (.. e -target -value))                                   
                                   )
                      :error (empty? value)
                      :helperText (if (empty? value) "Required" "Do not share your password with anyone")
                     }
       ]
     [:> TextField {
                      :label "Form Input"
                      :type "password"
                      :helperText "Do not share your password with anyone"
                      :disabled true
                    }
       ]
        [:> TextField {
                      :label "Read only"
                      :InputProps {:readOnly true}
                     }
       ]
     ]
     [:> Stack {:direction "row" :spacing 2}
       [:> TextField {:label "Amount"
                      :InputProps {:startAdornment (r/as-element [:> InputAdornment {:position "start"} "$"])}
                      
                      }
                 
        ]
       [:> TextField {:label "Weight"
                      :InputProps {:endAdornment (r/as-element [:> InputAdornment {:position "end"} "kg"])}
                      
                      }
                 
        ]
      ]
   ])

  )