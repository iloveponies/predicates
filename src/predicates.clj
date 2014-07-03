(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  (fn [a-val] (contains? a-set a-val)))

(defn pred-and [pred1 pred2]
  #(and (pred1 %) (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %) (pred2 %)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [{awards :awards} award]
  (contains? awards award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (let [m (map pred a-seq)
        f (remove #(or (nil? %) (false? %)) m)]
    (first f)))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (not-any? #(zero? (rem n %))
            (range 2 n)))
