(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
)

(defn less-than [n]
  (fn [k] (< k n))
)

(defn equal-to [n]
  (fn [k] (== k n))
)

(defn set->predicate [a-set]
  (fn [x]
    (
      contains? a-set x
    )
  )
  ; (fn [x]
  ;   (if (and (contains? a-set nil) (contains? (set x) nil))  
  ;     (conj nil (vec (filter a-set x)))
  ;     (filter a-set x)
  ;   )
  ; )
)

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x) (pred2 x)))
)

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x) (pred2 x)))
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)
)

(defn has-award? [book award]
  (contains? (get book :awards) award)
)

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-one 
        (fn [a] (has-award? book a))] 
    (every? has-one awards)
  )
)

(defn my-some [pred a-seq]
  (if (empty? (filter pred a-seq))
  false
  (apply pred (filter pred a-seq))
  )
)

(defn my-every? [pred a-seq]
(empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred 
        (fn [divisor]
          (= 0 (mod n divisor)))]
    (not (some pred (range 2 n)))  
  )
)
;^^
