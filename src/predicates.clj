(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-val] (contains? a-set a-val)))

(defn pred-and [pred1 pred2]
  (fn [a-val]
    (and (pred1 a-val)
         (pred2 a-val))))

(defn pred-or [pred1 pred2]
  (fn [a-val]
    (or (pred1 a-val)
         (pred2 a-val))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (let [awards (:awards book)]
    (if awards
      ((set->predicate awards) award)
      false)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-awards (:awards book)
        has-this-award? (set->predicate book-awards)]
    (every? has-this-award? awards)))

(defn my-some [pred a-seq]
  (let [mapped-seq (map pred a-seq)
        truthy-val (fn [x] (if x x))]
    (if (not (empty? mapped-seq))
      (first (filter truthy-val mapped-seq)))))

(defn my-every? [pred a-seq]
  (let [filtered-seq (filter pred a-seq)]
    (cond
     (empty? a-seq) true
     (= (count a-seq) (count filtered-seq)) true
     :default false)))

(defn prime? [n]
  (let [pred (fn [divisor] (== (rem n divisor) 0))]
    (not (some pred (range 2 n)))))
;^^
