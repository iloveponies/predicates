(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  (fn [x]
    (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x)
        (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x)
        (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [book-awards (:awards book)]
    (if (not book-awards)
      false
      (if (not (contains? book-awards award))
        false
        true))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-award-map #(has-award? book %)]
    (every? has-award-map awards)))

(defn my-some [pred a-seq]
  (let [values (filter pred a-seq)
        first-value (first values)]
    (if (empty? values)
      false
      (pred first-value))))

(defn my-every? [pred a-seq]
  (let [result (filter (complement pred) a-seq)]
    (empty? result)))

(defn prime? [n]
  (let [num (filter #(= 0 (mod n %)) (range 2 n))]
    (empty? num)))
;^^
