(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [e] (contains? a-set e)))

(defn pred-and [pred1 pred2]
  (fn [e] (and (pred1 e) (pred2 e))))

(defn pred-or [pred1 pred2]
  (fn [e] (or (pred1 e) (pred2 e))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards))

(defn my-some [pred a-seq]
  (let [head (first a-seq)
        tail (rest a-seq)]
    (if (empty? a-seq)
      nil
      (if (pred head)
        (pred head)
        (my-some pred tail)))))

(defn my-every? [pred a-seq]
((complement some) (complement pred) a-seq))

(defn prime? [n]
  (let [pred (fn [d] (== 0 (mod n d)))]
    (not (some pred (range 2 n)))))
;^^
