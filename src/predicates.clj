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
  (cond
   (empty? string) true
   (every? whitespace? string) true
   (= nil string) true
   :else false))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [trues (filter pred a-seq)]
    (and (not (empty? trues))
         (pred (first trues)))))

(defn my-every? [pred a-seq]
  (let [filt (filter pred a-seq)]
    (= a-seq filt)))


(defn prime? [n]
  (let [jaollinen (fn [jakaja] (== 0 (mod n jakaja)))]
    (not (some jaollinen (range 2 n)))))

;^^
