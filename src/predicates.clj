(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn greater-than [n]
  (fn [k] (> k n)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [a] (contains? (:awards book) a)) awards))

(defn my-some [pred a-seq]
  (let [mapped (map pred a-seq)
        filtered (filter (fn[x] (not (= x false))) mapped)]
    (if (empty? filtered)
      false
      (first filtered))))

(defn my-every? [pred a-seq]
  (let [mapped (map pred a-seq)
        filtered (filter (fn [x] (not (= x true))) mapped)]
    (empty? filtered)))

(defn divides? [divisor n]
  (if (== 0 (mod n divisor))
    true
    false))

(defn prime? [n]
  (let [pred (fn [x] (divides? x n))]
    (not (some pred (range 2 n)))))
;^^
