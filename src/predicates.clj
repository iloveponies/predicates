(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [item] (contains? a-set item)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [ prizes (:awards book)]
    (contains? prizes award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [ check-award? (fn [award] (has-award? book award))]
    (every? check-award? awards)))

(defn my-some [pred a-seq]
  (let [results (filter pred a-seq)]
     (if (= () results)
       false
       (pred (first results)))))

(defn my-every? [pred a-seq]
  (let [results (filter pred a-seq)]
     (if (= (count a-seq) (count results))
         true
         false)))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (rem n x)))]
     (not (some pred (range 2 n)))))
;^^
