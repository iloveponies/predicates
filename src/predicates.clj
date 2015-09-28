(ns predicates)

(defn sum-f [f g x]
  (+ (g x) (f x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

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
  (let [evaluation (set (map (fn [x] (pred x)) a-seq))
        filtered (filter (fn [x] (not (= false x))) evaluation)]
    (if (< 0 (count filtered))
      (if (not (nil? (first filtered))) (first filtered) false)
      false)))

(defn my-every? [pred a-seq]
  (let [evaluation (filter (complement pred) a-seq)]
    (empty? evaluation)))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
