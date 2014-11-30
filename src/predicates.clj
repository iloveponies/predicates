(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
  )

(defn less-than [n]
  (fn [k] (< k n))
  )

(defn equal-to [n]
  (fn [k] (== k n))
  )

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x))
  )

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x)))
  )

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x)))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
   (= string nil) true
   (every? whitespace? string) true
   :else false
  )
 )

(defn has-award? [book award]
  (let [awards (:awards book)]
   (contains? awards award)
  )
 )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award?
    (fn [x]
      (has-award? book x))]
   (every? book-has-award? awards))
  )

(defn my-some [pred a-seq]
 (let [first (first (filter (complement false?) (map pred a-seq)))]
   (if (= first nil)
     false
     first
     )
   )
 )


(defn my-every? [pred a-seq]
  (if (==
       (count a-seq)
       (count (filter true? (map pred a-seq))))
    true
    false)
  )

(defn prime? [n]
  (let [even-div?
        (fn [x] (integer? (/ n x)))]
    (not (some even-div? (range 2 n))))
  )
;^^
