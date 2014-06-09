(ns projecteuler.problem16)

(defn solve []
  (let [pwr (reduce * (repeat 1000 2N))
        digits (map #(Integer/parseInt (str %)) (seq (str pwr)))
        dsum (reduce + digits)]
    dsum))
