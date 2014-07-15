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
  (fn [x] (some (partial = x) a-set))
  )

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x)))
  )

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x)))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [the-award] (has-award? book the-award)) awards)
  )

(defn my-some [pred a-seq]
  (first (filter true? (map pred a-seq)))
   )

(defn my-every? [pred a-seq]
  (not (some false? (map pred a-seq)))
  )

(defn prime? [n]
  (let [is-divisible? (fn [x] (if (== (mod n x) 0) true false))]
    (not (some is-divisible? (range 2 n))))
  )
;^^
