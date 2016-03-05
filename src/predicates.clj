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
  (fn [n] (and (pred1 n) (pred2 n)))
  )

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n) (pred2 n)))
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
  (let [f (fn [x] (has-award? book x))]
  (every? f awards)
  ))

(defn my-some [pred a-seq]
  (let [res (first (filter (complement false?) (map pred a-seq)))]
  (if (nil? res)
    (boolean false)
    res
    )
  )
)

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq)))
  )


(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
