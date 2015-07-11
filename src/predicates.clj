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
  (or (nil? string)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [x] (has-award? book x))]
    (every? book-has-award? awards)))

(defn my-some [pred a-seq]
  (let [falsey (fn [x] (or (nil? x) (false? x)))
        truthy (complement falsey)
        truthy-seq (filter truthy (map pred a-seq))]
    (first truthy-seq)))

(defn my-every? [pred a-seq]
  (let [falsey (fn [x] (or (nil? x) (false? x)))
        truthy (complement falsey)
        falsey-seq (filter falsey (map pred a-seq))]
    (empty? falsey-seq)))

(defn prime? [n]
  (let [pred (fn [k] (== 0 (mod n k)))]
    (not (some pred (range 2 n)))))
;^^
