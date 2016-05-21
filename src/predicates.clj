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
  (cond
    (= string nil) true
    (every? whitespace? string) true
    :else false ))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-it? (fn [x] (has-award? book x))]
  (every? book-has-it? awards)))


(defn my-some [pred a-seq]
  (let [check-non-falsey (fn [x] (not (or (nil? x) (= x false))))]
  (first (filter check-non-falsey (map pred a-seq)))))

(defn my-every? [pred a-seq]
  (let [is-true (fn [x] (not (= x true)))]
  (empty? (filter is-true (map pred a-seq)))))

(defn prime? [n]
  (let [ div (fn [x] (== (mod n x) 0))]
  (not (some div (range 2 n)))))
;^^
