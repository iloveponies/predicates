(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

;=============================================

(defn less-than [n]
  (fn [k] (< k n)))

;=============================================

(defn equal-to [n]
  (fn [k] (== k n)))

;=============================================

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

;=============================================

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)
               (pred2 x))))

;=============================================

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)
              (pred2 x))))

;=============================================

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (nil? string)
      (every? whitespace? string)))

;=============================================

(defn has-award? [book award]
  (contains? (:awards book) award))

;=============================================

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

;=============================================

(defn my-some [pred a-seq]
  (let [result (filter (fn [x] (pred x)) a-seq)]
    (if (not (nil? (first result)))
      (pred (first result))
      (not (empty? result)))))

(my-some even? [1 3 5 7])       ;=> falsey
(my-some even? [1 3 5 7 8])     ;=> true
(my-some neg? [1 3 5 0 7 8])    ;=> falsey
(my-some neg? [1 3 5 0 7 -1 8]) ;=> true
(my-some neg? [])               ;=> falsey
(my-some first [[false] [1]])   ;=> 1
(my-some first [[false] []])    ;=> falsey
(my-some nil? [1 2])            ;=> falsey
(my-some nil? [1 nil 2])        ;=> true

(some even? [1 3 5 7])       ;=> falsey
(some even? [1 3 5 7 8])     ;=> true
(some neg? [1 3 5 0 7 8])    ;=> falsey
(some neg? [1 3 5 0 7 -1 8]) ;=> true
(some neg? [])               ;=> falsey
(some first [[false] [1]])   ;=> 1
(some first [[false] []])    ;=> falsey
(some nil? [1 2])            ;=> falsey
(some nil? [1 nil 2])        ;=> true

;=============================================

(defn my-every? [pred a-seq]
  (let [boos (map pred a-seq)]
    (empty? (filter (fn [x] (not x)) boos))))

;=============================================

(defn prime? [n]
  (let [pred (fn [x] (and
                       (= 0 (mod n x))
                       (not (== n x))))]
    (not (some pred (range 2 n)))))

;^^
