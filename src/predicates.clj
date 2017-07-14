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
  (fn [n] (and (pred1 n) (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n) (pred2 n))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (== 0 (count string))
              (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (first (map pred filtered))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (= a-seq (filter pred a-seq))))

(defn divides? [divisor n]
  (if (== (mod n divisor) 0) true false))

(defn prime? [n]
  (let [pred (fn [x] (divides? x n))]
    (not (some pred (range 2 n)))))
;^^

