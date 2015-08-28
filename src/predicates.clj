(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [e]
    (contains? a-set e)))

(defn pred-and [pred1 pred2]
  (fn [e]
    (and (pred1 e)
         (pred2 e))))

(defn pred-or [pred1 pred2]
  (fn [e]
    (or (pred1 e)
        (pred2 e))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awarded? (fn [a] (has-award? book a))]
    (every? awarded? awards)))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (not (my-some (complement pred) a-seq)))
;  (apply = true (map pred a-seq)))

(defn prime? [n]
  (let [divisor? (fn [x] (== (mod n x) 0))]
    (not (some divisor? (range 2 n)))))
;^^
