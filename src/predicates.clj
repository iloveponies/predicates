(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x]
    (cond
      (or (nil? x) (false? x)) true
      (a-set x) true
      :else false)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (if (and (pred1 x) (pred2 x)) true false)))

(defn pred-or [pred1 pred2]
  (fn [x]
    (if (or (pred1 x) (pred2 x)) true false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
    (every? whitespace? string) true
    (empty? string) true
    (nil? string) true
    :else false))

(defn has-award? [book award]
  (cond
    (nil? (:awards book)) false
    :else true))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)
        check-award (fn [x] (contains? book-awards x))]
    (if (every? check-award awards) true false)))

(defn my-some [pred a-seq]
  (if (empty? (filter pred a-seq)) nil (first (map pred (filter pred a-seq)))))

(defn my-every? [pred a-seq]
   (if (= (filter pred a-seq) a-seq) true false))

(defn prime? [n]
  (let [divides-n? (fn [x] (if (= (mod n x) 0) true false))]
    (if (empty? (filter divides-n? (range 2 n))) true false)))
;^^


(my-some even? [1 3 5 7])       ;=> falsey
(my-some even? [1 3 5 7 8])     ;=> true
(my-some neg? [1 3 5 0 7 8])    ;=> falsey
(my-some neg? [1 3 5 0 7 -1 8]) ;=> true
(my-some neg? [])               ;=> falsey
(my-some first [[false] [1]])   ;=> 1
(my-some first [[false] []])    ;=> falsey
(my-some nil? [1 2])            ;=> falsey
(my-some nil? [1 nil 2])        ;=> true
