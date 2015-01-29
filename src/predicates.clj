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
  (fn [x] (and (pred1 x)  (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x)  (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (or (= (filter (fn [award] (has-award? book award)) awards) (seq awards)) (empty? awards)))

(defn my-some [pred a-seq]
  (if (empty? (map pred (filter #(pred %) a-seq)))
    false
    (first (map pred (filter #(pred %) a-seq)))
    ))


(defn my-every? [pred a-seq]
  (empty? (filter false? (map pred a-seq))))

(defn prime?[n]
  (let [divisible? (fn[n, x] (if (not= n x)
                                (= (mod n x) 0)))]
    (not (some #(divisible? n %) (range 2 n)))))
;^^
