(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (< x n)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

;Minor bug (extra ']') at sample code from http://iloveponies.github.io/120-hour-epic-sax-marathon/predicates.html
(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [a] (has-award? book a)) awards))

(defn my-some [pred a-seq]
  (let [r (first (filter (fn [y] (if y true false)) (map pred a-seq)))]
  (if r r false)))


(defn my-every? [pred a-seq]
  (==(count (filter (fn [y] (if y true false) )(map pred a-seq))) (count a-seq)))

(defn prime? [n]
  (let [tst (fn [x] (== 0 (mod n x)))]
    (not (some tst (range 2 n)))))
;^^
