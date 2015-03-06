(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)) )

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [award] (has-award? book award))]
(every? book-has-award? (seq awards))))

(defn my-some [pred a-seq]
  (let [f (filter pred a-seq)]
    (if (empty? f) nil (pred (first f)))))

(defn my-every? [pred a-seq]
  (let [f (filter (complement pred) a-seq)]
      (if (empty? f) true false)))


(defn prime? [n]
  (let [divides? (fn [x] (= (mod n x) 0))]
    (not (some divides? (range 2 n)))))
;^^
