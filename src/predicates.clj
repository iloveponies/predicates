(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [s] (contains? a-set s)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  ((set->predicate (:awards book)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards))

(defn my-some [pred a-seq]
  (let [result (filter #(pred %) a-seq)]
    (if (empty? result)
      nil
      (pred (first result)))))

(defn my-every? [pred a-seq]
  (let [result (filter #((complement pred) %) a-seq)]
    (empty? result)))

(defn prime? [n]
  (let [pred (fn [x]
               (if (= x n)
               false
               (= (mod n x) 0)))]
    (not (some pred (range 2 n)))))
