(ns predicates)

(defn apply-1 [f x]
  (f x))

(defn sum-f [f g x]
  (+ (apply-1 f x) (apply-1 g x)))

(defn less-than [n]
  (fn [k] (< k n)))
 
(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-pred] (contains? a-set a-pred)))

(defn pred-and [pred1 pred2]
  (fn [x] (and
           (pred1 x)
           (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or
           (pred1 x)
           (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  :-)

(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
