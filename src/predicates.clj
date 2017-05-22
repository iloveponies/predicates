(ns predicates)

(defn apply-1 [f x]
  (f x))

(defn sum-f [f g x]
  (+ (apply-1 f x)(apply-1 g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
    (every? (fn[x] (contains? (book :awards) x)) awards))

(defn my-some [pred a-seq]
    (first(map pred (filter (fn [x] (pred x)) a-seq))))

(defn my-every? [pred a-seq]
   (= (count a-seq) (count(filter pred a-seq))))

(defn prime? [n]
  (let [pred (fn[x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
