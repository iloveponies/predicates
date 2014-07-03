(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [elem] (contains? a-set elem)))

(defn pred-and [pred1 pred2]
  (fn [v] (and (pred1 v) (pred2 v))))

(defn pred-or [pred1 pred2]
  (fn [v] (or (pred1 v) (pred2 v))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string) (nil? string) (every? whitespace? string)))

(defn has-award? [book award]
  (and (boolean (:awards book))
       (boolean (award (:awards book)))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [out (filter boolean (map pred a-seq))]
    (if (empty? out)
      nil
      (first out))))

(defn my-every? [pred a-seq]
  (let [out (filter pred a-seq)]
    (= (count a-seq) (count out))))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
