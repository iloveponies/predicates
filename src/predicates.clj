(ns predicates)

;Ex1 Write the function (sum-f f g x) that returns (+ (f x) (g x))
(defn sum-f [f g x]
  (+ (f x)
     (g x)))

;Ex2 Write the functions (less-than n) and (equal-to n) that work like greater-than. Use == as comparison in equal-to
(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))


;Ex3 Write the function (set->predicate a-set) that takes a-set as a parameter and returns a predicate that takes x as a parameter and
; returns true if x is in a-set
; otherwise returns false
(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

;Ex4  Write the function (pred-and pred1 pred2) that returns a new predicate that:
;returns true if both pred1 and pred2 return true
;otherwise returns false
;Suppose I wanted all even positive numbers from a sequence. With pred-and, this should be easy.
(defn pred-and [pred1 pred2]
  (fn [x] (and
            (pred1 x)
            (pred2 x))))

;Ex5 Write the function (pred-or pred1 pred2) that takes two predicates and returns a new predicate that:
;returns true if pred1 or pred2 returns true
;otherwise returns false
(defn pred-or [pred1 pred2]
  (fn [x] (or
            (pred1 x)
            (pred2 x))))

;Ex6 Write the function (blank? string) that takes a string as a parameter and returns true if string is empty, nil, or contains only whitespace.
;Remember that strings can be used as a sequence of characters with sequence functions like every?.
; A function whitespace? that tells if a character is whitespace is defined for you in the source file.
(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? (pred-or whitespace? nil?) string))

;Ex7 Write the function (has-award? book award) that returns true if book has won award.
(defn has-award? [book award]
  (contains? (:awards book) award))

;Ex8 Write the function (HAS-ALL-THE-AWARDS? book awards) that returns true if book has won every award in awards.
(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awards-intercept (set (filter (set->predicate awards) (:awards book)))]
    (= awards awards-intercept)))

;Ex9 Write you own implementation for some called my-some.
(defn my-some [pred a-seq]
  (first (filter (complement false?) (map pred a-seq))))

;Ex10 Write your own implementation for every? called my-every?.
(defn my-every? [pred a-seq]
  (=
    (count a-seq)
    (count (filter pred a-seq))))

;Ex11 Write the function (prime? n) that returns true if n is a prime number and otherwise false.
(defn prime? [n]
  (not (some (equal-to 0) (map #(mod n %) (range 2 n)))))

