(ns predicates)

(defn sum-f [f g x] (+ (f x) (g x)))

(defn less-than [n] (fn [x] (< x n)))

(defn equal-to [n] (fn [x] (== x n)))

(defn set->predicate [a-set] (fn [x] (if (contains? a-set x) true false)))

(defn pred-and [pred1 pred2] (fn [x](and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2] (fn [x](or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string] (let [helpfunc (fn[x] (or (whitespace? x) (= x "") (= x nil)))]
                         (every? helpfunc string)))

(defn has-award? [book award] (let [awardswon (:awards book)]
                                (contains? awardswon award)))

(defn HAS-ALL-THE-AWARDS? [book awards] (let [helpfunc (fn [x] (has-award? book x))]
                                (every? helpfunc awards)))

(defn my-some [pred a-seq] (let [temp (filter pred a-seq)]
                             (if (empty? temp) nil (pred (first temp)))))

(defn my-every? [pred a-seq] (not (my-some (complement pred ) a-seq )))

(defn prime? [n] (let [pred (fn[x] (zero? (mod n x)))]
                     (not (some pred (range 2 n)))))
;^^


