(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (let [alku (filter a-set [0 2 4 6 nil])
        loppu (filter nil? [0 2 4 6 nil])]
     (conj alku loppu)))

(defn pred-and [pred1 pred2]
  ( pred1 pred2))

(defn pred-or [pred1 pred2]
  :-)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  :-)

(defn has-award? [book award]
  (if (contains? (set (map :awards book)) award)
    true
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  :-)

(defn my-some [pred a-seq]
  (if (nil? (some pred a-seq))
    false
    true))

(defn my-every? [pred a-seq]
  (every? pred a-seq))

(defn prime? [n]
  :-)