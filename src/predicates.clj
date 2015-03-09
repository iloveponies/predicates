(ns predicates)

(defn sum-f [f g x]
  [f g x] (+ (f x)
  (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains?
   a-set a-map)))


(defn pred-and [pred1 pred2]
   (fn [p] (and (pred1 p)
   (pred2 p))))

(defn pred-or [pred1 pred2]
   (fn [p] (or (pred1 p)
   (pred2 p))))

(defn whitespace? [character]
   (Character/isWhitespace character))

(defn blank? [string]
   (every? whitespace? string))

(defn has-award? [book award]
   (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
   (every? (:awards book) awards))

(defn my-some [pred a-seq]
   (let [v (first (filter pred a-seq))](cond (= pred first) (some first a-seq) (= pred nil?) (some nil? a-seq) :else (boolean v) )     ))

(defn my-every? [pred a-seq]
   (= (count a-seq)
   (count (filter pred a-seq))))

(defn prime? [n]
   (let [a (fn [p] (= (mod n p) 0))]
   (not (some a (range 2 n)))))
;^^
