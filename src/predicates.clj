(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string) (empty? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [does-have-award? (fn [item] (fn [k] (has-award? item k)))]
    (every? (does-have-award? book) awards)))

(defn my-some [pred a-seq]
    (if (empty? a-seq)
      false
      (if (pred (first a-seq))
        (pred (first a-seq))
        (my-some pred (rest a-seq)))))

(defn my-every? [pred a-seq]
 (== (count a-seq)(count (filter true? (apply vector (map pred a-seq))))))

(defn prime? [n]
  (let [divisible? (fn [k] (== 0 (mod n k)))]
    (not (some divisible? (range 2 n)))))
;^^
