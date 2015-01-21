(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== n k)))

(defn set->predicate [a-set]
  (fn [a-value] (contains? a-set a-value)))

(defn pred-and [pred1 pred2]
  (fn [a-value] (and (pred1 a-value) (pred2 a-value))))

(defn pred-or [pred1 pred2]
  (fn [a-value] (or (pred1 a-value) (pred2 a-value))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string) (nil? string) (every? whitespace? string)))

(defn has-award? [book award]
  (keyword? (award (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [number]
               ((complement ratio?) (/ n number)))]
    (not (some pred (range 2 n)))))
