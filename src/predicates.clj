(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  #(and (pred1 %) (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %) (pred2 %)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))


(comment
;; Only for REPL testing
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

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (first (filter #(boolean %) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (apply = true (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [pred #(= 0 (mod n %))]
    (not (some pred (range 2 n)))))
