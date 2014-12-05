(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-elem] (contains? a-set a-elem)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (if (contains? book :awards) (contains? (:awards book) award) false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [this-book-has-award? (fn [x] (has-award? book x))]
   (every? this-book-has-award? (seq awards))))

(defn my-some [pred a-seq]
  (let [first-elem (first (filter pred a-seq))]
    (if (empty? (filter pred a-seq)) false (if first-elem (if (vector? first-elem) (first first-elem) true) true))))


(defn my-every? [pred a-seq]
  (if (empty? a-seq) true ((complement my-some) (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (if (== (mod n x) 0) true false))]
    (not (some pred (range 2 n)))))
;^^
