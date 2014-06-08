(ns projecteuler.problem14)

(def colatz-len
  (memoize (fn [n]
             (cond
                (= 1 n) 1
                (even? n) (inc (colatz-len (/ n 2)))
                :else (inc (colatz-len (inc (* 3 n))))))))

(defn solve []
  (->> (range 1 1000000)
       (reduce (partial max-key colatz-len))))
