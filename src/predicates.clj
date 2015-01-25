(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [val] (< val n)))

(defn equal-to [n]
  (fn [val] (== val n)))

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

(defn has-award? [book award]
  (not (empty? (filter (set->predicate #{award}) (:awards book)))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [a] (has-award? book a)) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [divides-n? (fn [m] (zero? (mod n m)))]
    (not (some divides-n? (range 2 n)))))
;^^
