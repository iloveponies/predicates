(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn[k] (< k n)))

(defn equal-to [n]
  (fn[k] (== n k)))

(defn set->predicate [a-set]
  (fn[k](contains? a-set k)))

(defn pred-and [pred1 pred2]
  (fn[x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn[x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? (seq string)))

(defn has-award? [book award]
  (let [awards-list (book :awards)]
    (and (not (nil? awards-list)) (contains? awards-list award))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has? (fn[award](has-award? book award))]
    (every? has? awards)))

(defn my-some [pred a-seq]
  (first (filter identity (map pred a-seq))))

(defn my-every? [pred a-seq]
  (= (count (filter identity (map pred a-seq))) (count a-seq)))

(defn prime? [n]
  (let [notdivides? (fn[k](not (= 0 (mod n k))))]
  (every? notdivides? (drop 2 (range n))))) 
;^^
