(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  #(contains? a-set %))

(defn pred-and [pred1 pred2]
  #(and (pred1 %) (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %) (pred2 %)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? #(whitespace? %) string))

(defn has-award? [book award]
  (if (and (:awards book) ((:awards book) award))
    true
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(contains? (:awards book) %) awards ))

(defn my-some [pred a-seq]
 (first (filter (fn [x] x) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (empty? (filter (fn [x] x) (map (complement pred) a-seq))))

(defn prime? [n]
  (not (some #(zero? (mod n %)) (range 2 n))))
;^^
