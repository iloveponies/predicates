(ns predicates)
;; Graphic Novels
(comment (def graphic-novels [{:name "Yotsuba 1" :series "Yotsuba"}
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
                      deus-irae, ysabel, scanner-darkly}))

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)
               (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)
              (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award)
  #_((set->predicate (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards)
  #_(every? #(contains? (:awards book) %) awards)
  #_(every?  (set->predicate (:awards book)) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
