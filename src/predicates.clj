(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [m] (< m n)))

(defn equal-to [n]
  (fn [m] (== m n)))

(defn set->predicate [a-set]
  (fn [m] (contains? a-set m)))

(defn pred-and [pred1 pred2]
  (fn [m] (and (pred1 m) (pred2 m))))

(defn pred-or [pred1 pred2]
  (fn [m] (or (pred1 m) (pred2 m))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards))

(defn my-some [pred a-seq]
  (let [fd (filter (fn [x] (pred x)) a-seq)
        mpd (map (fn [x] (pred x)) fd)]
    (first mpd)))

(defn my-every? [pred a-seq]
  (== (count (filter pred a-seq)) (count (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
