(ns predicates)

(defn sum-f [f g x]
  (->> ((juxt f g) x)
       (apply +)))

(defn less-than [n]
  (fn [item] (< item n)))

(defn equal-to [n]
  (fn [item] (== item n)))

(defn set->predicate [a-set]
  (fn [item]
      (-> a-set
           (zipmap (repeat true))
           (get item false))))

(defn pred-and [pred1 pred2]
  (fn [item]
      (->> item
           ((juxt pred1 pred2))
           (every? true?))))

(defn pred-or [pred1 pred2]
  (fn [item]
      (->> item
           ((juxt pred1 pred2))
           (some true?))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (if (nil? string)
    true
    (->> string
        (map whitespace?)
        (every? true?))))

(defn has-award? [book award]
  (if-let [awards (book :awards)]
    (contains? awards award)
    false))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (->> awards
       (map #(has-award? book %))
       (every? true?)))

(defn my-some [pred a-seq]
  (->> a-seq
       (map pred)
       (drop-while false?)
       (first)))

(defn my-every? [pred a-seq]
  (->> a-seq
       (map pred)
       (apply = true)))

(defn prime? [n]
  (-> (drop-while #(not (zero? (mod n %))) (range 2 n))
      (empty?)))

