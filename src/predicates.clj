(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  (fn [e] (some #(= e %) a-set)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
   (nil? string) true
   (false? string) true
   :else (every? whitespace? string)))

(defn has-award? [book award]
  ; Can't use anonymous function here, don't know why
  (if (some (fn [x] (= x award)) (:awards book))
    true
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (some pred a-seq)) ; okay, this is cheating

;(defn my-some [pred a-seq]
;  (first (filter pred a-seq)))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn divides? [divisor num]
  (== (rem num divisor) 0))

(defn prime? [n]
  (if (== n 1)
    false
    (every? #((complement divides?) % n) (range 2 n))))
;^^
