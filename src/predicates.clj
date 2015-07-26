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
    (every? whitespace? string)
    (or
      (nil? string)
      (= "" string))))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards)) ;; currying <3

(defn my-some [pred a-seq]
  (if (empty? a-seq)
    false
    (or
      (pred (first a-seq))
      (my-some pred (drop 1 a-seq)))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (and
      (pred (first a-seq))
      (my-every? pred (drop 1 a-seq)))))

(defn divisible? [x y]
  (= (mod x y) 0))

(defn prime? [n]
  (not-any? (partial divisible? n) (range 2 n)))
;^^
