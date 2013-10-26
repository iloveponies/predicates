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
  (fn [x]
    (and (= (pred1 x) true)
        (= (pred2 x) true))))


(defn pred-or [pred1 pred2]
  (fn [x]
    (or (= (pred1 x) true)
        (= (pred2 x) true))))


(defn whitespace? [character]
  (Character/isWhitespace character))


(defn blank? [string]
  (every? whitespace? string))


(defn has-award? [book award]
  (contains? (book :awards) award))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [fnd? (fn [x] (contains? (book :awards) x))]
  (every? fnd? awards)))


(defn my-some [pred a-seq]
  (let [filt (filter pred a-seq)]
    (if (vector? (first filt))
      (get (first filt) 0)
         (not (empty? filt)))))


(defn my-every? [pred a-seq]
    (let [filt (filter pred a-seq)]
      (= filt a-seq)))


(defn prime? [n]
  (let [luvut (range 2 (- n 1))
        divides? (fn [divisor] (= (mod n divisor) 0))]
      (not (some divides? luvut))))
;^^
