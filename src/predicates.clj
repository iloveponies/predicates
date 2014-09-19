(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [n2] (< n2 n)))

(defn equal-to [n]
  (fn [x] (== x n)))


(defn set->predicate [a-set]
  (fn [it] (contains? a-set it)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])  ;=> [1 2 6 7 -3]
(filter (pred-or pos? even?) [1 2 -4 0 6 7 -3]) ;=> [1 2 -4 0 6 7]

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (filter (fn [x] x) (map pred a-seq))))
(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))


(defn prime? [n]
  (let [divisor (fn [x] (= 0 (mod n x)))]
    (not (some divisor (range 2 n)))))

