(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
)

(defn less-than [n]
  (fn [x] (< x n))
)

(defn equal-to [n]
  (fn [x] (== n x))
  )

(defn set->predicate [a-set]
  (fn [elem] (contains? a-set elem))
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
  (let [awards (:awards book)]
    (if (and awards (award awards))
      true
      false
    )
  ))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)
        check-award (fn [award] (contains? book-awards award))]
        (if (contains? (set (map check-award awards)) false)
          false
          true
        )
  )
)

(defn my-some [pred a-seq]
  (let [falsey? (fn [x] (and (not (false? x))
                             (not (nil? x))))]
    (first (filter falsey? (map pred a-seq)))
  )
)

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq)))
  )

(defn prime? [n]
  (let [divisible? (fn [x]  (= (rem n x) 0) )]
    (not (some divisible? (range 2 n)))
  )
)
;^^
