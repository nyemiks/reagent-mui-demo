(ns react-mui-demo.components.muicheckbox
  (:require 
    [clojure.string :as str]
    ["react" :as react]
    [reagent.core :as r]
    ["@mui/material" :refer 
     [Checkbox FormHelperText Box FormControlLabel
      FormControl FormLabel FormGroup]
     ]   
      ["@mui/icons-material" :as mui-icons]
   )
  )




(defn mui-checkbox []
  (let 
      [
       [acceptTnc setAcceptTnc] (react/useState false)
       [skills setSkills]  (react/useState [])
       handleSkillChange    (fn [e]
                              (let [
                                    value (.. e -target -value)
                                    index (str/index-of skills value)
                                  ]
                                  (.info js/console "selected check box: " value " index: " index)
                                   
                                   (if (nil? index)
                                     (setSkills (conj skills value))
                                     (setSkills (filterv (fn [skill]
                                                          (when (not= skill value) 
                                                            skill                                                            
                                                            )
                                                          ) 
                                                        skills
                                                        )
                                                )
                                     )

                                )
                              )
      ]
   ; (.info js/console "accept tnc: " acceptTnc)
     (.info js/console "skills: " skills)
   [:> Box
    [:> Box 
       [:> FormControlLabel {
                             :label "I accept the terms and conditions"
                             :control (r/as-element [:> Checkbox {
                                                                  :size "small"
                                                                  :color "secondary"
                                                                  :checked acceptTnc
                                                                  :on-change (fn [e]
                                                                               (setAcceptTnc (.. e -target -checked))
                                                                               )
                                                                  }])
                             }
        ]
     ]
     [:> Box 
       [:> Checkbox {
                     :icon (r/as-element [:> mui-icons/BookmarkBorder ])
                     :checkedIcon (r/as-element [:> mui-icons/Bookmark])
                     :checked acceptTnc 
                     :on-change (fn [e] 
                                  (setAcceptTnc (.. e -target -checked))
                                  )
                     }
        ]
      ]
      [:> Box
         [:> FormControl {:error false}
            [:> FormLabel
              "Skills"
             ]
             [:> FormGroup {:row true}
              [:> FormControlLabel {
                                    :label "HTML"
                                    :value "html"
                                    :control (r/as-element [:> Checkbox {:value "html"
                                                                         :checked (str/includes? skills "html")
                                                                         :on-change handleSkillChange
                                                                         } ])
                                    }               
               ]
               [:> FormControlLabel {
                                    :label "CSS"
                                    :value "css"
                                    :control (r/as-element [:> Checkbox {:value "css"
                                                                         :checked (str/includes? skills "css")
                                                                         :on-change handleSkillChange
                                                                         } ])
                                    }               
               ]
               [:> FormControlLabel {
                                    :label "Javascript"
                                    :value "javascript"
                                    :control (r/as-element [:> Checkbox {
                                                                         :value "javascript"
                                                                         :checked (str/includes? skills "javascript")
                                                                         :on-change handleSkillChange
                                                                         } 
                                                            ])
                                    }               
               ]
              ]
             [:> FormHelperText "Invalid selection"]
          ]
         
       ]
   ])
  )