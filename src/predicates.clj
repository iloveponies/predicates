(ns predicates)


;http://iloveponies.github.io/120-hour-epic-sax-marathon/predicates.html

;ex1

(defn sum-f [f g x]
(+ (f x) (g x))
 )


;ex 2

(defn less-than [n]
  (fn [k] (< k n))
)
    

(defn equal-to [n]
  (fn [k] (== k n))
)

;ex 3

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x))
)

;ex 4

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x)))
 )

;ex5 
(defn pred-or [pred1 pred2]
  
  (fn [x] (or (pred1 x) (pred2 x)))
)

; ex6

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
(every? whitespace? string)
  )

;ex 7

(defn has-award? [book award]
(contains? (:awards book) award)
 )

;ex 8 

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every?  (fn [aw] (has-award? book aw)) awards)
  )

;ex 9

(defn my-some [pred a-seq]

(first 
 (filter identity 
         (map pred a-seq))
 )
)

          
; ex 10

(defn my-every? [pred a-seq]
(empty? (filter (complement identity) (map pred a-seq)))
)

; ex 11

(defn prime? [n]
  
 (let 
   [pred (fn [x](= 0 (mod n x)))]
   (not (some pred (range 2 n)))
 )
)
  
