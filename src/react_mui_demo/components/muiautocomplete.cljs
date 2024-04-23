(ns react-mui-demo.components.muiautocomplete
  (:require 
   ["react" :as react]
   [reagent.core :as r]
   ["@mui/material" :refer [Stack Autocomplete TextField ]]
   [reagent.impl.template :as rtpl]
   )
  )

(def skills ["HTML" "CSS" "JavaScript" "Typescript" "React"])
(def skills2 ["Vue" "Angular" "Struts" "Jsf"])


(def skillOptions (into [] (map-indexed (fn [idx item]
                           {
                            :id idx
                            :label item
                            }
                          )
                        skills2))
  )

; custom logic copied from reagent 1.2.0 example code 
; might be needed in the future 20240419
; #####################

  (def ^:private input-component
  (react/forwardRef
    (fn [props ref]
      (r/as-element
        [:input (-> (js->clj props :keywordize-keys true)
                    (assoc :ref ref))]))))

(def ^:private textarea-component
  (react/forwardRef
    (fn [props ref]
      (r/as-element
        [:textarea (-> (js->clj props :keywordize-keys true)
                       (assoc :ref ref))]))))

;; To fix cursor jumping when controlled input value is changed,
;; use wrapper input element created by Reagent instead of
;; letting Material-UI to create input element directly using React.
;; Create-element + convert-props-value is the same as what adapt-react-class does.
(defn text-field [props & children]
  (let [props (-> props
                  (assoc-in [:InputProps :inputComponent] (cond
                                                            (and (:multiline props) (:rows props) (not (:maxRows props)))
                                                            textarea-component

                                                            ;; FIXME: Autosize multiline field is broken.
                                                            (:multiline props)
                                                            nil

                                                            ;; Select doesn't require cursor fix so default can be used.
                                                            (:select props)
                                                            nil

                                                            :else
                                                            input-component))
                  ;; FIXME: Internal fn should not be used
                  ;; clj->js is not enough as prop on-change -> onChange, class -> classNames etc should be handled
                  rtpl/convert-prop-value)]
    (apply r/create-element TextField props (map r/as-element children))))

; ##########################

(defn mui-autocomplete []
  (
   let 
   [
     [value setValue] (react/useState nil)
     [skill setSkill] (react/useState nil)
   ]
   (.info js/console "value: " value)
   (.info js/console "skill: " skill)
   [:> Stack {
              :spacing 2
              :width "250px"
              }
    [:> Autocomplete {
                      :options skills
                      :freeSolo true
                      :render-input (fn [^js params]
                                     ;; Don't call js->clj because that would recursively
                                     ;; convert all JS objects (e.g. React ref objects)
                                     ;; to Cljs maps, which breaks them, even when converted back to JS.
                                     ;; Best thing is to use r/create-element and
                                     ;; pass the JS params to it.
                                     ;; If necessary, use JS interop to modify params.
                                    ; (set! (.-variant params) "outlined")
                                      (set! (.-label params) "Skills")
                                    
                                      (r/create-element TextField params)) 
                      :value value
                      :on-change (fn [evt, newValue]
                                   (setValue newValue)
                                   )
                      }
     ]
     [:> Autocomplete {
                      :options skillOptions
                      :freeSolo false
                      :render-input (fn [^js params]
                                     ;; Don't call js->clj because that would recursively
                                     ;; convert all JS objects (e.g. React ref objects)
                                     ;; to Cljs maps, which breaks them, even when converted back to JS.
                                     ;; Best thing is to use r/create-element and
                                     ;; pass the JS params to it.
                                     ;; If necessary, use JS interop to modify params.
                                    ; (set! (.-variant params) "outlined")
                                      (set! (.-label params) "Skills")
                                    
                                      (r/create-element TextField params)) 
                      :value skill
                      :on-change (fn [evt, newValue]
                                   (setSkill newValue)
                                   )
                       :isOptionEqualToValue (fn [option value]
                                               ;(.info js/console "option: " option " value: " value)
                                                (if (= (:id option) (:id value))
                                                  true
                                                  false
                                                  )
                                               )
                      }
     ]
    ])
  )