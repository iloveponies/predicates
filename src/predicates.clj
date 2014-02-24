(ns predicates)

(defn sum-f [f g x]
  (apply + ((juxt f g) x)))

(defn less-than [n]
  (partial > n))

(defn equal-to [n]
  (partial == n))

(defn set->predicate [a-set]
  (partial contains? a-set))

(defn pred-and [& preds]
  (comp (partial every? true?) (apply juxt preds)))

(defn pred-or [& preds]
  (comp (partial some true?) (apply juxt preds)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (true? ((pred-or (partial every? whitespace?)
                   nil?
                   empty?)
          string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (and (> n 1)
       (let [pred (comp zero? (partial mod n))]
         (not (some pred (range 2 n))))))

