(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [i] (< i n)))

(defn equal-to [n]
  (fn [i] (== i n)))

(defn set->predicate [a-set]
  (fn [x]
    (if (contains? a-set x)
      true
      false)))

(defn pred-and [pred1 pred2]
  (fn [i] (if (and (pred1 i) (pred2 i))
    true
    false)))

(defn pred-or [pred1 pred2]
  (fn [i] (if (or (pred1 i) (pred2 i))
    true
    false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true? (map (fn [award] (has-award? book award)) awards)))

(defn my-some [pred a-seq]
  (if (not (empty? (filter pred a-seq)))
    (pred (first (filter pred a-seq)))
    false))

(defn my-every? [pred a-seq]
  (if (= (filter pred a-seq) a-seq)
    true
    false))

(defn prime? [n]
  (let [dividable? (fn [x] (if (= (mod n x) 0) true false))]
    (every? false? (map dividable? (range 2 n)))
  ))
;^^
