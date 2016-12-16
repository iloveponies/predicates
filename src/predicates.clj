(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(sum-f inc dec 4)
(sum-f inc identity 5)
(sum-f identity - 10)

(defn less-than [n]
  (fn [x] (< x n)))

(filter (less-than 3) [1 2 3 4 5])

(defn equal-to [n]
  (fn [x] (== x n)))


(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(filter (set->predicate #{1 2 3})     [0 2 4 6])
(filter (set->predicate #{1 2 3 nil}) [2 nil 4 nil 6])

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(filter (pred-and pos? even?) [1 2 -4 0 6 7 -3])

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(filter (pred-or pos? odd?) [1 2 -4 0 6 7 -3])
(filter (pred-or pos? even?) [1 2 -4 0 6 7 -3])

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn subset-of? [subset superset]
  (let [bools (map (fn [x] (contains? superset x)) subset)]
    (every? true? bools)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (subset-of? awards (:awards book)))


(filter nil? [1 nil 2])

(defn my-some [pred a-seq]
  (let [bools (map pred a-seq)
        filtered (filter (fn [x] (boolean x)) bools)]
    (first filtered)))

(map even? [8])

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
  (let [opp (complement pred)]
    (nil? (my-some opp a-seq))))


(mod 2 3)
(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))

