(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))


(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [v] (contains? a-set v)))

(defn pred-and [pred1 pred2]
  (fn [v] (and (pred1 v) (pred2 v))))

(defn pred-or [pred1 pred2]
  (fn [v] (or (pred1 v) (pred2 v))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string)
    (empty? string)))

(defn has-award? [book award]
  (and (contains? book :awards)
       (contains? (:awards book) award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [a] (has-award? book a)) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)
        r (first filtered)]
    (if (coll? r) (first r)
      (> (count filtered) 0))))

(defn my-every? [pred a-seq]
  (not (my-some (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [d] (= 0 (mod n d)))]
    (not (some pred (range 2 n)))))
;^^
