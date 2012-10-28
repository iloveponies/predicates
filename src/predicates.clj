(ns predicates)

; Harjoitus 1
; OK
(defn sum-f
        [f g x]
        (+ (f x) (g x))
)

; Harjoitus 2a
; OK
(defn less-than
        [n]
        (fn [k] (< k n))
)

; Harjoitus 2b
; OK
(defn equal-to
        [n]
        (fn [k] (== k n))
)

; Harjoitus 3
(defn set->predicate
        [a-set]
        (let apuri [(fn [a-map] (contains? a-map a-set))]
         (fn [x] (contains? x a-set))
        )
)

; Harjoitus 4
(defn pred-and
        [pred1 pred2]
        (let apuri [(fn [x] (= x true))]
                (and (= (apuri pred1) true ) (= (apuri pred2) true))
        )
)


(defn pred-or [pred1 pred2]
  :-)

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
