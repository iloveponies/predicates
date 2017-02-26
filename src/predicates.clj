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
    (fn [elem] (contains? a-set elem))
)

(defn pred-and [pred1 pred2]
    (fn [elem] (and (pred1 elem) (pred2 elem)))
)

(defn pred-or [pred1 pred2]
    (fn [elem] (or (pred1 elem) (pred2 elem)))
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)
)

(defn has-award? [book award]
  (contains? (:awards book) award)
)

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [award] (has-award? book award))]
  (every? book-has-award? awards))
)

(defn my-some [pred a-seq]
   (> (count (filter pred a-seq)) 0)
)

(defn my-every? [pred a-seq]
    (= (count (filter pred a-seq)) (count a-seq))
)

(defn prime? [n]
   (let[pred (fn [d] (= (mod n d) 0))] 
   (not (some pred (range 2 n))))
)