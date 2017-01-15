(ns predicates)

(defn sum-f
  "Take two functions and an argument, apply both function to an argument, and return the result."
  [function-first function-second argument]
  (+ (function-first argument) (function-second argument)))

(defn less-than
  "Create a predicate, which squeezes out values which exceed given number, from a collection,
  returning a collection of items, which are less than upper limit."
  [upper-limit]
  (fn [tale] (< tale upper-limit)))

(defn equal-to
  "Create a predicate, which evaluates as truthy if a-set contains given value.."
  [fairy]
  (fn [tale] (== fairy tale)))

(defn set->predicate
  "Create a predicate, which evaluates as truthy,
   if a-set contains given value, and falsey otherwise."
  [a-set]
  (fn [value] (contains? a-set value)))

(defn pred-and
  "Create a predicate, which evaluates as truthy,
   when both argument predicates evaluate as truthy."
  [predicate-first predicate-second]
  (fn [tale] (and (predicate-first tale) (predicate-second tale))))

(defn pred-or
  "Create a predicate, which evaluates as truthy,
  when at least one of argument predicates evaluate as truthy."
  [predicate-first predicate-second]
  (fn [tale] (or (predicate-first tale) (predicate-second tale))))

(defn whitespace?
  "Detect, if this character is whitespace!"
  [character]
  (Character/isWhitespace character))

(defn blank?
  "Find out, whether this string is blank!"
  [string]
  (every? whitespace? string)
  )

(defn has-award?
  "Detect, if this book has received a given award."
  [book award]
  (contains? (get book :awards) award))

(defn HAS-ALL-THE-AWARDS?
  "Detect, if this book has all the awards in a set."
  [book awards]
  (every? (fn [award] (has-award? book award)) awards))

(defn my-some
  "My very special some implementation."
  [pred a-seq]
  (first (filter boolean (map pred a-seq))))

(defn my-every?
  "My very special every? implementation."
  [pred a-seq]
  (empty? (filter (complement pred) a-seq)))

(defn prime?
  "Determine, if given number a prime."
  [tale]
  (let
    [evenly-divisible (fn [num] (== 0 (mod tale num)))
     progression (range 1 tale)
     ] (= (seq [1]) (filter evenly-divisible progression))))

;^__^
