(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #( < % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [chars (seq string)
        blank-pred? (fn[x] (and (whitespace? x)(not (Character/isLetter x))))]
    (empty? (filter (complement blank-pred?) chars))))

(defn has-award? [book award]
  :-)

(defn HAS-ALL-THE-AWARDS? [book awards]
  :-)

(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
