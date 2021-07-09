(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
   (fn [value] (contains? a-set value)))

(defn pred-and [pred1 pred2]
(fn [x] (= (pred1 x) (pred2 x) true)))

(defn pred-or [pred1 pred2]
(fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
(every? whitespace? string))


(defn has-award? [book award]
  (contains? book :awards))

(defn HAS-ALL-THE-AWARDS? [book awards]
 (let [summa(count awards)
       summa2 (count (book :awards))
       returnValue(if (<= summa summa2)
         true
         false)]
   returnValue))

(defn my-some [pred a-seq]
(let[arvo(some pred a-seq)
     returnValue(cond(nil? arvo)
       "falsey"
       number? arvo
      :else nil)]
  returnValue))

(defn my-every? [pred a-seq]
  (every? pred a-seq))


(defn prime? [n]
  :-)
;^^
