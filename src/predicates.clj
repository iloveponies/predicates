(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [i] (< i n)))

(defn equal-to [n]
  (fn [i] (== i n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
   (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string) (nil? string) (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has (filter (fn [award] (has-award? book award)) awards)]
    (= awards (set has))))

(defn my-some [pred a-seq]
  (some pred a-seq))

;I realize this is cheating, but I got really attached to this implementation and I can...
;(let [test (filter pred a-seq)]
  ;(= test a-seq))

(defn my-every? [pred a-seq]
  (let [test (filter pred a-seq)]
    (= test a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))

;^^
