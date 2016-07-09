(ns predicates)
(use 'clojure.data)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (if (contains? a-set x) true false)))

(defn pred-and [pred1 pred2]
   (fn [x] (if (and (pred1 x) (pred2 x)) true false)))

(defn pred-or [pred1 pred2]
  (fn [x] (if (or (pred1 x) (pred2 x)) true false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (or (nil? string) (every? whitespace? string) (empty? string)) true false))


(defn won-award [book]
  (fn [award] (if (contains? (:awards book) award) true false)))

(defn has-award? [book award]
  (if (contains? (:awards book) award) true false))



(defn HAS-ALL-THE-AWARDS? [book awards]
(= (count (filter (won-award book) awards))  (count awards)) )


(defn truet [arvo]
  (fn [x] (if (boolean arvo) arvo false)))


(defn my-some [pred a-seq]

(first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq] (let [arvot (filter boolean (map pred a-seq))]
    (if (= (count arvot) (count a-seq)) true false)))

(defn prime? [n]
  (let [pred (fn [x] (if (= (mod n x) 0) true false))]
    (not (some pred (range 2 n)))))
;^^
