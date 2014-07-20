(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (> n k)))

(defn equal-to [n]
  (fn [k] (== n k)))

(defn set->predicate [a-set]
  "This function returns a predicate based on the supplied set, a-set."
  (fn [x]
    (if (contains? a-set x)
      true
      false)))

(defn pred-and [pred1 pred2]
  :-)

(defn pred-or [pred1 pred2]
  :-)

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
