(ns predicates)
;(require 'clojure.set)

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
  (fn [x] (contains? a-set x ))
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
  (every? whitespace? string)
)

(defn has-award? [book award]
  ((set->predicate (:awards book)) award)
)

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award) ) awards)
)

(defn my-some [pred a-seq]
  (first (filter (fn [x] (not (false? x))) (map (fn [x] (pred x)) a-seq)))
)

(defn my-every? [pred a-seq]
   (every? pred a-seq)
)

(defn prime? [n]
  (let [divisible? (fn [x] (= (int (/ n x)) (/ n x)))
        tope (- n 1)]
    (not (some divisible? (range 2 n)))
  )
)
;^^
