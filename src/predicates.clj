(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [limit]
  (fn [tested-number] (< tested-number limit)))

(defn equal-to [limit]
  (fn [tested-number] (== tested-number limit)))

(defn set->predicate [a-set]
  (fn [tested-set-value] 
    (contains? a-set tested-set-value)))

(defn pred-and [pred1 pred2]
  (fn [tested-value] (and (pred1 tested-value) (pred2 tested-value))))

(defn pred-or [pred1 pred2]
  (fn [tested-value] (or (pred1 tested-value) (pred2 tested-value))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (apply = true (map pred a-seq)))

(defn prime? [n]
  (let [pred (fn [candidate]
               (zero? (mod n candidate)))]
    (not (some pred (range 2 n)))))
;^^
