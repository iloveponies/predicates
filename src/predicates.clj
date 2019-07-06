(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? (fn [x] (whitespace? x)) string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (== 0 (count (filter (complement (set->predicate (book :awards))) awards))))

(defn my-some [pred a-seq]
  (first (filter (complement false?) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter true? (map (complement pred) a-seq))))

(defn prime? [n]
  (let [divides-n (fn [x] (= 0 (mod n x)))]
    (not (some divides-n (range 2 n)))))
;^^
