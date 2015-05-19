(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn pred-and [pred1 pred2]
(fn [n] (and (pred1 n) (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n) (pred2 n))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
   (every? whitespace? string))

(defn has-award? [book award]
(contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
 (let [has (fn [award] (has-award? book award))]
    (every? has awards)))

(defn my-some [pred a-seq]
 (first(filter (complement false?) (map pred a-seq))))


(defn my-every? [pred a-seq]
(if (empty? (filter (complement true?) (map pred a-seq)))
  true
  false
  ))

(defn prime? [n]
  (let [divide (fn [k] (== 0 (mod n k)))]
    (not (some divide (range 2 n)))))
;^^
