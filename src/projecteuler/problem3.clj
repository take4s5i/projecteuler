(ns projecteuler.problem3)

(defn remove-factor
  "Return a number removed fac from n."
  [n fac]
  (if (zero? (rem n fac))
    (recur (/ n fac) fac)
    n))

(defn max-factor
  "Return a number of the max in factors of n"
  [n]
  (loop [x n
         fac 2
         max-fac nil]
    (let [nx (remove-factor x fac)
          mf (if (= nx x) max-fac fac)]
      (if (= x 1)
        max-fac
        (recur nx (inc fac) mf)))))

(defn solve []
  (max-factor 600851475143))
