(ns projecteuler.problem9)

(defn get-ab-seq [sum-of-ab]
  (for [a (range 1 (inc (/ sum-of-ab 2)))]
    {:a a :b (- sum-of-ab a)}))

(defn get-abc-seq [sum-of-abc]
  (for [c (range 1 (inc (/ sum-of-abc 2)))
        ab (get-ab-seq (- sum-of-abc c))]
    (assoc ab :c c)))

(defn triplet? [m]
  (= (+ (* (:a m) (:a m))
        (* (:b m) (:b m)))
     (* (:c m) (:c m))))

(defn solve []
  (let [abc (->> (get-abc-seq 1000)
                 (filter triplet?)
                 first)]
    (* (:a abc) (:b abc) (:c abc))))
