(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [val] (contains? a-set val)))

(defn pred-and [pred1 pred2]
  (fn [val]
    (and
      (pred1 val)
      (pred2 val))))

(defn pred-or [pred1 pred2]
  (fn [val]
    (or
      (pred1 val)
      (pred2 val))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  ((set->predicate (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (cond
    (empty? a-seq) false
    (not (pred (first a-seq))) (my-some pred (rest a-seq))
    :else (pred (first a-seq))
    ))

(defn my-every? [pred a-seq]
  (cond
    (empty? a-seq) true
    (pred (first a-seq)) (my-every? pred (rest a-seq))
    :else false))

(defn prime? [n]
  (let [pred (fn [val] (= 0 (mod n val)))]
    (not (some pred (range 2 n)))))
;^^
