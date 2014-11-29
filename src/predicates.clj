(ns predicates)
;; GJG
;; (def china {:name "China Miéville", :birth-year 1972})
;; (def octavia {:name "Octavia E. Butler"
;;               :birth-year 1947
;;               :death-year 2006})
;; (def kay {:name "Guy Gavriel Kay" :birth-year 1954})
;; (def dick {:name "Philip K. Dick", :birth-year 1928, :death-year 1982})
;; (def zelazny {:name "Roger Zelazny", :birth-year 1937, :death-year 1995})

;; (def authors #{china, octavia, kay, dick, zelazny})

;; (def cities {:title "The City and the City" :authors #{china}
;;              :awards #{:locus, :world-fantasy, :hugo}})
;; (def wild-seed {:title "Wild Seed", :authors #{octavia}})
;; (def lord-of-light {:title "Lord of Light", :authors #{zelazny}
;;                     :awards #{:hugo}})
;; (def deus-irae {:title "Deus Irae", :authors #{dick, zelazny}})
;; (def ysabel {:title "Ysabel", :authors #{kay}, :awards #{:world-fantasy}})
;; (def scanner-darkly {:title "A Scanner Darkly" :authors #{dick}})

;; (def books #{cities, wild-seed, lord-of-light,
;;              deus-irae, ysabel, scanner-darkly})

(defn sum-f
  "returns (+ (f x) (g x))."
  [f g x]
  (+ (f x) (g x)))


(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

;;GJG
(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn set->predicate [a-set]
  (fn [x] (or (a-set x)
              (nil? x))))

(defn pred-and
  "returns a new predicate that:
  returns true if both pred1 and pred2 return true
  otherwise returns false"
  [pred1 pred2]
  (fn [x]
    (and (pred1 x)
         (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x)
        (pred2 x))))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (every? whitespace? string)
      (nil? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [hits (map #(has-award? book %) awards )]
    (or (empty? hits)
        (every? true? hits))))

;; (every? set->predicate (:awards book)) awards)



(defn my-some [pred a-seq]
  (first (filter #(not (= % false)) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (every? #(= % true) (map pred a-seq)))


(defn prime? [n]
  (let [divisors (range 2 n)] ;; range excluding n (every number can be divided by itself)
    (and (integer? n)
         (> n 1)
         (every? (fn [x] (= x false)) (map #(integer? (/ n %)) divisors)
                 ))))


                                        ;^^
