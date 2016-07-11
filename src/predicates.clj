(ns predicates)

(defn apply-1 [f x]
  (f x))

(defn sum-f [f g x]
  (+ (f x) (g x)))


(defn less-than [n]
 (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(filter (set->predicate #{1 2 3})     [0 2 4 6])  
(filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6])


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))



(defn blank? [string]
  (or (= "" string) (every? whitespace? string)))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defn has-award? [book award]
  ((set->predicate (:awards book)) award))



(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true? (map (fn [x] (has-award? book x)) awards)))




(some first [[] [1 2] []]) ;=> 1
(some first [[] [false true] []]) ;=> nil
(some nil? [1 nil 2]) ;=> true


(some whitespace? "Kekkonen")          ;=> nil
(some whitespace? "Kekkonen Kekkonen") ;=> True
(some even? [1 2 3])                   ;=> true
(some even? [1 3])                     ;=> false


(first [1 2 3])
(some first [[] [false true] []])
(first [[] [false true]])



(defn my-some [pred a-seq]
  (first (map (fn [x] (pred x)) (filter (fn [x] (pred x)) a-seq))))
  
(my-some even? [1 3 5 7])
(my-some even? [1 3 5 7 8])     ;=> true
(my-some neg? [1 3 5 0 7 8])    ;=> falsey
(my-some neg? [1 3 5 0 7 -1 8]) ;=> true
(my-some neg? [])               ;=> falsey
(my-some first [[false] [1]])   ;=> 1
(my-some first [[false] []])    ;=> falsey
(my-some nil? [1 2])            ;=> falsey
(my-some nil? [1 nil 2])        ;=> true


(defn my-every? [pred a-seq]
  (empty? (filter (fn [x] ((complement pred) x)) a-seq)))

(my-every? pos? [1 2 3 4])   ;=> true
(my-every? pos? [1 2 3 4 0]) ;=> false
(my-every? even? [2 4 6])    ;=> true
(my-every? even? [])         






(mod 4 2)

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^
