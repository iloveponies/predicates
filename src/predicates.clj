(ns predicates)

(defn sum-f
  "returns (+ (f x) (g x))"
  [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and 
             (pred1 x)
             (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or 
            (pred1 x)
            (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [pred (fn [x] (has-award? book x))
        is-false? (fn [x] (= false x))]
    (empty? (filter is-false?
                   (map pred awards)))))

(defn my-some [pred a-seq]
  (let [is-true? (fn [x] (= true x))]
    (not (empty? (filter is-true? 
                   (map pred a-seq))))))

(defn my-every? [pred a-seq]
  (let [is-false? (fn [x] (= false x))]
    (empty? (filter is-false? 
              (map pred a-seq)))))

(defn prime? [n]
  (let [pred (fn [x] (integer? (/ n x)))]
    (not (some pred (range 2 n)))))

;^^
