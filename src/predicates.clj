(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-value]
    (contains? a-set a-value)))

(defn pred-and [pred1 pred2]
  (fn [arg]
    (and (pred1 arg) (pred2 arg))))

(defn pred-or [pred1 pred2]
  (fn [arg]
    (or (pred1 arg) (pred2 arg))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  ((set->predicate (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn truthy? [arg]
  (if arg
    true
    false))

(defn my-some [pred a-seq]
  (first (filter truthy? (map pred a-seq))))

(defn my-every? [pred a-seq]
  (== (count a-seq)
      (count (filter pred a-seq))))

(defn prime? [n]
  (let [numbers (range 2 n)
        divides? (fn [x]
                   (integer? (/ n x)))]
    (nil? (my-some divides? numbers))))
