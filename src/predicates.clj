(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  #(contains? a-set %))

(defn pred-and [& predicates]
  (fn [element] (every? identity (map #(% element) predicates))))

(defn pred-or [& predicates]
  (fn [element] (some identity (map #(% element) predicates))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
    (empty? string)
    (= nil string)
    (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [candidate] (= 0 (mod n candidate)))]
    (not (some pred (range 2 n)))))
;^^
