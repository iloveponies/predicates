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
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (get book :awards) awards))

(defn my-some [pred a-seq]
  (if (empty? (filter pred a-seq))
   false
   true))

(defn my-every? [pred a-seq]
  (if (== (count (filter pred a-seq)) (count a-seq))
   true
   false))

(defn prime? [n]
  (let [x (fn [x] (== (mod n x) 0))]
  (not (some x (range 2 n)))))
;^^
