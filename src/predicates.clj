(ns predicates)

(defn sum-f [f g x] (+ (f x) (g x)))

(defn greater-than [n]
  (fn [k] (> k n)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (= (double k) (double n))))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (and
    ((complement empty?) (:awards book))
    (contains? (:awards book) award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [p (fn [a] (has-award? book a))]
    (every? p awards)))

(defn my-some [pred a-seq]
  (let [f (first (filter (complement false?) (map pred a-seq)))]
    (if (nil? f) false f)))


(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [r (range 2 n)
        p (map (fn [x] (= (mod n x) 0)) r)]
    (not (some true? p))))
;^^
