(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)(pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)(pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (if (contains? (get book :awards) award) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (get book :awards) awards))

(defn my-some [pred a-seq]
  (let [y (seq a-seq)]
    (if (= (some pred y) nil) false (some pred y))))

(defn my-every? [pred a-seq]
  (let [y (seq a-seq)]
    (if (= (some pred y) nil) true (every? pred y))))

(defn prime? [n]
  (let [pred #(= (mod n %1) 0)]
    (not (some pred (range 2 n)))))
;^^
