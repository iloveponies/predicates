(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== n x)))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

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
  (let [pred1 (contains? book :awards)
        pred2 (contains? (:awards book) award)]
  (and pred1 pred2)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [award] (has-award? book award))]
    (every? book-has-award? awards)))


(defn my-some [pred a-seq]
  (let [preds (map pred a-seq)]
    (first (filter boolean preds))))

(defn my-every? [pred a-seq]
  (let [preds (map pred a-seq)]
    (empty? (filter (complement boolean) preds))))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (rem n x)))]
    (not (some pred (range 2 n)))))

;^^
