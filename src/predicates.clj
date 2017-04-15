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
  (fn [x] (if (and (pred1 x) (pred2 x))
            true
            false)))

(defn pred-or [pred1 pred2]
  (fn [x] (if (or (pred1 x) (pred2 x))
            true
            false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (or (= string "") (= string nil) (every? whitespace? string))
    true
    false))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [matched (filter pred a-seq)]
    (if (empty? matched)
      false
      (pred (first matched)))))

(defn my-every? [pred a-seq]
  (let [matched (filter pred a-seq)]
    (if (= a-seq matched)
      true
      false)))

(defn prime? [n]
  (let [divisible? (fn [x] (= 0 (mod n x)))]
    (not (some divisible? (range 2 n)))))
;^^
