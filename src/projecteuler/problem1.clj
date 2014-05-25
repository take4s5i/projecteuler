(ns projecteuler.problem1)

(defn- multiples-of-3-or-5 []
  (->>  (range 1 1000)
        (filter #(or (zero? (rem % 3))
                     (zero? (rem % 5))))))

(defn solve []
  (reduce + (multiples-of-3-or-5)))
