(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [values] (contains? a-set values)))

(defn pred-and [pred1 pred2]
  (fn [a-seq] (and (pred1 a-seq) (pred2 a-seq))))

(defn pred-or [pred1 pred2]
  (fn [a-seq] (or (pred1 a-seq) (pred2 a-seq))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (= string nil) (empty? string) (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [x (filter (fn [value] (pred value)) a-seq)]
    (cond
      (empty? x) false
      :else (pred (first x)))))

(defn my-every? [pred a-seq]
  (let [x (count a-seq)
        y (count (filter (fn [value] (pred value)) a-seq))]
    (cond
      (empty? a-seq) true
      :else (= x y))))

(defn prime? [n]
  (let [values (range 2 n)
        div? (fn [x] (== 0 (mod n x)))]
    (not (some div? values))))
;^^
