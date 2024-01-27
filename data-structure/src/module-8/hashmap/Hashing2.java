import java.util.*;

public class Hashing2 {
    /**
     * Given an Array of integers B, and a target sum A.
     * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
     * @param A: A is the Target sum
     * @param []B: second argument is the array B
     * Input 1:
     * A = 8
     * B = [3, 5, 1, 2, 1, 2]
     * Example 1:
     * It is possible to obtain sum 8 using 3 and 5.
     * Logic: target = 8 - 3; if right hand side is 5 then return true
     *           T(C): O(N)
     *           S(C): O(N)
     */
    public static boolean checkPairsum(int A, int[]B){
        HashSet<Integer>set = new HashSet<>();
        for (int i = 0; i< B.length; i++) {
            int target = A-B[i];
            if (set.contains(target)) {
                return true;
            } else {
                set.add(B[i]);
            }
        }
        return false;
    }

    /**
     * You are given an array A of N integers and an integer B.
     * Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
     *
     * Since the answer can be very large, return the remainder after dividing the count with 109+7.
     * @param A; A is an array of integers
     * @param B: econd argument B is an integer.
     * @return count
     * Logic: Same as checkPairsum, but count to be maintained
     */
    public static int countPairsum(int[] A, int B) {
        int cnt = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        for (int i = 0; i<A.length; i++) {
           if (map.containsKey(A[i]+B)) {
               cnt = cnt + map.get(A[i]+B);
           }
           if (map.containsKey(A[i]-B)) {
                cnt = cnt + map.get(A[i]-B);
           }
           if (map.containsKey(A[i])){
               int old = map.get(A[i]);
               map.put(A[i], old+1);
           } else {
               map.put(A[i], 1);
           }
        }
        return  cnt% 1000000007;
    }
    public static void main(String[]args) {
        //int []B = {3, 5, 1, 2, 1, 2};
        //System.out.println("Hasing2: "+checkPairsum(8, B));
        int[] A = {1, 2, 1, 2};
        System.out.println("Hasing2:"+countPairsum(A, 1));
    }
}