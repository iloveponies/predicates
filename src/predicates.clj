(ns predicates)

(defn sum-f [f g x]
  ;(+ (f x) (g x))
  (+ (f x) (g x)))

(defn less-than [n]
 (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-pred] (contains? a-set a-pred)))

(defn pred-and [pred1 pred2]
   (fn[a-seq]  (and (pred1 a-seq)
                  (pred2 a-seq))))

(defn pred-or [pred1 pred2]
   (fn[a-seq]  (or (pred1 a-seq)
                  (pred2 a-seq))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
   (empty? string) true
   (nil? string) true
   (every? whitespace? string) true
   :else false))

(defn has-award? [book award]
  (contains? (:award book) award))

;(defn HAS-ALL-THE-AWARDS? [book awards]
;  (every? (fn[x] has-award? book x) awards))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))


(defn my-some [pred a-seq]
  (boolean
  (first (filter pred a-seq)))
   )

;(defn my-some [pred a-seq]
;  (boolean (filter pred (map first a-seq))))

(defn my-every? [pred a-seq]
  (boolean (complement
  (first (filter pred a-seq)))
   ))

(defn prime? [n]
  (let [pred (fn[x] (== (mod n x)0)) ]
  (not (some pred (range 2 n)))))
;^^
