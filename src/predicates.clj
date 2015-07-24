(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x]
    (contains? (frequencies a-set) x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and (pred1 x)
         (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x]
    (cond (pred1 x) true
          (pred2 x) true
          :else false)))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (every? whitespace? string))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (first (filter #(not (not %)) (map pred a-seq))))

(defn my-every? [pred a-seq]
  (let [aseqlen (count a-seq)
        newseq (filter pred a-seq)
        newseqlen (count newseq)]
    (cond (= 0 aseqlen) true
          (= aseqlen newseqlen) true
          :else false)))


(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n)))))

