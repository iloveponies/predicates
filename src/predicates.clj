(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (if (and (pred1 x) (pred2 x)) true false)))

(defn pred-or [pred1 pred2]
  (fn [x] (if (pred1 x) true (pred2 x) )))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? (fn [x] (Character/isWhitespace x)) string))

(defn has-award? [book award]
  (let [awards (get book :awards)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards ))

(defn my-some [pred a-seq]
  (if (> (count(filter (fn [x] (pred x)) a-seq)) 0) true false))

(defn my-every? [pred a-seq]
  (if (= (count(filter (fn [x] (pred x)) a-seq)) (count a-seq) ) true false))

(defn prime? [n]
  (= (count(filter (fn [x] (= (mod n x) 0)) (range 2 n))) 0))
;^^
