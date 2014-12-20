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
  (fn [x] (contains? a-set x))
  )

(defn non-negatives [a-seq]
  (filter (complement neg?) a-seq))

(defn andp [& fns]
  (fn [& args]
    (every? #(apply % args) fns)))

(defn pred-and [pred1 pred2]
(andp pred1 pred2)
)
(defn pred-or [pred1 pred2]
  (some-fn pred1 pred2)
)
(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
(or (empty? string) (nil? string) (every? whitespace? string))
)

(defn has-award? [book award]
 (contains? (:awards book) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards)
  )

(defn my-some [pred a-seq]
  (cond (= first pred) (first(first (filter pred a-seq)))
        :else  (not (empty? (filter pred a-seq)))
        )
  )

(defn my-every? [pred a-seq]
  (== (count (filter pred a-seq)) (count a-seq))
  )

(defn prime? [n]
(let [pred (fn [x] (== 0 (mod n x)))]
	 (not (some pred (range 2 n))))
  )
;^^
