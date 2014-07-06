(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [el] (contains? a-set el)))

(defn pred-and [pred1 pred2]
  (fn [el] (and (pred1 el)
                (pred2 el))))

(defn pred-or [pred1 pred2]
  (fn [el] (or (pred1 el)
               (pred2 el))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (reduce (fn [x y] (or x y)) false (map pred a-seq)))

(defn my-every? [pred a-seq]
  (reduce (fn [x y] (and x y)) true (map pred a-seq)))

(defn prime? [n]
  (every? (fn [x] (> (mod n x) 0)) (range 2 n)))
;^^
