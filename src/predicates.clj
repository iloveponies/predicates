(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [i] (< i n)))

(defn equal-to [n]
  (fn [i] (== i n)))

(defn set->predicate [a-set]
  (fn [a-param] (contains? a-set a-param)))

(defn pred-and [pred1 pred2]
  (fn [p] (and (pred1 p) (pred2 p))))

(defn pred-or [pred1 pred2]
  (fn [p] (or (pred1 p) (pred2 p))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (contains? (:awards book) award)) awards))

(defn my-some [pred a-seq]
  )

(defn my-every? [pred a-seq]
  (== (count (filter false? (map pred a-seq))) 0))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))])
  (not (some pred (range 2 n))))
;^^

