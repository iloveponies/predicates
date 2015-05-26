(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n )))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond (every? whitespace? string) true
        (= nil string) true
        (= [] string) true
        :else false))

(defn has-award? [book award]
  (if (contains? (:awards book) award) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (if (<= 1 (count (filter pred a-seq)))
    (if (= first pred)
      (first (filter number? (map first a-seq)))
      true)
    false))

(defn my-every? [pred a-seq]    ; ei tehty
  (if (= (count a-seq) (count (filter pred a-seq))) true false))

(defn prime? [n]
  (let [pred (fn [x] (if (= 0 (mod n x))true false))]
    (not (some pred (range 2 n)))))


