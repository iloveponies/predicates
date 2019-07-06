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
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [{awards :awards} award]
  (if (award awards) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (->> a-seq (map pred) (filter #(if % true false)) first))

(defn my-every? [pred a-seq]
  (let [filtered-seq (filter pred a-seq)]
    (== (count a-seq) (count filtered-seq))))

(defn prime? [n]
  (let [pred (fn [divider] (== 0 (rem n divider)))
        dividers (filter pred (range 2 n))]
    (= dividers ())))

;^^
