(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  (if (contains? a-set nil)
    (fn [x] (or (a-set x) (nil? x)))
    a-set))

(defn pred-and [pred1 pred2]
  (fn [x] (reduce #(and %1 %2)
                  ((juxt pred1 pred2) x))))

(defn pred-or [pred1 pred2]
  (fn [x] (reduce #(or %1 %2)
                  ((juxt pred1 pred2) x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [book-awards (:awards book)]
    (contains? book-awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)]
    (every? book-awards awards)))

(defn truthy? [x]
  (true? (boolean x)))

(defn my-some [pred a-seq]
  (first (filter truthy? (map pred a-seq))))

(defn my-every? [pred a-seq]
  (every? true? (map pred a-seq)))

(defn prime? [n]
  (let [pred #(= (mod n %) 0)]
    (not (some pred (range 2 n)))))
;^^
