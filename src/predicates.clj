(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [arg] (< arg n)))

(defn equal-to [n]
  (fn [arg] (== arg n)))

(defn set->predicate [a-set]
  (fn [arg] (contains? a-set arg)))

(defn pred-and [pred1 pred2]
  (fn [arg] (and (pred1 arg) (pred2 arg))))

(defn pred-or [pred1 pred2]
  (fn [arg] (or (pred1 arg) (pred2 arg))))

(defn pred-inverse [pred1]
  (fn [arg] (not (pred1 arg))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  ((pred-or
    (pred-and empty? nil?)
    (fn [arg] (every? whitespace? arg)))
   string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [result (first (filter (fn [arg] arg) (map pred a-seq)))]
    (if (nil? result)
      false
      result)))


(defn my-every? [pred a-seq]
  (==
   (count (filter pred a-seq))
   (count a-seq)))

(defn divisible? [x, y]
  (== 0 (mod x y)))

(defn prime? [n]
  (every?
   (fn [arg] (not (divisible? n arg)))
   (range 2 n)))
;^^
