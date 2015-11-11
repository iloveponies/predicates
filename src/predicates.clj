(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [checker (fn [x] (or (whitespace? x) (= x nil)))]
    (or (empty? string) (every? checker string))))

(defn has-award? [book award]
  (contains? book :awards))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-the-award? (fn [award] (contains? (:awards book) award))]
   (every? has-the-award? awards)))

(defn my-some [pred a-seq]
  (let [passes (filter pred a-seq)]
   (if (empty? passes) nil (pred (first passes)))))

(defn my-every? [pred a-seq]
  (let [not-passes (filter (complement pred) a-seq)]
   (empty? not-passes)))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
