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
  (or (= string nil) (= string "") (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [books-awards (:awards book)]
    (cond
     (empty? awards) true
     (not (has-award? book (first awards))) false
     :else (HAS-ALL-THE-AWARDS? book (rest awards)))))

(defn my-some [pred a-seq]
  (let [check-truthy (fn [x] (if x true false))]
    (first (filter check-truthy (map pred a-seq)))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (if (== (count (filter pred a-seq)) (count a-seq))
      true
      false)))

(defn prime? [n]
  (let [asdf (fn [x]
               (if (not= (mod n x) 0)
                 false
                 true))]
    (if (== (count (filter asdf (range 2 n))) 0)
      true
      false)))
;^^
