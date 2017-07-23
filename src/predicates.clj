(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(sum-f inc dec 4)

(defn less-than [n]
  (fn [k] (< k n)))

(map (less-than 3) [2 3 5 1])

(defn equal-to [n]
  (fn [k] (== k n)))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award (fn [aw] (has-award? book aw))]
    (every? award awards)))

(defn my-some [pred a-seq]
  (let [first-non-false (first (filter (complement false?) (map pred a-seq)))]
    (if (nil? first-non-false)
      false
      first-non-false)))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred #(= (mod n %) 0)]
    (not (some pred (range 2 n)))))

(prime? 3)
