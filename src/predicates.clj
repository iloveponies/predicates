(ns predicates)

(def graphic-novels [{:name "Yotsuba 1" :series "Yotsuba"}
                     {:name "Yotsuba 5" :series "Yotsuba"}
                     {:name "Persepolis"}
                     {:name "That Yellow Bastard" :series "Sin City"}
                     {:name "The Hard Goodbye" :series "Sin City"}
                     {:name "Maus"}
                     {:name "Solanin"}
                     {:name "Monster 3" :series "Monster"}])

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

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn[k] (< k n)))

(defn equal-to [n]
  (fn[k] (= k n)))

(defn set->predicate [a-set]
  (fn[a-map] (contains? a-set a-map)))

(defn pred-and [pred1 pred2]
  (fn[x](and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn[x](or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if(= (count string) 0)
    true
    (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn[award](contains? (book :awards) award)) awards))

(defn my-some [pred a-seq]
  (if (some pred a-seq) (some pred a-seq) false))

(defn my-every? [pred a-seq]
  (pred a-seq))

(defn prime? [n]
  (let [pred (fn[div] (= (mod n div) 0))]
    (not (some pred (range 2 n)))))

;^^