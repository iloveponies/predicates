(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [m] (< m n)))

(defn equal-to [n]
  (fn [m] (== n m)))

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
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award (fn [a] (has-award? book a))]
    (every? book-has-award awards)))

(defn my-some [pred a-seq]
  (let [p (complement (pred-or nil? false?))
        m-seq (map pred a-seq)]
    (first (filter p m-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
