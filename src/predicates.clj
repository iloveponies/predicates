(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [other] (< other n)))

(defn equal-to [n]
  (fn [other] (== n other)))

(defn set->predicate [a-set]
  (fn [x]
    (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards))

(defn my-some [pred a-seq]
  (first (set (map pred a-seq))))

(defn my-every? [pred a-seq]
  (let [results (set (map pred a-seq))]
    (cond
      (empty? results) true
      (= 1 (count results)) (first results)
      :else false)))

(defn prime? [n]
  (let [divides? (fn [a] (= (rem n a) 0))
        pred (fn [x] (some divides? (range 2 x)))]
    (not (some pred (range 2 n)))))
;^^
