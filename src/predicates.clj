(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [a] (< a n)))

(defn equal-to [n]
  (fn [a] (== a n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank?
  "Checks whether string is empty, nil or contains whitespace"
  [string]
  (every? (pred-or whitespace? nil?) string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) (:awards book)))

(defn my-some [pred a-seq]
  (not (empty? (filter pred a-seq))))

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
