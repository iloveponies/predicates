(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-book-award? (fn [x] (has-award? book x))]
    (every? has-book-award? awards)))

(defn my-some [pred a-seq]
  :-)

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
