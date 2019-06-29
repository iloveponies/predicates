(ns predicates)

(defn sum-f [f g x]
   (+ (f x) (g x))
  )

(defn less-than [n]
  #(< % n)
  )

(defn equal-to [n]
  #(== % n)
  )

(defn set->predicate [a-set]
  #(contains? a-set %)

  )

(comment (defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)  (pred2 x)))))

(defn pred-and [pred1 pred2]
  #(and (pred1 %)  (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %) (pred2 %))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]

  (or (empty? string) (nil? string) (every?  whitespace? string)))



(defn has-award? [book award]
  (> (count (filter (set->predicate (get book :awards)) (conj #{} award))) 0 ))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (clojure.set/subset? awards (get book :awards) )
  )

(defn my-some [pred a-seq]
  (> (count  (filter pred  a-seq)) 0))

(defn my-every? [pred a-seq]
  (not (my-some (complement pred) a-seq)))

(defn prime? [n]

  (let [pred #(== (mod n %) 0)]

  (not (some pred (range 2 n)))))
;^^
