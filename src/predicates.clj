(ns predicates)

(defn sum-f [f g x]
  (+ (f x)(g x)))

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
  (every? (fn [a] (has-award? book a)) awards))

(defn my-some [pred a-seq]
  (let [mapped (map pred a-seq)
        preda  (fn [x] x)
        filtered (filter preda mapped)]
    (first filtered)))

(defn my-every? [pred a-seq]
  (let [mapped (map pred a-seq)
        preda   (fn [x] x)
        filtered (filter preda mapped)]
    (== (count a-seq) (count filtered))))

(defn prime? [n]
(every? (fn [x] (not (= 0 (mod n x)))) (range 2 n)))
;^^
