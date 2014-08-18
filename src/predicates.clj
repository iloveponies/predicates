(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [elem] (< elem n)))

(defn equal-to [n]
  (fn [elem] (== elem n)))

(defn set->predicate [a-set]
  (fn [elem] (contains? a-set elem)))

(defn pred-and [pred1 pred2]
  (fn [elem] (and (pred1 elem) (pred2 elem))))

(defn pred-or [pred1 pred2]
  (fn [elem] (or (pred1 elem) (pred2 elem))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-pred? (fn [award] (has-award? book award))]
    (every? book-pred? awards)))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [elem] (= (mod n elem) 0))]
    (not (some pred (range 2 n)))))
;^^
