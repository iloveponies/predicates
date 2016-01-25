(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))


(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (= (int k) n)))


(defn set->predicate [a-set]
  (fn [a-value] (contains? a-set a-value)))

(defn pred-and [pred1 pred2]
  (fn [a-value]
    (and (pred1 a-value)
         (pred2 a-value))))

(defn pred-or [pred1 pred2]
  (fn [a-value]
    (or (pred1 a-value)
         (pred2 a-value))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [all-whitespace (every? whitespace? string)]
    (or (empty? string)
        (= nil string)
        all-whitespace)))

(defn has-award? [book award]
  (contains? (set (get book :awards)) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [filtered-seq (filter (complement false?) (map pred a-seq))
        empty-filtered-seq (empty? filtered-seq)]
    (if empty-filtered-seq false (first filtered-seq))))

(defn my-every? [pred a-seq]
  (let [filtered-seq (filter (complement true?) (map pred a-seq))
        empty-filtered-seq (empty? filtered-seq)]
    empty-filtered-seq))

(defn prime? [n]
  (let [pred (fn[x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))

;^^
