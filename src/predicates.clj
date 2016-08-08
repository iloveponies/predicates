(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (> n x)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [s]
    (contains? a-set s)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
    (or (empty string) (nil? string) (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [award]
                        (has-award? book award))]
    (every? book-has-award? awards)))

(defn my-some [pred a-seq]
  (let [filtered-seq (filter pred a-seq)
        applied-pred (map pred filtered-seq)]
    (first applied-pred)))

(defn my-every? [pred a-seq]
  (= a-seq (filter pred a-seq)))

(defn prime? [n]
  (let [pred (fn [x]
               (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))

;^^
