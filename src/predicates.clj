(ns predicates)

(defn sum-f [f g x]
  (+ (g x) (f x))
  )



(defn less-than [n]
  (fn [k] (< k n))
  )

(defn equal-to [n]
  (fn [k] (== k n))
  )



(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key))
  )



(defn pred-and [pred1 pred2]
  (fn [a-key] (and
               (pred1 a-key)
               (pred2 a-key)))
  )





(defn pred-or [pred1 pred2]
  (fn [a-key] (or
               (pred1 a-key)
               (pred2 a-key)))
  )


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)
  )


(defn has-award? [book award]
  (contains? (book :awards) award)
  )


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards)
  )


(defn my-some [pred a-seq]
  (let [filtered (map pred (filter pred a-seq))]
   (cond
    (empty? filtered)      false
    :else   (first filtered)
  )))



(defn my-every? [pred a-seq]
  (let [valuated (map pred a-seq)
        contains-true? (fn [valuated-set] (contains? (set valuated) false))]
  ((complement contains-true?) valuated)
    ))




(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not(some pred(range 2 n))))

  )




;^^
