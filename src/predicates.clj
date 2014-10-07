(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and
            (pred1 x)
            (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or
            (pred1 x)
            (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
    (every? whitespace? string) true
    ((pred-or nil? empty?) string) true
    :else false))

(defn has-award? [book award]
  (let [book-awards (book :awards)]
    (contains? book-awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [pred-found (filter
            (fn [x] (pred x)) a-seq)]
   (if
     (empty? pred-found)
     false
     (pred (first pred-found)))))

(defn my-every? [pred a-seq]
  (let [exception-found (filter
                         (fn [x] (not (pred x))) a-seq)]
   (if (empty? exception-found)
     true
     false)))

(defn prime? [n]
  (let [mod-eq-zero?
        (fn [x] (= (mod n x) 0))]
    (not (some mod-eq-zero? (range 2 n)))))

;^^
