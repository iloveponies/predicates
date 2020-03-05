(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn greater-than [n]
  (fn [k] (> k n)))

(defn equal-to [n]
  (fn [k] (= 0 (compare k n))))

(defn key->predicate [a-key]
  (fn [a-map] (contains? a-map a-key)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (true? (or (pred1 x) (pred2 x)))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or  (every? whitespace? string) 
       (empty? string) 
       (nil? string)))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (first (filter #(not (false? %)) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (= (count a-seq) (count (filter #(not (false? %)) (map pred a-seq)))))

(defn prime? [n]
  (let [divisible-by? (fn [k] (= 0 (mod n k)))]
    (not (some divisible-by? (range 2 n)))))
;^^
