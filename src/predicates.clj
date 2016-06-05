(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
    (every? whitespace? string)
    (empty? string)))

(defn has-award? [book award]
  (let [book-awards (:awards book)]
    (contains? book-awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)
        predicate (fn [book] (fn [award] (has-award? book award)))]
    (every? (predicate book) awards)))

(defn my-some [pred a-seq]
  (first (filter (fn [x] x) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (=
    (count (filter (fn [x] x) (map pred a-seq)))
    (count a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
