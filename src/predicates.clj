(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
)

(defn less-than [n]
  (fn [k] (< k n))
)

(defn equal-to [n]
  (fn [k] (== k n))
)

(defn set->predicate [a-set]
  (fn [x] (if (contains? a-set x) true false))
)

(defn pred-and [pred1 pred2]
  (fn [x] (if (and (pred1 x) (pred2 x)) true false))
)

(defn pred-or [pred1 pred2]
  (fn [x] (if (or (pred1 x) (pred2 x)) true false))
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)
)

(defn has-award? [book award]
  (let [awards (get book :awards)]
    (if (contains? awards award) true false)))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [bookawards (get book :awards)]
     (let [isinawards? (fn [x] (contains? bookawards x))]
       (every? isinawards? awards)))
)

(defn my-some [pred a-seq]
  (cond (empty? a-seq) false
        (pred (first a-seq)) (pred (first a-seq))
        :else (my-some pred (rest a-seq)))
)

(defn my-every? [pred a-seq]
  (cond (empty? a-seq) true
        (pred (first a-seq)) (my-every? pred (rest a-seq))
        :else false))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))










