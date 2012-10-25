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
  (or (= nil string) (every? whitespace? string) (= "" string)))

(defn has-award? [book award]
  (let [functio? (fn [x] (= x award))]
  (< 0 (count (filter functio? (:awards book))))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [functior (fn [x] (has-award? book x))]
    (every? functior awards)))

(defn my-some [pred a-seq]
  (let [f (fn [x] (filter pred x))]
    (if (empty? (f a-seq))
      nil
      true)))

(defn my-every? [pred a-seq]
  (let [f (fn [x] (filter pred x))]
    (== (count a-seq) (count (f a-seq)))))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))