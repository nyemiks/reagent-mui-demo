(ns react-mui-demo.components.muiselect
  (:require 
    [clojure.string :as str]
    ["react" :as react]
    ["@mui/material" :refer [MenuItem TextField Box]]
     )
  )

;(array 1 2 3)

(defn mui-select []
  (let 
   [
      [country setCountry] (react/useState "")
      [countries setCountries] (react/useState [])
    ]
      ; (.info js/console "selected country: " country)
        (.info js/console "selected countries: " countries)
                            
    [:> Box {:width "250px"}
    [:> TextField {
                   :label "Select country"
                   :select true
                   :value countries
                   :on-change (fn [e]
                               (let [value (.. e -target -value)]
                                 (.info js/console "evt target value: " value)
                                 (.info js/console "are u js array ? " (array? value))
                                
                                 ; (setCountry (.. e -target -value))  ; single select
                                
                                 ;(if (array? value)
                                  ;  (setCountries  (str/split value #","))
                                  ;  (setCountries value)
                                  ;  )
                                    (setCountries value)
                                 )
                                ) 
                   :fullWidth true
                   :SelectProps {:multiple true}  ;   for multiple selection of menu items
                   :size "small"
                   :color "secondary"
                   :helperText "Please select your country"
                 ;  :error true
                   }
     [:> MenuItem {:value "IN"} "India"]
     [:> MenuItem {:value "US"} "Usa"]
     [:> MenuItem {:value "AU"} "Australia"]
     ]   
     ]
    )
  )