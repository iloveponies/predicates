(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (= (- k 0.1) (- n 0.1))))

(defn set->predicate [a-set]
  (fn [x] (if (and (not (contains? a-set x)) (= nil (a-set x))) false true)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (= "" string) (= nil string) (every? whitespace? string)))

(defn has-award? [book award]
  (not= nil (get (book :awards) award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [pred (fn [award] (not= nil (get (book :awards) award)))]
    (every? pred awards)))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq) true
    (= (count a-seq) (count (filter pred a-seq)))))

(defn prime? [n]
  (let [pred (fn [in] (= 0 (mod n in)))]
    (not (some pred (range 2 n)))))
;^^
