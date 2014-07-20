(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (> n k)))

(defn equal-to [n]
  (fn [k] (== n k)))

(defn set->predicate [a-set]
  "This function returns a predicate based on the supplied set, a-set."
  (fn [x]
    (if (contains? a-set x)
      true
      false)))

(defn pred-and [pred1 pred2]
  "This function returns a new predicate that returns true if both
  pred1 and pred2 are true, otherwise it returns false."
  (fn [x]
    (if (and (pred1 x) (pred2 x))
      true
      false)))

(defn pred-or [pred1 pred2]
  "This function returns a new predicate that returns true if either
  pred1 and pred2 are true, otherwise it returns false."
  (fn [x]
    (if (or (pred1 x) (pred2 x))
      true
      false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  "This function takes a string and returns if it is empty, nil, or has only
  whitespace."
  (if (or (empty? string) (every? whitespace? string))
    true
    false))

(defn has-award? [book award]
  "This function returns true if the book has won the award."
  (if (not (empty? (:awards book)))
    true
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  "This function returns true if the supplied book has won
  all awards given."
  (let [matching-awards (filter (set->predicate awards) (:awards book))]
    (if (= (count matching-awards) (count awards))
      true
      false)))

(defn my-some [pred a-seq]
  (let [truthy-vals (filter pred a-seq)
        pred-val (if (empty? truthy-vals)
                   nil
                   (pred (first truthy-vals)))]
    (if pred-val
      pred-val
      nil)))

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  :-)
;^^
