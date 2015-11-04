(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
)


(defn less-than [n]
  (fn [x] (< x n))
)

(defn equal-to [n]
  (fn [x] (== x n))
)


(defn set->predicate [a-set]
  (fn [x] (contains? a-set x))
)

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x)) )
)

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x)) )
)


(defn whitespace? [character]
  (Character/isWhitespace character)
)

(defn blank? [string]
  (every? whitespace? string)
)

(defn has-award? [book award]
  ((set->predicate (:awards book)) award)
)

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [ book-has-awards (fn [x] (has-award? book x))]
    (every? book-has-awards awards)
  )
)

(defn my-some [pred a-seq]
    (cond
       (empty? a-seq) false
       (pred (first a-seq)) (pred (first a-seq))
       :else (my-some pred (rest a-seq))
    )
)


(defn my-every? [pred a-seq]
    (cond
       (empty? a-seq) true
       (not (pred (first a-seq))) false
       :else (recur pred (rest a-seq))
    )
)



(defn prime? [n]
  (let [divisor  (fn [x] (= 0 (mod n x))) ]
    (not (some divisor (range 2 n))))
)












