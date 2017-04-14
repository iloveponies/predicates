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
  (fn [x] (if (and (pred1 x) (pred2 x)) true false)))

(defn pred-or [pred1 pred2]
  (fn [x] (if (or (pred1 x) (pred2 x)) true false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [arr (char-array string)]
    (every? whitespace? arr)))

(defn has-award? [book award]
  (if (contains? (:awards book) award) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter (complement nil?) (filter (complement false?) (map pred a-seq)))]
    (if (empty? filtered) false (first filtered))))

(defn my-every? [pred a-seq]
  (let [mapped (set (map pred a-seq))]
    (if (contains? mapped false) false true)))

(defn prime? [n]
  (empty? (filter #(= 0 (mod n  %)) (range 2 n))))
;^^
