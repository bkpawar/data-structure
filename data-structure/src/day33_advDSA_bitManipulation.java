/**
 * file: day33_advDSA_bitManipulation.java
 * @author Bhupendra Pawar
 * @version 0.1
 * @since Jan 2023
 *
 * Q1. --> find the unique element in array
 * xor all the element the result shall be the answer
 *
 * Q2. --> Two elements appear once in a array, find those two elements
 * A = {2, 3, 2, 5, 6,3, 7,6}
 * Ans = {5, 7}
 * soln 1: for every element check if it is unique
 *     find Unique:
 *         : 1. nested loop for every element O(N^2), Sc = O(1)
 *         : 2. Use hashmap table first and find the element with frequency 1 Tc: O(N) Sc: ON)
 * soln 2: Using bit operators
 *     XOR:
 *     A = {2, 3, 2, 5, 6,3, 7,6}
 *     1. Take XOR of al: 2^2^3^3^6^6^5^7 = 5^7 = 2
 *     2. find any set bit in XORall, start from LSB, store the index in b
 *     3. Split based on b bit and take XOR separately, and store them in x and y
 *     4. return the answer x and y
 *     5. Tc: O(N), Sc: O(1)
 * ---------------------------------------------------------------------------------------------\n
 * Q3. --> Given an integer array of N elements where elements from 1 to N+2 are present exactly once
 * except for two elements, find the two missing elements.
 * A=[1,3,4,6] N= 4; (N+2 = 6)B= [1.....6] ans={2, 5}
 * Soln: XOR each element of both the array, the answer will be the missing no.'s XOR result.
 *     Now apply the solution 2.
 *     b = -1;
 *     for i->0 to 31
 *         if ((XOR>>i) & 1) ==1
 *           b = i; break;
 *     x = 0, y = 0;
 *     for i>0 to N-1
 *         if (((A[i]>>b)&1) == 1)
 *             x ^= A[i];
 *         else
 *             y ^= A[i];
 *          for i>0 to N-1
 *     for n->1 to N+2
 *         if (((n>>b)&1) == 1)
 *             x ^= n;
 *         else
 *             y ^= n;
 * return (x,y)
 * Tc: O(N), Sc: O(1)
 * ---------------------------------------------------------------------------------------------------
 * Q5. --> Given an integer array of N positive elements, calculate sum of XOR of all pairs A[i]^A[j] s.t. i<j
 * A=[3, 5, 6]
 * 3 ^ 5 = 6
 * 3 ^ 6 = 5
 * 5 ^ 6 = 3
 * -----------+
 * 6+5+3 = 14
 *
 * Soln1: Bruteforce: all i, j (i<j) -> compute A[i]^A[j] and take sum
 * Tc: O(N^2)
 * Sc: O(1)
 *
 * Soln2:
 *
 *
 */

