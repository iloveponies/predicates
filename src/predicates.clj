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

  (fn [val] (contains? a-set val))

  )


(defn pred-and [pred1 pred2]

  (fn [val] (and (pred1 val) (pred2 val)))

  )


(defn pred-or [pred1 pred2]
  (fn [val] (or (pred1 val) (pred2 val)))
  )


(defn whitespace? [character]
  (Character/isWhitespace character))


(defn blank? [string]

  (cond
   (nil? string) true
   (every? whitespace? string) true
   :else
   false
   )

  )


(defn has-award? [book award]
    (contains? (:awards book) award)
  )




(defn HAS-ALL-THE-AWARDS? [book awards]

  (every? (set->predicate (:awards book)) awards)

  )


(defn my-some [pred a-seq]


    (let

      [ret (some pred a-seq)]


      (cond

       (nil? ret) false
       (true? ret) true
       :else
       ret
       )
  )
)


(defn my-every? [pred a-seq]
   ( = false (my-some (complement pred) a-seq))

)


(defn prime? [n]


    (every? (complement (fn[k] (== 0 (mod n k )))) (range 2 n))


  )

;^^
