(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

#_(sum-f inc dec 4) ;=> 8
#_(sum-f inc identity 5) ;=> 11
#_(sum-f identity - 10) ;=> 0

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

#_(filter (less-than 3) [1 2 3 4 5])   ;=> (1 2)
#_(filter (less-than 4) [-2 12 3 4 0]) ;=> (-2 3 0)
#_(filter (equal-to 2) [2 1 3 2.0])    ;=> (2 2.0)
#_(filter (equal-to 2) [3 4 5 6])      ;=> ()

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

#_(filter (set->predicate #{1 2 3})     [0 2 4 6])       ;=> (2)
#_(filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6]) ;=> (2 nil nil)

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)
               (pred2 x))))

#_(filter (pred-and pos? even?) [1 2 -4 0 6 7 -3]) ;=> [2 6]
#_(filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3]) ;=> [1 7]
#_(filter (pred-and (complement nil?) empty?) [[] '() nil {} #{}])
;=> [[] '() {} #{}]


(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)
              (pred2 x))))

#_(filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])  ;=> [1 2 6 7 -3]
#_(filter (pred-or pos? even?) [1 2 -4 0 6 7 -3]) ;=> [1 2 -4 0 6 7]

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (nil?   string)
      (every? whitespace? string)))

#_(blank? " \t\n\t ") ;=> true
#_(blank? "  \t a")   ;=> false
#_(blank? "")         ;=> true

#_(do
  (def china {:name "China Miéville", :birth-year 1972})
  (def octavia {:name       "Octavia E. Butler"
                :birth-year 1947
                :death-year 2006})
  (def kay {:name "Guy Gavriel Kay" :birth-year 1954})
  (def dick {:name "Philip K. Dick", :birth-year 1928, :death-year 1982})
  (def zelazny {:name "Roger Zelazny", :birth-year 1937, :death-year 1995})

  (def authors #{china, octavia, kay, dick, zelazny})

  (def cities {:title  "The City and the City" :authors #{china}
               :awards #{:locus, :world-fantasy, :hugo}})
  (def wild-seed {:title "Wild Seed", :authors #{octavia}})
  (def lord-of-light {:title  "Lord of Light", :authors #{zelazny}
                      :awards #{:hugo}})
  (def deus-irae {:title "Deus Irae", :authors #{dick, zelazny}})
  (def ysabel {:title "Ysabel", :authors #{kay}, :awards #{:world-fantasy}})
  (def scanner-darkly {:title "A Scanner Darkly" :authors #{dick}})

  (def books #{cities, wild-seed, lord-of-light,
               deus-irae, ysabel, scanner-darkly}))

(defn has-award? [book award]
  (contains? (:awards book) award))

#_(has-award? ysabel :world-fantasy) ;=> true
#_(has-award? scanner-darkly :hugo)  ;=> false


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)]
    (every? (fn [award] (contains? book-awards award)) awards)))



(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (cond (empty? filtered)        false
          (true? (pred (first filtered)))  true 
          :else                    (pred (first filtered)))))

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
  (let [filtered (filter pred a-seq)]
    (= (count filtered)
       (count a-seq))))

(my-every? pos? [1 2 3 4])   ;=> true
(my-every? pos? [1 2 3 4 0]) ;=> false
(my-every? even? [2 4 6])    ;=> true
(my-every? even? [])         ;=> true

(defn prime? [n]
  (let [pred (fn [x] (= (rem n x) 0))]
   (not (some pred (range 2 n)))))

(prime? 4) ;=> false
(prime? 7) ;=> true
(prime? 10) ;=> false
(filter prime? (range 2 50)) ;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)

;^^
