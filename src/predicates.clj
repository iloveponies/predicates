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
  (if (contains? book :awards)
    ((has-award-1? book) award)
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award? (fn [x] (has-award? book x))]
    (every? award? awards)))

(defn check-some [pred]
  (fn [v] (pred v)))

(defn my-some [pred a-seq]
  (let [truthy? (fn [x] x)]
    (first (filter truthy? (map pred a-seq)))))

;;  (first (filter true? (map (check-some pred) a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
