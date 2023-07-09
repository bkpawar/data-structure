import java.util.HashSet;
import java.util.Scanner;

/**
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, else return 0.

Input Format
The only argument given is the integer array A.
Output Format
Return whether the given array contains a subarray with a sum equal to 0.

Example Input
Input 1:
A = [1, 2, 3, 4, 5]

Input 2:
A = [-1, 1]

Example Output
Output 1:
0
Output 2:
1
 */
public class SubArrayEqualToZero {
    static int solve(int[] A) {
        int N = A.length;
        long[] pf = new long[N];
        pf[0]= A[0];
        for(int i=1; i<N; i++){ /* create prefix sum array */
            pf[i]=pf[i-1]+A[i];
            if (pf[i] == 0)
                return 1;
        }
        HashSet<Long>myHash = new HashSet<>();
        for(int i=0; i<N; i++){
            myHash.add(pf[i]);
        }
        if (myHash.size() < N)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[]A = new int[2];
        A[0] = 1;
        A[1] = -1;
        //A[2] = 0;
        //A[3] = -3;
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt();
        //sc.
        int c = solve(A);
        System.out.println(c);
    }
}
