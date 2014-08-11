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
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [evalres (map (fn [curval] (pred curval)) a-seq)]
    (let [matches (filter (fn [v] v) evalres)]
      (if (> (count matches) 0) (first matches) false))))

(defn my-every? [pred a-seq]
  (let [evalres (map (fn [curval] (if (pred curval) true nil)) a-seq)]
    (= (count (filter (fn [v] v) evalres)) (count a-seq))))

(defn prime? [n]
  (let [pred (fn [v] (= (rem n v) 0))]
    (not (some pred (range 2 n)))))
;^^
