(ns projecteuler.problem20)

(defn fact [n]
  (reduce * (range 1N (inc n))))

(defn solve []
  (->> (-> (fact 100N) str seq)
       (map #(Integer/parseInt (str %)))
       (reduce +)))
