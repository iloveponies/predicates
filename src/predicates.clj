(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  (partial == n))

(defn set->predicate [a-set]
  (partial contains? a-set))

(defn pred-and [pred1 pred2]
  (every-pred pred1 pred2))

(defn pred-or [pred1 pred2]
  (some-fn pred1 pred2))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (boolean (award (:awards book))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))

(def truthy? boolean)

(def falsey? (complement truthy?))

(defn my-some [pred a-seq]
  (first (filter truthy? (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter falsey? (map pred a-seq))))

(defn prime? [n]
  (let [divides-n? (fn [x] (= 0 (mod n x)))]
    (not (some divides-n? (range 2 n)))))

;^^
