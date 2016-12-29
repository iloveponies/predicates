(ns predicates)

(defn sum-f
  [f g x]
  (apply + [(f x) (g x)]))

(defn less-than
  [n]
  (fn [x] (> n x)))

(defn equal-to
  [n]
  (fn [x] (== n x)))

(defn set->predicate
  [a-set]
  (fn [val] (contains? a-set val)))

(defn pred-and
  [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or
  [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace?
  [character]
  (Character/isWhitespace character))

(defn blank?
  [string]
  (every? whitespace? string))

(defn has-award?
  [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS?
  [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some
  [pred a-seq]
  (->> (map pred a-seq)
       (remove false?)
       first))

(defn my-every?
  [pred a-seq]
  (if (empty? (map pred a-seq))
    true
    (= 1 (count (set (map pred a-seq))))))

(defn prime?
  [n]
  (let [pred (fn [i] (= 0 (mod n i)))]
    (not (some pred (range 2 n)))))
