(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x]
    (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x)
         (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x)
        (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (let [awards (book :awards)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let[wins (book :awards)]
    (every? wins awards)))

(defn my-some [pred a-seq]
  (first
    (map pred
      (filter
        (fn [x] (pred x))
         a-seq))))

(defn my-every? [pred a-seq]
  (let [filtered-seq
       (filter (fn [x] (pred x)) a-seq)]
    (== (count a-seq)
        (count filtered-seq))))

(defn prime? [n]
  (let [mod-is-zero?
       (fn [x] (== (mod n x) 0))]
    (not (some mod-is-zero? (range 2 n)))))

;^^
