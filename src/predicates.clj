(ns predicates)

(defn sum-f [f g x]
  (+ (f x)(g x)))


(defn less-than [n]
  (fn [k] (> n k)))


(defn equal-to [n]
  (fn [x] (== n x)))


(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)(pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)(pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
 (every? whitespace? string))


(defn has-award? [book award]
  (let [awarde (get book :awards)]
    (contains? awarde award )))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awarde (get book :awards)]
    (every? awarde awards)))


(defn my-some [pred a-seq]
 (let [mapd (mapv pred a-seq)]
   (first(set(filter (complement nil?) mapd)))))

;(my-some even? [1 3 5 7])
  ;(my-some even? [1 3 5 7 8])
  ;(my-some neg? [1 3 5 0 7 8])
  ;(my-some neg? [1 3 5 0 7 -1 8])
   ;(my-some neg? [])
  ;(my-some first [[false] [1]])
  ;(my-some first [[false] []])
  ;(my-some nil? [1 2])
  ;(my-some nil? [1 nil 2])



  (defn my-every? [pred a-seq]
  (let [mapd (mapv pred a-seq)
    doublefilteredcoffee (set(filter false? mapd))]
    (if(contains? doublefilteredcoffee false)false true)))

 ;(my-every? pos? [1 2 3 4])   ;=> true
;(my-every? pos? [1 2 3 4 0]) ;=> false
;(my-every? even? [2 4 6])    ;=> true
;(my-every? even? [])         ;=> true

  (defn prime? [n]
  (let[ pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n))))
    )

;(filter prime? (range 15))

;^^
