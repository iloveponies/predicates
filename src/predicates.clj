(ns predicates)

(defn sum-f [f g x]
  (+ (f x)(g x)))

(defn less-than [n]
  (fn [v] (< v n)))

(defn equal-to [n]
  (fn [v] (== v n)))

(defn set->predicate [a-set]
  (fn [v] (contains? a-set v)))

(defn pred-and [pred1 pred2]
  (fn [v] (and (pred1 v) (pred2 v))))

(defn pred-or [pred1 pred2]
  (fn [v] (or (pred1 v) (pred2 v))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (and (contains? (:awards book) award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (partial has-award? book) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (if (empty? filtered)
      false
      (pred (first filtered)))))

;;  (defn my-some [pred a-seq]
;;     (first (filter (fn [x] (not (= x false)))      ; 2. filter out falsey elements 3. And take the first from the remainder
;;                   (map (fn [x] (pred x)) a-seq)))) ; 1. map a-seq to (pred x)

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [v] (= 0 (mod n v)))]
    (not (some pred (range 2 n))))) ; if there is some number between 2 ... n-1 that can devide n then it is not a prime
