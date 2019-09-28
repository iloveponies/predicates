(ns predicates)

(defn sum-f [f g x]
  (+ (f x)(g x)))

(defn less-than [n]
  (fn [p] (< p n)))

(defn equal-to [n]
  (fn [p] (== p n)))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn non-negatives [a-seq]
  (filter (complement neg?) a-seq))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn complement [predicate]
  (fn [x] (not (predicate x))))

(defn pred-and [pred1 pred2]
  (fn [p] (and (pred1 p)(pred2 p))))

(defn pred-or [pred1 pred2]
   (fn [p] (or (pred1 p)(pred2 p))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [books awards]
    (every? (fn [award] (contains? (books :awards) award)) awards))

(defn my-some [pred a-seq]
  (if (not= nil (first (take 1 (filter (fn [p] (and (not= p false) (not= p nil))) (map pred a-seq)))))
    (first (take 1 (filter (fn [p] (and (not= p false) (not= p nil))) (map pred a-seq))))
    false))

(defn my-every? [pred a-seq]
  (if (= false (first (take 1 (filter (fn [p] (= p false)) (map pred a-seq)))))
    false
    true))

(defn prime? [n]
  (not (some (fn [p] (= 0 (mod n p))) (range 2 n))))

(prime? 4) ;=> false
(prime? 7) ;=> true
(prime? 10) ;=> false
(filter prime? (range 2 50)) ;=> (2 3 5 7 11 13 17 19 23 29 31 37 41 43 47)
