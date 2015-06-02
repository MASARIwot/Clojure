(ns Test-loop)

(loop [x 5]
  (if (neg? x)
    x
    (recur (dec x))))

(defn counter 
  [x]
  (if (zero? x)
    :END!)
  (do (prn x) (recur (dec x))))

(counter 15)

(loop [x 5]
  (if (neg? x)
    x
    (recur (dec x))))

(defn counter 
  [x]
  (if (zero? x)
    :END!)
  (do (prn x) (recur (dec x))))

(counter 15)

(loop [x 5]
  (if (neg? x)
    x
    (recur (dec x))))

(defn counter 
  [x]
  (if (zero? x)
    :END!)
  (do (prn x) (recur (dec x))))

(counter 15)

(loop [x 5]
  (if (neg? x)
    x
    (recur (dec x))))

(defn counter 
  [x]
  (if (zero? x)
    :END!)
  (do (prn x) (recur (dec x))))

(counter 15)