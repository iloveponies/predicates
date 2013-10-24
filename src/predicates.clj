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
  (fn [x] (if (and (pred1 x) (pred2 x))
               true
               false)))

(defn pred-or [pred1 pred2]
  (fn [x] (if (or (pred1 x) (pred2 x))
               true
               false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [pass-award (fn [x] (has-award? book x))]
    (every? pass-award awards)))

(defn my-some [pred a-seq]
  (if (not= (count (filter pred a-seq)) 0)
    (pred (first (filter pred a-seq)))
    false))

(defn my-every? [pred a-seq]
  (if (empty? (filter (complement pred) a-seq))
    true
    false))

(defn prime? [n]
  (let [pred (fn [x] (if (integer? (/ n x))
                       true
                       false))]
    (not (some pred (range 2 n)))))
;^^
