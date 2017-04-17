(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
  )

(defn less-than [n]
  (fn [k] (< k n))
  )

(defn equal-to [n]
  (fn [k] (== n k))
  )

(defn set->predicate [a-set]
  (fn [value] (contains? a-set value))
  )

(defn pred-and [pred1 pred2]
  (fn [value] (and (pred1 value) (pred2 value)))
  )

(defn pred-or [pred1 pred2]
  (fn [value] (or (pred1 value) (pred2 value)))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [predicate (fn [character] (or
                                    (nil? character)
                                    (whitespace? character)
                                    ))]
    (every? predicate string)
    )
  )

(defn has-award? [book award]
  :-)

(defn HAS-ALL-THE-AWARDS? [book awards]
  :-)

(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
