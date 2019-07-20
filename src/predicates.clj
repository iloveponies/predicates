(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string)
      (nil? string)
      (== (count string) 0)))

(defn has-award? [book award]
  (> (count (:awards book)) 0))

(defn HAS-ALL-THE-AWARDS? [book awards]
      (>= (count (:awards book)) (count awards)))

(defn my-some [pred a-seq]
  (let [predicate-seq (map pred a-seq)
        truthy-values (filter (fn [e] (identity e)) predicate-seq)]
    (if (> (count truthy-values) 0)
      (first truthy-values)
      false)))

(defn my-every? [pred a-seq]
  (== (count (filter pred a-seq))
      (count a-seq)))

(defn prime? [n]
  (let [pred (fn [a] (== (rem n a) 0))]
    (not (some pred (range 2 n)))))
;^^
