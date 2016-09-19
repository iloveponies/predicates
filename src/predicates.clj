(ns predicates)

(defn sum-f [f g x]
(+ (f x) (g x))
  )

(defn less-than [n]
 (fn [x] (< x n)
  )
)

(defn equal-to [n]
  (fn [x] (== x n)
  )
)

(defn set->predicate [a-set]
(fn [a-val] (contains? a-set a-val)
  )
)

(defn pred-and [pred1 pred2]
(fn [x] (and (pred1 x) (pred2 x))
  )
)

(defn pred-or [pred1 pred2]
(fn [x] (or (pred1 x) (pred2 x))
  )
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
 (every? whitespace? string
  )
)

(defn has-award? [book award]
 (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
(every? (fn [x] (has-award? book x)) awards
  )
)

(defn my-some [pred a-seq]
(first (filter (fn [x] (pred x)) a-seq)
  )
)

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq)))
  )

(defn my-every? [pred a-seq]
(== (count a-seq)  (count (map pred (filter pred a-seq))))
  )

(defn prime? [n]
(let [predicate (fn [x] (== (mod n x) 0))]
    (not (some predicate (range 2 n)))))
