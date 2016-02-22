(ns predicates)

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n )))

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

(defn has-award? [book award]
  ((set->predicate (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [ a (fn [k] (has-award? book k))]
    (every? a awards)
    ))

(defn my-some [pred a-seq]
  (some pred a-seq))

(defn my-every? [pred a-seq]
  (every? pred a-seq))

(defn prime? [n]
  (let [pred (fn [k] (== (mod n k) 0))]
    (not (some pred (range 2 n)))))
;^^
