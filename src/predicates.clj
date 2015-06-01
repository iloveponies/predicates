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
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [seq-filtered-by-pred (filter pred a-seq)]
    (cond
     (empty? seq-filtered-by-pred) false
     :else (first (map pred seq-filtered-by-pred)))))

(defn my-every? [pred a-seq]
  (let [seq-filtered-by-pred (filter (complement pred) a-seq)]
    (empty? seq-filtered-by-pred)))

(defn prime? [n]
  (let [pred (fn [k] (and (<= k n) (== 0 (mod n k))))]
    (not (some pred (range 2 n)))))
;^^
