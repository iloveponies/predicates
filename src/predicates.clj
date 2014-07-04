(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [v] (contains? a-set v)))

(defn pred-and [pred1 pred2]
  (fn [arg]
    (and (pred1 arg)
         (pred2 arg))))

(defn pred-or [pred1 pred2]
  (fn [arg]
    (or (pred1 arg)
        (pred2 arg))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
    (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [award] (has-award? book award))]
    (every? identity (map book-has-award? awards))))

(defn my-some [pred a-seq]
  (let [mapped (map pred a-seq)
        only-true (filter identity mapped)]
    (first only-true)))

(defn my-every? [pred a-seq]
  (let [mapped (map pred a-seq)
        only-false (filter (complement identity) mapped)]
    (empty? only-false)))

(defn prime? [n]
  (let [pred (fn [k] (= (mod n k) 0))]
    (not (some pred (range 2 n)))))
;^^
