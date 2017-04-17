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
  (let [awards (:awards book)]
    (contains? awards award)
    )
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)
        predicate (fn [award] (contains? book-awards award))]
    (every? predicate awards)
    )
  )

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (if (< 0 (count filtered))
      (pred (first filtered))
      false
      )
  ))

(defn my-every? [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (= (count filtered) (count a-seq))
  ))

(defn prime? [n]
  :-)
;^^
