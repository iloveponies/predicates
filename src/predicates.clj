(ns predicates)

(defn sum-f [f g x] (+ (f x) (g x)))

(defn less-than [n] (fn [value] (< value n)))

(defn equal-to [n] (fn [value] (== value n)))

(defn set->predicate [a-set] (fn [x] (not (empty? (filter (fn [e] (= e x)) a-set)))))

(defn pred-and [pred1 pred2] (fn [value] (and (pred1 value) (pred2 value))))

(defn pred-or [pred1 pred2] (fn [value] (or (pred1 value) (pred2 value))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string] (every? (fn [ch] (whitespace? ch)) string))

(defn has-award? [book award] (not (or (= nil (:awards book)) (empty? (:awards book)))))

(defn HAS-ALL-THE-AWARDS? [book awards] (every? (fn [award] (contains? (:awards book) award)) awards))

(defn my-some [pred a-seq] (first (map pred (filter (fn [value] (pred value)) a-seq))))

(defn my-every? [pred a-seq] (== (count a-seq) (count (filter (fn [value] (pred value)) a-seq))))

(defn prime? [n]
  (let [pred (fn [number] (== 0 (mod n number)))]
    (not (some pred (range 2 n)))))
;^^
