(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)
               (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)
              (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? (fn [x] (whitespace? x)) string))

(defn has-award? [book award]
  (not (nil? (get (:awards book) award))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [map-pred (map pred a-seq)
        filtered (filter (fn [x] x) map-pred)]
    (first filtered)))

(defn my-every2? [pred a-seq]
  (let [aux (map pred a-seq)
        values #(map (fn [x] x) aux)]
    (and (= (count values) 1)
         (= (first values) true))))

(defn my-every? [pred a-seq]
  (let [aux (map pred a-seq)
        values (filter (fn [x] x) aux)]
    (and (= (count values) (count a-seq)))))


(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
