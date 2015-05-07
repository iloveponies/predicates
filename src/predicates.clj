(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x](> n x)))

(defn equal-to [n]
  (fn [x](== n x)))

(defn set->predicate [a-set]
  (fn [x](contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x](and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x](or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn[x](has-award? book x)) awards))

(defn my-some [pred a-seq]
  (let [foo (map pred (filter pred a-seq))]
    (if (empty? foo)
    false
    (first foo))))

(defn my-every? [pred a-seq]
 (= (count (filter pred a-seq)) (count a-seq)))

(defn prime? [n]
  (not-any? #(zero? (mod n %))(range 2 n)))

;^^
