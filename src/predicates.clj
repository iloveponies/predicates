(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n )))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (if (contains? a-set x) true false)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]

    (every? whitespace? string))


(defn has-award? [book award]

    (contains? (:awards book) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

 (defn my-some [pred a-seq]  (let [result (filter (fn [x] (not (false? x))) (filter (complement nil?) ( map pred a-seq)))] (if (nil? result) false (let [[a &more] result] (-> a)))))


(defn my-every? [pred a-seq] (empty? (filter (complement true?) (map pred a-seq))))

(defn prime? [n] ( let [pred (fn [x] (= (mod  n x) 0))] (not (some pred (range 2 n)))))

