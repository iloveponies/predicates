(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(sum-f inc dec 2)

(defn less-than [n]
  (fn [x] (< x n)))

(filter (less-than 3) [1 2 3 4 5])

(defn equal-to [n]
  (fn [x] (== x n)))

(filter (equal-to 2) [2 1 3 2.0])

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

;(filter (pred-and pos? even?) [1 2 -4 0 6 7 -3])

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

;(has-award? ysabel :world-fantasy)


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))


(defn my-some [pred a-seq]
  (first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq]
    (empty? (filter false? (map pred a-seq))))

(my-every? pos? [1 2 3 4 0])
(my-every? pos? [1 2 3 4])

(defn prime? [n]
  (let [pred (fn [k] (= (mod n k) 0))]
     (not (some pred (range 2 n)))))

;(prime? 4)

;^^
