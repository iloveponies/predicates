(ns predicates)



;; Exercise 1
;; Write the function (sum-f f g x) that returns (+ (f x) (g x)).
;;
;; func1 func2 number -> number
(defn sum-f [f g x]
  (+ (f x) (g x)))
;;
;; (sum-f inc dec 4) ;=> 8
;; (sum-f inc identity 5) ;=> 11
;; (sum-f identity - 10) ;=> 0


;; Exercise 2
;; Write the functions (less-than n) and (equal-to n) that work like greater-than. Use == as comparison in equal-to
;;
(defn less-than [n]
  (fn [x] (< x n)))
;;
(defn equal-to [n]
  (fn [x] (== x n)))
;;      v works because the return value is a function!!
;; (filter (less-than 3) [1 2 3 4 5])   ;=> (1 2)
;; (filter (less-than 4) [-2 12 3 4 0]) ;=> (-2 3 0)
;; (filter (equal-to 2) [2 1 3 2.0])    ;=> (2 2.0)
;; (filter (equal-to 2) [3 4 5 6])      ;=> ()


;; (def graphic-novels [{:name "Yotsuba 1" :series "Yotsuba"}
;;                      {:name "Yotsuba 5" :series "Yotsuba"}
;;                      {:name "Persepolis"}
;;                      {:name "That Yellow Bastard" :series "Sin City"}
;;                      {:name "The Hard Goodbye" :series "Sin City"}
;;                      {:name "Maus"}
;;                      {:name "Solanin"}
;;                      {:name "Monster 3" :series "Monster"}])
;;
;; Exercise 3
;; Write the function (set->predicate a-set) that takes a-set as a parameter and returns a predicate that takes x as a parameter and
;; returns true if x is in a-set
;; otherwise returns false
;;
;; set -> function
;; return a function check for presence of an element in the set
(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))
;;

