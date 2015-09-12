(ns predicates)


;(def china {:name "China Miéville", :birth-year 1972})
;(def octavia {:name "Octavia E. Butler"
;                            :birth-year 1947
;                                          :death-year 2006})
;(def kay {:name "Guy Gavriel Kay" :birth-year 1954})
;(def dick {:name "Philip K. Dick", :birth-year 1928, :death-year 1982})
;(def zelazny {:name "Roger Zelazny", :birth-year 1937, :death-year 1995})
;
;(def authors #{china, octavia, kay, dick, zelazny})
;
;(def cities {:title "The City and the City" :authors #{china}
;                          :awards #{:locus, :world-fantasy, :hugo}})
;
;(def wild-seed {:title "Wild Seed", :authors #{octavia}})
;(def lord-of-light {:title "Lord of Light", :authors #{zelazny}
;                                        :awards #{:hugo}})
;
;(def deus-irae {:title "Deus Irae", :authors #{dick, zelazny}})
;(def ysabel {:title "Ysabel", :authors #{kay}, :awards #{:world-fantasy}})
;(def scanner-darkly {:title "A Scanner Darkly" :authors #{dick}})
;
;(def books #{cities, wild-seed, lord-of-light,
;                          deus-irae, ysabel, scanner-darkly})
;
(defn sum-f [f g x]
  (+ (f x) (g x))) ;could do inc dec identity

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-key] (if (contains? a-set a-key) true false)))

(defn pred-and [pred1 pred2]
  (fn [param] (and (pred1 param) (pred2 param))))

;(filter (pred-and pos? even?) [1 2 -4 0 6 7 -3])

(defn pred-or [pred1 pred2]
  (fn [param] (or (pred1 param) (pred2 param))))

;(filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])  ;=> [1 2 6 7 -3]

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (= (count (filter (set->predicate (:awards book)) awards))
  (count awards)))

;  (let [is-in-book-awards (fn [book award] (has-award? book award))]
;   every? has-award? book award ))
;(HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo})
;(HAS-ALL-THE-AWARDS? cities #{:locus :world-fantasy :hugo :pulitzer})
(defn my-some [pred a-seq]
  (let [processed-seq (map pred a-seq) 
        is-true? (fn [bool] (boolean bool))
        ret (first (filter is-true? processed-seq))] 
        (if ret ret false)))

;(my-some even? [1 3 5 7])       ;=> falsey
;(my-some even? [1 3 5 7 8])     ;=> true
;(my-some neg? [1 3 5 0 7 8])    ;=> falsey
;(my-some neg? [1 3 5 0 7 -1 8]) ;=> true
;(my-some neg? [])               ;=> falsey
;(my-some first [[false] [1]])   ;=> 1
;(my-some first [[false] []])    ;=> falsey
;(my-some nil? [1 2])            ;=> falsey
;(my-some nil? [1 nil 2])        ;=> true
(defn my-every? [pred a-seq]
  (= (count (filter pred a-seq)) (count a-seq)))

(defn prime? [n]
  (let [pred (fn [divisor] (= (mod n divisor) 0))]
    (not (some pred (range 2 n)))))
;^^
