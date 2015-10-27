(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map)))

(defn pred-and [pred1 pred2]
  (fn [value] (and (pred1 value) (pred2 value))))

(defn pred-or [pred1 pred2]
  (fn [value] (or (pred1 value) (pred2 value))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter not (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [k] (= 0 (mod n k)))]
    (not (some pred (range 2 n)))))
;^^
