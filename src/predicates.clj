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
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awarded? (fn [award] (has-award? book award))]
    (every? awarded? awards)))

(defn my-some [pred a-seq]
  (let [passed (filter pred a-seq)]
    (not (empty? passed))))

(defn my-every? [pred a-seq]
  (let [passed (filter (complement pred) a-seq)]
    (empty? passed)))

(defn prime? [n]
  (let [divi (fn [x] (== (mod n x) 0))]
    (not (some divi (range 2 n)))))