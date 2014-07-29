(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn[x] (if (= x nil) (contains? a-set nil) (a-set x))))

(defn pred-and [pred1 pred2]
  (fn[x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn[x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (if (contains? book :awards) 
      (contains? (get book :awards) award)
      false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (if (contains? book :awards) 
      (every? (get book :awards) awards)
      (if (empty? awards) true false)))

(defn my-some [pred a-seq]
      (let [data (filter pred a-seq)]
  (first (map pred data))))

(defn my-every? [pred a-seq]
      (let [filtered (filter (complement pred) a-seq)]
        (empty? filtered)))

(defn prime? [n]
  (let [pred (fn[x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
