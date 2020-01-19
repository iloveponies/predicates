(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [v] (< v n)))

(defn equal-to [n]
  (fn [v] (== v n)))

(defn set->predicate [a-set]
  (fn [v] (contains? a-set v)))

(defn pred-and [pred1 pred2]
  (fn [v] (and (pred1 v) (pred2 v))))

(defn pred-or [pred1 pred2]
  (fn [v] (or (pred1 v) (pred2 v))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  ((set->predicate (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [divisor? (fn [potential-divisor] (== (mod n potential-divisor) 0))
        ; n/2 optimization
        potential-divisors (range 2 (+ (/ n 2) 1))]
    (not (some divisor? potential-divisors))))

;^^
