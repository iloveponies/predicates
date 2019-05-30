(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n )))

(defn equal-to [n]
  (fn [k] (== k n )))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and
      (pred1 x)
      (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or
      (pred1 x)
      (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
    (nil? string)
    (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [a] (has-award? book a)) awards))

(defn my-some [pred a-seq]
  (first (filter pred a-seq)))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  :-)
;^^
