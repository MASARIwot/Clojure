(ns Recursion)

(def Non
{
  :__own_symbol__ 'Non

 })

(def Anything
{
  :__own_symbol__ 'Anything
  :__superclass_symbol__ 'Non   ;; <<= New

 })

(def Point
{
  :__own_symbol__ 'Point
  :__superclass_symbol__ 'Anything   ;; <<= New

 })

(def RedPoint
{
  :__own_symbol__ 'RedPoint
  :__superclass_symbol__ 'Point   ;; <<= New

 })

(def class-symbol-above 
  (fn [class-symbol] (eval (:__superclass_symbol__ class-symbol))))

(def class-symbol-above-2 
  (fn [class-symbol]  (:__superclass_symbol__ (eval class-symbol))))

(def recursive-function
        (fn [class-symbol]
        	(if (nil? class-symbol)
        	nil
        	(cons class-symbol
        	(recursive-function  (class-symbol-above class-symbol))))))

(def lineage
		(fn [class-symbol so-far]
			(if (nil? class-symbol)
			so-far
			;VVVVV next line
			(recur (class-symbol-above class-symbol)
			(cons class-symbol so-far)))))

(def factorial-ex1 
  (fn [n]
    (if (or (= n 0) 
      		(= n 1))
      1
      (* n (factorial (dec n))))))

(def factorial-ex2
  (fn [n so-far]
  	(if (or (= n 0)
            (= n 1))
      so-far
  (factorial-ex2 (dec n) (* n so-far))))) 

(def factorial-ex3
  (fn [operation n so-far]
    (if (empty? n)
	so-far
    (factorial-ex3 operation (rest n) (operation (first n) so-far)))))

(defn factorial-ex3-2 [x]
  ((fn [x y]
    (if (or (= x 0) (= x 1))
        y
        (recur (- x 1) (* x y)))) x 1))

(defn factorial-ex3-3 [operation n]
  ((fn [operation n so-far]
    (if (empty? n)
	so-far
    (recur operation (rest n) (operation (first n) so-far))))operation n 1))

(prn (factorial-ex3-3 + [1 2 3 4]))

(prn (factorial-ex3-2 6))

(prn "+" (factorial-ex3 + [1 2 3 4] 1) )

(prn "-" (factorial-ex3 - [1 2 3 4] 1) )

(prn "*" (factorial-ex3 * [1 2 3 4] 1) )

 (reduce (fn [so-far val] (assoc so-far val 0))
{}
[:a :b :c])

  (reduce (fn [so-far val] (assoc so-far val (count so-far)))
{}
[:a :b :c])

(prn (factorial-ex3 (fn [elt so-far]
                           (assoc so-far elt 0))
                         [:a :b :c]
                         {}))

(prn (factorial-ex3 (fn [elt so-far]
                           (assoc so-far elt (count so-far)))
                         [:a :b :c]
                         {}))

(def add 
  (fn [a] 
    (fn [b] (+ a b))))

(def add2 (add 2))

(add2 3)

(def func 
  (fn [vector] (map inc vector)))

 (func [0 1 2 3])