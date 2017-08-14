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
  (let [helper (fn [x] (has-award? book x))]
    (every? helper awards)))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (if (> (count filtered) 0) (first (map pred filtered)) false)))

(defn my-every? [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (== (count a-seq) (count filtered))))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
     (not (some pred (range 2 n)))))
 
 ;^__^
