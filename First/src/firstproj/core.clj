(ns firstproj.core)

;position of current operation,counter,iterator
(def position (atom 1))

;map. save last three operation in type: 
;key(number of operation) 
;value (result)
(def state (atom {}))

;print collection
(defn pprint-map [m]
  (println "{")
  (doall (for [[k v] m] (println k ":" v)))
  (print "}")
)

;add operation in collection
(defn update-state [key val]
  (swap! state assoc key val)
)

;update counter of operation- return iterator on basic position
(defn update-position[n]  
  (repeat (- n 2) (swap! position dec))
  (swap! position dec)
)

;observer (counter) of operation
(defn imba
  "x - function to memoize,
   y - number of last calls to cache"
  [x y]
 (println "Last three operation,last result on position :" (deref position))
 ;add operation
 (update-state (deref position) x)
 ;print result
 (pprint-map (deref state))
 ;check current number of operation to save
 ;if position more than given -> update counter (return basic position of iterator) 
 (if (== (deref position) y)(
                            (update-position y)
     ) 
 )
 ;increment iterator
 (swap! position inc)
 )
;main method
(defn adder [x] (future  (imba (apply + x) 3) ) )
;(adder [1 1])
;(adder [1 2])
;(adder [1 3])
;result:
; Last three operation,last result on position : 3
; {
;  3 : 4
;  2 : 3
;  1 : 2
; }
;(adder [1 10])
;(adder [1 100])
;result:
; Last three operation,last result on position : 2
;	{
;	 3 : 4
;	 2 : 101
;	 1 : 11
; }

