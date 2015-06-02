(ns test-18.05.2015)

(def m {:a 5 :g 6
        :r 20 :l 10})

(let [{k :unknown x :a} m 
      k (or k 50)]
  (+ k x))

(def chas {:name "loli" :age 35})

(let [{:keys [name age]} chas]
  (format "%s is %s years old." name age))

(def chas2 {"name" "loli" "age" "33"})

(let [{:strs [name age]} chas2])

(def chas3 {'name "loli" 'age 31})

(let [{:syms [name age]} chas])

(def user-info ["robert8990" 2011 :name "Bob" :city "Boston"])

(let [[username account-year & {:keys [name city]}] user-info]
  (format "%s is in %s" name city))

((fn [x y z] (let [x y z(or z 50)] (+ x y z))  ) 2 2 2)

((fn [x y z] (let [x y z(or z 50)] (+ x y z))  ) 2 2 nil)

(def standart-addr(fn 
                    ([x] x)
                    ([x y] (+ x y)))
  )

(standart-addr 1)

(standart-addr 2 2)

(def standart-addr(fn sameName
                    ([x] (sameName x 1))
                    ([x y] (+ x y)))
  )

(standart-addr 1)

(standart-addr 2 2)

(def m {:a 5 :g 6
        :r 20 :l 10})

(let [{k :unknown x :a} m 
      k (or k 50)]
  (+ k x))

(def chas {:name "loli" :age 35})

(let [{:keys [name age]} chas]
  (format "%s is %s years old." name age))

(def chas2 {"name" "loli" "age" "33"})

(let [{:strs [name age]} chas2])

(def chas3 {'name "loli" 'age 31})

(let [{:syms [name age]} chas])

(def user-info ["robert8990" 2011 :name "Bob" :city "Boston"])

(let [[username account-year & {:keys [name city]}] user-info]
  (format "%s is in %s" name city))

((fn [x y z] (let [x y z(or z 50)] (+ x y z))  ) 2 2 2)

((fn [x y z] (let [x y z(or z 50)] (+ x y z))  ) 2 2 nil)

(def standart-addr(fn 
                    ([x] x)
                    ([x y] (+ x y)))
  )

(standart-addr 1)

(standart-addr 2 2)

(def standart-addr(fn sameName
                    ([x] (sameName x 1))
                    ([x y] (+ x y)))
  )

(standart-addr 1)

(standart-addr 2 2)