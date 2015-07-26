(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))
;4

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))
;7

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))
;9

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))
;12

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))
;14

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
    (not string)
    (or (== 0 (count string))
       (every? whitespace? string))))
;17

(defn has-award? [book award]
  (contains? (:awards book) award))
;19

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards))
;22

(defn my-some [pred a-seq]
  (let [result (filter (fn[x] (boolean x)) (map pred a-seq))]
    (first result)))
;30

(defn my-every? [pred a-seq]
  (let [result (filter pred a-seq)]
    (== (count a-seq) (count result))))
;34

(defn prime? [n]
  (let [pred (fn [x] (not (= 0 (mod n x))))]
    (my-every? pred (range 2 n))))
;42
;^^
