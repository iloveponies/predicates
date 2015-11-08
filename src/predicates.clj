(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn[x] (< x n)))

(defn equal-to [n]
  (fn[x] (== x n)))

(defn set->predicate [a-set]
  (fn[x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn[x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn[x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (if (contains? book :awards) (contains? (:awards book) award) false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (let [x (filter pred a-seq)]
  (if (= (count x) 0) false (pred (first x)))))

(defn my-every? [pred a-seq]
  (let [x (filter pred a-seq)]
  (= (count x) (count a-seq))))

(defn prime? [n]
  (let [pred (fn[x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
