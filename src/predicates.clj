(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))



(defn set->predicate [a-set]
  (fn [v] (contains? a-set v )))


(defn pred-and [pred1 pred2]
  (fn [v] (and (pred1 v) (pred2 v))))

(defn pred-or [pred1 pred2]
  (fn [v] (or (pred1 v) (pred2 v))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))



(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award)))



(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [books-awards (:awards book)]
    (every?  books-awards awards)
    ))


(defn my-some [pred a-seq]
  (let [tests (map pred a-seq)
      extractor (fn [x] ((complement false?) x))]
    (first (filter extractor tests)
    )))


(defn my-every? [pred a-seq]

  (let [tests (map pred a-seq)
        xtests  (filter false? tests)]
   (empty? xtests)))



(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x))) ]
    (not (some pred (range 2 n)))))

;^^
