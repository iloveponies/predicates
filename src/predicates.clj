(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))


(sum-f inc dec 4) ;=> 8
(sum-f inc identity 5) ;=> 11
(sum-f identity - 10) ;=> 0

(defn greater-than [n]
  (fn [k] (> k n)))
(filter (greater-than 5) [4 6 5 0 9 2 12])

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(filter (less-than 3) [1 2 3 4 5])   ;=> (1 2)
(filter (less-than 4) [-2 12 3 4 0]) ;=> (-2 3 0)
(filter (equal-to 2) [2 1 3 2.0])    ;=> (2 2.0)
(filter (equal-to 2) [3 4 5 6])      ;=> ()

(defn set->predicate [a-set]
  (fn [x]
    (contains? a-set x)
      ))

(filter (set->predicate #{1 2 3})     [0 2 4 6])       ;=> (2)
(filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6]) ;=> (2 nil nil)


(contains? [1 2 3] 2)


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) ;=> [1 7]
(filter (pred-and (complement nil?) empty?) [[] '() nil {} #{}])

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])  ;=> [1 2 6 7 -3]
(filter (pred-or pos? even?) [1 2 -4 0 6 7 -3]) ;=> [1 2 -4 0 6 7]

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  :-)

(defn has-award? [book award]
  :-)

(defn HAS-ALL-THE-AWARDS? [book awards]
  :-)

(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
