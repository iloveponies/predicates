(ns predicates)

(defn sum-f
  [f g x]
  (+ (f x) (g x)))

(defn less-than
  [n]
  (partial > n))

(defn equal-to
  [n]
  (partial == n))

(defn set->predicate
  [a-set]
  (partial contains? a-set))

(defn pred-and
  [pred1 pred2]
  #(and (pred1 %) (pred2 %)))

(defn pred-or
  [pred1 pred2]
  #(or (pred1 %) (pred2 %)))

(defn whitespace?
  [character]
  (Character/isWhitespace character))

(defn blank?
  [string]
  (every? whitespace? string))

(defn has-award?
  [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS?
  [book awards]
  (clojure.set/superset? (:awards book) awards))

(defn- truthy?
  [x]
  (if x true false))

(defn my-some
  [pred a-seq]
  (first (filter truthy? (map pred a-seq))))

(defn my-every?
  [pred a-seq]
  (= a-seq (filter pred a-seq)))

(defn prime?
  [n]
  (let [pred (comp zero? (partial mod n))]
    (not (some pred (range 2 n)))))

;^^
