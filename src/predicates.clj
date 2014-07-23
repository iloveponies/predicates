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
  (cond
   (nil? string) true
   (empty? string) true
   (every? whitespace? string) true
   :else false))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter (fn [x] (pred x)) a-seq))))

(defn my-every? [pred a-seq]
  (==
   (count (filter (fn [x] (pred x)) a-seq))
   (count a-seq)))

(defn prime? [n]
  (let [jako (fn [x] (not (== 0 (mod n x))))]
    (every? jako (range 2 (/ (+ 1 n) 2)))))
