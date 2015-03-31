(ns predicates)

(defn sum-f [f g x]
    (+ (f x) (g x))
  )

(defn less-than [n]

  ( fn [k] (< k n) )

)



(defn equal-to [n]
  ( fn [k] (== k n) )
)

(defn set->predicate [a-set]
  (fn [a-map]  (contains? a-set a-map  ) )
  )

(defn pred-and [pred1 pred2]

  (   fn[ n]  ( if (and (pred1 n) (pred2 n) ) true false) )
  )

(defn pred-or [pred1 pred2]
  (   fn[ n]  ( if (or (pred1 n) (pred2 n) ) true false) )
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]

   (if (or (every? whitespace? string ) ) true false) ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
)



(defn has-award? [book award]
   (contains? (:awards book) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards] (every? (fn [award] (has-award? book award)) awards))


(defn my-some [pred a-seq]
  (let  [ abc (filter  (complement  false?) ( map pred a-seq ) )]
    (if ( = (first abc) nil  ) false (first abc))
  )
)


(defn my-every? [pred a-seq]
  (if (= (first (filter  (complement  true?) ( map pred a-seq  ))) nil) true false)
  )



(defn prime? [n]
(let [divisible-by (fn [yy] (= (mod n yy) 0))] (not (some divisible-by (range 2 n)))))

;^^
