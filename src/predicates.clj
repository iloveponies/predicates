(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x]
    (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and
      (pred1 x)
      (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or
      (pred1 x)
      (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
    (every? whitespace? string)
    (empty? string)
    (= nil string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awarded?
        (fn [award]
          (has-award? book award))]
  (every? awarded? awards)))

(defn my-some [pred a-seq]
  (let [self (fn [x] x)]
    (first (filter self (map pred a-seq)))))

(defn my-every? [pred a-seq]
  (=
    (count a-seq)
    (count (filter pred a-seq))))

(defn prime? [n]
  (let [divides? (fn [x] (= 0 (rem n x)))
        sqrt     (int (Math/sqrt n))]
    (not (some divides? (range 2 (inc sqrt))))))
;^^
