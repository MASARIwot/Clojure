(ns Test2Boo.core) 

(defn some-tect-chp2

(def Point 
  (fn [x y] 
    {:x x
     :y y
     }))
(:x (Point 21 2))

(def x ;getter
  (fn [this] (get this :x)))
(x (Point 21 2))

(def x2 (fn [this] (:x this)))
(x2 (Point 22 2))

(def x3 :x)
(x3 (Point 25 2))

  )

(def do-something-to-map 
  ;; (do-something-to-map :a)
  ;;(do-something-to-map count)
  (fn [function] 
    (function {:a 1 :b 2  :d 3 :c 4})))

 (def do-something-with-a-colored-point
   ;; (do-something-with-a-colored-point :color "red", :x 1, :y 2)
(fn [& args]
 (apply hash-map args) ))

(re-seq #"(...) (...)" "foo bar")

  (re-seq #"(\d+)-(\d+)" "1-3")

 (def personeLoc 
   ;;(:location personeLoc)
   ;; (:user/location personeLoc
 ;;(:name personeLoc)
   				 {:name "Soso"
                  :location "Bla"
                  ::location "43-45"})

 (def person  ;;(:city person)
   			 {:name "Sandra"
              :city "Poland"})

 (def Ex8-tails3
     (fn [seq]
       (map drop
            (reverse(range (inc (count seq))))
            (repeat seq))))

(def Ex8-tails1
  ;;Ex8
     (fn [seq]
       (map drop
            (range (inc (count seq)))
            (repeat (inc (count seq)) seq))))

(def Ex8-tails2
     (fn [seq]
       ;;Ex8
       (map drop
            (range (inc (count seq)))
            (repeat seq))))

(def factorial
  (fn [n] (apply * (range 1 (inc n))) ))

(def add-squares 
    (fn [& numbers] (apply + (map * numbers numbers))))

(defn test-filter [args] 
(prn "First odd" (first (filter odd? [2 2 3 4])))
(filter odd? args )
  )

(def position (atom 1))

(def state (atom {}))

(defn update-state [key val]
  (swap! state assoc key val)
)

(defn update-position[n]  
  (repeat (- n 2) (swap! position dec))
  (swap! position dec)
)

(defn pprint-map [m]
  (println "{")
  (doall (for [[k v] m] (println k ":" v)))
  (print "}")
)

(def my-apply
(fn [function sequence]
(eval (cons function sequence)) (prn (apply function sequence) "d" ) ) )

(defn testmethod [& args]
(if (odd? 5)
   (println "Odd!")
   (prn "Evrn!")
   )

  (println "s")
)