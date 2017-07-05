(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-map] (contains? a-set a-map )))

(defn pred-and [pred1 pred2]
  (fn [n] (if (and (pred1 n) (pred2 n))
    true
    false)))

(defn pred-or [pred1 pred2]
  (fn [n] (if (or (pred1 n) (pred2 n))
            true
            false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (or
        (= 0 (count string))
        (every? whitespace? string))
    true
    false))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award-won (fn [award] (has-award? book award))]
    (every? award-won awards)))

(defn my-some [pred a-seq]
  (let [is-in (fn [item] (if(pred item)
                       true
                       false))
        is-boolean (fn [v] (if (instance? Boolean (pred v))
                             true
                             false))
        returns-boolean (fn [func] (every? is-boolean a-seq))]
    (if (not (returns-boolean pred))
      (get (first (filter is-in
          a-seq)) 0)
      (if (< 0 (count (filterv is-in a-seq)))
        true
        false))
  ))

(defn my-every? [pred a-seq]
  (if (= (count a-seq) (count(filterv pred a-seq)))
    true
    false))

(defn prime? [n]
  (let [pred (fn [divisor] (if (== (mod n divisor) 0)
                             true
                             false))]
    (not (some pred (range 2 n)))))
;^^
