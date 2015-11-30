(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [test] (contains? a-set test)))

(defn pred-and [pred1 pred2]
  (fn [seq] (and (pred1 seq) (pred2 seq))))

(defn pred-or [pred1 pred2]
  (fn [seq] (or (pred1 seq) (pred2 seq))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? (seq string)))

(defn has-award? [book award]
  (contains? (:awards book) award)
  )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards)
  )

(defn my-some [pred a-seq]

;;   (let [results (filter (fn [value] (boolean value)) (map pred a-seq))]
;;     (if (empty? results) false (first results)))
  ; staci vratit falsey, ne nutne false!
  (first (map pred (filter pred a-seq))))

(defn my-every? [pred a-seq]
  (== (count a-seq) (count (filter pred a-seq)))
)

(defn prime? [n]
  (let [pred (fn [x] (= 0 (rem n x)))]
    (not (some pred (range 2 n)))
    )
)
