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
  (fn [k]
    (if (contains? a-set k)
      true
      false))
  )

(defn pred-and [pred1 pred2]
  (fn [k]
    (if (and (pred1 k) (pred2 k))
      true
      false))
  )

(defn pred-or [pred1 pred2]
  (fn [k]
    (if (or (pred1 k) (pred2 k))
      true
      false))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)
  )

(defn has-award? [book award]
  (contains? (:awards book) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards)
  )

(defn my-some [pred a-seq]
  (if (first (filter (complement false?) (map pred a-seq)))
    (first (filter (complement false?) (map pred a-seq)))
    false)
  )

(defn my-every? [pred a-seq]
  (if (empty? (filter false? (map pred a-seq)))
    true
    false)
  )

(defn prime? [n]
  (let [pred (fn [k] (if (= 0 (mod n k)) true false))]
    (not (some pred (range 2 n))))
  )

;^^
