(ns projecteuler.problem21
  (:require  [projecteuler.problem5 :as p5]))

(def ^:dynamic *primes* (p5/primes))
(def prime-factors
  "Return a sequence of prime factors of n."
  (memoize
   (fn [n]
      (cond (<= n 1)
            [n]

            (zero? (rem n (first *primes*)))
            (let [p (first *primes*)]
              (cons p (prime-factors (/ n p))))

            :else
            (binding [*primes* (rest *primes*)]
              (prime-factors n))))))

(def subsets
  "Return a sequence of subsets of coll."
  (memoize (fn [coll]
             (when (seq coll)
               (let [x (first coll)
                     r (rest coll)]
                 (lazy-cat [[x]]
                           (subsets r)
                           (map #(conj % x) (subsets r))))))))

(defn sum-divisibles
  "return the sum of divisibles of n."
  [n]
  (->> (subsets (prime-factors n))
       (map (partial apply *))
       (filter (partial not= n))
       set
       (reduce +)))

(defn amicable-pair [n]
  (let [the-other (sum-divisibles n)]
    (when (and (not= n the-other)
               (= n (sum-divisibles the-other)))
      the-other)))

(defn solve []
  (->> (range 1 10000)
       (map amicable-pair)
       (filter identity)
       set
       (reduce +)))
