(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

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
  ((complement nil?) (award (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn filtered-seq [pred a-seq]
  (filter #(not= false %) (map #(pred %) a-seq)))

(defn my-some [pred a-seq]
  (let [fst (first (filter #(not= false %) (map #(pred %) a-seq)))]
    (if fst fst false)))

(defn my-every? [pred a-seq]
  (let [a-seq-size (count a-seq)]
    (= a-seq-size (count (filtered-seq pred a-seq)))))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))

;^^
