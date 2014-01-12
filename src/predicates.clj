(ns predicates)

(defn sum-f [f g x]
  (+ (f x ) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [to-be-filtered] (contains? a-set to-be-filtered)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [is-nil (fn [x] (= nil x))
        all-whitespace (fn [str] (every? whitespace? string))]
    (or (is-nil string) (all-whitespace string))))

(defn has-award? [book award]
  (and (not (= nil (:awards book))) (contains? (:awards book) award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (= (count a-seq) (count (filter pred a-seq))))

(defn prime? [n]
  (let [divisor? (fn [num] (== 0 (mod n num)))]
    (not (some divisor? (range 2 n)))))
;^^
