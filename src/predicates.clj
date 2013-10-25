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
  (fn [a_set] (and (pred1 a_set) (pred2 a_set))))

(defn pred-or [pred1 pred2]
  (fn [a_set] (or (pred1 a_set) (pred2 a_set))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
   (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [first-item (get (vec (filter pred a-seq)) 0 false)]
    (if (= first-item false) false (pred first-item))))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [divisible? (fn [elem] (== 0 (mod n elem)))]
    (not (some divisible? (range 2 n)))))

;-__-
