(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [n] (and (pred1 n) (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n) (pred2 n))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [k (filter pred a-seq)]
    (if (empty? k)
      nil
      (pred (first k)))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
	(== (count a-seq) (count (filter pred a-seq)))))

(defn prime? [n]
  (let [divisible? ( fn [k] (== 0 (mod n k)))]
    (not (some divisible? (range 2 n)))))
;^^
