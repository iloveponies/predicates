(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n )))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award-pred [book]
  (fn [award] (contains? (:awards book) award)))

(defn has-award? [book award]
  (let [f (has-award-pred book)]
    (f award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (has-award-pred book) awards))

(defn my-some [pred a-seq]
  (let [bools (map pred a-seq)
        truthies (filter boolean bools)]
    (first truthies)))

(defn my-every? [pred a-seq]
  (not (my-some (complement pred) a-seq)))

(defn prime? [n]
  (let [divisible? (fn [k] (== (mod n k) 0))]
    (not (some divisible? (range 2 n)))))
;^^
