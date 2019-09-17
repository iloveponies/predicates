(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (> n k)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map]
    (contains? a-set a-map)))

(defn pred-and [pred1 pred2]
  (fn [coll]
    (and (pred1 coll)
         (pred2 coll))))

(defn pred-or [pred1 pred2]
  (fn [coll]
    (or (pred1 coll)
        (pred2 coll))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn not-falsey []
  (fn [coll]
  (not ((pred-or false? nil?) coll))))

(defn my-some [pred a-seq]
  (first (filter (not-falsey) (map pred a-seq))))


(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
  (reduce #(true? (pred %2)) pred a-seq)))

(/ 6 2)
(defn prime? [n]
  (let [pred (fn [i]
               (and (not= i n)
                    (integer? (/ n i))))]
    (not (some pred (range 2 n)))))
;^^
