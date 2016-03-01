(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [item] (contains? a-set item)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-award-in-book?
        (fn [award] (has-award? book award))]
    (every? has-award-in-book? awards)))

(defn my-some [pred a-seq]
  (let [v (first (filter #(boolean %) (map pred a-seq)))]
    (if (nil? v) false v)))

(defn my-every? [pred a-seq]
  (let [comp-pred (complement pred)]
    (empty? (filter true? (map comp-pred a-seq)))))

(defn prime? [n]
  (let [divisible? (fn [x] (= (rem n x) 0))]
    (not (some divisible? (range 2 n)))))
;^^
