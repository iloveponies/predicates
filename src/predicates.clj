(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [k] (< k n)))

(defn equal-to [n]
  (fn [k] (== k n)))
 
(defn set->predicate 
  "Muunnetaan setti predikaatiksi"
  [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and
  "Palautetaan predikaatti joka tarkistaa päteekö kumpikin annettu"
  [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or
  "Palautetaan predikaatti joka tarkistaa päteekö jompi kumpi annettu predikaatti"
  [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank?
  "Onko annettu string tyhjä"
  [string]
  (or (every? whitespace? string)))

(defn has-award?
  "Tarkistetaan onko kirjalla annettu palkinto"
  [book award]
  ((set->predicate (:awards book)) award))

(defn HAS-ALL-THE-AWARDS?
  "Katsotaan onko kirjalla kaikki palkinnot"
  [book awards]
  (= (set awards) (set (:awards book))))

(defn my-some
  "Tutkitaan päteekö predikaatti jollain sekvenssin elementillä"
  [pred a-seq]
 (< 0 (count (filter pred a-seq))))

(defn my-every? 
  "Tutkitaan päteekö predikaatti kaikilla sekvenssin elementeillä"
  [pred a-seq]
  (= (count a-seq) (count (filter pred a-seq))))

(defn prime? 
  "Onko luku alkuluku?"
  [n]
  (let [jako (fn [x] (= 0 (mod n x)))]
      (not (some jako (range 2 n)))))
;^^
