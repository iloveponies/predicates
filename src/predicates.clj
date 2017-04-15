(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-val] (contains? a-set a-val)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (not string)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
  (if(empty? filtered)
    false
    (pred (first filtered)))))

(defn my-every? [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (== (count a-seq) (count filtered))))

(defn prime? [n]
  (let [pred (fn [k] (== 0 (mod n k)))]
    (not (some pred (range 2 n)))))

(prime? 8)
;^^

