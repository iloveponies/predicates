(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [value] (contains? a-set value)))

(defn pred-and [pred1 pred2]
  (fn [value] (and (pred1 value) (pred2 value))))

(defn pred-or [pred1 pred2]
  (fn [value] (or (pred1 value) (pred2 value))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (contains? (:awards book) award)) awards))

(defn my-some [pred a-seq]
  (let [val (first (map pred (filter pred a-seq)))]
    (cond
     (nil? val) false
     :else val)))

(defn my-every? [pred a-seq]
  (= (count (filter pred a-seq)) (count a-seq)))

(defn prime? [n]
  (let [pred (fn[x] (= (rem n x) 0))]
    (not (some pred (range 2 n)))))
