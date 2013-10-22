(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== n %))

(defn set->predicate [a-set]
  #(contains? a-set %))

(defn pred-and [pred1 pred2]
  #(boolean (and (pred1 %) (pred2 %))))

(defn pred-or [pred1 pred2]
  #(boolean (or (pred1 %) (pred2 %))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string) (empty? string) (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (first (filter boolean (map pred a-seq))))

(defn my-every? [pred a-seq]
  (reduce (fn [ok? a] (and ok? (boolean (pred a)))) true a-seq))

(defn prime? [n]
  (not (some #(= 0 (mod n %)) (range 2 n))))

;^^
