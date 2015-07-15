(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map)))

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
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (let [jaavat (filter pred a-seq)]
    (if (empty? jaavat)
      false
      (pred (first jaavat)))))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq)))) ;if none is false, all are true

(defn prime? [n]
  (let [divides-n? (fn [k] (== 0 (rem n k)))]
    (not (some divides-n? (range 2 (+ 1 (/ n 2)))))))

;^^
