(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

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

(defn key->predicate [a-map]
  (fn [x] (contains? a-map x)))

(defn has-award? [book award]
  (and (contains? book :awards)
       (contains? (:awards book) award)))

(defn has-award?->predicate [book]
  (fn [x] (has-award? book x)))()

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (has-award?->predicate book) awards))

(defn my-some [pred a-seq]
  (let [truth-values (filter pred a-seq)
        truth-values-pred (map pred truth-values)]
    (if (> (count truth-values) 0) (first truth-values-pred) nil)))

(defn my-every? [pred a-seq]
  (let [filt (filter pred a-seq)]
    (== (count a-seq) (count filt))))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))

