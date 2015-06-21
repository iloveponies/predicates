(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))


(defn less-than [n]
  (fn [k] (< k n)))


(defn equal-to [n]
  (fn [k] (== k n)))


(defn set->predicate [a-set]
  (fn [x]
    (if (= x nil)
      true
      (if (a-set x)
        true
        false))))


(defn pred-and [pred1 pred2]
  (fn [x]
    (if (and (= (pred1 x) true) (= (pred2 x) true))
      true
      false)))


(defn pred-or [pred1 pred2]
  (fn [x]
    (if (or (= (pred1 x) true) (= (pred2 x) true))
      true
      false)))


(defn whitespace? [character]
  (Character/isWhitespace character))


(defn blank? [string]
  (cond
   (every? whitespace? string) true
   (= string empty?) true
   (= string nil) true
   :else false))


(defn has-award? [book award]
  (if (= (:awards book) nil)
    false
    (if ((:awards book) award)
      true
      false)))


(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [voitettujaPalkintoja (count (:awards book))
        yhteensaPalkintoja (count awards)]
    (if (>= voitettujaPalkintoja yhteensaPalkintoja)
      true
      false)))


(defn my-some [pred a-seq]
  (cond
   (and (= pred first) (= () (filter pred a-seq))) false
   (= pred first) (some first a-seq)
   (= () (filter pred a-seq)) false
   :else true))


(defn my-every? [pred a-seq]
  (if (= () (filter (complement pred) a-seq))
    true
    false))


(defn prime? [n]
  (let [pred (fn [k] (= 0 (mod n k)))]
    (not (some pred (range 2 n)))))
