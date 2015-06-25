(ns predicates)

(defn sum-f [f g x]
  (+(f x) (g x))
)

(defn less-than [n]
  (fn[k](< k n))
)

(defn equal-to [n]
  (fn [k] (== k n))
)

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x))  
)

(defn pred-and [pred1 pred2]
  (fn [x] (= (pred1 x) (pred2 x) true))
)

(defn pred-or [pred1 pred2]
  (fn [x] (or (= (pred1 x) true) (= (pred2 x) true)))
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond (or (nil? string) (empty? string) (every? whitespace? string)) true :else false)
)

(defn has-award? [book award]
  (contains? (book :awards) award)
)

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards)
)

(defn my-some [pred a-seq]
  (let [
        x (map pred a-seq)
        y (filter (fn [y] (and (not= y false) (not= y nil))) x)
        ]
  (cond (or (> (count y) 0) (not (nil? (first y)))) (first y) :else false ))
  ;(some pred a-seq)
)

(defn my-every? [pred a-seq]
  (let[
       x (map pred a-seq)
       y (filter (fn [y] (and (not= y false) (not= y nil))) x)
       ]
     (cond (== (count y) (count x))  true :else false)
    )
  ;(every? pred a-seq)
)

(defn prime? [n]
  (let[
      chk (fn [x] (== (mod n x) 0))
      res (not (some chk (filter (fn[y] (not (even? y))) (range 2 n))))
      
      ]
    (cond (or (and (not (even? n)) (= res true) (> n 2)) (== n 2)) true :else false)
    )
)
;^^
