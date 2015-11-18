(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== n k)))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn pred-and [pred1 pred2]
  (fn [n] (and (pred1 n) (pred2 n))))

(defn pred-or [pred1 pred2]
  (fn [n] (or (pred1 n) (pred2 n))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award? (fn [award] (has-award? book award))]
    (every? award? awards)))

(defn my-some [pred a-seq]
  (let [filter-seq (filter pred a-seq)
        map-seq (map pred filter-seq)
        get-first (first map-seq)]
    (if (nil? get-first)
      false
      get-first)))

(defn my-every? [pred a-seq]
  (let [filter-truthies (filter pred a-seq)]
    (= (count filter-truthies) (count a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))

;^^
