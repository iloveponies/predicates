(ns predicates)

(defn sum-f [f g x]
  (+ (g x) (f x)))

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
 (or (every? whitespace? string) (== (count string) 0) (nil? string)))

(defn my-has [book]
  (fn [award] ((set->predicate (:awards book)) award)))

(defn has-award? [book award]
  ((my-has book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (my-has book) awards))

(defn my-some [pred a-seq]
  (first (filter (complement false?) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (== (count (filter (complement false?) (map pred a-seq))) (count a-seq)))

(defn prime? [n]
  (let [divisible? (fn [x] (== 0 (mod n x)))]
    (not (some divisible? (range 2 n)))))




