(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [v] (< v n)))

(defn equal-to [n]
  (fn [v] (== v n)))

(defn set->predicate [a-set]
  (fn [n] (contains? a-set n)))

(defn pred-and [pred1 pred2]
  (fn [n] (and (pred1 n)
               (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n)
              (pred2 n))))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [awards (:awards book :not-found)]
  (if (awards award)
    true
    false)))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %1) awards))

(defn my-some [pred a-seq]
  (if (= 0 (count (filter pred a-seq)))
    (first (filter pred a-seq))
    (pred (first (filter pred a-seq)))))



(defn my-every? [pred a-seq]
  (not (some false? (map pred a-seq))))


(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))

(prime? 4) ;=> false
(prime? 7) ;=> true
(prime? 10) ;=> false
(filter prime? (range 2 50)) ;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)

;^^
