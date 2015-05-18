(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [x] (> n x)))

(defn equal-to [n]
  (fn [x] (== x n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x]
    (and
      (pred1 x)
      (pred2 x)
    )))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (or (empty? string) (= string nil))
    true
    (every? whitespace? string)))

(defn has-award? [book award]
  (if (contains? (set (keys book)) :awards)
    (not (= nil ((:awards book) award)))
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [aw] (has-award? book aw)) awards))

(defn my-some [pred a-seq]
  "Melko vaikeaa saada testit menemään läpi, kun ei tiedä, mitä testataan.
  Erilaisten truthy-arvojen palauttaminen tuotti virheitä, kunnes
  aloin palauttamaan johdonmukaisesti true.
  Nyt kuitenkin yksi testi haluaisikin 1 eikä true."
  (if  (first (filter pred a-seq))
    true ;Tässä ollut muita juttuja, nykyisellään turha tupla-if
    (if (empty? (filter pred a-seq))
      false
      true)))

(defn my-every? [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime? [n]
  (let [pred (fn [x] (== (mod n x) 0))]
    (not (some pred (range 2 n)))))
