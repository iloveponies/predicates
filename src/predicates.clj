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
  (fn [arg] (and (pred1 arg) (pred2 arg))))

(defn pred-or [pred1 pred2]
  (fn [arg] (or (pred1 arg) (pred2 arg))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (zero? (count string))
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [result (filter pred a-seq)]
    (if result
      (first (map pred result)) false)))

(defn my-every? [pred a-seq]
  (empty? (filter true? (map (complement pred) a-seq))))

(defn prime? [n]
  (let [pred #(zero? (mod n %))]
    (not (some pred (range 2 n)))))

;; ^^
