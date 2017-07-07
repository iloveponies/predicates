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
  ((set->predicate (:awards book)) award))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))



(defn HAS-ALL-THE-AWARDS? [book awards]
  (and (>= (count (:awards book)) (count awards))
       (every? #(contains? (:awards book) %) awards)))

(defn my-some [pred a-seq]
  (first
    (remove false? (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (if (and (integer? n) (> n 1))
    (if (or (odd? n) (= n 2))
      (let [divisible? (fn [x] (= 0 (mod n x)))]
        (not (some divisible? (range 2 n))))
      false
    ) 
    false))


;^^
