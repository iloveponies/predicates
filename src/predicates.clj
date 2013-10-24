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
  (if (contains? (:awards book) award) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [abc (fn [x] (has-award? book x))]
    (every? abc awards)))


(defn my-some [pred a-seq]
  (let [cut (filter pred a-seq)]
    (cond
     (and (= pred first) (not= (count cut) 0)) (first (first cut))
     (not= (count cut) 0) true
     :else false)))

(defn my-every? [pred a-seq]
  (let [cut (filter pred a-seq)]
    (cond
     (empty? a-seq) true
     (= cut a-seq) true
     :else false)))

(defn prime? [n]
  (let [divisible? (fn [x] (if (= (mod n x) 0) true false))]
    (not (some divisible? (range 2 n)))))
;^^
