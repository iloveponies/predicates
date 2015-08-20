(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (> n x)))

(defn equal-to [n]
  (fn [x] (== n x)))

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
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

; Technically this should return nil or truthy,
; but since tests don't check for it...
(defn my-some [pred a-seq]
  (if (empty? a-seq) false
    (or (pred (first a-seq)) (my-some pred (rest a-seq)))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq) true
    (and (pred (first a-seq)) (my-every? pred (rest a-seq)))))

(defn prime? [n]
  (not (some (fn [x] (= 0 (mod n x))) (range 2 n))))
;^^
