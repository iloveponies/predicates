(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (= k n)))

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
  (every? true? (map #(has-award? book %) awards)))

(defn my-some [pred a-seq]
  (let [map-pred (map #(pred %) a-seq)
        remove-false (remove (pred-or false? nil?) map-pred)]
  (if (empty? remove-false) false (first remove-false))))

(defn my-every? [pred a-seq]
  (let [map-pred (map #(pred %) a-seq)
        remove-false (remove (pred-or false? nil?) map-pred)]
    (= (count a-seq) (count remove-false))))

(defn prime? [n]
  (not (some integer? (map #(/ n %) (range 2 n)))))
;^^
