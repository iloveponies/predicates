(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (if (contains? a-set x)
            true
            false)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (every? whitespace? string)
    true
    false))

(defn has-award? [book award]
  (if (contains? (:awards book) award)
    true
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (if (every?
        (fn [award] (contains? (:awards book) award))
        awards)
    true
    false))

(defn my-some [pred a-seq]
  (if (not (empty? (filter pred a-seq)))
    (if (= (first (filter pred a-seq)) true)
      true
      (pred (first (filter pred a-seq))))
    false))

(defn my-every? [pred a-seq]
    (if (== (count a-seq) (count (filter pred a-seq)))
      true
      false))

(defn prime? [n]
  (let [jakaa (fn [k] (== (mod n k) 0))]
    (not (some jakaa (range 2 n)))))
;^^

