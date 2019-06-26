(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn greater-than [n]
  (fn [x] (> x n)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))


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
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award ))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards ))

(defn my-some [pred a-seq]
  (->> a-seq
       (map pred ,,)
       (filter (complement false?) ,,)
       (first ,,)))

(defn my-every? [pred a-seq]
  (->> a-seq
       (map pred ,,)
       (filter false? ,,)
       (empty? ,,)))

(defn prime? [n]
  (cond (== n 1) false
        (<= n 3) true
        (zero? (mod n 2)) false
        :else
        ,,(->> (range 3 (+ 2 (int (Math/sqrt n))) 2)
               (map #(mod n %) ,,)
               (every? (complement zero?) ,,))))

(defn prime2? [n]
  (let [pred (fn [x] (zero? (mod n x)))]
    (not (some pred (range 2 n)))))
;^^
