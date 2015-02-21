(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x]  (> (count(filter (fn [y]  (= x y)) a-set)) 0)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string) (every? whitespace? string) (not string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true? (map (fn [x] (has-award? book x)) awards)))

(defn my-some [pred a-seq]
  (let [value (set (map pred a-seq))]
    (if (first value) (first value) (second value))))

(defn my-every? [pred a-seq]
  (let [value (set (map pred a-seq))]
    (if (or (> (count value) 1) (= (get value 0) false)) false true)))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
