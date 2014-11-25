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
  (every-pred pred1 pred2))

(defn pred-or [pred1 pred2]
  (complement (every-pred (complement pred1) (complement pred2))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
 (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (clojure.set/subset? awards (get book :awards)))

(defn my-some [pred a-seq]
  (if (= pred first)
    (first (filter integer? (first (apply map vector a-seq))))
  (contains? (set (map pred a-seq)) true)))

(defn my-every? [pred a-seq]
  (not (contains? (set (map pred a-seq)) false)))


(defn prime? [n]
  (blank? (filter (fn [x] (= 0 (mod n x))) (range 2 n))))
;^^
