(ns projecteuler.problem19)

(defn leap-year? [y]
  (condp #(zero? (rem %2 %1)) y
    400 true
    100 false
    4   true
    false))

(defn days-of-month
  [y m]
  {:pre [(<= 1 m 12)]}
  (condp #(%1 %2) m
    #{1 3 5 7 8 10 12} 31
    #{4 6 9 11} 30
    #{2} (if (leap-year? y) 29 28)))

(defn tomorrow [[y m d]]
  (let [nd (if (or (< d 28) (< d (days-of-month y m))) (inc d) 1)
        nm (if (= nd 1) (-> (rem m 12) inc) m)
        ny (if (= nd nm 1) (inc y) y)]
    [ny nm nd]))

(defn days []
  (map vector
       (iterate tomorrow [1900 1 1])
       (cycle [:mon :tue :wed :thu :fri :sat :sun])))

(defn solve []
  (->> (days)
       (drop-while (fn [[ymd dow]] (not= ymd [1901 1 1])))
       (take-while (fn [[[y m d] dow]] (<= y 2000)))
       (filter (fn [[[y m d] dow]] (and (= d 1) (= dow :sun))))
       count))
