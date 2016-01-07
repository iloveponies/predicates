(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
  )

(sum-f inc dec 4)
(sum-f inc identity 5)
(identity 5)
(sum-f identity - 10)


(defn less-than [n]
  (fn [k] (< k n))
  )


(defn equal-to [n]
  (fn [k] (== k n))

  )

(filter (less-than 3) [ 1 2 3 4])
(filter (less-than 4) [-2 12 3 4 0])

(def graphic-novels [{:name "Yotsuba 1" :series "Yotsuba"}
                     {:name "Yotsuba 5" :series "Yotsuba"}
                     {:name "Persepolis"}
                     {:name "That Yellow Bastard" :series "Sin City"}
                     {:name "The Hard Goodbye" :series "Sin City"}
                     {:name "Maus"}
                     {:name "Solanin"}
                     {:name "Monster 3" :series "Monster"}])

(filter :series graphic-novels)

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))
(filter (fn [x] ( contains? x "Name" )) [{"Name" "Joe"} {"Blargh" 3}])


(defn set->predicate [a-set]
  (fn [x] (contains? a-set x) )
  )


(filter (set->predicate #{1 2 3})     [0 2 4 6])
(filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6])



(defn pred-and [pred1 pred2]
  ;(and (fn[x] (pred1 x)) (fn[x] (pred2 x)))
  (and
    (fn[x] (and (pred1 x) (pred2 x)) )

   )
 )

(and 1 0)

(pos? 1)

(filter (fn [x] (pos? x)) [1 2 -4 0 6 7 -3])

(filter (pred-and pos? even?) [1 2 -4 0 6 7 -3])
(filter (pred-and pos? odd?) [1 2 -4 0 6 7 -3])
(filter (pred-and (complement nil?) empty?) [[] '() nil {} #{}])

(defn pred-or [pred1 pred2]

    (fn[x] (or (pred1 x) (pred2 x)) )


  )

(filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])
(filter (pred-or pos? even?) [1 2 -4 0 6 7 -3])

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
    (every? whitespace? string)
  )


(blank? " \t\n\t ")
(blank? "  \t a")
(blank? "")

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
    (not (blank? (apply str (map (fn[x] (= x award)) (:awards book)))))
  )

(has-award? ysabel :world-fantasy)
(has-award? scanner-darkly :hugo)



(defn HAS-ALL-THE-AWARDS? [book awards]
    (every? (:awards book) awards)
  )

(HAS-ALL-THE-AWARDS? cities #{:locus})
(HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo})
(HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo :pulitzer})
(HAS-ALL-THE-AWARDS? lord-of-light #{:locus :world-fantasy :hugo})
(HAS-ALL-THE-AWARDS? lord-of-light #{:hugo})
(HAS-ALL-THE-AWARDS? scanner-darkly #{})

(defn my-some [pred a-seq]
   (not (nil? (first (filter (fn[x] (true? x )) (map (fn[x]  (pred x) ) a-seq)))))
  )

(my-some even? [1 3 5 7])
(my-some even? [1 3 5 7 8])
(my-some neg? [1 3 5 0 7 8])
(my-some neg? [1 3 5 0 7 -1 8])
(my-some neg? [])
(my-some first [[false] [1]])

(defn my-every? [pred a-seq]
    ;(not (empty? (map (fn[x] (= (complement x) true)) (map (fn[x] (pred x) ) a-seq))))
    (empty? (filter (fn[x] (= x false)) (map (fn[x] (pred x) ) a-seq)))
  )

(complement false)
(my-every? pos? [1 2 3 4])
(my-every? pos? [1 2 3 4 0])
(my-every? even? [2 4 6])
(my-every? even? [])


(defn prime? [n]

   (every? (fn[x] (not (= 0 x))) (map (fn[x] (mod n x)) (range 2 n)))

)

(prime? 4)
(prime? 7)
(prime? 10)
(filter prime? (range 2 50))
;^^
