(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== n x)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(filter (pred-and pos? even?) [1 2 -4 0 6 7 -3])

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (not string)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards))

(defn my-some [pred a-seq]
  (if (empty? a-seq)
    false
    (let [item (pred (first a-seq))]
      (if item
        item
        (my-some pred (rest a-seq))))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred #(== 0 (mod n %))]
    (not (some pred (range 2 n)))))


;^^
