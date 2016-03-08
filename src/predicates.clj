(ns predicates)


;; done
(defn sum-f [f g x]
  (+ (f x) (g x)))


;; done
(defn less-than [n]
  (fn [k] (< k n)))

;; done
(defn equal-to [n]
  (fn [k] (== k n)))

;; done
(defn set->predicate [a-set]
  (fn [a-value] (contains? a-set a-value)))

;; done
(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

;; done
(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

;; done
(defn whitespace? [character]
  (Character/isWhitespace character))

;; done
(defn blank? [string]
  (every? whitespace? string))

;; done
(defn has-award? [book award]
  (let [awards (:awards book)]
    (contains? awards award)))

;; done
(defn HAS-ALL-THE-AWARDS? [book awards]
  (let [has_award? (fn[award] (has-award? book award))]
  (every? has_award? awards)))

;; done
(defn my-some [pred a-seq]
  (let [match (filter pred a-seq)]
    (cond
      (empty? match) nil
      (nil? (first match)) true
      :else (first match))))
;; done
(defn my-every? [pred a-seq]
  (let [match (map pred a-seq)]
    (every? true? match)))

;; done
(defn prime? [n]
(let [modzero? (fn[k] (== 0 (mod n k)))]
  (not (some modzero? (range 2 n)))))


;^^
