(ns predicates)


;; Ex 1
;; Write the function (sum-f f g x) that returns (+ (f x) (g x)).

(defn sum-f [f g x]
  (+ (f x) (g x)))


;; Ex 2
;; Write the functions (less-than n) and (equal-to n) that work like greater-than. Use == as comparison in equal-to

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))


;; Ex 3
;; Write the function (set->predicate a-set) that takes a-set as a parameter and returns a predicate that takes x as a parameter and
;; returns true if x is in a-set
;; otherwise returns false

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))


;; Ex 4
;; Write the function (pred-and pred1 pred2) that returns a new predicate that:
;; returns true if both pred1 and pred2 return true
;; otherwise returns false
;; Suppose I wanted all even positive numbers from a sequence. With pred-and, this should be easy.

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))


;; Ex 5
;; Write the function (pred-or pred1 pred2) that takes two predicates and returns a new predicate that:
;; returns true if pred1 or pred2 returns true
;; otherwise returns false

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))


(defn whitespace? [character]
  (Character/isWhitespace character))


;; Ex 6
;; Write the function (blank? string) that takes a string as a parameter and returns true if string is empty, nil, or contains only whitespace.
;; Remember that strings can be used as a sequence of characters with sequence functions like every?. A function whitespace? that tells if a character is whitespace is defined for you in the source file.

(defn blank? [string]
  (every? (fn [x] (whitespace? x)) string))


;; Ex 7
;; Write the function (has-award? book award) that returns true if book has won award.

(defn has-award? [book award]
  (and (contains? book :awards) (contains? (:awards book) award)))


;; Ex 8
;; Write the function (HAS-ALL-THE-AWARDS? book awards) that returns true if book has won every award in awards.

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))


;; Ex 9
;; Write you own implementation for some called my-some.
;; Hint: You might find map, filter and first useful (you won’t necessarily need them all).

(defn my-some [pred a-seq]
  (first (filter (fn [x] false? x) (map pred a-seq))))


;; Ex 10
;; Write your own implementation for every? called my-every?.
;; Hint: the previous hint applies. empty? and complement might come in handy as well.

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))


;; Exercise 11
;; Write the function (prime? n) that returns true if n is a prime number and otherwise false.

(defn prime? [n]
  (= '(1) (filter #(= 0 (mod n %1)) (range 1 n))))

