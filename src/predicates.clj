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
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
   (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
   (empty? string)
   (nil? string)
   (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)]
    (every? true? (map #(contains? book-awards %) awards))))

(defn my-some [pred a-seq]
  (first (filter (complement false?) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (let [results (map pred a-seq)]
    (or
     (empty? results)
     (= (count results) (first (vals (frequencies results)))))))

(defn prime? [n]
  (let [limit (int (Math/sqrt n))
        _ (println limit)
        test-range (range 2 (+ limit 1))
        _ (println test-range)]
    ((complement some) true? (map #(zero? (mod n %)) test-range))))
;^^
