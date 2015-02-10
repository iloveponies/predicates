(ns predicates)
;E1
(defn sum-f [f g x]
  (+ (f x) (g x)))
;E2
(defn less-than [n]
  (fn [x] (< x n)))
(defn equal-to [n]
  (fn [x] (== x n)))
;E3
(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

;E4
(defn pred-and [pred1 pred2]
   (fn [x] (and (pred1 x) (pred2 x))))
;E5
(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))
;E6
(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string)
      (empty? string)
      (every? whitespace? (seq string))))


;E7
(defn has-award? [book award]
  (contains? (:awards book) award))
;E8
(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [ awarded? (fn [x] (has-award? book x))]
  (every? awarded? awards)))

;E9
(defn my-some [pred a-seq]
  (if (empty? a-seq)
    false
    (or (pred (first a-seq)) (my-some pred (next a-seq)))))


;E10
(defn my-every? [pred a-seq]
(let [passes (fn [x] (pred x))
        filtered (filter passes a-seq)]
     (= (count filtered) (count a-seq))))

;E11
(defn prime? [n]
  (let [divides? (fn [x] (= 0 (mod n x)))]
    (not (my-some divides? (range 2 n)))))

;^^
