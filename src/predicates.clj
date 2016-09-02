(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
  )

(defn less-than [n]
 (fn [k] (< k n)))

(defn equal-to [n]
   (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map))
)
(defn pred-and [pred1 pred2]
 (every-pred (fn[x] (pred1 x))
        (fn[x] (pred2 x )))
  )

(defn pred-or [pred1 pred2]
   (some-fn (fn[x] (pred1 x))
        (fn[x] (pred2 x )))
  )
(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
 (every? whitespace? string))

 (defn has-award? [book award]
  (if (award (:awards book))
    true
    false)
  )
(defn HAS-ALL-THE-AWARDS? [book awards]
 (every? (:awards book) awards)
)

(defn my-some [pred a-seq]

(if (first (filter pred a-seq) )
  true
  false))




(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