;; (filter (set->predicate #{1 2 3})     [0 2 4 6])       ;=> (2)
;; (filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6]) ;=> (2 nil nil)


;; Exercise 4
;; Write the function (pred-and pred1 pred2) that returns a new predicate that:
;; returns true if both pred1 and pred2 return true
;; otherwise returns false
;; Suppose I wanted all even positive numbers from a sequence. With pred-and, this should be easy.
;;
;; two predicate functions -> one predicate function (and condition)
(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))
;;
;; (filter (pred-and pos? even?) [1 2 -4 0 6 7 -3]) ;=> [2 6]
;; ;; Here are some other test cases:
;; (filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) ;=> [1 7]
;; (filter (pred-and (complement nil?) empty?) [[] '() nil {} #{}])
;=> [[] '() {} #{}]


;; Exercise 5
;; Write the function (pred-or pred1 pred2) that takes two predicates and returns a new predicate that:
;; returns true if pred1 or pred2 returns true
;; otherwise returns false
(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))
;;
;; (filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])  ;=> [1 2 6 7 -3]
;; (filter (pred-or pos? even?) [1 2 -4 0 6 7 -3]) ;=> [1 2 -4 0 6 7]


;; Exercise 6
;; Write the function (blank? string) that takes a string as a parameter and returns true if string is empty, nil, or contains only whitespace.
;; Remember that strings can be used as a sequence of characters with sequence functions like every?. A function whitespace? that tells if a character is whitespace is defined for you in the source file.
(defn whitespace? [character]
  (Character/isWhitespace character))
;;
;; string -> bool
;; 
(defn blank? [string]
  (every? whitespace? string))
;;
;; (blank? " \t\n\t ") ;=> true
;; (blank? "  \t a")   ;=> false
;; (blank? "")         ;=> true



;; (def china {:name "China Miéville", :birth-year 1972})
;; (def octavia {:name "Octavia E. Butler"
;;               :birth-year 1947
;;               :death-year 2006})
;; (def kay {:name "Guy Gavriel Kay" :birth-year 1954})
;; (def dick {:name "Philip K. Dick", :birth-year 1928, :death-year 1982})
;; (def zelazny {:name "Roger Zelazny", :birth-year 1937, :death-year 1995})

;; (def authors #{china, octavia, kay, dick, zelazny})

;; (def cities {:title "The City and the City" :authors #{china}
;;              :awards #{:locus, :world-fantasy, :hugo}})
;; (def wild-seed {:title "Wild Seed", :authors #{octavia}})
;; (def lord-of-light {:title "Lord of Light", :authors #{zelazny}
;;                     :awards #{:hugo}})
;; (def deus-irae {:title "Deus Irae", :authors #{dick, zelazny}})
;; (def ysabel {:title "Ysabel", :authors #{kay}, :awards #{:world-fantasy}})
;; (def scanner-darkly {:title "A Scanner Darkly" :authors #{dick}})

;; (def books #{cities, wild-seed, lord-of-light,
;;              deus-irae, ysabel, scanner-darkly})


;; Exercise 7
;; Write the function (has-award? book award) that returns true if book has won award.
;;
;; (map keyword) -> bool
;; Check the presence of keyword in the :awards part of the book
(defn has-award? [book award]
  (contains? (get book :awards) award))
;;
;; (has-award? ysabel :world-fantasy) ;=> true
;; (has-award? scanner-darkly :hugo)  ;=> false


;; Exercise 8
;; Write the function (HAS-ALL-THE-AWARDS? book awards) that returns true if book has won every award in awards.
;;
;; (map set) -> bool
;; Check if :awards part of the map contains all in set
;; (defn HAS-ALL-THE-AWARDS? [book awards]
;;   (let [awards-won (get book :awards)]
;;     (every? awards-won awards)))
;;
(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))
;; ;;
;; (HAS-ALL-THE-AWARDS? cities #{:locus})
;; ;=> true
;; (HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo})
;; ;=> true
;; (HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo :pulitzer})
;; ;=> false
;; (HAS-ALL-THE-AWARDS? lord-of-light #{:locus :world-fantasy :hugo})
;; ;=> false
;; (HAS-ALL-THE-AWARDS? lord-of-light #{:hugo})
;; ;=> true
;; (HAS-ALL-THE-AWARDS? scanner-darkly #{})
;; ;=> true



;; Exercise 9
;; Write you own implementation for some called my-some.
;; Hint: You might find map, filter and first useful (you won’t necessarily need them all).
;;
;; (pred a-seq) -> first value being non-nil
(defn my-some [pred a-seq]
  ;; apply predicate on all
  (let [res-map       (map pred a-seq)
        ;; Get non-false elements
        non-false-elt (filter identity res-map)]
    ;;
    ;; if not empty return the first element, otherwise false
    (if (not (empty? non-false-elt))
      (first non-false-elt)
      false)))
;;
;; (my-some even? [1 3 5 7])       ;=> falsey
;; (my-some even? [1 3 5 7 8])     ;=> true
;; (my-some neg? [1 3 5 0 7 8])    ;=> falsey
;; (my-some neg? [1 3 5 0 7 -1 8]) ;=> true
;; (my-some neg? [])               ;=> falsey
;; (my-some first [[false] [1]])   ;=> 1
;; (my-some first [[false] []])    ;=> falsey
;; (my-some nil? [1 2])            ;=> falsey
;; (my-some nil? [1 nil 2])        ;=> true



;; Exercise 10
;; Write your own implementation for every? called my-every?.
;; Hint: the previous hint applies. empty? and complement might come in handy as well.
;;
(defn my-every? [pred a-seq]
  ;; filter by complement predicate
  (let [res-flt (filter (complement pred) a-seq)]
    ;; if empty, true, otherwise false 
    (empty? res-flt)))
;;
;; (my-every? pos? [1 2 3 4])   ;=> true
;; (my-every? pos? [1 2 3 4 0]) ;=> false
;; (my-every? even? [2 4 6])    ;=> true
;; (my-every? even? [])         ;=> true



;; Exercise 11
;; Write the function (prime? n) that returns true if n is a prime number and otherwise false.
;; The function (range k n) returns the sequence
;; (k (+ k 1) (+ k 2) ... (- n 1))
;; Here’s a concrete example:
;; (range 2 10) ;=> (2 3 4 5 6 7 8 9)
;; A positive integer p is a prime number if the only positive numbers dividing p are p and 1.
;; Your solution should be of the form
;; (defn prime? [n]
;;   (let [pred ...]
;;     (not (some pred (range 2 n)))))
;;
;; number -> bool
;; Check if a number is a prime number
(defn prime? [n]
  (let [divsrs (range 2 n)]
    ;; divide by all divsrs, filter out ones without reminder; if none present, prime
    (empty? (filter
             ;; check if the reminder is zero
             #(= 0 (rem n %))
             ;; for all divsors
             divsrs))))
;;
;; Here are some tests:
;; (prime? 4) ;=> false
;; (prime? 7) ;=> true
;; (prime? 10) ;=> false
;; (filter prime? (range 2 50)) ;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)


;^^
