(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< %1 n))

(defn equal-to [n]
  #(== %1 n))

(defn set->predicate [a-set]
  #(contains? a-set %1))

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
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [applied (map pred a-seq)
        truthy? (fn [val] (if val true false))]
    (first (filter truthy? applied))))

(defn my-every? [pred a-seq]
  (or (empty? a-seq) (empty? (filter false? (map pred a-seq)))))

(defn prime? [n]
  (let [divides? #(== (mod n %1) 0)
        numbers (range 1 (inc n))
        divisors (filter divides? numbers)]
    (== (count divisors) 2)))
;^^
