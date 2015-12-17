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
  (fn [x] (boolean (and (pred1 x) (pred2 x)))))

(defn pred-or [pred1 pred2]
  (fn [x] (boolean (or (pred1 x) (pred2 x)))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (let [awards-non-empty? (fn [b] (not (empty? (:awards b))))]
    (let [contains-award? (fn [b] ((:awards b) award))]
      ((pred-and awards-non-empty? contains-award?) book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has? (fn [a] (has-award? book a))]
    (every? has? awards)))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (let [every-pr (pred-or empty?
                          (fn [s] (== (count s) (count (filter pred s)))))]
    (every-pr a-seq)))


(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
