(ns predicates)

(defn sum-f [f g x]
  "Exercise 1"
  (+ (f x) (g x)))


(defn less-than [n]
  "Exercise 2"
  (fn [k] (< k n)))

(defn equal-to [n]
  "Exercise 2"
  (fn [k] (== k n)))


(defn set->predicate [a-set]
  "Exercise 3"
  (fn [value] (contains? a-set value)))


(defn pred-and [pred1 pred2]
  "Exercise 4"
  (fn [x] (and (pred1 x) (pred2 x))))


(defn pred-or [pred1 pred2]
  "Exercise 5"
  (fn [x] (or (pred1 x) (pred2 x))))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  "Exercise 6"
  (every? whitespace? string))


(defn has-award? [book award]
  "Exercise 7"
  (boolean (if (book :awards) award)))


(defn HAS-ALL-THE-AWARDS? [book awards]
  "Exercise 8"
  (every? (book :awards) awards))


(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
