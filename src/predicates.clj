(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
	(fn [a] (contains? a-set a)))

(defn pred-and [pred1 pred2]
  (fn [a] (and (pred1 a) (pred2 a))))

(defn pred-or [pred1 pred2]
  (fn [a] (or (pred1 a) (pred2 a))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [truethys (filter pred a-seq)]
	     (if (empty? truethys)
				   nil 
					 (pred (first truethys)))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [divisors (range 2 (- n 1))
	      is-divisible? (fn [divsr] (== 0 (mod n divsr)))]
				(every? (complement is-divisible?) divisors)))
;^^
