(ns firstproj.core)

(def position (atom 1))
(def state (atom {}))

(defn pprint-map [m]
  (println "{")
  (doall (for [[k v] m] (println k ":" v)))
  (print "}")
)

(defn update-state [key val]
  (swap! state assoc key val)
)

(def update-position
  (fn [y]
  (swap! position dec)
  (if (== (deref position) 1) true (recur 1)))
  )

(defn imba
  "x - function to memoize,
   y - number of last calls to cache"
  [x comand y]
 (future (update-state (deref position) (apply comand x))
 (if (== (deref position) y)
   ((update-position y))
 (swap! position inc))
 ))

(defn adder [x]  (imba x + 3)  )

(adder [1 1])
(adder [1 1])
(adder [1 1])
(adder [1 6])
(adder [1 6 2])
(adder [1 6 1])
(adder [1 1])
(adder [1 1])
(adder [1 1])

(prn (pprint-map (deref state)))
