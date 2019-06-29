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
  (fn [x] (and
    (pred1 x)
    (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or
      (pred1 x)
      (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
  (let [passed (filter pred a-seq)
        somes (map pred passed)]
    (first somes)))

(defn my-every? [pred a-seq]
  (let [seq-count (count a-seq)
        passed (filter pred a-seq)]
    (= seq-count (count passed))))

(defn prime? [n]
  (let [pred (fn [divisor]
               (= 0 (mod n divisor)))]
    (not (some pred (range 2 n)))))

