(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [a-value] (contains? a-set a-value)))

(defn pred-and [pred1 pred2]
  (fn [a-value]
    (and (pred1 a-value) (pred2 a-value))))

(defn pred-or [pred1 pred2]
  (fn [a-value]
    (or (pred1 a-value) (pred2 a-value))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (boolean (:awards book)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (clojure.set/subset? awards (:awards book)))

(defn my-some [pred a-seq]
  (first (filter (fn [x] (boolean x)) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (fn [x] (boolean x)) (map (complement pred) a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
