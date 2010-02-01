(ns clojure.contrib.test-lazy-seqs
  (:use clojure.test
	clojure.contrib.lazy-seqs))

(deftest test-fibs
  (is (= [0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 
	    17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 
	    3524578 5702887 9227465 14930352 24157817 39088169 63245986 102334155 
	    165580141 267914296 433494437 701408733 1134903170 1836311903 2971215073 
	    4807526976 7778742049]
	 (take 50 (fibs)))))

(deftest test-powers-of-2
  (is (= [1 2 4 8 16 32 64 128 256 512]
	 (take 10 (powers-of-2)))))

(deftest test-primes
  (is (= [2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 101 
	  103 107 109 113 127 131 137 139 149 151 157 163 167 173 179 181 191 193 197 
	  199 211 223 227 229]
	 (take 50 primes))))
