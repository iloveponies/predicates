(ns predicates)

(defn sum-f 
  "Returns the sum of two functions."
  [f g x]
  (+ (f x) (g x)))

(defn less-than 
  "Returns a predicate that checks if its parameter is less than n." 
  [n]
  (fn [x] (< x n)))

(defn equal-to 
  "Returns a predicate that checks if its parameter is equal to n."
  [n]
  (fn [x] (== x n)))

(defn set->predicate 
  "Returns a predicate that checks if its parameter is contained in a set."
  [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and
  "Returns a predicate that ANDs two predicates (given as parameters)."
  [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or
  "Returns a predicate that ORs two predicates (given as parameters)."
  [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace?
  [character]
  (Character/isWhitespace character))

(defn blank? 
  "Checks if all characters in a string are whitespace."
  [string]
  (every? whitespace? string))

(defn has-award?
  "Checks if a book has won an award."
  [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS?
  "Checks if a book has all the awards (passed as a parameter).
   The set of books is used as a predicate against awards."
  [book awards]
  (every? (:awards book) awards))

(defn my-some 
  "Checks if any value in a sequence passes the predicate."
  [pred a-seq]
  (> (count (filter pred a-seq))
      0))

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

