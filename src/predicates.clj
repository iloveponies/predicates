(ns predicates)

(defn sum-f [f g x]
  (+ 
    (f x)
    (g x)))

(defn compare-with-pred [pred n]
  (fn [k] (pred k n)))

(defn less-than [n]
  (compare-with-pred < n))

(defn equal-to [n]
  (compare-with-pred == n))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-binary [f pred1 pred2]
  (fn [x]
    (f
      (pred1 x) (pred2 x))))

(defn pred-and [pred1 pred2]
  (fn [x] 
    (and 
      (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or 
      (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? 
    (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (first
    (filter #(true? (boolean %))
      (map pred a-seq))))

(defn my-every? [pred a-seq]
  (= 
    (count a-seq)
    (count
      (filter true?
        (map pred a-seq)))))

(defn prime? [n]
  (let [pred #(== 0 (mod n %))]
    (not (some pred (range 2 n)))))
;^^
