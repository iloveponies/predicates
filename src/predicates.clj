<(ns predicates)

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
  (fn [key] (contains? a-set key))
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
  (let [space (fn [x] (whitespace? x))]
    (every? true? (map space string))
    )
  )

(defn has-award? [book award]
  (contains? (:awards book) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has (fn [award] (contains? (:awards book) award))]
    (every? true? (map has awards))
    )
  )

(defn my-some [pred a-seq]
  (or (some pred (filter pred a-seq)) false)
  )

(defn my-every? [pred a-seq]
  (every? true? (map pred a-seq))
  )

(defn prime? [n]
  (let [divisible (fn [x] (= (mod n x) 0))]
    (not (some true? (map divisible (range 2 n))))
    )
  )
