(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (let [has-nil (some nil? a-set)
        has-false (some false? a-set)]
    (fn [x] 
      (cond 
        (boolean x) (contains? a-set x)
        (nil? x) has-nil
        (false? x) has-false
        ))))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x)
         (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x)
         (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (clojure.string/blank? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? boolean (map has-award? (repeat book) awards)))

(defn my-some [pred a-seq]
  (first (filter #(if % % false) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (if (empty? a-seq)
    true
    (not (some false? (map pred a-seq)))))
(defn prime? [n]
  (let [pred (fn [x]
               (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))
