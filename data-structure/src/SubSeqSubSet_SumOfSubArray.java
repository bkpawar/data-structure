/*
You are given an array of integers A of size N.

The value of a subarray is defined as BITWISE OR of all elements in it.

Return the sum of value of all subarrays of A % 109 + 7.
Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [7, 8, 9, 10]


Example Output
Output 1:

 71
Output 2:

 110
 */
import java.lang.Math;

public class SubSeqSubSet_SumOfSubArray {
    public static long getSumOfAllSubArray(int[] A) {
        long n = A.length;
        long N = (n*(n+1))/2; //(long)Math.pow(2, A.length-1);

        long sum = 0;
        for (long i = 0; i< N; i++) {
            for(long j = 0; j<n; j++){
                //if ((1<<i & j) != 0)
                sum = (long) (sum + (long)A[(int)j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[]A=new int[5];
        A[0] = 1; A[1] =2; A[2] = 3; A[3]=4; A[4]=5;
        System.out.println(getSumOfAllSubArray(A));

    }
}
