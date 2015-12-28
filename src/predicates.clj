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
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [k] (has-award? book k)) awards))

(defn my-some [pred a-seq]
  (first (filter (fn [k] (if k true)) (map (fn [k] (pred k)) a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map (fn [x] (pred x)) a-seq))))

(defn prime? [n]
  (let [pred (fn [k] (integer? (/ n k)))]
    (not (some pred (range 2 n)))))
;^^
