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
  (or (= string nil)
      (empty? string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (:awards book)
             award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [the-dogs-out (fn[award](has-award? book award))]
  (not (contains? (set (map the-dogs-out awards)) false))))

(defn my-some [pred a-seq]
  (if (empty? a-seq)
    false
  (if (pred (first a-seq))
    true
    (my-some pred (rest a-seq)))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (if (pred (first a-seq))
      (my-every? pred (rest a-seq))
      false)))

(defn prime? [n]
  (cond
   (= n 3) true
   (= n 2) true
   (even? n) false
   :else (let [pred (fn [x] (= (mod n x) 0))
               sqrt (int (Math/floor (Math/sqrt n)))]
           (not (some pred
                  (filter odd? (range sqrt n)))))))