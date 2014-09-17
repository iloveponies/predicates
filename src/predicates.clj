(ns predicates)

(defn sum-f [f g x]
  (+ (f x ) (g x)))


(defn less-than [n]
  (fn [k] (< k n )))

(defn equal-to [n]
    (fn [k] (== k n )))

(defn set->predicate [a-set]
  (fn [a] (true? (contains? a-set a))))

(defn pred-and [pred1 pred2]
  (fn [a-map] (and (pred1 a-map) (pred2 a-map))))

(defn pred-or [pred1 pred2]
  (fn [a-map] (or (pred1 a-map) (pred2 a-map))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))


(defn my-some [pred a-seq]
  (if (empty? (filter pred a-seq))
    false
    (pred (first (filter pred a-seq)))))

(defn my-every? [pred a-seq]
  (= (filter pred a-seq) a-seq))


(defn prime? [n]
  (let [div (fn [x] (not (== 0 (mod n x))))]
    (every? div (range 2  n))))
;^^ °~°
