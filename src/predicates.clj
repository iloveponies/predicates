(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (> n x)))

(defn equal-to [n]
 (fn [x] (= (double n) (double x))))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
    (every? whitespace? string) true
    (empty? string) true
    :else false))

(defn has-award? [book award]
    (let [award-set #{award}
        not-empty? (complement empty?)]
  (not-empty? (filter award-set (:awards book)))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? true? (map (fn [x] (has-award? book x)) awards)))

(defn my-some [pred a-seq]
  (let [no-falsey (filter (fn [x] ((complement false?) x)) (map pred a-seq))]
    (cond
      (or (empty? no-falsey) (every? nil? no-falsey)) false
      :else (first no-falsey))))

(defn my-every? [pred a-seq]
  (empty? (filter (fn [x] ((complement true?) x)) (map pred a-seq))))

(defn prime? [n]
  (let [divisors (range 2 n)]
    (empty? (filter (complement false?) (map (fn [x] (if (= (mod n x) 0) true false)) divisors)))))
;^^


