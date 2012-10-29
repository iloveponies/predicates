(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (let [this-set-contains? (fn [item] (contains? a-set item))]
    (fn [a-coll] (this-set-contains? a-coll))))

(defn pred-and [pred1 pred2]
  (fn [arg] (and (pred1 arg) (pred2 arg))))
                                        ;I don't like that ((pred-and < >) 1 2)
                                        ;is not possible

(defn pred-or [pred1 pred2]
  (fn [arg] (or (pred1 arg) (pred2 arg))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? book :awards))

(defn HAS-ALL-THE-AWARDS? [book awards]
       (= (count (filter awards (:awards book))) (count awards)))

(defn my-some [pred a-seq]
  ((complement empty?) (filter pred a-seq)))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [numb] (if (= (mod n numb) 0) true false))]
    (not (some pred (range 2 n)))))
;^^
