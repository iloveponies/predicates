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
  #(and (pred1 %) (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %) (pred2 %)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string) (every? whitespace? string) (empty? string)))

(defn has-award? [book award]
  (let [awards (book :awards)]
    (and (not (nil? awards)) (contains? awards award))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (first (filter #(if % true false) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (not (my-some false? (map pred a-seq))))

(defn prime? [n]
  (let [divides? #(= 0 (mod n %))]
    (not (some divides? (range 2 n)))))
;^^
