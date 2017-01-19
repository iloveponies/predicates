(ns predicates)

(defn apply-1 [f x]
  (f x))

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k-map] (contains? a-set k-map)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? (seq string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (cond
    (empty? a-seq) false
    (nil? a-seq) false
    (pred (first a-seq)) (pred (first a-seq))
    (< 1 (count a-seq)) (my-some pred (rest a-seq))
    :else false))

(defn my-every? [pred a-seq]
  (cond
    (empty? a-seq) true
    (nil? a-seq) true
    (not (pred (first a-seq))) false
    (< 1 (count a-seq)) (my-every? pred (rest a-seq))
    :else true))

(defn prime? [n]
  (my-every? (fn [x] (not= 0 (mod n x))) (range 2 n)))
