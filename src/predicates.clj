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
  (fn [v] (and
            (pred1 v)
            (pred2 v)
            true)))

(defn pred-or [pred1 pred2]
  (fn [v] (or
            (pred1 v)
            (pred2 v)
            false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (if (empty? filtered)
      false
      (pred (first filtered)))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [k] (= 0 (mod n k)))]
    (not (some pred (range 2 n)))))

;^^
