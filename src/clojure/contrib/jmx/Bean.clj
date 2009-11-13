(in-ns 'clojure.contrib.jmx)
(import '[javax.management DynamicMBean MBeanInfo AttributeList])

; TODO: rest of the arguments, as needed
(defn generate-mbean-info [reference]
  (MBeanInfo. "clojure.contrib.jmx.Bean"                          ; class name
              "Clojure Dynamic MBean"                             ; description
              (map->attribute-infos @reference)                   ; attributes
              nil                                                 ; constructors
              nil                                                 ; operations
              nil))                                               ; notifications                                          

(deftype Bean [reference] [javax.management.DynamicMBean]
  (.getMBeanInfo
   []
   (generate-mbean-info reference))
  (.getAttribute
   [attr]
   (@reference (keyword attr)))
  (.getAttributes
   [attrs]
   (let [result (AttributeList.)]
     (doseq [attr attrs]
       (.add result (.getAttribute this attr)))
     result)))

