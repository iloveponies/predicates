(ns predicates)

(defn sum-f [f g x]
 (+ (f x) (g x))
)

(defn less-than [n]
  (fn [k] (< k n))
)

(defn equal-to [n]
  (fn [k] (== k n))
)

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x))
)

(defn pred-and [pred1 pred2]
   (fn [x] (and (pred2 x) (pred1 x)))
)

(defn pred-or [pred1 pred2]
   (fn [x] (or (pred2 x) (pred1 x)))
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
(every? whitespace? string)
)

(defn has-award? [book award]
(cond
  (:awards book) true
  :else false)
)


(defn HAS-ALL-THE-AWARDS? [book awards]
  (cond
    (= 0 (count awards)) true
    (= 1 (count awards)) (has-award? book awards)
    :else  (= awards (:awards book)))
)

(defn my-some [pred a-seq]
  (some pred a-seq)
  ; (not (empty? (filter pred a-seq)))
)

(defn my-every? [pred a-seq]
  (cond
    (= 0 (first (sort a-seq))) false
    :else true)
)

(defn prime? [n]
  (empty? (filter #(= 0 (mod n %)) (range 2 n)))
)

;^^
