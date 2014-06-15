(ns projecteuler.problem22
  (:require [clojure.data.csv :as csv]
            [clojure.java.io :as io]))

(defn names []
  (with-open [rdr (io/reader "http://projecteuler.net/project/names.txt")]
    (->> (seq (csv/read-csv rdr))
         (mapcat identity)
         sort)))

(def score
  (->> (range (int \A) (inc (int \Z)))
       (map (juxt char #(- % (dec (int \A)))))
       (reduce #(apply assoc %1 %2) {})))

(defn name-score [s]
  (reduce + (map score (seq s))))

(defn solve []
  (let [names (names)
        scores (map name-score names)
        idx (iterate inc 1)]
    (->> (map * scores idx)
         (reduce +))))
