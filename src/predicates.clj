(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))
  ;:-)

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))
  ;:-)

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))
  ;:-)

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))
  ;:-)

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))
  ;:-)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))
  ;:-)

(defn has-award? [book award]
  (contains? (:awards book) award))
  ;:-)

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (:awards book) awards))
  ;:-)

(defn my-some [pred a-seq]
  (let [a (filter pred a-seq) b (first a) c (seq? a)]
    (cond
      (and (seq? a) (vector? b)) (get b 0) ; for that weird [1]
      (= (count a) 1) true
      :else false)))
  ;:-)

(defn my-every? [pred a-seq]
  (let [ mymap (map pred a-seq)]
  (not (some false? mymap))))
  ;:-)

(defn prime? [n]
  (let [sq (int (+ (Math/sqrt n) 1)) ran (drop 2 (range sq))]
    (defn noLeftover [n d] (== 0 (mod n d)))
    (not-any? (fn [x] (noLeftover n x)) ran)))
  ()
  ;:-)

;^^
