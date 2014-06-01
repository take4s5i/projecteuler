(ns projecteuler.problem4 )


(defn mirror [s]
  (str s (clojure.string/reverse s)))

(defn palindromeics
  "Return a sequence of all palindromic numbers that mirrored number from n to 1 ."
  [n]
  (->> (range n 1 -1)
       (map (comp #(Integer/parseInt %) mirror str))))


(defn divide [n m]
  (when (zero? (rem n m))
    [m (int (/ n m))]))

(defn creatable? [upper-bound n]
  (let [under-bound (int (Math/ceil (/ n upper-bound)))]
    (->> (range (dec upper-bound) under-bound -1)
         (keep (partial divide n))
         (first))))


(defn solve []
  (->> (palindromeics 999)
       (filter (partial creatable? 1000))
       (first)))
