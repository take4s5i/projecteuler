(ns projecteuler.problem12
  (:require [clojure.math.combinatorics :as cmb]
            [projecteuler.problem5 :as p5]))

(defn tiriangle-numbers []
  (reductions + (iterate inc 1)))

(defn solve []
  (let [ps (p5/primes)]
    (->> (tiriangle-numbers)
         (map (juxt identity
                    (comp count
                          set
                          #(map (partial reduce *) %)
                          cmb/subsets
                          (partial p5/prime-factor ps))))
         (filter (comp (partial < 500) second))
         first
         first)))
