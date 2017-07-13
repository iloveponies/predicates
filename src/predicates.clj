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
  (if (every? whitespace? string)
    true
    (if (empty? string)
      true
      false)))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-won?
        (fn [award] (has-award? book award))]
    (every? has-won? awards)))

(defn my-some [pred a-set]
  (cond
    (empty? (map pred a-set))                                      false
    (nil? (first (filter (complement false?) (map pred a-set))))   false
    :else                                                          (first (filter (complement false?) (map pred a-set)))
    ))

(defn my-every? [pred a-set]
  (let [filtered-set
        (filter (complement true?) (map pred a-set))]
    (if (empty? filtered-set)
      true
      false)))

(defn prime? [n]
  (let [pred
    (fn [k] (= (mod n k) 0))]
  (not (some pred (range 2 n)))))
;^^
