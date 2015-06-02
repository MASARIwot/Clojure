(ns Barely-Believable-Object)

(def Point 
  ;;(x (Point 21 2))
  ;;(:x (Point 21 2))
  (fn [x y] 
    {:x x
     :y y
     :_class_symbol_ 'Point-class-BBO
     }))

(def Triangle
     (fn [& point]
       {:point1 point, 
        :point2 point, 
        :point3 point
        :__class_symbol__ 'Triangle}))

(def x ;getter
  (fn [this] (get this :x)))

(def y ;getter
  (fn [this] (get this :y)))

(def valid-triangle? 
  (fn [& args] (and (= 3 (count args)) (= (distinct args) args)))

#_(valid-triangle?	 (Ex2-make Point 0 1)
                	 (Ex2-make Point 0 5) 
               		 (Ex2-make Point 3 4))
  )

(def equal-triangles? =)

(def equal-triangles-2? 
  (fn [& args] (apply = args))
#_(equal-triangles-2? (Ex2-make Triangle 
                         	(Ex2-make Point 1 2)
							(Ex2-make Point 1 3)
							(Ex2-make Point 3 1)) 
                    (Ex2-make Triangle 
                          	(Ex2-make Point 1 2)
							(Ex2-make Point 1 3)
							(Ex2-make Point 3 1))
                    (Ex2-make Triangle 
                          	(Ex2-make Point 1 2)
							(Ex2-make Point 1 3)
							(Ex2-make Point 3 5)))
  )

(def Ex2-make
  (fn [object & args]
  (apply object args)))

(def Ex1-creator
  ;;(Ex1-creator (Point 1 2)(Point 1 2))
  (fn [this other]
    (Point (+ (x this) (x other))
           (+ (y this)(y other)))))

(def Ex1-creator-shift
  ;;(Ex1-creator-shift (Point 1 2)(Point 1 2))
  (fn [this other]
    (shift this (x other)(y other))))

(def shift
	(fn [this xinc yinc]
		(Point (+ (x this) xinc)
			   (+ (y this) yinc))))