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
   (empty? string)             true
   (every? whitespace? string) true
   (= string nil)              true
   :else                       false))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [awarded (fn [award] (has-award? book award))]
    (every? true? (map awarded awards))))

(defn my-some [pred a-seq]
  (let [parc-resul (first (filter (complement false?) (map pred a-seq)))]
    (if (= parc-resul nil) false parc-resul)))

(defn my-every? [pred a-seq]
  (not (my-some false? (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
