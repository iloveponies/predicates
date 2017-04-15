(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [arg] (< arg n)))

(defn equal-to [n]
  (fn [arg] (== arg n)))

(defn set->predicate [a-set]
  (fn [x] (= x (a-set x))))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (set (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn[award](has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [first-item (get (vec (filter pred a-seq)) 0 false)]
    (if(= first-item false)
      false
      (pred first-item))))

(defn my-every? [pred a-seq]
 (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [is-divisible? (fn[x] (== 0 (mod n x)))]
    (not (some is-divisible? (range 2 n)))))
;^^





