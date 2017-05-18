(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (if (or (a-set k)
                  (nil? k))
            true
            false)))

(defn pred-and [pred1 pred2]
  (fn [k] (and (pred1 k)
               (pred2 k))))

(defn pred-or [pred1 pred2]
  (fn [k] (or (pred1 k)
               (pred2 k))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [f (fn [k] (or (empty? k) (nil? k)))]
    (or (f string)
         (every? whitespace? string))))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [fun (fn [k] (has-award? book k))]
    (every? fun awards)))

(defn my-some [pred a-seq]
  (let [switch-nil (fn [k] (if (nil? k) 1 k))
        filtered (filter pred a-seq)
        mapped (map switch-nil filtered)]
    (if (= first pred)
      (if (nil? (first (first mapped)))
        false
        (first (first mapped)))
      (boolean (first mapped)))))

(defn my-every? [pred a-seq]
  (let [opposite (filter (complement pred) a-seq)]
    (empty? opposite)))

(defn prime? [n]
  (let [pred (fn [k] (== (mod n k) 0))]
    (not (some pred (range 2 n)))))


;^^
