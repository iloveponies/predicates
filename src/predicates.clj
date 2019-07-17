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
  ((complement nil?) (award (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-award (fn [award] (award (:awards book)))]
    (every? awards (map has-award awards))))

(defn my-some [pred a-seq]
  (let [f-test (filter pred a-seq)
        m-test (map pred a-seq)]
    (if (empty? f-test)
      false
      (first (filter (complement false?) m-test)))))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
