import java.util.ArrayList;

/**
 * A prime number is a positive integer greater than 1 that has no positive integer
 * divisors other than 1 and itself. In other words, a prime number is a number that
 * is only divisible by 1 and itself. For example, 2, 3, 5, 7, 11, and 13 are prime numbers,
 * but 4, 6, 8, and 9 are not (because they can be divided by other numbers besides 1 and themselves).
 * The first prime number is 2 and the only even prime number. Prime numbers play an important role
 * in number theory and have many applications in cryptography and coding theory.
 */
public class day37_advDSA_prime_numbers {
    /**
     * Problem 1: count no of factors of N.
     * f = 0
     * for i->i to sqrt(N)
     * if (N%i = 0) //N = i*k
     *  if (i == N/i)
     *      f + = 1
     *  else
     *      f += 2
     * return f;
     * Tc: O(Sqrt(N), Sc: O(1)
     */
    public static int getFactorsOfN(int N){
        int res = 0;
        return res;
    }

    /**
     * Problem2: Given an integers N, check every number from 1->N
     * and determine if it is a Prime number
     * 1. Bruteforce: Iterate through i=1 ->N, count #factors
     * and flag with true if #factors = 2
     * otherwise, flag with False. Tc: O(N Sqrt(N)), Sc: O(1).
     * 2. Sieve of Eratosthenes Algo:
     * The time complexity of the Sieve of Eratosthenes algorithm is O(n log log n).
     * The algorithm iterates over all numbers from 2 to n (the upper limit of the range of primes being generated)
     * and for each number, it marks all its multiples as composite (i.e., not prime).
     * The outer loop iterates over all numbers from 2 to n, and the inner loop iterates over all multiples of the
     * current number. The number of multiples of a number i is n/i. The total number of iterations of the inner loop
     * is the sum of n/i for i from 2 to sqrt(n), which is roughly equal to
     * n*(1/2 + 1/3 + 1/4 + ... + 1/sqrt(n)) = n*(ln(sqrt(n)) - 1) = n*(ln(n)/2 - 1).
     * So, the overall time complexity of the algorithm is O(n*(ln(n)/2 - 1)) which is equivalent to O(n log log n).
     * It is a very efficient algorithm and can be used to find prime numbers till 10^18.
     * It is important to note that the space complexity is O(n) as it uses a boolean array of size n to mark the composite numbers.
     * @param N The number limit to find the prime number.
     * @return ArrayList
     *
     */
    public static ArrayList<Integer>getPrimeNumberList(int N){
        ArrayList<Integer>res = new ArrayList<Integer>();
        return res;
    }
}
