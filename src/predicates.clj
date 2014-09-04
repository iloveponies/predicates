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
  (or (every? whitespace? string) (empty? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [check-award (fn [award] (has-award? book award))
        check-awards (filter check-award awards)]
  (= (sort awards) (sort check-awards))))

(defn my-some [pred a-seq]
  (let [values (filter pred a-seq)]
    (if (empty? values) false (if (coll? (first values)) (first (first values)) true))))

(defn my-every? [pred a-seq]
  (let [values (filter pred a-seq)]
    (= (sort values) (sort a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
