(ns predicates)

; (+ (f x) (g x))
(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [m] (< m n)))

(defn equal-to [n]
  (fn [m] (== n m)))

(defn set->predicate [a-set]
  (fn [what] (contains? a-set what)))

(defn pred-and [pred1 pred2]
  (fn [a] (and (pred1 a) (pred2 a))))

(defn pred-or [pred1 pred2]
  (fn [a] (or (pred1 a) (pred2 a))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (if (:awards book)
    (if (get (:awards book) award)
      true
      false)
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %1) awards))

(defn my-some [pred a-seq]
  (not (empty? (filter #(= true %1) (map pred a-seq)))))

(defn my-every? [pred a-seq]
  ; uargh
  (let [predres1 (map pred a-seq)
        predres2 (filter #(= true %1) predres1)]
    (= (count predres1) (count predres2))))

(defn prime? [n]
   (let [pred #(= 0 (mod n %1))]
     (not (some pred (range 2 n)))))
;^^
