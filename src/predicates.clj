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
  (let [a (:awards book)]
    (contains? a award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [predhelp? (fn [a] (has-award? book a))]
    (every? predhelp? awards)))

(defn my-some [pred a-seq]
  (let [values (filter pred a-seq)]
    (if (seq values) (first (map pred values)) false)))

(defn my-every? [pred a-seq]
  (not (my-some (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [d] (= 0 (mod n d)))]
  (not (some pred (range 2 n)))))
