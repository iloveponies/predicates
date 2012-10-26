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
  (fn [x] (if (and (= (pred1 x) true) (= (pred2 x) true))
            true
            false)
  ))

(defn pred-or [pred1 pred2]
  (fn [x] (if (or (= (pred1 x) true) (= (pred2 x) true))
            true
            false)
    ))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (or (empty? string) (= string nil))
    true
    (if (every? whitespace? string)
      true
      false)))

(defn has-award? [book award]
  (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (== (count (book :awards)) (count awards)))

(defn my-some [pred a-seq]
  (let [noni (map pred a-seq)]
    (contains? (set noni) true))
  )

(defn my-every? [pred a-seq]
  (let [noni (filter (complement pred) a-seq)]
    (empty? noni))
  )

(defn prime? [n]
  :-)