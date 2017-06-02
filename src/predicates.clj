(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))


(defn less-than [n]
  (fn [k] (< k n)))


(defn equal-to [n]
  (fn [k] (== k n)))


(defn set->predicate [a-set]
  (fn [a-value] (contains? a-set a-value)))



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
  (let [this-contains? (fn [award] (has-award? book award))]
    (every? this-contains? awards)))



(defn my-some [pred a-seq]
  ())

(defn my-every? [pred a-seq]
  (let [nonpred (complement pred)]
    (not (some nonpred a-seq))))




(defn prime? [n]
  (let [pred (fn [divisor] (== 0 (mod n divisor)))]
    (not (some pred (range 2 n)))))
;^^
