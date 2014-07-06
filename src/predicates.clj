(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

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
    (and (not (nil? awards))
         (contains? awards award))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [candidates (filter pred a-seq)]
    (if (empty? candidates)
      false
      (pred (first candidates)))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn divides? [divisor n]
  (= (mod n divisor) 0))

(defn prime? [n]
  (let [possible-divisors (range 2 (Math/floor (+ (Math/sqrt n) 1)))
        divides-n? (fn [x] (divides? x n))]
    (empty? (filter divides-n? possible-divisors))))
;^^
