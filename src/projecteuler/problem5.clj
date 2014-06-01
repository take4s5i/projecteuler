(ns projecteuler.problem5)

(defn prime?
  "Return true if n is not multiples of under-primes."
  [n under-primes]
  (->> under-primes
       (take-while #(<= (* % %) n))
       (every? (comp not zero? (partial rem n)))))

(defn primes
  ([]
   (let [init [2 3 5 7 11]]
     (lazy-cat init
               (primes 13
                       (repeat 2)
                       init))))
  ([n wheel under-primes]
   (lazy-seq
      (loop [n n
             wheel wheel]
         (if (prime? n under-primes)
           (lazy-seq (cons n
                           (primes (+ n (first wheel))
                                   (rest wheel)
                                   (conj under-primes n))))
           (recur (+ n (first wheel))
                  (rest wheel)))))))

(defn prime-factor
  "Return a list of n's prime factors."
  [primes n]
  (lazy-seq
     (let [prime (first primes)]
       (cond
         (zero? (rem n prime))
         (lazy-seq (cons prime
                         (prime-factor primes
                                       (int (/ n prime)))))

         (< 1 n)
         (lazy-seq (prime-factor (rest primes) n))))))


(defn solve []
  (let [primes (primes)]
    (->> (range 1 21)
         (map (comp frequencies (partial prime-factor primes)))
         (reduce (partial merge-with max))
         (map (fn [[x n]] (int (Math/pow x n))))
         (reduce *))))
