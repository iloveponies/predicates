(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string) (empty? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn[x] (has-award? book x)) awards))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [poss-factors (range 2 n)
  ;(+ 1 (Math/sqrt n))) ; smarter factorization (answer as (...) not [...])
        pred? (fn [x] (== 0 (mod n x)))]
    (not (some pred? poss-factors))))

;;;;;;;;; DONE ABOVE ;;;;;;;;;

(defn my-some [pred a-seq]
  ;(pred
    (first
      (filter pred a-seq)
    )
  ;)
)
  ;(first (filter pred a-seq)))
