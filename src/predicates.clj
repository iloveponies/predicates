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
  (fn [x] (and (pred1 x)
               (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)
              (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
    (nil? string)
    (every? whitespace? string)))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (and (not (nil? awards))
         (contains? awards award))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (if (> (count (filter (fn [x] (true? (pred x))) a-seq))
         0)
    true
    false))

(defn my-every? [pred a-seq]
  (if (= (count (filter (fn [x] (true? (pred x))) a-seq))
         (count a-seq))
    true
    false))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
