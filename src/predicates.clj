(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [n] (contains? a-set n)))

(defn pred-and [pred1 pred2]
 (fn [n] (and (pred1 n) (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n) (pred2 n))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? (seq string)))

(defn has-award? [book award]
 (boolean (award (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? 
    (fn [award] (has-award? book award)) 
    awards))

(defn my-some [pred a-seq]
  (let 
    [filtered-seq (filter pred a-seq)]
    (if (not (empty? filtered-seq))
      (pred (first filtered-seq))
      false)))
    

(defn my-every? [pred a-seq]
  )

(defn prime? [n]
  :-)
;^^
