(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [v] (contains? a-set v)))

(defn pred-and [pred1 pred2]
  (fn [v] (and (pred1 v) (pred2 v))))

(defn pred-or [pred1 pred2]
  (fn [v] (or (pred1 v) (pred2 v))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (= awards (set (filter #(has-award? book %) awards))))

(defn my-some [pred a-seq]
  (first (map pred (filter #(pred %) a-seq))))


(defn my-every? [pred a-seq]
  (or (empty? a-seq)  (not (some (complement pred) a-seq))))


(my-every? pos? [1 2 3 4])

(defn prime? [n]
  (let [divided-without-remant? (fn [d] (== (mod n d) 0))]
    (every? (complement divided-without-remant?) (range 2 n))))

;^^
