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
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [some-has-pred (first (filter (fn [y] (if y true false)) (map pred a-seq)))]
  (if some-has-pred some-has-pred false)))

(defn my-every? [pred a-seq]
  (= a-seq (filter pred a-seq)))

(defn prime? [n]
  (let [divisable? (fn [x] (== 0 (mod n x)))]
    (not (some divisable? (range 2 n)))))
;^^
