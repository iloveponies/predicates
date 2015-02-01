(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))
;  (apply + ((juxt f g) x))) <-- for fun.

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  (fn [x]
    (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [{awards? :awards} award]
  (boolean awards?))

(defn HAS-ALL-THE-AWARDS? [{awards-won :awards} awards]
  (every? awards-won awards))

(defn my-some [pred a-seq]
  (if (seq a-seq)
    (let [result (pred (first a-seq))]
      (or result (recur pred (next a-seq))))
    nil))

(defn my-every? [pred a-seq]
  (if (seq a-seq)
    (let [result (pred (first a-seq))]
      (if result 
        (recur pred (next a-seq))
        false))
    true))

(defn prime? [n]
  (let [pred #(zero? (mod n %))]
    (not (some pred (range 2 n)))))
;^^
