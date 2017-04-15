(ns predicates)

(defn sum-f [f g x]
  (+  (f x) (g x)))

(defn greater-than [n]
  (fn [k] (> k n)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [item] (contains? a-set item)))

(defn pred-and [pred1 pred2]
  (fn [item] 
    (and (pred1 item)
         (pred2 item))))

(defn pred-or [pred1 pred2]
  (fn [item] 
    (or (pred1 item)
         (pred2 item))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
   (= "" string) true
   (whitespace? (first string)) (blank? (apply str (rest string)))
   :else false))

(defn has-award? [book award]
   (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
   (every? 
    (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (cond 
     (< 0 (count filtered)) (pred (first filtered))
     :else nil)))

(defn my-every? [pred a-seq]
  (let [filtered (filter pred a-seq)]
     (== (count a-seq) (count filtered))))
   

(defn prime? [n]
  (let [divides? (fn [m] (== 0 (mod n m)))]
    (every? false? (map divides? (range 2 (- n 1))))))

;^^
