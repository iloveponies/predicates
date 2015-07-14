(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn greater-than [n]
  (fn [k] (> k n)))

(defn less-than [n]
  #(< % n))


(defn set->predicate [a-set]
  (fn [target] (some #(= target %) a-set)))


(defn pred-and [pred1 pred2]
  (fn[n] (and (pred1 n) (pred2 n))))

(defn equal-to [n]
    (pred-and (complement (greater-than n)) (complement (less-than n))))

(defn pred-or [pred1 pred2]
  (fn[n] (or (pred1 n) (pred2 n))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains?  awards award)))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement  pred) a-seq)))

(my-every? pos? [1 2 3 4])   ;=> true
(my-every? pos? [1 2 3 4 0]) ;=> false
(my-every? even? [2 4 6])    ;=> true
(my-every? even? [])         ;=> true

(defn prime? [n]
  (let [divide (fn[x] (= 0 (mod n x)))]
    (not (some divide (range 2 n)))))

;^^

