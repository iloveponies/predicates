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
  (every? (set->predicate (:awards book)) awards))

(defn my-some2 [pred a-seq]
  (let [first-truthy (first (drop-while (complement pred) a-seq))]
    (if (nil? first-truthy)
      nil
      (pred first-truthy))))

(defn my-some[pred a-seq]
  (let [true-values (filter pred a-seq)]
    (if (not (empty? true-values))
      (pred (first true-values))
      nil)))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [v]  (zero? (mod n v)))
        pred2 (fn [v] (not (= v 1)))] ;; 1 is not a prime..
    (not (some (pred-and pred pred2) (range 2 n)))))

