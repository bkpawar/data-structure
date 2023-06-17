public class day_66_arrays_bit_manipulations {
    /**
     * Please refer day33_advDSA_bitManipulation.java
     * Prefix sum: Keep on doing the commutative sum of 0 to i
     * Pf[i] = Pf[i-1]+A[i]
     *
     * <p>
     *     find max sum sub array. Use prefix sum. O(N^2)
     *     Size N array will have total sub array = N(N+1)/2
     * </p>
     * <p>
     *     kadane's algo
     *     Tc; O(N)
     *     Sc: O(1)
     *
     * </p>
     * <p>
     *     Bitwise
     *     N = N | (1 << i) --> Set ith bit
     *     N = N &  (~ (1 << i)) --> UnSet ith bit
     *     if (N & 0x01 == 0x01) --> condition true if 0th bit is set
     *     if ((N >> i) & 0x01 == 0x01) --> if ith bit is set
     *
     * </p>
     * @param args
     */
    public static void main(String[] args) {
        /* int []A = {53, 39, 88};
        System.out.println("ans: "+getMaxofAndOperation(A));*/
        /*int []B = {1, 2, 2, 3, 1};
        System.out.println(singleNumber(B));*/
        /*int []c=  {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(singleNumberFromThriceFreq(c));*/
        //System.out.println(numSetBits(0x0f));

    }
}
