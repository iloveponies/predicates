(ns predicates)

(defn app [y x]
  (y x))

(defn sum-f [f g x] (+ (app f x) (app g x)))


(defn less-than [n] (fn [k] (< k n)))


(defn equal-to [n] (fn [k] (== k n)))


(defn set->predicate [a-set]
  :-)

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
