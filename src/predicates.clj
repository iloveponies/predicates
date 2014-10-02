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
  (every? #(or (whitespace? %)
               (nil? %)) string))

(defn has-award? [book award]
  (not (nil? (award (:awards book)))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (let [a (map #(pred %) a-seq)
        b (filter #(if % true false) a)]
    (first b)))

(defn my-every? [pred a-seq]
  (empty? (filter #((complement pred) %) a-seq)))

(defn prime? [n]
  (let [pred #(=(mod n %) 0)]
    (not (some pred (range 2 n)))))
