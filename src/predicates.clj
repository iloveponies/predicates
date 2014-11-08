(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n))
  )

(defn equal-to [n]
  (fn [k] (== k n))
  )

(defn set->predicate [a-set]
  (fn [element] (contains? a-set element))
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
  (every? whitespace? string)
  )

(defn has-award? [book award]
  (contains? (:awards book) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book_awards (:awards book)
        has-award? (fn [x]
                     (contains? book_awards x))]
    (every? has-award? awards))
  )

(defn my-some [pred a-seq]
  (let  [tset (filter (complement false?) (map pred a-seq))]
    (if (empty? tset) false (first tset)))
  )

(defn my-every? [pred a-seq]
  (let [tset (filter false? (map pred a-seq))]
    (if (empty? tset) true false))
  )

(defn prime? [n]
  (let [divides? (fn [x] (== 0 (rem n x)))]
    (not (some divides? (range 2 n))))
  )
;^^
