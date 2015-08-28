(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (if (empty? a-set) false
            (if (= x (first a-set)) true
              ((set->predicate (rest a-set)) x)))))

(defn pred-and [pred1 pred2]
  (fn [x] (if (and (pred1 x)
                   (pred2 x)) true false)))

(defn pred-or [pred1 pred2]
  (fn [x] (if (or (pred1 x)
                   (pred2 x)) true false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (contains? (:awards book) awards))

(defn my-some [pred a-seq]
  (if (empty? a-seq) false
    (if (pred (first a-seq)) (pred (first a-seq))
      (my-some pred (rest a-seq)))))

(defn my-every? [pred a-seq]
  :-)

(defn prime? [n]
  (let [jaollinen? (fn [x] (if (== 0 (rem n x)) true false))]
    (not (some jaollinen? (range 2 n)))))
