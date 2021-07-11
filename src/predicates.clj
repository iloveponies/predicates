(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [m] (< m n)))

(defn equal-to [n]
  (fn [m] (== m n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)
               (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)
              (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [a-set (:awards book)]
    (contains? a-set award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [a-set (:awards book)]
    (every? (fn [award] (contains? a-set award)) awards)))

(defn my-some [pred a-seq]
  (first (filter (fn [x] x) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (apply = (map pred a-seq))))

(defn prime? [n]
  (every? (fn [x] (not= 0 (mod n x))) (range 2 n)))
;^^
