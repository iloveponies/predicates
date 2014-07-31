(ns predicates
  (:require [clojure.set :as set]))

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (set/subset? awards (:awards book)))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)
        first-val (first filtered)]
    (cond (or (number? first-val) 
              (= filtered '(nil))) true
          (vector? first-val) (first first-val))))

(defn my-every? [pred a-seq]
  (== (count a-seq) 
      (count (filter pred a-seq))))

(defn prime? [n]
  (let [pred (fn [p] (= (type (/ n p)) java.lang.Long))]
    (not (some pred (range 2 n)))))

;^^
