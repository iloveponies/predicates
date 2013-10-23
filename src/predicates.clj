(ns predicates)

(defn sum-f [f g x]
  "Sums f(x) and g(x)"
  (+ (f x)(g x)))

(defn less-than [n]
  "Returns predicate f(k) that checks if k < n,
  where n is input of less-than"
  (fn [k] (< k n)))

(defn equal-to [n]
  "Returns predicate f(k) that checks if k == n,
  where n is the input of equal-to"
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  "Returns a predicate f(k) that checks if a-set contains k,
  where a-set is input of set->predicate"
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  "Returns a predicate f(x), that checks whether
  (pred1 x) AND (pred2 x) return true"
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  "Returns a predicate f(x) that checks whether
  (pred1 x) OR (pred2 x) return true"
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  "Returns true if character is whitespace"
  (Character/isWhitespace character))

(defn blank? [string]
  "True if whole string is only whitespace"
  (every? whitespace? string))

(defn has-award? [book award]
  "True <=> book has award"
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  "True <=> book has all the awards"
    ;(has-avard? book award)
    ; ->(fn [award] (has-award? book award))
    ;we need a "middle guy" -> (every? middle-guy awards)
  (every? (fn [award] (has-award? book award)) awards ))

;a bit confusing version I suppose
(defn my-some [pred a-seq]
  "Returns first truthy value returned by pred"
  (let [eka (first (filter pred a-seq))]
    (if eka
     (pred eka)
      (if (boolean eka)
        true
        (contains? (set (map pred a-seq)) true)))))

(defn my-every? [pred a-seq]
  "Checks if pred returns true for every item in a-seq"
  (let [lista (filter (complement pred) a-seq)]
    (if (empty? lista)
      true
      false)))

(defn prime? [n]
  "Checks if n is a prime"
  (let [pred (fn [k] (= 0 (mod n k)))]
    (not (some pred (range 2 n)))))
;^^
