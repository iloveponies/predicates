(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== n x)))

(defn set->predicate [a-set]
  (fn [elem] (contains? a-set elem)))

(defn pred-and [pred1 pred2]
  (fn [elem] (and (pred1 elem) (pred2 elem))))

(defn pred-or [pred1 pred2]
  (fn [elem] (or (pred1 elem) (pred2 elem))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (nil? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (boolean (some #{award} (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true? (map #(has-award? book %) awards)))

(defn my-some [pred a-seq]
  (first (drop-while false? (map pred a-seq))))

(defn my-every? [pred a-seq]
  (= (count a-seq) (count (filter true? (map pred a-seq)))))

(defn prime? [n]
  (let [below (range 2 n)]
    (every? (complement zero?) (map #(mod n %) below))))
;^^

