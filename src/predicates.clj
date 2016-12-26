(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map)))

(defn pred-and [pred1 pred2]
  (fn [a-map] (and (pred1 a-map) (pred2 a-map))))

(defn pred-or [pred1 pred2]
  (fn [a-map] (or (pred1 a-map) (pred2 a-map))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? (seq string)))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [fun (fn [award] (has-award? book award))]
    (every? fun awards)))

(defn my-some [pred a-seq]
  (let [fun (fn [x] (pred x))]
    (let [lista (map fun a-seq)]
      (first (filter (fn [x] (not= x false)) lista)))))

(defn my-every? [pred a-seq]
  (let [fun (fn [x] (pred x))]
    (let [lista (map fun a-seq)]
      (let [fil (filter (fn [x] (not= x false)) lista)]
        (if (= (count fil) (count lista))
          true
          false)))))

(defn prime? [n]
  (let [pred (fn [x] (== 0 (mod n x)))]
    (not (some pred (range 2 n)))))

;;(filter prime? (range 2 50))

;^^

