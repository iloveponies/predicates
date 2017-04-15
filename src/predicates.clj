(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
   (fn [x] (> n x)))

(defn equal-to [n]
  (fn [x] (== n x)))

(defn set->predicate [a-set]
  (fn [x] ( contains? a-set x )))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

;(blank? "desdi")

(defn has-award? [book award]
  (contains? (get book :awards) award) )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (contains? (get book :awards) award)) awards))

(defn my-some [pred a-seq]
  (let [results (set (map pred a-seq))]
    (first (filter (complement nil?) results))))

;(my-some whitespace? "Kekkonen Kekkonen")
;(my-some even? [1 3 5 7 8])
;(my-some neg? [1 3 5 0 7 8])

;(my-some first [[false] [1]])
;(my-some first [[false] []])

(defn my-every? [pred a-seq]
  (let [results (map pred a-seq)]
    (if (contains? (set (filter false? results)) false) false true)))

;(my-every? even? [2 4 6])
;(my-every? pos? [1 2 3 4 0])

(defn prime? [n]
  (let [is-divisible-by (fn [x] (= (mod n x) 0))]
    (not (some is-divisible-by (range 2 n)))))

;(prime? 4) ;should be falsey
;(prime? 7) ;should be truethsy
;(filter prime? (range 2 50))

;~^o^~



