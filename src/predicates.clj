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
  (every? (set->predicate (get book :awards)) awards))

(defn if->predicate [x]
  (if x true false))

(defn my-some [pred a-seq]
  (first (filter if->predicate (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter if->predicate (map (complement pred) a-seq))))

(defn prime? [n]
  (let [divisible (fn [x] (fn [y] (== (mod x y) 0)))]
    (not (some (divisible n) (range 2 n)))))
;^^
