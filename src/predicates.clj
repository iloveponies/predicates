(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
  )

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map)))


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x)))
  )

(defn pred-or [pred1 pred2]
    (fn [x] (or (pred1 x) (pred2 x)))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
   (empty? string) true
   (every? whitespace? string) true
   :else false
   ))
(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn[aw] (has-award? book aw)) awards))

(defn my-some [pred a-seq]
  ;(some pred a-seq)
    (first (filter (fn [x] x) (map pred a-seq)))
)

(defn my-every? [pred a-seq]
  ;(every? pred a-seq)
  (let [len (count (filter pred a-seq))]
    (= len (count a-seq)))
)

(defn prime? [n]
  (let [pred (fn[x] (= (mod n x) 0))]
    (not (some pred (range 2 n))))
  )
;^^

