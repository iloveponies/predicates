(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [an-elem] (contains? a-set an-elem)))

(defn pred-and [pred1 pred2]
  (fn[x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn[x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (not string) (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn[award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [pred_vals (map pred a-seq)]
    (first (filter identity pred_vals))))

(defn my-every? [pred a-seq]
  (let [comp-pred-vals (map (complement pred) a-seq)]
    (empty? (filter identity comp-pred-vals))))

(defn prime? [n]
  (let [divides? (fn[k] (== (mod n k) 0))]
    (not (some divides? (range 2 n)))))
;^^
