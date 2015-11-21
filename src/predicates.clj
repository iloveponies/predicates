(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)(pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)(pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-book-award-checker [book]
  (fn [x] (contains? (:awards book) x))
  )

(defn has-award? [book award]
  ((has-book-award-checker book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (has-book-award-checker book) awards))

(defn my-some [pred a-seq]
  (let [mapped-seq (map pred a-seq)
        not-false-els (filter (fn [x] (not (false? x))) mapped-seq)]

  (first not-false-els)
  ))

(defn my-every? [pred a-seq]
  (= (count (filter (fn [x] (pred x)) a-seq)) (count a-seq)))

(defn prime? [n]
  (let [divides-n-not? (fn [x] (not (= (mod n x) 0)))]
  (my-every? divides-n-not? (range 2 n)))
  )
;^^
