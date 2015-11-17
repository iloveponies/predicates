(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [is-blank (fn [chr] (or (whitespace? chr) (nil? chr) (= "" chr)))]
    (every? is-blank string)))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-award (fn [award] (has-award? book award))]
    (every? has-award awards)))

(defn my-some [pred a-seq]
   (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (let [filter-result (filter pred a-seq)
        filter-result-size (count filter-result)
        initial-seq-size (count a-seq)]
  (= initial-seq-size filter-result-size)))

(defn prime? [n]
  (let [is-a-divisor? (fn [potential-divisor] (= 0 (mod n potential-divisor)))]
    (not (some is-a-divisor? (range 2 n)))))
;^^
