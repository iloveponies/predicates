(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [key] (contains? a-set key)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string) (nil? string) (= string "")))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [val (first (filter pred a-seq))]
    (if (= nil val) (contains? (set a-seq) nil) (if (= pred nil?) true (pred val)))))

(defn my-every? [pred a-seq]
  (= (filter pred a-seq) a-seq))

(defn prime? [n]
  (let [divides? (fn [x] (= (mod n x) 0))]
    (not (some divides? (range 2 n)))))
;^^
