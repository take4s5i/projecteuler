(ns projecteuler.problem17)

(defmulti num->word (memfn length))

(defmethod num->word 4 [s]
  (str (num->word (.substring s 0 1))
       " thousand "
       (if (= (.substring s 1 4) "000")
         ""
         (num->word (.substring s 1 4)))))

(defmethod num->word 3 [s]
  (str (num->word (.substring s 0 1))
       " hundred"
       (if (= (.substring s 1 3) "00")
         ""
         (str " and " (num->word (.substring s 1 3))))))

(defmethod num->word 2 [s]
  (case (.substring s 0 1)
    "0" (num->word (.substring s 1 2))
    "1" (case s
          "10" "ten"
          "11" "eleven"
          "12" "twelve"
          "13" "thirtenn"
          "14" "fourteen"
          "15" "fifteen"
          "16" "sixteen"
          "17" "seventeen"
          "18" "eighteen"
          "19" "nineteen")
    "2" (str " twenty "  (num->word (.substring s 1 2)))
    "3" (str " thirty "  (num->word (.substring s 1 2)))
    "4" (str " forty "   (num->word (.substring s 1 2)))
    "5" (str " fifty "   (num->word (.substring s 1 2)))
    "6" (str " sixty "   (num->word (.substring s 1 2)))
    "7" (str " seventy " (num->word (.substring s 1 2)))
    "8" (str " eighty "  (num->word (.substring s 1 2)))
    "9" (str " ninety "  (num->word (.substring s 1 2)))))

(defmethod num->word 1 [s]
  (case s
    "0" ""
    "1" "one"
    "2" "two"
    "3" "three"
    "4" "four"
    "5" "five"
    "6" "six"
    "7" "seven"
    "8" "eight"
    "9" "nine"
    :else ""))

(defn letter-count [s]
  (->> (seq s)
       (filter (complement #{\space}))
       (count)))

(defn solve []
  (->> (range 1 1001)
       (map (comp letter-count num->word str))
       (reduce +)))
