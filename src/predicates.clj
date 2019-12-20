(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (if (pred1 x) (if (pred2 x) true false) false)))

(defn pred-or [pred1 pred2]
  (fn [x] (if (pred1 x) true (if (pred2 x) true false))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
    (= nil string) true
    (= (count string) 0) true
    (every? whitespace? string) true
    :else false))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (if (< 0 (count (filter (fn [x] x) (map pred a-seq)))) 
    (first (filter (fn [x] x) (map pred a-seq)))
    false))

(defn my-every? [pred a-seq]
  (if (< 0 (count (filter (fn [x] (not x)) (map pred a-seq)))) false true))

(defn prime? [n]
  (let [pred (fn [x] (if (= 0 (mod n x)) true false))]
    (not (some pred (range 2 n)))))
;^^
