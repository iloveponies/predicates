(ns predicates)

(defn sum-f [f g x]
	(+ (f x) (g x)))

(defn less-than [n]
	(fn [k] (< k n)))

(defn equal-to [n]
	(fn [k] (== k n)))

(defn set->predicate [a-set]
	(fn [k] (if (contains? a-set k)
		true
		false)))

(defn pred-and [pred1 pred2]
	(fn [k] (and (pred1 k) (pred2 k))))


(defn pred-or [pred1 pred2]
	(fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
	(every? (fn [x] (or (whitespace? x) (nil? x))) string))

(defn has-award? [book award]
	(let [awards (:awards book)]
	(if (contains? awards award)
		true
		false)))

(defn HAS-ALL-THE-AWARDS? [book awards]
	(every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
	(first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq]
	 (= (count a-seq) (count (filter pred a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
