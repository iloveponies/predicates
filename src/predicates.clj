(ns predicates)

(defn sum-f
  "returns (+ (f x) (g x))"
  [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate
  "takes a-set as a parameter and returns a predicate that takes x as a parameter and returns true if x is in a-set otherwise returns false"
  [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and
  "returns a new predicate that: returns true if both pred1 and pred2 return true, otherwise returns false"
  [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or
  " takes two predicates and returns a new predicate that: returns true if pred1 or pred2 returns true, otherwise returns false"
  [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank?
  "takes a string as a parameter and returns true if string is empty, nil, or contains only whitespace."
  [string]
  (every? whitespace? string))

(defn has-award?
  "returns true if book has won award."
  [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS?
  "returns true if book has won every award in awards."
  [book awards]
  (let [book-has-awards? (fn [award]
                           (has-award? book award))]
    (every? book-has-awards? awards)))

(defn my-some [pred a-seq]
   (let [falsey? (fn [x] (or (false? x) (nil? x)))]
    (first (filter (complement falsey?) (map pred a-seq)))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [predicate? (fn [x] (= 0 (mod n x)))]
   (not (some predicate? (range 2 n)))))
