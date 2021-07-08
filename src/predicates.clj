(ns predicates)


(defn sum-f [f g x] (+ (f x) (g x)))

(defn greater-than [n]
  (fn [k] (> k n)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== n k))
  )

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))


(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))


(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (every? whitespace? string) true false))

(defn has-award? [book award]
  (if (contains? (get book :awards) award) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
(if (= (count (clojure.set/intersection awards (get book :awards))) (count awards)) true false))

(defn my-some [pred a-seq]
  (some pred a-seq))


(defn my-every? [pred a-seq]
  (every? pred a-seq))


(defn prime? [n]
  (let [luvut (range 2 (dec n))
        jako (fn [k] (zero? (mod n k)))]
     (not-any? jako luvut)))


;^^
