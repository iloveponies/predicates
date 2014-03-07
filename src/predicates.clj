(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (= x (a-set x))))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (not (nil? ((or (:awards book) #{}) award))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true? (map #(has-award? book %) awards)))

(defn my-some [pred a-seq]
  (first (filter #(not (false? %)) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (if (empty? (map pred a-seq))
              true
              (= 1 (count (keys (frequencies (map pred a-seq)))))))

(defn divides? [divisor n]
  (= 0 (mod n divisor)))

(defn prime? [n]
 (let [pred (fn [x] (divides? x n))]
    (not (some pred (range 2 n)))))
;^^
