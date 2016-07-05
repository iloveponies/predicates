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
  (fn [k] (contains? a-set k))
  )

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k)))
  )

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k)))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)
  )

(defn has-award? [book award]
  (and (contains? book :awards)
       (contains? (get book :awards) award))
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards)
  )

(defn my-some [pred a-seq]
  (let [siivila (filter pred a-seq)
        in-booleans (filter (fn [k] k) (map pred a-seq))]
    (if (empty? siivila)
      nil
      (first in-booleans))
    )
  )

(defn my-every? [pred a-seq]
  (cond
    (empty? a-seq) true
    (empty? (filter (complement pred) a-seq)) true
    :else false
    )
  )

(defn prime? [n]
  (my-every? (fn [k] (not (== 0 (mod n k)))) (range 2 n))
  )
;^^
