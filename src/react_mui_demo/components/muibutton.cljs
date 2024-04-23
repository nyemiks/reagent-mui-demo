(ns react-mui-demo.components.muibutton
  (:require
   [reagent.core :as r]
   ["react" :as react]
  ; [reagent.core :refer [atom]]
   ["@mui/material" :refer 
    [ButtonGroup Stack Button IconButton
     ToggleButtonGroup ToggleButton
     ]]
  ; ["@mui/icons-material/Send" :as SendIcon]
  ; ["@mui/icons-material" :refer [Send]]
   ["@mui/icons-material" :as mui-icons]
  )
  )

(defn handle-change-format []
  
  )

; 
(defn mui-button [] 
  (let [
         
        ;[formats setformat] (react/useState [])   ; allows toggling multiple buttons
          [formats setformat] (react/useState nil) 
        ]
   
   [:> Stack {:spacing 4}   
    [:> Stack {:spacing 2 :direction "row"}
      [:> Button {:variant "text" :href "https://google.com"} "Text"]
      [:> Button {:variant "contained"} "Text"]
      [:> Button {:variant "outlined"} "Text"]
    ]
    [:> Stack {:spacing 2 :direction "row"} 
       [:> Button {:variant "contained" :color "primary"} "Primary"] 
       [:> Button {:variant "contained" :color "secondary"} "Secondary"]
          [:> Button {:variant "contained" :color "error"} "Error"]
       [:> Button {:variant "contained" :color "warning"} "Warning"]
          [:> Button {:variant "contained" :color "info"} "Info"]
       [:> Button {:variant "contained" :color "success"} "Success"]
    
     ]
    [:> Stack {:display "block" :spacing 2 :direction "row"}
      [:> Button {:variant "contained" :size "small"} "Small"] 
      [:> Button {:variant "contained" :size "medium"} "Medium"]
      [:> Button {:variant "contained" :size "large"} "Large"]
     ]
    [:> Stack {:spacing 2 :direction "row"}
   ;  [:> Button {:variant "outlined" :color "secondary" } "Reset"       [:> mui-icons/Clear]       ]
      [:> Button {:variant "contained"
                  :disableRipple true
                  :on-click #(js/alert "hello")
                  }
       [:> mui-icons/Send] "Send"]
     [:> Button {:variant "contained"
                 :disableElevation true
                 } "Send" [:> mui-icons/Send] ]
      [:> IconButton {
                      :aria-label "send"
                      :color "success"
                      :size "small" 
                      }
          [:> mui-icons/Send]
       ]
     
       [:> Button {:variant "contained"
                   :startIcon (r/as-element [:> mui-icons/Send ])
                   } "send u na"]
      
       [:> Button {:variant "contained"
                   :endIcon (r/as-element [:> mui-icons/Send ])
                   } "send u na again"]
     ]
    [:> Stack {:direction "row"}
     [:> ButtonGroup {
                      :variant "contained" 
                      :orientation "vertical"
                      :size "small"
                      :color "secondary"
                      :aria-label "alignment button group"
                      }
        [:> Button {:on-click #(js/alert "left clicked")} "Left" ]
        [:> Button "Center"]
        [:> Button "Right"]
      ]
     
     ]
      [:> Stack {:direction "row"}
        [:> ToggleButtonGroup {
                               :aria-label "text formatting"
                               :value formats
                               :on-change (fn [evt updatedFormats]
                                            (.info js/console "updatedFormats: " updatedFormats)
                                             (setformat updatedFormats)
                                            )
                               :size "small"
                               :color "success"
                               :orientation "vertical"
                               :exclusive true
                               }
           [:> ToggleButton {:value "bold"
                             :aria-label "bold"
                             } [:> mui-icons/FormatBold]] 
           [:> ToggleButton {:value "italic"
                             :aria-label "bold"
                             } [:> mui-icons/FormatItalic]]
           [:> ToggleButton {:value "underlined"
                             :aria-label "bold"
                             } [:> mui-icons/FormatUnderlined]]
         ]
       ]
    
   ])
  
  )
