(ns react-mui-demo.components.muilayout
  (:require 
    ["@mui/material" :refer [Box Stack Divider Grid Paper]]
  
    [reagent.core :as r])
  )


(defn mui-layout []
  [:> Paper {
             :sx {
                  :padding "32px"                  
                  }
             :elevation 8
             } 
   

    [:> Stack {
             :sx {
                :border "1px solid"                
                }
             :direction "row"
             :spacing 2
             :divider (r/as-element [:> Divider {:orientation "vertical"
                                                 :flexItem true}])
           }
   [:> Box {
            
            :sx {
                 :backgroundColor "primary.main"
                 :color "white"
                 :height "100px"
                 :width "100px"
                 :padding "16px"
                 "&:hover" {
                            :backgroundColor "primary.light"
                 }
                 }
            } 
    "Code Evolution"
    ]
    [:> Box {
             :display "flex"
             :width "100px"
             :height "100px"
             :bgcolor "success.light"
             :p 2
             }
     ]
   ]

   [:> Grid {
             :container true
             :my 4
             :rowSpacing 2
             :columnSpacing 1
             }
       [:> Grid {
                 :item true
                 :xs 6
                 
                 }
           [:> Box {
                    :bgcolor "primary.light"
                    :p 2
                    } 
            "Item 1"
            ]
        ]
       [:> Grid {
                 :item true
                 :xs 6
                 
                 }
          [:> Box {
                    :bgcolor "primary.light"
                    :p 2
                    } 
           "Item 2"]
        ]
       [:> Grid {
                 :item true
                 :xs 6
                 
                 }
           [:> Box {
                    :bgcolor "primary.light"
                    :p 2
                    } 
            "Item 3"]
        ]
       [:> Grid {
                 :item true
                 :xs 6
                 
                 }
          [:> Box {
                    :bgcolor "primary.light"
                    :p 2
                    } 
           "Item 4"]
        ]
    ]

   
   
   ]
  
   
  )