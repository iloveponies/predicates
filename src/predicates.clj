(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k](== k n)))

(defn set->predicate [a-set]
  (fn [elem] (contains? a-set elem)))

(defn pred-and [pred1 pred2]
  (fn [v] (and (pred1 v) (pred2 v))))

(defn pred-or [pred1 pred2]
  (fn [v] (or (pred1 v) (pred2 v))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [check (fn [v] (whitespace? v))]
    (every? check string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [doit (fn [award] (has-award? book award))]
  (every? doit awards)))


(defn my-some [pred a-seq]
  (let [helper (fn [v] (if v
                         v))
        value (first (filter helper (map pred a-seq)))]
  (if (= nil value)
    false
    value)))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime? [n]
  (let [divides? (fn [v] (== 0 (mod n v)))]
   (= nil (second (filter divides? (range 1 (+ 1 (/ n 2))))))))

; ^^
