(ns predicates)

(defn sum-f [f g x]
  (+ (g x) (f x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (contains? (get book :awards) x)) awards)) ; can't figure out how to pass multiple params to predicate in every?, but this way works too

(defn my-some [pred a-seq]
  (let [mapped-items (map pred a-seq)
        truthy-items (filter (fn [x] (true? (boolean x))) mapped-items)]
    (cond
        (empty? mapped-items) false
        :else (first truthy-items)
        )
     ))

(defn my-every? [pred a-seq]
  (let [a-seq-len (count a-seq)
        truthy-a-seq-items (filter pred a-seq)]
        (= (count truthy-a-seq-items) a-seq-len)))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (rem n x)))]
    (not (some pred (range 2 n)))))
;^^
