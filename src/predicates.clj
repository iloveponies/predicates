(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))


(defn set->predicate [a-key]
  (fn [a-map]
   (or
      (a-key a-map)
      (and (not (not-any? nil? a-key)) (nil? a-map))
      (and (not (not-any? false? a-key)) (false? a-map)))))


(defn pred-and [pred1 pred2]
  (fn [x]
    (and
     (pred1 x)
     (pred2 x))))


(defn pred-or [pred1 pred2]
  (fn [x]
    (or
     (pred1 x)
     (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
   (== 0 (count string))
   (nil? string)
   (every? whitespace? string)))


(defn has-award? [book award]
  (contains? (:awards book) award))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (or
   (empty? a-seq)
   (== 0 (count (filter (complement true?) (map pred a-seq))))))


(defn prime? [n]
  (let [pred (fn [x] (== 0 (rem n x)))]
    (not (some pred (range 2 n)))))
;^^