public class day33_advDSA_bitManipulation {
    public static int[] getUniqueIntegersfromArray(int []A){
        int x = 0, y=0, xor = 0;
        int []res = new int[2];
        int b = -1;
        int N = A.length;
        for (int j = 0; j<N; j++){
            xor = xor ^ A[j];
        }
        for (int i = 0; i < 32; i++) {
            if ((xor >> i & 0x01) == 0x01) {
                b = i;
                break;
            }
        }
        for (int j = 0; j<N; j++){
            if (((A[j] >> b)&1) == 1)
                x ^= A[j];
            else
                y ^= A[j];
        }
        if (x > y){
            res[0] = y;
            res[1] = x;
        } else {
            res[0] = x;
            res[1] = y;
        }
        return res;
    }
    /**
     * ---------------------------------------------------------------------------------------------------
     * Q4. --> Given an integer array, find max value of (A[i]&A[j]) such that i#j
     *     A=[16, 9, 11, 10]
     *             16 & 9 = 0
     *             16 & 11 = 0
     *             16 & 10 = 0
     *             9 & 11 = 9
     *             9 & 10 = 8
     *             11 & 10 = 10 (answer11 and 10)
     *
     *     Soln 1: for every i and j (i != j) compute A[i] &A [j] and store max
     *     Tc: O(N^2)
     *     Sc: O(1)
     *     : Find the value where MSB bit is set, then go step by step if you find two nos where bit is set
     *       this will be answer
     *
     *     ans->0
     *             for b-> 31 to 0
     *     // count the no A[i] where bth bit is set
     *     cnt = 0
     *             for i->0 to N-1
     *     cnt += ( a[i] >> b) & 1)
     *             if (cnt > = 2)
     *     ans |= 1<<b //set bth bit in ans
     *                 for i > 0 to N-1
     *             if (A[i] >> b) &1 == 0) // clear the index, if bit is unset
     *     AA[i] = 0;
     *     return ans;
     *     Tc: O(N) Sc: O(1)
     *
     *     Return a single integer that is the maximum A[i] & A[j].
     */
    public static int getMaxofAndOperation(int []A){
        int ans = 0;
        int cnt = 0;
        int N = A.length;
        for (int b = 31; b>=0; b-- ){
            cnt = 0;
            for (int i = 0; i < N; i++){
                cnt += ((A[i]>>b) & 1);
            }
            if (cnt >= 2){
                ans |= 1<<b;
                for (int j = 0; j<N; j++){
                    if (((A[j]>>b)&1)==0){
                        A[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
    /**
     * Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
     *     NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *      A = [1, 2, 2, 3, 1] Ans: 3
     *      A = [1, 2, 2] Ans: 1
     */
    public static int singleNumber(final int[] A) {
        int res = 0, cnt = 0;
        for (int i=0; i< 32; i++) {
            for(int j = 0; j<A.length; j++){
                if(((A[j]>>i) & 0x01) == 0x01) {
                    cnt++;
                }
            }
            if ((cnt %2) != 0){
                res |= (1<<i);
            }
            cnt = 0;
        }
        return res;
    }
    /**
     * Given an array of integers, every element appears thrice except for one, which occurs once.
     *     Find that element that does not appear thrice.
     *     NOTE: Your algorithm should have a linear runtime complexity
     *      A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1] ans: 4
     *      A = [0, 0, 0, 1], ans: 1
     */
    public static int singleNumberFromThriceFreq(final int[] A) {
        int res = 0, cnt = 0;
        for (int i=0; i< 32; i++) {
            for(int j = 0; j<A.length; j++){
                if(((A[j]>>i) & 0x01) == 0x01) {
                    cnt++;
                }
            }
            if ((cnt %3) != 0){
                res |= (1<<i);
            }
            cnt = 0;
        }
        return res;
    }
    /*
    Write a function that takes an integer and returns the number of 1 bits it has.
     */
    public static int numSetBits(int A) {
        int cnt = 0;
        while(A > 0x00){
            if ((A & 0x01) == 0x01){
                cnt++;
            }
            A = A>>1;
        }
        return cnt;
    }

    /**
     * Q: Smallest XOR
     * A = 7  --> 111
     * B = 3
     * 1. match 1s in A from left to right
     * 2. match os in A from right to left
     * @param args
     */
    public static int minXOR(int A, int B){
        int mask = 0;
        for (int shift = 31; shift >= 0 && B>0; shift--){
            if ((A & (1<<shift)) != 0) {
                mask |=(1 << shift);
                B--;
            }
        } // if B runs out 2nd loop doesn't run
        System.out.println("mask:"+mask+",B:"+B);
        for (int shift = 0; shift <= 31 && B > 0; shift++ ){
            if ((A & (1 << shift)) == 0){
                mask |= (1 << shift);
                B--;
            }
        }
        System.out.println("mask:"+mask);
        return mask^A;
    }
    public static void main(String[] args) {
        /* int []A = {53, 39, 88};
        System.out.println("ans: "+getMaxofAndOperation(A));*/
        /*int []B = {1, 2, 2, 3, 1};
        System.out.println(singleNumber(B));*/
        /*int []c=  {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(singleNumberFromThriceFreq(c));*/
        //System.out.println(numSetBits(0x0f));
        System.out.println(minXOR(7, 5));
    }
}
