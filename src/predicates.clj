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
  (cond
    (== (count string) 0) true
    (every? whitespace? string) true
    :else false))

(defn has-award? [book award]
  (let [x (:awards book)]
    (if(contains? x award) true false)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [x (:awards book)]
    (every? x awards)))

(defn my-some [pred a-seq]
  (if(== (count (filter pred a-seq)) 0) false (first (filter boolean (map pred a-seq)))))

(defn my-every? [pred a-seq]
  (cond
    (empty? a-seq) true
    (== (count (filter pred a-seq)) (count a-seq)) true
    :else false))

(defn prime? [n]
  (let [f1 (fn [x] (mod n x))]
    (if(== (count (filter (equal-to 0) (map f1 (range 2 n)))) 0) true false)))
;^^^
