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
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (= string "")
      (nil? string))
      (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (book :awards)) awards))

(defn my-some [pred a-seq]
 (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (if (= nil (first (filter false? (map pred a-seq))))
    true
    false))

(defn prime? [n]
  :-)
;^^
