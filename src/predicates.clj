(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [item] (contains? a-set item)))

(defn pred-and [pred1 pred2]
  (fn [item] (and (pred1 item) (pred2 item))))

(defn pred-or [pred1 pred2]
  (fn [item] (or (pred1 item) (pred2 item))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (filter (fn [x] (not (= false x))) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (= (filter pred a-seq) a-seq))

(defn prime? [n]
  (let [pred (fn [x] (integer? (/ n x)))]
    (not (some pred (range 2 n)))))
;^^
