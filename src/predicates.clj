(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x]
    (cond
      (or (nil? x) (false? x)) true
      (a-set x) true
      :else false)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (if (and (pred1 x) (pred2 x)) true false)))

(defn pred-or [pred1 pred2]
  (fn [x]
    (if (or (pred1 x) (pred2 x)) true false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  :-)

(defn has-award? [book award]
  :-)

(defn HAS-ALL-THE-AWARDS? [book awards]
  :-)

(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^

