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
  (every? (pred-or whitespace? nil?) string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (book :awards) awards))

(defn my-some [pred a-seq]
  (if (empty? (filter pred a-seq))
    false
    (pred (first (filter pred a-seq)))))

(defn my-every? [pred a-seq]
  (= a-seq (filter pred a-seq)))

(defn prime? [n]
  ; (fn [k] (== k n)))
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
