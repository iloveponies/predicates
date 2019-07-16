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

;(defn whitespace? [c]
;  (Character/isWhitespace c))

(defn blank? [string]
  (every? whitespace? string))

(defn award-set [book]
  (get book :awards #{}))

(defn has-award? [book award]
  (contains? (award-set book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (every? #(not= 0 (mod n %)) (range 2 n)))
;^^
