(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [an-element] (contains? a-set an-element)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (let [values (map pred a-seq)]
    (first (filter (fn [x] (if x true false)) values))))

(defn my-every? [pred a-seq]
    ;; (if (= (map (fn [x] (pred x)) a-seq) (map (fn [x] ((complement pred) x)) a-seq))true false))
  (if (empty? (filter (fn [x] (if (not x) true false)) (map (fn [x] (pred x)) a-seq))) true false))

(defn prime? [n]
  ;; (every? false? (map (fn [x] (not= (mod x n) 0)) (range 2 10))))
  (every? false? (map (fn [x] (and (= (mod n x) 0) (not= n x))) (range 2 10))))
