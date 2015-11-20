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
  (fn [a] (and (pred1 a) (pred2 a))))

(defn pred-or [pred1 pred2]
  (fn [a] (or (pred1 a) (pred2 a))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [award] (has-award? book award))]
    (every? book-has-award? awards)))

(defn truthy? [x]
  (if x true false))

(defn falsey? [x]
  (not (truthy? x)))

(defn my-some [pred a-seq]
  (first (filter truthy? (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter falsey? (map pred a-seq))))

(defn prime? [n]
  (let [can-divide-n? (fn [x] (== (mod n x) 0))]
   (not (some can-divide-n? (range 2 n)))))
;^^
