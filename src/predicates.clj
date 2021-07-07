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

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [award] (has-award? book award))]
    (every? book-has-award? awards)))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (=
    (count a-seq)
    (count (filter true? (map pred a-seq)))))

(defn prime? [n]
  (let [n-divides? (fn [divisor] (zero? (mod n divisor)))]
    (nil? (some n-divides? (range 2 n)))))
;^^
