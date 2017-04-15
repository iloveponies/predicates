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
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (contains? (:awards book) award)) awards))

(defn my-some [pred a-seq]
  (let [b-seq (filter pred a-seq)
        eka (first b-seq)]
    (if (empty? b-seq)
      eka
      (if (nil? eka)
        (if (= pred nil?) true eka)
        (pred eka)))))

(defn my-every? [pred a-seq]
  (= (count (filter false? (map pred a-seq))) 0))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (every? false? (map pred (range 2 n)))))

