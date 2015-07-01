(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k](< k n)))

(defn equal-to [n]
  (fn [k](= (int k) n)))

(defn set->predicate [a-set]
  (fn [a-value] (contains? a-set a-value)))



(defn pred-and [pred1 pred2]
  (fn [a-seq]
    (and 
      (pred1 a-seq)
      (pred2 a-seq))))

(defn pred-or [pred1 pred2]
  (fn [a-seq]
    (or
      (pred1 a-seq)
      (pred2 a-seq))))


(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (cond 
    (empty? string) true
    (= nil string) true
    (every? whitespace? string) true
    :else false))



(defn has-award? [book award]
  (if (contains? book :awards)
      (contains? (:awards book) award)
      false))

(defn has-award-fn [book]
   (fn [award] (has-award? book award)))

(defn lazy-contains? [col key]
  (some #{key} col))

(defn seq-contains? [coll target] (some #(= target %) coll))

(defn HAS-ALL-THE-AWARDS? [book awards]
   (case (seq-contains? (doall (map (has-award-fn book) awards)) false)
   	 nil true
	 true false))

(defn my-some [pred a-seq]
(first (filter (fn [x] (if x true false)) (map pred a-seq)))
)


(defn my-every? [pred a-seq]
  (= (count (filter pred a-seq)) (count a-seq))
)

(defn c 
  "kth coefficient of (x - 1)^n"
  [n k] 
  (/ (apply *' (range n (- n k) -1)) 
     (apply *' (range k 0 -1))
     (if (and (even? k) (< k n)) -1 1)))
 
(defn cs 
  "coefficient series for (x - 1)^n, k=[0..n]"
  [n] 
  (map #(c n %) (range (inc n))))
 
(defn prime? [p] (->> (cs p) rest butlast (every? #(-> % (mod p) zero?))))


