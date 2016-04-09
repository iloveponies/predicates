(ns predicates)

(defn sum-f [f g x]
  (+ (f x)(g x))

  )

(defn less-than [n]
  (fn[k] (< k n)))

(defn equal-to [n]
   (fn[k] (== k n)))

(defn set->predicate [a-set]
   (fn [k] (contains? a-set k)))


(defn pred-and [pred1 pred2]
 (fn[x] (and (pred1 x)(pred2 x ))              )
 )


(defn pred-or [pred1 pred2]
  (fn[x] (or (pred1 x)(pred2 x))
    )
 )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))


(defn has-award? [book award]
  (contains? (:awards book) award)

)


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [ has-award-pred (fn[a] (has-award? book a) )]

  ( every? has-award-pred awards)


  )
  )



(defn my-some [pred a-seq]
 (let [s (filter pred a-seq)]

   (if (not (empty? s)) ( pred(first s) ) false)
   )

  )



(defn my-every? [pred a-seq]
  (let [s (filter pred a-seq)]

   ( if (empty? a-seq) true (==(count a-seq) (count s)) )


 ))



(defn prime? [n]
  (let [pred (fn[x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
