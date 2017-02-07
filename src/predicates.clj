(ns predicates)

(defn sum-f [f g x]
 (+ (f x) (g x)))

(defn less-than [n]
    (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-coll] (or (a-set a-coll) (nil? a-coll))))

(defn pred-and [pred1 pred2]
  (fn [testable] (and (pred1 testable) (pred2 testable))))

(defn pred-or [pred1 pred2]
  (fn [testable] (or (pred1 testable) (pred2 testable))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string) (every? whitespace? string) (nil? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (let [some-or-nil (first (filter (fn [x] x) (map pred a-seq)))]
    (not (nil? some-or-nil)) false some-or-nil))

(defn my-every? [pred a-seq]
  (= a-seq (filter pred a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (nil? (some (fn [x] (== 0 (mod n x))) (range 2 (+ 1 (Math/floor (Math/sqrt n))))))))
;^^
