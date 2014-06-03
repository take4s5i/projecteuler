(ns projecteuler.problem7
  (:require [projecteuler.problem5 :as p5 ]))


(defn solve []
  (nth (p5/primes) 10000))
