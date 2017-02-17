(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
)

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
  (let [x (:awards book)
        xx (contains? x award)]
          xx))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [fun? (fn [x] (has-award? book x))]
    (every? fun? awards)))

(defn my-some [pred a-seq]
  (let [x (map (fn [x] (pred x)) a-seq)
        xxxx (into #{} x)
        ]
          (cond
            (contains? xxxx 1) 1
            (contains? xxxx true) true
            :else false)))

(defn my-every? [pred a-seq]
  (let [x (filter (fn [x] (pred x)) a-seq)
        xx (count a-seq)
        xxx (count x)
        xxxx (= xx xxx)]
          xxxx))

(defn prime? [n]
  (let [x (range 2 n)
        xx (fn [v] (mod n v))
        xxx  (map xx x)
        xxxx (set xxx)
        xxxxx (contains? xxxx 0)
        xxxxxx (not xxxxx)]
          xxxxxx))
