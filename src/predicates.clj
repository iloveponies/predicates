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
  (fn [k] (if (and (pred1 k) (pred2 k))
    true
    false)))

(defn pred-or [pred1 pred2]
  (fn [k] (if (or (pred1 k) (pred2 k))
    true
    false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (or (every? whitespace? string)
          (nil? string)
          (== (count string) 0))
    true
    false))

(defn has-award? [book award]
  (> (count (:awards book)) 0))

(defn HAS-ALL-THE-AWARDS? [book awards]
  :-)

(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
