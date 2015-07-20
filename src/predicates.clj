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
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? (seq string)) (empty? string) (nil? string)))

(defn has-award? [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (= (count (filter (has-award? book award) awards)) (count awards)))

(defn my-some [pred a-seq]
  (let [elems (filter (pred a-seq))]
    (if (empty? elems)
      false
      (pred (first elems)))))

(defn my-every? [pred a-seq]
  (= (count (filter (pred x) a-seq)) (count a-seq)))

(defn prime? [n]
  (not (some (= (mod n x) 0) (range 2 n))))

;^^
