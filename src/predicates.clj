(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (nil? string)
      (every? whitespace? (seq string))))

(defn has-award? [book award]
  (and (contains? book :awards)
       (contains? (:awards book) award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [pred-map (map pred a-seq)
        truthy-map (filter (fn [x] (or (true? x) (not= false x))) pred-map)]
    (if (empty? truthy-map)
        (do false)
        (first truthy-map))))

(defn my-every? [pred a-seq]
  (let [pred-map (map pred a-seq)
        falsey-filter (filter (fn [x] (or (nil? x) (= false x))) pred-map)]
    (if (empty? falsey-filter)
        (do true)
        (do false))))

(defn prime? [n]
  (let [divide? (fn [x] (zero? (mod n x)))]
    (not(some divide? (range 2 n)))))
;^^
