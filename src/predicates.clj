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
 (or (empty? string) (nil? string) (every? whitespace? string)))

(defn has-award? [book award]
 (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
 (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
 (let [mapped-sequence (map pred a-seq)
       truthy-values (filter (fn [value] value) mapped-sequence)]
  (if (empty? truthy-values)
   false
   (first truthy-values))))

(defn my-every? [pred a-seq]
 (let [mapped-sequence (map pred a-seq)
       truthy-values (filter (fn [value] value) mapped-sequence)]
  (= (count mapped-sequence) (count truthy-values))))

(defn prime? [n]
 (let [divisible (fn [number] (= 0 (mod n number)))]
  (not (some divisible (range 2 n)))))
