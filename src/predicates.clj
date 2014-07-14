(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x]
    (< x n)))

(defn equal-to [n]
  (fn [x]
    (== x n)))

(defn set->predicate [a-set]
  (fn [x]
    (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x)
         (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x)
         (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (if-let [awards (:awards book)]
    (contains? awards award)
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (loop [s a-seq]
    (if (not-empty s)
      (if-let [v (pred (first s))]
        v
        (recur (rest s)))
      nil)))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (= nil (some (complement pred) a-seq))))

(defn prime? [n]
  (let [pred #(= 0 (mod n %))]
    (not (some pred (range 2 n)))))



