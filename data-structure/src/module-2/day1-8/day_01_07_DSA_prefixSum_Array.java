import java.util.ArrayList;
import java.util.Arrays;

/**
 * The prefix sum formula for an array A of N integers is given by :-
 * prefSum[i] = prefSum[i - 1] + A[i].
 * the time complexity of creating the prefix sum array of an array A of N integers: O(n).
 *
 *
 */
public class day_01_07_DSA_prefixSum_Array {
    /** Problem: 1 --> You are given an integer array A of length N.
     * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
     * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
     * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
     *
     * @param A
     * @param B
     * @return
     */
    public static long[] rangeSumm1(int[] A, int[][] B) {
        long res[]=new long[B.length];
        for(int i = 0; i<B.length; i++){
            //int start_index = B[i]
            long sum = 0;
            for(int j = B[i][0]; j<= B[i][1]; j++){
                sum = sum + A[j];
            }
            res[i]=sum;
        }
        return res;  // Tc: O(n^2)
    }

    /**
     * This is optimized solution
     * @param A
     * @param B
     * @return
     */
    public static long[] rangeSumOptimizedm2(int[] A, int[][] B) {
        long res[]=new long[B.length];
        long []sumA = new long[A.length];
        long sum = 0;
        for(int i = 0; i<A.length; i++) {
            // Calculate prefix sum araay first Tc: O(N)
            sum = sum + A[i];
            sumA[i] = sum;
        }
        for(int j = 0; j< B.length; j++){
            // Calcuate the sum; O(n)
            int std_idx = B[j][0];
            int end_idx = B[j][1];
            if (std_idx > 0) {
                res[j] = sumA[end_idx] - sumA[std_idx - 1];
            } else {
                res[j] = sumA[end_idx];
            }
        }
        // Tc: O(n)
        // Sc: O(n)
        return res;  // Tc: O(n^2)
    }

    /**
     * Problem2: Given an array A of N integers. Construct prefix sum of the array in the given array itself.
     * @param args
     */
    public ArrayList<Integer> constructPrefixSumArray(ArrayList<Integer> A) {
        for(int i = 1; i < A.size(); i++) {
            A.set(i, (int)A.get(i)+A.get(i-1));
        }
        return A;
    }

    /**
     * Problem3: You are given an array A of integers of size N.
     * Your task is to find the equilibrium index of the given array
     * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
     * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
     * <p>
     * Note:
     *
     * Array indexing starts from 0.
     * If there is no equilibrium index then return -1.
     * If there are more than one equilibrium indexes then return the minimum index.
     * </p>
     * @param args
     */
    public static int equilibriumArrayIndex(ArrayList<Integer> A) {
        long left = 0;
        long right = 0;
        int index = -1;
        ArrayList<Long> B = new ArrayList<Long>();

        B.add(0, (long) (A.get(0)));

        for(int i = 1; i < A.size(); i++) {
            B.add(i, (long)(A.get(i)+B.get(i-1)));
        }
        for (int i = 0; i<B.size(); i++) {
            if (i == 0)
                left = 0;
            else
                left = B.get(i-1);

            right = B.get(B.size()-1) - B.get(i);
            if(left == right) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Problem4: You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
     * Each query consists of two integers B[i][0] and B[i][1].
     * For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
     * @param args
     */
    public static ArrayList<Integer> getEvenNoArrrayFromRange(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        //System.out.println("Input a[x]"+A);
        for (int i=0; i<A.size(); i++){
            if(i == 0){
                int res = 0;
                if(A.get(i)%2==0)
                    res = 1;
                A.set(i, res);
                continue;
            }
            if (A.get(i)%2 == 0){
                A.set(i, 1);
            } else {
                A.set(i, 0);
            }
            A.set(i, A.get(i)+A.get(i-1));
        }
        //System.out.println("pf[x]:"+A);

        for (int j= 0; j<B.size(); j++){
            //System.out.println("Index "+j+ ":"+B.get(j));

            int n = B.get(j).get(1);
            int m = B.get(j).get(0);

            int sum;
            //System.out.println("m: "+m+" n:"+n);

            if(m ==0){
                sum = A.get(n);
            } else {

                sum = A.get(n)-A.get(m-1);
            }
            result.add(j, sum);
        }
        return result;
    }
    public static void main(String[] args) {
        /**
         * A : [ 7, 3, 1, 5, 5, 5, 1, 2, 4, 5 ]
         * B :
         * [
         *   [6, 9]
         *   [2, 9]
         *   [2, 4]
         *   [0, 9]
         * ]
         * Expected result: 12 28 11 38
         */
        int[] A = {7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
        int[][] B = {{6, 9}, {2, 9}, {2, 4}, {0, 9}};
        long[] res = rangeSumOptimizedm2(A, B);
        //ArrayList<Long>res1 = new ArrayList<>();
        //res1.Arrays.stream(res).toArray();
        System.out.println(res);
    }
}
