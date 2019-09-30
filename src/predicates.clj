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
  (let [awards (:awards book)]
    (if (award awards)
      true
      false)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)
        same-awards (filter awards book-awards)]
    (if (= (count same-awards) (count awards))
      true
      false)))

(defn my-some [pred a-seq]
  (first (filter #(not (false? %)) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (let [the-seq-of-truth (filter #(not (false? %)) (map pred a-seq))]
    (if (= (count a-seq) (count the-seq-of-truth))
      true
      false)))

(defn prime? [n]
  (let [divisible (fn [x] (zero? (mod n x)))]
       (not (some divisible (range 2 n)))))
;^^
