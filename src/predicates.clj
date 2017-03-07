(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [value] (< value n)))

(defn equal-to [n]
  (fn [value] (== value n)))

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
  (let [has-award-pred? (fn [award] (has-award? book award))]
    (every? has-award-pred? awards)))

(defn my-some [pred a-seq]
  (let [filtered-seq (filter pred a-seq)]
    (if (empty? filtered-seq) 
      nil 
      (pred (first filtered-seq)))))
    
(defn my-every? [pred a-seq]
  (if (empty? a-seq) 
    true 
    (= (seq a-seq) (filter pred a-seq))))

(defn prime? [n]
  (let [divisible? (fn [divider] (= (mod n divider) 0))]
    (not (some divisible? (range 2 n)))))

;^^
