(ns predicates)

(defn sum-f [f g x]
  "returns (+ (f x) (g x))"
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  "returns a predicate that takes x as a parameter and
returns true if x is in a-set
otherwise returns false"
  (fn [x]
    (= (a-set x) x)))

(defn pred-and [pred1 pred2]
  "returns a new predicate that:
returns true if both pred1 and pred2 return true
otherwise returns false"
  (fn [x]
    (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  "returns a new predicate that:
returns true if pred1 or pred2 returns true
otherwise returns false"
  (fn [x]
    (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  "returns true if string is empty, nil, or contains only whitespace."
  (cond
   (= (count string) 0) true
   (= string nil) true
   (every? whitespace? string) true
   :else false))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn has-award? [book award]
  ((key->predicate award) (:awards book)))

(defn HAS-ALL-THE-AWARDS? [book awards]
 (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  "returns true if at least one element of a sequence passes a predicate"
  (let [identity-or-false (fn [elem] (if (not elem) false elem))
        truthy? (fn [elem] ((complement not) elem))]
    (first (filter truthy? (map identity-or-false
         (map pred a-seq))))))

(defn my-every? [pred a-seq]
  (empty? (filter (fn [elem] (not elem)) (map pred a-seq))))

(defn prime? [n]
  (let [equals-n? (fn [number] (= number n))
        divisor? (fn [m] (let [k-times-m-results (map (fn [k] (* k m)) (range 1 n))]
                           (some equals-n? k-times-m-results)))]
    (not (some divisor? (range 2 n)))))
;^^
