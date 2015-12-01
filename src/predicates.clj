(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [no-whitespace (filter #(not (whitespace? %)) string)]
    (or (empty? no-whitespace)
        (nil? no-whitespace))))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (empty? (filter false?
                  (map
                    (fn [x] (has-award? book x)) awards))))

(defn my-some [pred a-seq]
  (cond (empty? a-seq) nil
        (pred (first a-seq)) (pred (first a-seq))
        :else
        (recur pred (rest a-seq))))

(defn my-every? [pred a-seq]
  (cond (empty? a-seq) true
        (not (pred (first a-seq))) false
        :else
        (recur pred (rest a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
