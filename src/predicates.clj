(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)) )

(defn less-than [n]
  (fn [k] (< k n)) )

(defn equal-to [n]
  (fn [k] (== k n)) )

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)) )
  
(defn pred-and [pred1 pred2]
  (fn [elem] (and (pred1 elem) (pred2 elem))) )

(defn pred-or [pred1 pred2]
  (fn [elem] (or (pred1 elem) (pred2 elem))) )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (every? whitespace? string ) ) )

(defn has-award? [book award]
  (contains? (:awards book) award) )

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award]
	        (has-award? book award) )
		   awards ) )

(defn my-some [pred a-seq]
  (let [filtered-seq (filter pred a-seq)]
    (if (empty? filtered-seq)
		 nil
		 (pred (first filtered-seq)) ) ) )
 
; my-every? using my-some:
(defn my-every? [pred a-seq]
  (not (my-some (complement pred) a-seq)) )

; my-every without using my-sum:
; (defn my-every? [pred a-seq]
;    (empty? (filter (complement pred) a-seq)) )
  
(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n))) ) )
;^^
