(ns react-mui-demo.components.muiaccordion
   (:require   
      ["react" :as react]
      [reagent.core :as r]
      ["@mui/material" :refer 
       [Typography Accordion AccordionSummary AccordionDetails]]
      ["@mui/icons-material" :as mui-icons]      
    )     
  )


(defn mui-accordion []
  (let 
    [
      [expanded setExpanded] (react/useState false)
      handleChange           (fn [isExpanded panel]
                               (.info js/console " -- handle change -- ")
                               (.info js/console " isExpanded: " isExpanded " panel: " panel)
                               (setExpanded (if (= isExpanded true)
                                              panel                                              
                                              false 
                                              )
                                            )
                               )
    ]
    (.info js/console " expanded: " expanded)
   [:div 
   [:> Accordion {
                  :expanded (if (= expanded "panel1") 
                              true 
                              false
                              )
                  :on-change (fn [event isExpanded]
                               (handleChange isExpanded "panel1")
                               )
                  }
    [:> AccordionSummary {
                  :id "panel1-header"
                  :aria-controls "panel1-content"
                  :expandIcon (r/as-element [:> mui-icons/ExpandMore])
                  }
      [:> Typography "Accordion 1"]
     ]
    [:> AccordionDetails
     [:> Typography 
      "Lorem ipsum dolor sit amet consectetur adipisicing elit.
        Sapiente nisi accusamus nam qui natus, explicabo quisquam minus. 
       Vel, omnis cupiditate ut, ea, fugiat enim placeat eos quae facilis molestias dignissimos?
               "
      ]
     ]
    ]
   
    [:> Accordion {
                  :expanded (if (= expanded "panel2") 
                              true 
                              false
                              )
                  :on-change (fn [event isExpanded]
                               (handleChange isExpanded "panel2")
                               )
                  }
    [:> AccordionSummary {
                  :id "panel2-header"
                  :aria-controls "panel2-content"
                  :expandIcon (r/as-element [:> mui-icons/ExpandMore])
                  }
      [:> Typography "Accordion 2"]
     ]
    [:> AccordionDetails
     [:> Typography 
      "Lorem ipsum dolor sit amet consectetur adipisicing elit.
        Sapiente nisi accusamus nam qui natus, explicabo quisquam minus. 
       Vel, omnis cupiditate ut, ea, fugiat enim placeat eos quae facilis molestias dignissimos?
               "
      ]
     ]
    ]

    [:> Accordion {
                  :expanded (if (= expanded "panel3") 
                              true 
                              false
                              )
                  :on-change (fn [event isExpanded]
                               (handleChange isExpanded "panel3")
                               )
                  }
    [:> AccordionSummary {
                  :id "panel3-header"
                  :aria-controls "panel3-content"
                  :expandIcon (r/as-element [:> mui-icons/ExpandMore])
                  }
      [:> Typography "Accordion 3"]
     ]
    [:> AccordionDetails
     [:> Typography 
      "Lorem ipsum dolor sit amet consectetur adipisicing elit.
        Sapiente nisi accusamus nam qui natus, explicabo quisquam minus. 
       Vel, omnis cupiditate ut, ea, fugiat enim placeat eos quae facilis molestias dignissimos?
               "
      ]
     ]
    ]
   ]
   )
  )