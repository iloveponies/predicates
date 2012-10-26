(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [j] (< j n)))

(defn equal-to [n]
  (fn [j] (== j n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map)))

(defn pred-and [pred1 pred2]
  (fn [a-map] (and (pred1 a-map) (pred2 a-map))))

(defn pred-or [pred1 pred2]
  (fn [a-map] (or (pred1 a-map) (pred2 a-map))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [h-a? (fn [x] (has-award? book x))]
    (every? h-a? awards)))

(defn my-some [pred a-seq]
  (not (empty? (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (not (my-some false? (map pred a-seq))))

(defn prime? [n]
  (let [divs? (fn [x] (== 0 (mod n x)))]
    (not (some divs? (range 2 n)))))

;^^
