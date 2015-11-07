(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x)
               (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or  (pred1 x)
               (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
    (contains? (book :awards) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [book-has-award? (fn [award] (has-award? book award))]
  (every? book-has-award? awards)))

;;This seems like it's not the right answer, but i did not get why 
;; it should return the behaviour specified and recursion seemed like the most readable way to do it
(defn my-some [pred a-seq]
  (cond     
            (empty? a-seq)        false
            (pred (first a-seq))  (if (first a-seq) (first a-seq) true)
            :else                 (my-some pred (rest a-seq))))

(defn my-every? [pred a-seq]
  (cond     
            (empty? a-seq)        true
            (pred (first a-seq))  (my-every? pred (rest a-seq))
            :else                 false))

(defn prime? [n]
  :-)

(defn prime? [n]
  (let [isDivided (fn [x] (== 0 (mod n x)))]
    (not (some isDivided (range 2 n)))))
;^^
