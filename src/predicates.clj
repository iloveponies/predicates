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
  (let [awards (:awards book)]
    (contains? awards award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has? (fn [x] (has-award? book x))]
    (every? book-has? awards)))

(defn my-some [pred a-seq]
  (let [pred-seq (map pred a-seq)
        non-nil (filter (fn [x]
                          (not (nil? x)))
                        pred-seq)
        non-false (filter (fn [x]
                            (not (= x false)))
                          non-nil)]
    (cond (nil? non-nil) nil
          (nil? non-false) false
          :else (first non-false))))

(defn my-every? [pred a-seq]
  (not (some (complement pred) a-seq)))

(defn prime? [n]
  (every? (complement (fn [x]
                        (= (mod n x) 0)))
          (range 2 (+ 1 (/ n 2)))))
