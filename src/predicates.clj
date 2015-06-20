(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x))
  )

(defn less-than [n]
  (fn [k] (< k n))
  )

(defn equal-to [n]
  (fn [k] (== k n))
  )

(defn set->predicate [a-set]
  (fn [x] (if (some #(= x %) a-set) true false)
    )
  )

(defn pred-and [pred1 pred2]
    (fn [x]
    (and
     (pred1 x)
     (pred2 x)
     )
    )
  )

(defn pred-or [pred1 pred2]
  (fn [x]
    (or
     (pred1 x)
     (pred2 x)
     )
    )
  )

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or
   (every? whitespace? string)
   (empty? string)
   (nil? string)
   )
  )

(defn has-award? [book award]
  (contains? (:awards book) award))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [x] (has-award? book x)) awards))

(defn my-some [pred a-seq]
  (first (map pred (filter pred a-seq))))
;hyva muistaa! ensin testataan filtterilla, mihin funktio pred toimii
;ja erotellaan ne joukosta
;sen jalkeen kaytetaan niihin sita ja poimitaan ensimmainen!

(defn my-every? [pred a-seq]
  (let [filtered (filter pred a-seq)]
    (= filtered a-seq)
    )
  )
;voinee myos filteroida predin vastafunktiolla ja tarkastaa
;onko syntyva joukko tyhja (isoilla listoilla nopeampaa??)

(defn prime? [n]
  (let [pred (fn [x] (= 0 (mod n x)))]
    (not (some pred (range 2 n))))
  )
;^^
