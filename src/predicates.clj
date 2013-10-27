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
  (every? (fn [x] (whitespace? x)) string))

(defn has-award? [book award]
  (contains?  (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (= (seq awards) (seq (filter (set->predicate awards) (:awards book)))))

(defn my-some [pred a-seq]
 (let [truthies (filter pred a-seq)]
   (and (not (empty? truthies))
   (pred (first truthies)))))

(defn my-every? [pred a-seq]
 (let [filtteri (filter pred a-seq)]
   (= a-seq filtteri)))

(defn prime? [n]
 (let [jaollinen (fn [jakaja] (== 0 (mod n jakaja)))]
  (not (some jaollinen (range 2 n)))))
;^^
