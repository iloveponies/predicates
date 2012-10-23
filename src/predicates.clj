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
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  ((complement empty?) (filter (fn [aw] (= aw award)) (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (cond (empty? a-seq)        false
        (pred (first a-seq))  true 
        :else                 (my-some pred (rest a-seq))))

(defn my-every? [pred a-seq]
  (not (my-some (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [k] (== (mod n k) 0))]
    (not (some pred (range 2 n)))))