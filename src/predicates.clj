(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn compare-to [f n]
  (fn [x] (f x n)))

(defn less-than [n]
  (compare-to < n))

(defn equal-to [n]
  (compare-to == n))

(defn set->predicate [a-set]
  #(contains? a-set %))

(defn pred-and [pred1 pred2]
  #(and (pred1 %) (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %) (pred2 %)))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))


(defn has-award? [book award]
  (contains? (book :awards) award))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))


(defn my-some [pred a-seq]
  (first (filter #(not= false %) (map #(pred %) a-seq))))


(defn my-every? [pred a-seq]
  (apply = true (map pred a-seq)))



(defn prime? [n]
  (let [pred #(= 0 (mod n %))]
    (not (some pred (range 2 n)))))

;^^
