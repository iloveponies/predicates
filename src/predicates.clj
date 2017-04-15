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
  (fn [n] (and (pred1 n) (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n) (pred2 n))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
   (empty? string) true
   (every? whitespace? string) true
   :else false))

(defn has-award? [book award]
  (if (award (:awards book)) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [dm (fn [award] (has-award? book award))]
    (every? dm awards)))

(defn my-some [pred a-seq]
  (let [t? (fn [s] (if (pred s) (pred s) false))
        f (fn [s] (if (false? s) false s))
        que (map t? a-seq)]
    (first (filter f que))))

(defn my-every? [pred a-seq]
  (let [que (map pred a-seq)
        f (fn [s] (if (false? s) false s))]
    (if (= (filter f que) que) true false)))

(defn prime? [n]
  (let [m (fn [a] (and (< a n) (= (/ n a) (quot n a))))
        pred (fn [que] (map m que))]
    (not (some true? (pred (range 2 n))))))
