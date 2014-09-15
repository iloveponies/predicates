(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map)))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [a (fn [k] (has-award? book k))]
    (every? a awards)))

(defn my-some [pred a-seq]
  (let [helpr (fn [x] (pred x))]
    (cond
     (= nil (some helpr a-seq)) false
     :else (some helpr a-seq))))

(defn my-every? [pred a-seq]
  (let [helpr (fn [x] (pred x))]
    (if(empty? (filter false? (map helpr a-seq)))
      true
      false)))

(defn prime? [n]
  (let [pred (fn [x] (integer? (/ n x)))]
    (not (some pred (range 2 n)))))

;^^
