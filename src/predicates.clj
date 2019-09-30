(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-val] (contains? a-set a-val)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? (fn [c] (whitespace? c)) string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (filter
          (complement false?)
          (map (fn [y] (pred y)) a-seq))))

(defn my-every? [pred a-seq]
  (or
   (empty? a-seq)
   (==
    (count a-seq)
    (count (filter
          (complement false?)
          (map (fn [y] (pred y)) a-seq))))))

(defn prime? [n]
  (let [pred (fn [x]
               (= (mod n x) 0))]
    (not (some pred (range 2 n)))))

;^^
