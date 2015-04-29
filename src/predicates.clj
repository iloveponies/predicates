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
  (every? (fn [x] (whitespace? x)) string))
  
(defn has-award? [book award]
  (let [award? (fn [book] (contains? (:awards book) award))]
    (if (award? book) true false)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (if (every? (fn [award] (has-award? book award)) awards) true false))

(defn my-some [pred a-seq]
 (let [newSeq (map pred a-seq)]
   (first (set (filter (complement nil?) newSeq)))))

(defn my-every? [pred a-seq]
   (let [newSeq (map pred a-seq)
          filteredSeq (set (filter (complement true?) newSeq))]
    (if (empty? filteredSeq) true false)))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
