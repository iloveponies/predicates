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
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (= award (award (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [a] (has-award? book a)) awards))

(defn my-some [pred a-seq]
  (let [res  (filter pred a-seq)
        fst (first res)]
    (cond
      (> (count res) 0) (pred fst)
      :else nil)))

(defn my-every? [pred a-seq]
  (let [res  (filter pred a-seq)]
    (cond
      (== (count res) (count a-seq)) true
      :else false)))

(defn prime? [n]
  (every? (fn [x] (> (rem n x) 0)) (range 2 (- n 1))))
;^^
