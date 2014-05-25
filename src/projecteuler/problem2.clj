(ns projecteuler.problem2)

(defn- fibonacci-nums []
  (map second
       (iterate (fn [[x y]] [y (+ x y)])
                [1 1])))

(defn solve []
  (->> (fibonacci-nums)
       (take-while #(< % 4000000))
       (filter even?)
       (reduce +)))
