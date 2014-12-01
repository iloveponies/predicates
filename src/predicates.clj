(ns predicates)

(defn sum-f [f g x]
  (apply + ((juxt f g) x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-fun [function & preds]
  (fn [x] (function identity ((apply juxt preds) x))))

(defn pred-and [pred1 pred2]
  (pred-fun every? pred1 pred2))

(defn pred-or [pred1 pred2]
  (pred-fun some pred1 pred2))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? (pred-or whitespace? nil?) string))

(defn has-award? [book award]
  ((set->predicate (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [k]
               (= 0 (mod n k)))]
    (not (some pred (range 2 n)))))
;^^
