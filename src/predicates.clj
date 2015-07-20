(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [elem] (contains? a-set elem)))

(defn pred-and [pred1 pred2]
  (fn [a]
    (and (pred1 a) (pred2 a))))

(defn pred-or [pred1 pred2]
  (fn [a]
    (or (pred1 a) (pred2 a))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-award? (fn [award] (contains? (:awards book) award))]
    (every? book-award? awards)))

(defn my-some [pred a-seq]
  (first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq]
  (= (count a-seq) (count (filter pred a-seq))))

(defn prime? [n]
  (let [pred (fn [d] (= 0 (mod n d)))]
    (not (some pred (range 2 n)))))
;^^
