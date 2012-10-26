(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a] (contains? a-set a)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  ((comp not nil?) (award (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  ;set to set just in case.  they should be sets anyways?
  (= (set awards)
     (set (:awards book))))

(defn my-some [pred a-seq]
  ((comp not empty?) (filter pred a-seq)))

(defn my-every? [pred a-seq]
  ((comp not my-some) (comp not pred) a-seq))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
