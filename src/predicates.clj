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
  (fn [x]
    (and (pred1 x) (pred2 x))))
  
(defn pred-or [pred1 pred2]
  (fn [x]
    (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (empty? string)
      (nil?   string)
      (every? whitespace? string)))

(defn has-award? [book award]
  (and (contains? book :awards)
       (contains? (book :awards) award)))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some [pred a-seq]
  (let [values (filter pred a-seq)]
    (if (or (empty? values)
            (nil?   values))
      false
      (pred (first values)))))

(defn my-every? [pred a-seq]
  (= (count a-seq)
     (count (filter pred a-seq))))

(defn prime? [n]
  (if (== 1 n) false
      (if (or (== 2 n) (== 3 n)) true
          (if (and (> n 3)
                   (or (== 0 (mod n 2))
                       (== 0 (mod n 3))))
            false
            (let [divisors  (filter (fn [x] (or (== 1 (mod x 6))
                                                (== 5 (mod x 6))))
                                    (range 5 (/ n 3)))
                  quotients (filter (fn [x] (== 0 (mod n x))) divisors)]
              (== 0 (count quotients)))))))
;^^
