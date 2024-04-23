(ns react-mui-demo.components.muicard
   (:require 
    ["@mui/material" :refer 
     [Box Card CardContent Typography CardActions Button CardMedia]
     ]
    )  
  )


(defn mui-card []
  [:> Box {
            :width "300px"
           }
   [:> Card
     [:> CardMedia {
                    :component "img"
                    :height "140"
                    :image "https://source.unsplash.com/random"
                    :alt "unsplash image"
                    }
      ]
     [:> CardContent
       [:> Typography {
                        :gutterBottom true
                        :variant "h5"
                        :component "div"
                       }
         "React"
        ]
        [:> Typography {
                        :variant "body2"
                        :color "text.secondary"
                        }
         "React is a Javascript library for building user interfaces. React 
                  can be used as a base in the development of single-page or mobile applications.
            "
         ]
        [:> CardActions
         [:> Button {
                     :size "small"
                     } 
            "Share"
          ]
         [:> Button {
                     :size "small"
                     } 
            "Learn More"
          ]
         ]
      ]
    ]
   ]
  )