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
(contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
 (cond
  (= (some pred a-seq) true) true
  (= (some pred a-seq) nil) false
  (= (some pred a-seq) 1) 1
  ))

(defn my-every? [pred a-seq]
  (every? pred a-seq))

(defn prime? [n]
  (let [pred
        (fn [x] (zero? (mod n x)))]
    (not (some pred (range 2 n)))))

