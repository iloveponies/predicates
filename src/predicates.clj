(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [item]
    (contains? a-set item)))

(defn pred-and [pred1 pred2]
  (fn [arg]
    (and (pred1 arg) (pred2 arg))))

(defn pred-or [pred1 pred2]
  (fn [arg]
    (or (pred1 arg) (pred2 arg))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [divides? (fn [divisor]
                  (= 0 (mod n divisor)))]
    (not (some divides? (range 2 n)))))
;^^
