(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn greater-than [n]
  (fn [k] (> k n)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn set->predicate [a-set]
  (fn [x] (boolean (contains? a-set x))))

(defn non-negatives [a-seq]
  (let [non-negative? (fn [n] (not (neg? n)))]
    (filter non-negative? a-seq)))


(defn non-negatives [a-seq]
  (filter (complement neg?) a-seq))

(defn pred-and [pred1 pred2]
 (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [awards (:awards book)
		valid (award awards)]
	(boolean valid)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-award?-helper (fn [award]
							(has-award? book award))]
  (every? has-award?-helper awards)))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (let [fails (filter (complement pred) a-seq)
		valid (empty? fails)]
	(boolean valid)))

(defn prime? [n]
  (let [pred (fn [x]
			   (not
				(or (not (== 0(mod n x)))
				   	(== x n)
				   	(== x 1))))]
    (not (some pred (range 2 n)))))


;^^


