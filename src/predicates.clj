(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== n k)))

(filter (equal-to 2) [2 1 3 2.0])

(defn set->predicate [a-set]
  (fn [tgt] (contains? a-set tgt)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
 (or
        (every? whitespace? string)
        (= 0 (count string))
        (= nil string)
        ))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
   (first (filter (fn [x] (not (= x false)))
    (map (fn [x] (pred x)) a-seq))))

(my-some first [[false] [1]])

(defn my-every? [pred a-seq]
  (empty?
  (filter
   (fn [x] (not (= x true)))
   (map (fn [x] (pred x)) a-seq))))


(defn divisible? [num divisor]
  (= 0 (mod num divisor)))

(defn prime? [n]
  (not (some (fn [num] (divisible? n num)) (range 2 n))))

(filter prime? (range 2 50))



(prime? 10)
  ;^^
