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
  (every? (fn [award] (has-award? book award))
          awards ))

(defn my-some [pred a-seq]
  (let [xs (filter pred a-seq)]
    (if (empty? xs)
      nil
      (pred (first xs)))))



; map, filter and first
; empty? and complement
(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
