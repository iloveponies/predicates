(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
  )

(defn less-than [n]
  (fn [k] (< k n))
  )

(defn equal-to [n]
  (fn [k] (== k n))
  )

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map))
  )

(defn pred-and [pred1 pred2]
  (fn [a-map] (and (pred1 a-map) (pred2 a-map)))
  )

(defn pred-or [pred1 pred2]
  (fn [a-map] (or (pred1 a-map) (pred2 a-map)))
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? (seq string))
  )

(defn has-award? [book award]
  (contains? (book :awards) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards)
  )

(defn my-some [pred a-seq]
  (let [vals (map pred a-seq)
        tmp (fn [x] (if (boolean x) x false))
        boolvals (filter tmp vals)]
    (first boolvals))
  )

(defn my-every? [pred a-seq]
  (every? true? (map pred a-seq))
  )

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n))))
  )

; >^~^< ;
