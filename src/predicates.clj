(ns predicates)


(defn sum-f [f g x]
  (+ (f x) (g x)))



(defn less-than [n]
  (fn [x] (< x n)))



(defn equal-to [n]
  (fn [x] (== x n)))


(defn set->predicate [a-set]
  (fn [x] (if (contains? a-set x) true false)))



(defn pred-and [pred1 pred2]
  (fn [x] (if (and (pred1 x) (pred2 x)) true false)))


(defn pred-or [pred1 pred2]
  (fn [x] (if (or (pred1 x) (pred2 x)) true false)))



(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))




(defn has-award? [book award]
  (if (contains? (:awards book) award) true false))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))


(defn my-some [pred a-seq]
  (let [value (filterv pred a-seq)]
    (if (> (count value) 0) (pred (first value)) false)))



(defn my-every? [pred a-seq]
  (let [all-items (count a-seq)
        value (filterv pred a-seq)
        count-value (count value)]
    (if (== all-items count-value) true false)))

(defn prime? [n]
  (let [pred (fn [x] (if (> (mod n x) 0) false true))]
    (not (some pred (range 2 n)))))

;^^
