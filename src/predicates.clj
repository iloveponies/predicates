(ns predicates)

(defn sum-f [f g x]
  "Returns the sum of two functions."
  (+ (f x) (g x)))

(defn less-than [n]
  "Returns a predicate that checks if its parameter is less than n."
   (fn [x] (< x n)))

(defn equal-to [n]
  "Returns a predicate that checks if its parameter is equal to n."
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  "Returns a predicate that checks if its parameter is contained in a set."
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  "Returns a predicate that ANDs two predicates (given as parameters)."
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  "Returns a predicate that ORs two predicates (given as parameters)."
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  "Checks if all characters in a string are whitespace."
  (every? whitespace? string))

(defn has-award? [book award]
  "Checks if a book has won an award."
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS?
  "Checks if a book has all the awards (passed as a parameter).
   The set of book's awards is used as a predicate against awards."
  [book awards]
  (every? (:awards book) awards))


;;;Some
;Returns the first logical true value of (pred x) for any x in coll,
;else nil. One common idiom is to use a set as pred, for example
;this will return :fred if :fred is in the sequence, otherwise nil:
;(some #{:fred} coll)

(defn my-some [pred a-seq]
  "Returns the first logical true value of (pred x) for any x in coll, else nil."
  (if (empty? a-seq)
    nil
    (if (pred (first a-seq))
      (pred (first a-seq))
      (my-some pred (rest a-seq)))))

(defn my-every?
  "Checks if every value in a sequence passes the predicate."
  [pred a-seq]
  (= (count (filter pred a-seq))
     (count a-seq)))

(defn prime?
  "Checks if a number is prime. Naive implementation."
  [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
