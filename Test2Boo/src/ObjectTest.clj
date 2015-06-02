(ns ObjectTest)

(def shift
  (fn [this xinc yinc] 
    (this (+(x this) xinc)
          (+(y this) yinc))))

(def shift
  ;;(shift (Point 2 200) -1 -100)
(fn [this xinc yinc]
(Point (+ (x this) xinc)
(+ (y this) yinc))))

(def Point 
  ;;(x (Point 21 2))
  ;;(:x (Point 21 2))
  (fn [x y] 
    {:x x
     :y y
     :_class_symbol_ 'Point-class
     }))

(def class-of-3 (fn [this] (get this :_class_symbol_)))

(def class-of-2 (fn [this] (:_class_symbol_ this)))

(def class-of :_class_symbol_)

(def x ;getter
  (fn [this] (get this :x)))

(def x2 (fn [this] (:x this)))

(def x3 :x)