(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k) (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k) (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [k] (has-award? book k)) awards))

(defn my-some [pred a-seq]
  (let [firstsome (filter (fn [k] (pred k)) a-seq)]
    (if (empty? firstsome) nil (pred (first firstsome)))))

(defn my-every? [pred a-seq]
  (= (count (filter (fn [k] (pred k)) a-seq)) (count a-seq)))

(defn prime? [n]
  (let [divides (fn [i] (= (mod n i) 0))]
    (not (some divides (range 2 n)))))

;^^
