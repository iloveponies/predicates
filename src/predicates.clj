(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x]
    (< x n)))

(defn equal-to [n]
  (fn [x]
    (== x n)))

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
  ((pred-or
    (fn [x] (every? whitespace? x))
    (pred-or empty? nil?))
   string))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq]
  (=
   (count a-seq)
   (count (filter pred a-seq))))

(defn prime? [n]
  (empty? (filter (fn [x] (= 0 (mod n x))) (range 2 (- n 1)))))
;^^
