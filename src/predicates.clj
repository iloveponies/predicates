(ns predicates)

(defn sum-f [f g x]
 (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n )))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [s (filter (complement whitespace?) string)
        l (count s)]
    (== 0 l)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [n (count awards)
        contained (filter (:awards book) awards)]
    (== n (count contained))))

(defn my-some [pred a-seq]
  (let [bs (map pred a-seq)
        f (fn [x] (boolean x))
        trues (filter f bs)]
    (first trues)))


(defn my-every? [pred a-seq]
  (let [trues (filter pred a-seq)
        c (count a-seq)]
    (== c (count trues))))

(defn prime? [n]
  (let [testers (range 2 (- n 1))
        test (fn [t] (not (== 0 (rem n t))))]
    (if (> n 1)
    (my-every? test  testers)
      false)))
;^^
