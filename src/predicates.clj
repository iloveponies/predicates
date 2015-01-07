(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k]
    (cond
      (nil? k) (contains? a-set k)
      (false? k) (contains? a-set k)
      :else (a-set k))))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (= 0 (count string))
      (every? (pred-or nil? whitespace?) string)))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award-pred (fn [a] (has-award? book a))]
    (every? award-pred awards)))

(defn my-some [pred a-seq]
  (let [bools (map pred a-seq)]
    (first (filter identity bools))))

(defn my-every? [pred a-seq]
  (let [bools (map (complement pred) a-seq)]
    (empty? (filter identity bools))))

(defn prime? [n]
  (let [pred (fn [k] (= 0 (mod n k)))]
    (not (some pred (range 2 n)))))
;^^
