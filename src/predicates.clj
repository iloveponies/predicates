(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [key] (contains? a-set key)))

(defn pred-and [pred1 pred2]
  (fn [key] (and (pred1 key) (pred2 key))))

(defn pred-or [pred1 pred2]
  (fn [key] (or (pred1 key) (pred2 key))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? (seq string)))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (get book :awards)) awards))

(defn my-some [pred a-seq]
  (let [filter-pred (fn [key] key)
        result (filter filter-pred (map pred a-seq))]
    (if(not (empty? result))
      (first result)
      false)))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
