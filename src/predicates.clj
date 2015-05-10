(ns predicates
  (:use midje.sweet))

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (if (empty? a-seq)
    (symbol "falsey")
    (first (filter #(and true %1) (map pred a-seq)))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (if (nil? (some (complement pred) a-seq))
      true
      false)))

(defn prime? [n]
  (let [pred #(if (== 0 (mod n %1)) true false)]
    (not (some pred (range 2 n)))))
;^^
