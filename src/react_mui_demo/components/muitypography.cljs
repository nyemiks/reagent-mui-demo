(ns react-mui-demo.components.muitypography
  (:require 
   ; ["@mui/material" :refer [Paper Grid Typography Box Rating ThemeProvider]]
    ["@mui/material" :refer [Typography]]
   )
  )


(defn mui-typography []
  [:div 
   [:> Typography {:variant "h1"} "h1 Heading"]
    [:> Typography {:variant "h2"} "h2 Heading"]
    [:> Typography {:variant "h3"} "h3 Heading"]
    [:> Typography {:variant "h4" 
                    :component "h1"
                    :gutterBottom true
                    } "h4 Heading"]
    [:> Typography {:variant "h5"} "h5 Heading"]
    [:> Typography {:variant "h6"} "h6 Heading"]
    [:> Typography {:variant "subtitle1"} "subtitle1"]
    [:> Typography {:variant "subtitle2"} "subtitle2"]
   [:> Typography {:variant "body1"} 
    "Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis quos nulla doloremque fuga voluptatem ab cumque illum dolorem placeat, cupiditate quibusdam atque officia eveniet expedita similique, id tempore tempora magni?"]
    [:> Typography {:variant "body2"} 
     "Lorem ipsum dolor sit amet consectetur adipisicing elit. Odit nobis, veritatis, maxime error unde tempora rem doloremque commodi deserunt illum quidem iure? Dolorem repellat maiores exercitationem sit! Nam, laboriosam non!"
     ]
   ]
  )