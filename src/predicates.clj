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
  (or
   (nil? string)
   (empty? (filter (complement whitespace?) string))))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (== (count (filter
              (fn [award]
                (contains?
                 (:awards book) award)) awards))
      (count awards)))

(defn my-some [pred a-seq]
  (let [filtered (map pred (filter pred a-seq))]
    (cond
     (empty? filtered) false
     :else (first filtered))))

(defn my-every? [pred a-seq]
  (let [filtered (map pred (filter pred a-seq))]
      (== (count filtered) (count a-seq))))

(my-every? pos? [1 2 3 4])   ;=> true
(my-every? pos? [1 2 3 4 0]) ;=> false
(my-every? even? [2 4 6])    ;=> true
(my-every? even? [])         ;=> true

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
  (not (some pred (range 2 n)))))


;^^

