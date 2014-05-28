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
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-this-award? (fn [award] (has-award? book award))]
    (every? has-this-award? awards)))

(defn my-some [pred a-seq]
  (let [is-this-true? (fn [elem] (pred elem))
        truthyfalsey (map is-this-true? a-seq)
        result (filter boolean truthyfalsey)]
    (if (empty? result) false (first result))
  ))

(defn my-every? [pred a-seq]
  (let [is-this-true? (fn [elem] (pred elem))
        truthyfalsey (map is-this-true? a-seq)
        result (filter (complement boolean) truthyfalsey)]
    (if (empty? result) true (first result))))

(defn prime? [n]
  (let [divisor? (fn [x] (boolean (= (mod n x) 0)))]
  (not (some divisor? (range 2 n)))))
;^^
