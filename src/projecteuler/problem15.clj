(ns projecteuler.problem15)

(def lattice-paths
  (memoize (fn [x y]
             (let [nx (dec x)
                   ny (dec y)]
               (if (= x y 0)
                 1
                 (+ (if (< nx 0)
                      0
                      (lattice-paths (max nx y) (min nx y)))
                    (if (< ny 0)
                      0
                      (lattice-paths (max ny x) (min ny x)))))))))

(defn solve []
  (lattice-paths 20 20))
