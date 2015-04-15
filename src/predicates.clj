(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  #(< % n))

(defn equal-to [n]
  #(== % n))

(defn set->predicate [a-set]
  #(contains? a-set %))

(defn pred-and [pred1 pred2]
  #(and (pred1 %) (pred2 %)))

(defn pred-or [pred1 pred2]
  #(or (pred1 %) (pred2 %)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? #(has-award? book %) awards))

(defn my-some [pred a-seq]
  (let [val (filter pred a-seq)]
    (if (empty? val) false (pred (first val)))))

(defn my-every? [pred a-seq]
  (not (my-some (complement pred) a-seq)))

(defn prime? [n]
  (let [pred-div #(zero? (mod n %))]
    (not (some pred-div  (range 2 n))))
)
;^^
