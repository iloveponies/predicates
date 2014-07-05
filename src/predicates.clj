(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a] (contains? a-set a)))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (reduce #(and %1 %2) (map pred a-seq))))

(defn prime? [n]
  (if (<= 1 n 3)
    true
    (not (some #(= 0 (mod n %)) (range 2 (inc (Math/sqrt n)))))))
;^^
