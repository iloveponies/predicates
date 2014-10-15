(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [ele](contains? a-set ele)))

(defn pred-and [pred1 pred2]
  (fn [x]  (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]  (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? #(or (whitespace? %) (= % "") (= % nil)) string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
   (every? #(has-award? book %) awards))

;(defn my-some [pred a-seq]
;  (if (empty?(filter pred a-seq))
;  nil
;  first(filter pred a-seq)))

(defn my-some [pred a-seq]
  (let [ result  (filter pred a-seq)]
    (if (empty? result)
      nil
      (pred(first result)))))

(defn my-every? [pred a-seq]
  (empty?(filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn prime-helper [k] (== 0 (mod n k)))]
    (not (some pred (range 2 n)))))
;^.^

(boolean "")
(filter (set->predicate #{1 2 3 nil})     [0 2 nil 4 6 nil])

(blank? "")


;(def ysabel {:title "Ysabel", :authors #{kay}, :awards #{:world-fantasy}})

;(has-award? ysabel :world-fantasy)

;(contains? ysabel :award)

(my-some even? [1  3])

(filter prime? (range 2 50))



(my-some even? [1 3 5 7])       ;=> falsey
(my-some even? [1 3 5 7 8])     ;=> true
(my-some neg? [1 3 5 0 7 8])    ;=> falsey
(my-some neg? [1 3 5 0 7 -1 8]) ;=> true
(my-some neg? [])               ;=> falsey
(my-some first [[false] [1]])   ;=> 1
(my-some first [[false] []])    ;=> falsey
(my-some nil? [1 2])            ;=> falsey
(my-some nil? [1 nil 2])        ;=> true
