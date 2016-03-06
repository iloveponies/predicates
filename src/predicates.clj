(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [el] (contains? a-set el)))

(defn pred-and [pred1 pred2]
  (fn [el] (and (pred1 el) (pred2 el))))

(defn pred-or [pred1 pred2]
  (fn [el] (or (pred1 el) (pred2 el))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [sqrtn (Math/sqrt n)
        divisible? (fn [el] (== 0 (mod n el)))]
    (not (some divisible? (range 2 (min n (+ 1 sqrtn)))))))
;^^
