(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn greater-than [n]
  (fn [k] (> k n)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map]
    (contains? a-set a-map)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
 (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (set
                     (filter
                      (fn [x]
                        (has-award? book x))
                      awards))]
    (= book-awards
       awards)))

(defn my-some [pred a-seq]
  (first
   (vec
    (filter
     (complement false?) (map pred a-seq)))))

(defn my-every? [pred a-seq]
  (empty?
   (filter
    (complement pred)
     a-seq)))

(defn prime? [n]
  (empty?
   (filter
    (fn [x] (= (rem n x) 0))
            (range 2 n))))
;^^
