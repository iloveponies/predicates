(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
    (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond
    (empty? string) true
    (nil? string) true
    (every? whitespace? string) true
    :else false))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award-for-book? (fn [x] (has-award? book x))]
    (every? award-for-book? awards)))

(defn my-some [pred a-seq]
  (let [test-pred-on-seq (map (fn [x] (pred x)) a-seq)
        tests-into-set (into #{} test-pred-on-seq)]
          (cond
            (contains? tests-into-set 1) 1
            (contains? tests-into-set true) true
            :else false)))

(defn my-every? [pred a-seq]
  (let [filtering-seq-by-pred (filter (fn [x] (pred x)) a-seq)
        length-of-sequence (count a-seq)
        length-of-true-seq (count filtering-seq-by-pred)]
    (= length-of-sequence length-of-true-seq)))

(defn prime? [n]
  (let [range-2-to-n (range 2 n)
        mod-with-n (fn [v] (mod n v))
        mods-on-range (map mod-with-n range-2-to-n)
        set-of-mods (set mods-on-range)]
    (not (contains? set-of-mods 0))))
