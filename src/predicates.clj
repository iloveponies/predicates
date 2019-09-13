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
  (fn [x] (and (pred1 x)
               (pred2 x))))


(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)
              (pred2 x))))


(defn whitespace? [character]
  (Character/isWhitespace character))


(defn blank? [string]
  (every? whitespace? string))


(defn has-award? [book award]
  (let [premi (:awards book)]
    (not (nil? (award premi)))))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [premiatore (fn [x] (has-award? book x))
        premi (map premiatore awards)]
  (every? true? premi)))


(defn my-some [pred a-seq]
  (let [responso (map pred a-seq)
        sopravissuti (filter (complement false?) responso)]
    (first sopravissuti)))


(defn my-every? [pred a-seq]
  (let [responso (map pred a-seq)
        sopravissuti (filter false? responso)]
    (empty? sopravissuti)))


(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))


;^^
