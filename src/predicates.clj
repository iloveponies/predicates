(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [arg] (< arg n)))

(defn equal-to [n]
  (fn [arg] (== arg n)))

(defn set->predicate [a-set]
  (fn [x] (= x (a-set x))))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (set (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn[award](has-award? book award)) awards))

(defn my-some [pred a-seq]
  (not (empty? (filter pred a-seq)))) ;Todo: Not the solution.

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^

