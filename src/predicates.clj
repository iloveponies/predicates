(ns predicates)

(defn sum-f [f g x]
 (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [n] (contains? a-set n)))

(defn pred-and [pred1 pred2]
  (fn [n](and (pred1 n)
              (pred2 n)
          )))

(defn pred-or [pred1 pred2]
  (fn [n](or (pred1 n)
              (pred2 n)
          )))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (nil? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [pred (fn [book]
              (fn [n] (has-award? book n)))]
  (every? (pred book) awards)))

(defn my-some [pred a-seq]
  (let [is-not-false-value? (fn [val](not (= val false)))]
    (first (filter is-not-false-value? (map pred a-seq)))
    ))


(defn my-every? [pred a-seq]
  (let [is-false (fn [value] (= value false))]
   (empty? (filter is-false (map pred a-seq)))))

(defn prime? [n]
  (let [numbers (fn [n] (range 2 n))
        is-divisible( fn [n] (fn [k] (== (mod n k ) 0)))]
    (empty? (filter (is-divisible n) (numbers n)))))
;^^
