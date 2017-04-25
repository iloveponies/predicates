(ns predicates)

(defn sum-f [f g x]
  (let [f-result (f x)
        g-result (g x)]
    (+ f-result g-result)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (boolean (and (pred1 x)
                        (pred2 x)))))

(defn pred-or [pred1 pred2]
  (fn [x] (boolean (or (pred1 x)
                       (pred2 x)))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (boolean (or (== (count string) 0)
               (every? whitespace? string))))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [bool-v (map pred a-seq)
        trues (filter boolean bool-v)]
    (first trues)))

(defn my-every? [pred a-seq]
  (let [bool-v (map pred a-seq)
        trues (filter boolean bool-v)
        len-seq (count a-seq)
        len-trues (count trues)]
    (boolean (== len-trues len-seq))))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
