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
  (not= (some (fn[x] (= x award)) (:awards book)) nil))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn[x] (contains? (:awards book) x)) awards))

(defn my-some [pred a-seq]
  (let [value (first (filter (fn[x] (and (not= x nil) (not= x false)))(map pred a-seq)))]
    (cond
     value value
     :else false)))

(defn my-every? [pred a-seq]
  (let [evalued (filter true? (mapv pred a-seq))]
    (= (count evalued) (count a-seq))))

(defn prime? [n]
  (let [pred (fn[x] (== (mod n x ) 0))]
    (not (some pred (range 2 n)))))
  ;^^
