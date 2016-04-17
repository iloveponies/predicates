(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  #(contains? a-set %))

(defn pred-and [pred1 pred2]
  #(and (pred1 %)
        (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %)
        (pred2 %)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (if (empty? filtered)
        false
        (pred (first filtered)))))

(defn my-every? [pred a-seq]
  (let [filtered (filter (complement pred) a-seq)]
    (empty? filtered)))

(defn prime? [n]
  (let [p #(== 0 (mod n %))]
    (not (some p (range 2 n)))))
