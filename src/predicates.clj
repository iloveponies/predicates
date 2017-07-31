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
  (or (every? whitespace? string) (= 0 (count string))))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter (fn [x] (pred x)) a-seq)]
    (cond
      (empty? filtered) false
      (= pred first) (apply int (first filtered))
      :else true
    )))

(defn my-every? [pred a-seq]
  (let [filtered (filter (fn [x] ((complement pred) x)) a-seq)]
    (empty? filtered)))

(defn prime? [n]
  (let [pred (fn [x] (and (pos? (/ x x)) (pos? (/ x 1))))]
    (not (some pred (range 2 n)))))
;^^
