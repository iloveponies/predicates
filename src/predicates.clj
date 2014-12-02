(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [v] (< v n)))

(defn equal-to [n]
  (fn [v] (== v n)))

(defn set->predicate [a-set]
  (fn [n] (contains? a-set n)))

(defn pred-and [pred1 pred2]
  (fn [n] (and (pred1 n)
               (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n)
              (pred2 n))))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

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

(defn has-award? [book award]
  (let [awards (:awards book :not-found)]
  (if (awards award)
    true
    false)))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %1) awards))

(defn my-some [pred a-seq]
  (if (= 0 (count (filter pred a-seq)))
    (first (filter pred a-seq))
    (pred (first (filter pred a-seq)))))



(defn my-every? [pred a-seq]
  (not (some false? (map pred a-seq))))


(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))

(prime? 4) ;=> false
(prime? 7) ;=> true
(prime? 10) ;=> false
(filter prime? (range 2 50)) ;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)

;^^
