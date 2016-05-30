(ns predicates)

(defn sum-f [f g x] (+ (f x) (g x)))
; :-)

(defn less-than [n] (fn [k] (< k n)))
; :-)

(defn equal-to [n] (fn [k] (== k n)))
;  :-)

(defn set->predicate [a-set] (fn [x] (contains? a-set x)))
;  :-)

(defn pred-and [pred1 pred2] (fn [x] (and (pred1 x) (pred2 x))))
;  :-)

(defn pred-or [pred1 pred2] (fn [x] (or (pred1 x) (pred2 x))))
;  :-)

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string] (every? whitespace? string))
;  :-)

(defn has-award? [book award] (if (contains? (:awards book) award) true false))
;  :-)

(defn HAS-ALL-THE-AWARDS? [book awards] (every? #(contains? (:awards book) %) awards))
;  :-)

(defn my-some [pred a-seq] (let [b-seq (filter #(pred %) a-seq)]
                             (if (= () b-seq) false (pred (first b-seq)))))

;  :-)

(defn my-every? [pred a-seq] (let [b-seq (filter #(pred %) a-seq)]
                               (= (count b-seq) (count a-seq))))
;  :-)

(defn prime? [n] (let [pred #(= 0 (rem n %))] (not (some pred (range 2 n)))))
;  :-)
;^^
