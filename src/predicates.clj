(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(sum-f inc dec 4) ;=> 8
(sum-f inc identity 5) ;=> 11
(sum-f identity - 10) ;=> 0

(defn less-than [n]
  (fn [k] (< k n)))

(filter (less-than 3) [1 2 3 4 5])   ;=> (1 2)
(filter (less-than 4) [-2 12 3 4 0]) ;=> (-2 3 0)

(defn equal-to [n]
  (fn [k] (== k n)))

(filter (equal-to 2) [2 1 3 2.0])    ;=> (2 2.0)
(filter (equal-to 2) [3 4 5 6])      ;=> ()

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(filter (set->predicate #{1 2 3})     [0 2 4 6])       ;=> (2)
(filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6]) ;=> (2 nil nil)

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(filter (pred-and pos? even?) [1 2 -4 0 6 7 -3]) 
(filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) ;=> [1 7]
(filter (pred-and (complement nil?) empty?) [[] '() nil {} #{}])

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])  ;=> [1 2 6 7 -3]
(filter (pred-or pos? even?) [1 2 -4 0 6 7 -3]) ;=> [1 2 -4 0 6 7]

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(blank? " \t\n\t ") ;=> true
(blank? "  \t a")   ;=> false
(blank? "")         ;=> true

(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award) ))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let  [awards? (fn [award] (has-award? book award))]
    (every? awards? awards)))

(defn my-some [pred a-seq]
  (not (= (count (filter pred a-seq)) 0)))

(my-some even? [1 3 5 7])       ;=> falsey
(my-some even? [1 3 5 7 8])     ;=> true
(my-some neg? [1 3 5 0 7 8])    ;=> falsey
(my-some neg? [1 3 5 0 7 -1 8]) ;=> true
(my-some neg? [])               ;=> falsey
(my-some first [[false] [1]])   ;=> 1
(my-some first [[false] []])    ;=> falsey
(my-some nil? [1 2])            ;=> falsey
(my-some nil? [1 nil 2])        ;=> true

(defn my-every? [pred a-seq]
  (= (count (filter pred a-seq)) (count a-seq)))

(my-every? pos? [1 2 3 4])   ;=> true
(my-every? pos? [1 2 3 4 0]) ;=> false
(my-every? even? [2 4 6])    ;=> true
(my-every? even? [])         ;=> true

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))

(prime? 4) ;=> false
(prime? 7) ;=> true
(prime? 10) ;=> false
(filter prime? (range 2 50))
