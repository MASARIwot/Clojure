(ns mass-test)

(def arr-rand 
  (fn [n] (repeatedly n #(rand-int 10))))

(def arr-rand-2 
  (fn [n] (take n (repeatedly #(rand-int 11)))))

(def arr-rand-3 
  (fn [n] (take n (repeatedly (partial rand-int 11)))))

(def arr-rand-4 
  (fn [n] (repeatedly n (partial rand-int 11))))