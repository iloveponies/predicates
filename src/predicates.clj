(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== n x)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)
               (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)
              (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [nilEmpty? (pred-or nil? empty?)]
    (or (nilEmpty? string)
        (every? whitespace? string))))

(defn has-award? [book award]
  (if (contains? book :awards)
    (contains? (:awards book) award)
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awarded (:awards book)
        rev-has? (fn [award] (contains? awarded award))]
    (every? rev-has? awards)))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (if (empty? filtered)
      nil
      (pred (first filtered)))))

(defn my-every? [pred a-seq]
  (let [filtered (filter (complement pred) a-seq)]
    (empty? filtered)))

(defn prime? [n]
  (let [pDivN? (fn [p] (= (mod n p) 0))]
    (not (some pDivN? (range 2 n)))))
;^^
