(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))

(defn set->predicate [a-set]
  (fn [x] (if (= nil x)
            (contains? a-set nil)
            (a-set x))))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (every? whitespace? string)
      (= nil string)
      (= 0 (count string))))

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (let [filtered (filter pred a-seq)
        mapped   (map pred a-seq)
        trues    (filter true? mapped)
        firstf   (first filtered)]
    (if (not (= 0 (count filtered))) (if (< 0 (count trues)) true (pred firstf))
        (last filtered))))

(defn my-every? [pred a-seq]
  (let [filtered (filter pred a-seq)
        filcount (count filtered)]
    (= (count a-seq) filcount)))

(defn prime? [n]
  (let [testrange (range 2 (+ 1 (int (Math/sqrt n))))
        modulos   (map (fn [x] (mod n x)) testrange)]
    (every? (fn [x] (< 0 x)) modulos)))
;^^
