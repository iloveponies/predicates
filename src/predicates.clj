(ns predicates)

(defn sum-f [f g x]
   (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [s] (contains? a-set s)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (let [f (first (filter (fn [x] (not (false? x))) (map pred a-seq)))]
    (if (nil? f) false f)))

(defn my-every? [pred a-seq]
  (let [f (filter pred a-seq)]
    (if (== (count a-seq) (count f)) true false)))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))

;^^
