(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [item] (contains? a-set item)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (== (count string) 0) (every? whitespace? string)))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (if (nil? awards)
      false
      (boolean (awards award)))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-this-award? (fn [award] (has-award? book award))]
    (every? has-this-award? awards)))

(defn my-some [pred a-seq]
  (let [filter-res (filter pred a-seq)]
    (if (empty? filter-res)
      false
      (pred (first filter-res)))))

(defn my-every? [pred a-seq]
  (== (count a-seq) (count (filter pred a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
