(ns projecteuler.problem6)


(defn sum-of-square [coll]
  (->> coll
       (map #(* % %))
       (reduce +)))

(defn square-of-sum [coll]
  (let [sum (reduce + coll)]
    (* sum sum)))

(defn solve []
  (- (square-of-sum (range 1 101))
     (sum-of-square (range 1 101))))
