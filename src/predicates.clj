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
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)]
    (== (count awards) (count (filter awards book-awards)))))

(defn my-some [pred a-seq]
  (let [true-vals (filter pred a-seq)]
    (if (empty? true-vals) false (pred (first true-vals)))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq) true (not (my-some (complement pred) a-seq))))

(defn prime? [n]
  (let [n-vals (range 2 n)]
      (defn dividable? [x div]
        (== 0 (mod x div)))
      (not (my-some (fn [x] (dividable? n x)) n-vals))))
;^^
