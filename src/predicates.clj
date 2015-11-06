(ns predicates
  (:use clojure.repl))

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [a-val] (contains? a-set a-val)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
    (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [an-award] (has-award? book an-award)) awards))

(defn my-some [pred a-seq]
  (first (filter (complement false?) (map pred a-seq))))

(defn my-every? [pred a-seq]
 (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [n-range (range 1 n)
        composite? (fn [x] (= 0 (mod n x)))]
  (every? (complement composite?) (range 2 n))))
