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
  (fn [prex] (and (pred1 prex) (pred2 prex)))
)

(defn pred-or [pred1 pred2]
  (fn [prex] (or (pred1 prex) (pred2 prex)))
)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string)
)

(defn has-award? [book award]
  (contains? (book :awards) award)
)

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (set->predicate (:awards book)) awards)
)

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq)))
)

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq))
)

(defn prime? [n]
  :-)
;^^
