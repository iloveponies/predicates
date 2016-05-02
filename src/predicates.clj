(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (if (and
                  (pred1 x)
                  (pred2 x))
              true
              false)))

(defn pred-or [pred1 pred2]
  (fn [x] (if (or
                (pred1 x)
                (pred2 x))
            true
            false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (if (and
        (:awards book)
        (award (:awards book))) true false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
  ((complement empty?) (filter true? (map pred a-seq))))


(my-some even? [1 3 5 7])       ;=> falsey
(my-some even? [1 3 5 7 8])     ;=> true
(my-some neg? [1 3 5 0 7 8])    ;=> falsey
(my-some neg? [1 3 5 0 7 -1 8]) ;=> true
(my-some neg? [])               ;=> falsey
(my-some first [[false] [1]])   ;=> 1
(my-some first [[false] []])    ;=> falsey
(my-some nil? [1 2])            ;=> falsey
(my-some nil? [1 nil 2])        ;=> true


(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [pred #(= 0 (mod n %))]
    (not (some pred (range 2 n)))))


;^^
