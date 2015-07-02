(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x]
    (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
   (empty? string) true
   (nil? string) true
   (every? whitespace? string) true
   :else false))


(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every?
   (fn [x] (has-award? book x))
   awards))

(defn my-some [pred a-seq]
  (let [filtered (filter (fn [x] (pred x)) a-seq)]
    (if (empty? filtered) false (pred (first filtered)))))

(defn my-every? [pred a-seq]
  (let [filtered (filter (fn [x] (pred x)) a-seq)
        filtered-size (count filtered)
        a-seq-size (count a-seq)]
    (= filtered-size a-seq-size)))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))













;^^
