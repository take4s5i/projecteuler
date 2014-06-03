(ns projecteuler.problem10
  (:require [projecteuler.problem5 :as p5]))

(defn solve []
  (->> (p5/primes)
       (take-while #(<= % 2000000))
       (reduce +)))
