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
  (let [predicate (fn [x] (has-award? book x))]
  (every? predicate awards)))

(defn my-some [pred a-seq]
  (let [truthy (fn [x] (boolean x))]
   (first (filter truthy (map pred a-seq)))))

(defn my-every? [pred a-seq]
  (let [size (count a-seq)
        filtered-size (count (filter pred a-seq))]
    (= size filtered-size)))

(defn prime? [n]
  (let [a-divisor? (fn [x] (= (mod n x) 0))]
    (not (some a-divisor? (range 2 n)))))
;^^
