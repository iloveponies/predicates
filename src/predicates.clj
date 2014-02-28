(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
 (fn [k] (< k n)))

(defn equal-to [n]
 (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [k] (contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (let [blanky (fn [x] (or (nil? x)
                           (every? whitespace? x)
                           (empty? x)))]
  (blanky string)))
  

(defn has-award? [book award]
  (if (contains? book :awards )
    (contains? (:awards book) award)
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [award-pred (fn [x] (has-award? book x))]
   (every? award-pred awards)))

(defn my-some [pred a-seq]
  (let [any (fn [x] (if (pred x)
                      (pred x)))] 
    (first (filter (fn [x] (if (or (nil? x))
                             false
                             true)) (map any a-seq)))))

(defn my-every? [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (= (count filtered) (count a-seq)) 
    ))

(defn prime? [n]
 (let [pred (fn [x] (= 0 (mod n x))) ] 
  (not (some pred (range 2 n)))))
;^^
