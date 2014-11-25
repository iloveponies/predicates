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
  (fn [n] (and (pred1 n) (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n) (pred2 n))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (set (book :awards)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-book-award? #(has-award? book %)]
    (every? has-book-award? awards)))

(defn my-some [pred a-seq]
  (let [match (filter pred a-seq)]
    (if (empty? match) nil (pred (first match)))))

(defn my-every? [pred a-seq]
  (nil? (my-some (complement pred) a-seq)))

(defn prime? [n]
  (let [pred #(= 0 (mod n %))]
    (not (some pred (range 2 n)))))
;^^
