(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-key]
    (or (contains? a-set a-key)
        (and (= a-key nil) (contains? a-set nil)))))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (= string "") (= string nil) (every? whitespace? string)))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn h-a? [book]
  (fn [x] (contains? (get book :awards) x)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (h-a? book) awards))

(defn my-some [pred a-seq]
  (if (= (some pred a-seq) nil) false (some pred a-seq)))

(defn my-every? [pred a-seq]
  (every? pred a-seq))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))
;^^

