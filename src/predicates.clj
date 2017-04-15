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
  (fn [x] (and(pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or(pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (= (my-some (complement pred) a-seq) nil))

(defn prime? [n]
  (let [divides (fn [n ps]
                   (let [p (first ps)]
                     (cond
                       (> (* p p) n)   true
                       (= (mod n p) 0) false
                       :else           (recur n (rest ps)))))]
    (divides n (conj (range 3 n 2) 2))))

;^^
