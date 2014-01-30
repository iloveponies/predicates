(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [a-member] (contains? a-set a-member)))

(defn pred-and [pred1 pred2]
  (fn [a-val]
    (and
     (pred1 a-val)
     (pred2 a-val))))

(defn pred-or [pred1 pred2]
  (fn [a-val]
    (or
     (pred1 a-val)
     (pred2 a-val))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (and
   (not (nil? (book :awards)))
   (not (nil? (contains? (book :awards) award)))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (not-any? false?
   (map
    (fn [award] (contains? (book :awards) award))
    awards)))

(defn my-some [pred a-seq]
  (first (filter (complement false?) (map pred a-seq))))


(defn my-every? [pred a-seq]
  (reduce #(and % %2) true (map pred a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (zero? (rem n x)))]
    (not (some pred (range 2 n)))))
