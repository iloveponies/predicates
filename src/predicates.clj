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
  (-> book
      :awards
      (contains? award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (if (empty? a-seq)
    false
    (let [item (pred (first a-seq))]
      (if item item
               (my-some pred (rest a-seq))))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (let [item (pred (first a-seq))]
      (if (not item) false
                     (my-every? pred (rest a-seq))))))

(defn prime? [n]
  (let [pred #(== 0 (rem n %))]
    (not (some pred (range 2 n)))))

;^^
