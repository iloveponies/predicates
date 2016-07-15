(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string) (empty? string) (nil? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [helper (fn [award] (has-award? book award))] (every? helper awards)))

(defn my-some [pred a-seq]
  (first (filter pred a-seq)))

(my-some even? [1 3 5 7 8])

(defn my-every? [pred a-seq]
  (= (count a-seq) (count (filter pred a-seq))))

(defn prime? [n]
  (= nil (first (filter (fn [x] (== 0 (mod n x))) (range 2 n)))))

(filter prime? (range 2 50))
