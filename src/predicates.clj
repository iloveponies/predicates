(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [a-key] (contains? a-set a-key)))

(defn pred-and [pred1 pred2]
 (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has-a-book-award? (fn [x]
              (has-award? book x))]
    (every? has-a-book-award? awards)))

(defn my-some [pred a-seq]
  (let [my-true (fn [x]
                  (not (or (nil? x) (false? x))))
        my-some (first (filter my-true (map (fn [y] (pred y)) a-seq)))]
   (if (nil? my-some)
     false
     (if (true? my-some)
       true
       my-some))))

(defn my-every? [pred a-seq]
  (empty? (filter false? (map (fn [x] (pred x)) a-seq))))

(defn prime? [n]
  (let [pred (fn [x] (= (mod n x) 0))]
    (not (some pred (range 2 n)))))
;^^
