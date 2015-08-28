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
  (let [book-awards (:awards book)]
    (contains? book-awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (first (filter (complement false?) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (let [matches (map pred a-seq)]
    (= (count (filter true? matches)) (count matches))))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (let [int-greater-than-two? (fn [y] (and (>= y 2) (integer? y)))]
      (if (not (int-greater-than-two? n))
        false
        (not (some pred (range 2 n)))))))

;^^
