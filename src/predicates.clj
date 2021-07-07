(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

;; (sum-f inc dec 4) ;=> 8
;; (sum-f inc identity 5) ;=> 11
;; (sum-f identity - 10) ;=> 0


(defn less-than [n]
  (fn [x]
     (< x n)))

(defn equal-to [n]
  (fn[x]
    (== x n)))

;; (filter (less-than 3) [1 2 3 4 5])   ;=> (1 2)
;; (filter (less-than 4) [-2 12 3 4 0]) ;=> (-2 3 0)
;; (filter (equal-to 2) [2 1 3 2.0])    ;=> (2 2.0)
;; (filter (equal-to 2) [3 4 5 6])      ;=> ()

(defn set->predicate [a-set]
  (fn [x]
    (if (contains? a-set x)
      true
      false)))

;; (filter (set->predicate #{1 2 3})     [0 2 4 6])       ;=> (2)
;; (filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6]) ;=> (2 nil nil)

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x) (pred2 x))))

;; (filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) ;=> [1 7]
;; (filter (pred-and (complement nil?) empty?) [[] '() nil {} #{}])
;; ;=> [[] '() {} #{}]

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x) (pred2 x))))

;; (filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])  ;=> [1 2 6 7 -3]
;; (filter (pred-or pos? even?) [1 2 -4 0 6 7 -3]) ;=> [1 2 -4 0 6 7]

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

;; (blank? " \t\n\t ") ;=> true
;; (blank? "  \t a")   ;=> false
;; (blank? "")         ;=> true


(defn has-award? [book award]
  (let [ list-awards (:awards book)]
  (contains? list-awards award)))

;; (has-award? ysabel :world-fantasy) ;=> true
;; (has-award? scanner-darkly :hugo)  ;=> false

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [ list-award (:awards book)]
    (every? #(contains? list-award %) awards)))


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


;; (defn contains-number? [liste]
;;   (reduce (fn [acc x]
;;             (or (number? x)
;;                 acc)
;;             false
;;             )
;;           liste))


(defn my-some [pred a-seq]
  (let [ not-pred (complement pred)
         values-pred (map #(if (not-pred %)
                             false
                             (pred %)) a-seq)]
       (if  (empty? a-seq) false
            (reduce (fn [acc x]
                   (or acc x))
                 false
                 values-pred))))

;; (my-some even? [1 3 5 7])       ;=> falsey
;; (my-some even? [1 3 5 7 8])     ;=> true
;; (my-some neg? [1 3 5 0 7 8])    ;=> falsey
;; (my-some neg? [1 3 5 0 7 -1 8]) ;=> true
;; (my-some neg? [])               ;=> falsey
;; (my-some first [[false] [1]])   ;=> 1
;; (my-some first [[false] []])    ;=> falsey
;; (my-some nil? [1 2])            ;=> falsey
;; (my-some nil? [1 nil 2])        ;=> true


(defn my-every? [pred a-seq]
  (reduce (fn [acc x]
            (and acc (pred x)))
          true
          a-seq))

;; (my-every? pos? [1 2 3 4])   ;=> true
;; (my-every? pos? [1 2 3 4 0]) ;=> false
;; (my-every? even? [2 4 6])    ;=> true
;; (my-every? even? [])         ;=> true

(defn prime? [n]
  (let  [interval (range 2 n)]
    (every? #(< 0 (mod n %)) interval)))

;; (prime? 4) ;=> false
;; (prime? 7) ;=> true
;; (prime? 10) ;=> false
;; (= (filter prime? (range 2 50))  '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)) ;=>true

