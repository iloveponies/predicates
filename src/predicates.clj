(ns predicates)

(defn sum-f [f g x]
  (+
    (f x)
    (g x)))

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
  (let [isNil (fn [character] ((if (character = nil) true false)))
        empty (fn [character] (== (count character) 0))]
       (every? (and nil? empty? whitespace?) string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [hasaward? (fn [award] (has-award? book award))]
       (every? hasaward? awards)))

(defn my-some [pred a-seq]
      (let [x (map pred a-seq)]
           (first (filter boolean x))))

(defn my-every? [pred a-seq]
      (if (empty? a-seq) true (apply = (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [divisor] (= (mod n divisor) 0))]
       (not (some pred (range 2 n)))))
;^^
