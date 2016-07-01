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

(defn my-some-recur [pred a-seq]
  (let [a-first (first a-seq)
        a-next (next a-seq)
        a-pred (pred a-first)]
    (cond
      a-pred a-pred
      (nil? a-next) false
      :else (my-some-recur pred a-next))))

(defn my-some [pred a-seq]
  (cond
    (empty? a-seq) false
    :else (my-some-recur pred a-seq)))

(defn my-every-recur? [pred a-seq prev]
  (let [a-first (first a-seq)
        a-next (next a-seq)
        a-pred (pred a-first)
        prev-next (and prev a-pred)]
    (cond
      (false? prev-next) false
      (nil? a-next) prev-next
      :else (my-every-recur? pred a-next prev-next))))

(defn my-every? [pred a-seq]
  (cond
    (empty? a-seq) true
    :else (my-every-recur? pred a-seq true)))

(defn prime? [n]
  (let [numbers (range 2 n)
        div? (fn [d] (== 0 (mod n d)))]
    (my-every? (complement div?) numbers)))
;^^
