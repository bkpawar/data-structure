public class day01_intDSA_IntroProblemSolving {
    /**
     * Given an integer A, you need to find the count of it's factors.
     * Factor of a number is the number which divides it perfectly leaving no remainder.
     * Example : 1, 2, 3, 6 are factors of 6
     * @param args
     */
    static int countNoOfFactors(int A) {
        int result = 0;
        if ( A < 0)
            return 0;
        for (int i = 1; i*i <= A; i++) {  //
            if (A%i == 0x00) {
                if (i == A/i)  // determine if we can find two factor, factor come in pair. Sometime it can be one also
                    result += 1;  // first factor is equal to second factor eg 10*10 == 100
                else {
                    //System.out.println("Increment by 2:"+i);
                    result += 2;
                }
            }
        }
        return result;
    }

    /**
     * Given a number A. Return 1 if A is prime and return 0 if not.
     * Note :
     * The value of A can cross the range of Integer.
     * Gauss theorem: Sum of first N number S=N*(N+1)/2
     * @param args
     */
    static int isPrime(int A) {
        int result = 0;
        if (A < 0)
            return -1;
        else if(A == 1)
            return 0;

        for (long i = 1; i*i <= A; i++) {
            if (A%i == 0x00) {
                if (i == A/i)  // determine if we can find two factor, factor come in pair. Sometime it can be one also
                    result += 1;  // first factor is equal to second factor eg 10*10 == 100
                else {
                    //System.out.println("Increment by 2:"+i);
                    result += 2;
                }
            }
            if (result > 2)
                return 0;
        }
        if (result == 2)
            return 1;
        else
            return 0;
    }

    /**
     * Given a number A. Return square root of the number if it is perfect square otherwise return -1.
     * Note: A number is a perfect square if its square root is an integer.
     * @param args
     */
    static int findSqrt(int N) {
        for (int i=1; i*i <= N; i++) {
            if (N%i == 0) {
                if (i*i == N) {
                    return i;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //System.out.println(countNoOfFactors(10));
       // System.out.println(isPrime(5));
        System.out.println(findSqrt(25));
    }
}
