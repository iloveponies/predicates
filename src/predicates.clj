(ns predicates)

(def china {:name "China Miéville", :birth-year 1972})
(def octavia {:name "Octavia E. Butler"
              :birth-year 1947
              :death-year 2006})
(def kay {:name "Guy Gavriel Kay" :birth-year 1954})
(def dick {:name "Philip K. Dick", :birth-year 1928, :death-year 1982})
(def zelazny {:name "Roger Zelazny", :birth-year 1937, :death-year 1995})

(def authors #{china, octavia, kay, dick, zelazny})

(def cities {:title "The City and the City" :authors #{china}
             :awards #{:locus, :world-fantasy, :hugo}})
(def wild-seed {:title "Wild Seed", :authors #{octavia}})
(def lord-of-light {:title "Lord of Light", :authors #{zelazny}
                    :awards #{:hugo}})
(def deus-irae {:title "Deus Irae", :authors #{dick, zelazny}})
(def ysabel {:title "Ysabel", :authors #{kay}, :awards #{:world-fantasy}})
(def scanner-darkly {:title "A Scanner Darkly" :authors #{dick}})

(def books #{cities, wild-seed, lord-of-light,
             deus-irae, ysabel, scanner-darkly})

(contains? (get ysabel :awards) :world-fantasy)
(contains? (get deus-irae :awards) 3)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [key] (contains? a-set key)))

(filter (set->predicate #{1 2 3})     [0 2 4 6])       ;=> (2)
(filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6]) ;=> (2 nil nil)

(defn pred-and [pred1 pred2]
  (fn [key] (and (pred1 key) (pred2 key))))

(defn pred-or [pred1 pred2]
  (fn [key] (or (pred1 key) (pred2 key))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? (seq string)))

(blank? " \t\n\t ") ;=> true
(blank? "  \t a")   ;=> false
(blank? "")         ;=> true

(defn has-award? [book award]
  (contains? (get book :awards) award))

(has-award? ysabel :world-fantasy) ;=> true
(has-award? scanner-darkly :hugo)  ;=> false

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (get book :awards)) awards))


(seq #{:locus :world-fantasy :hugo :pulitzer})
(seq #{:locus :world-fantasy :hugo})

(HAS-ALL-THE-AWARDS? cities #{:locus})
;=> tru
(HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo})
;=> true
(HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo :pulitzer})
;=> false
(HAS-ALL-THE-AWARDS? lord-of-light #{:locus :world-fantasy :hugo})
;=> false
(HAS-ALL-THE-AWARDS? lord-of-light #{:hugo})
;=> true
(HAS-ALL-THE-AWARDS? scanner-darkly #{})

(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
