(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
    (empty? string)
    (nil? string)
    (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [one (fn [x] (contains? (:awards book) x))]
    (every? one awards)))

(defn my-some [pred a-seq]
  (let [untrue (fn [x] ((complement =) false x))]
    (let [[result] (filter untrue (map pred a-seq))]
      (if (boolean result) result false))))

(defn my-every? [pred a-seq]
  (let [untruthy (fn [x] (= false x))]
    (let [result (filter untruthy (map pred a-seq))]
      (if (empty? result) true false))))

(defn prime? [n]
  (let [divisible? (fn [x] (== (mod n x) 0))]
    (let [pred (fn [y] (divisible? y))]
      (not (some pred (range 2 n))))))
;^^
