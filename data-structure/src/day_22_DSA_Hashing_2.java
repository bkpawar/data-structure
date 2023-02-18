import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class day_22_DSA_Hashing_2 {
    /**
     * Q1: Longest Subarray Zero Sum
     * <p>
     *     Given an array A of N integers.
     *     Find the length of the longest subarray in the array which sums to zero.
     * </p>
     * <p>
     *     Input: A = [1, -2, 1, 2]
     *     Output: 3, [1, -2, 1] is the largest subarray which sums up to 0.
     *     Input: A = [3, 2, -1]
     *     Output: 0, No subarray sums up to 0.
     * </p>
     */
    public static int findLongestSubarrayZeroSum(int[] A){
        HashMap<Long, Integer> pref = new HashMap<Long, Integer>();
        Long curr = 0L;
        int ans = 0;
        pref.put(0L, 0);
        for(int i = 1 ; i <= A.length ; i++){
            curr += A[i - 1];
            if(pref.containsKey(curr)){
                ans = Math.max(ans, i - pref.get(curr));
            }
            else{
                pref.put(curr, i);
            }
        }
        return ans;
    }

    /**
     * Q2. Check Pair Sum
     * <p>
     *     Given an Array of integers B, and a target sum A.
     *     Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
     * </p>
     * <p>
     *     A = 8   B = [3, 5, 1, 2, 1, 2]
     *     O/p: 1; It is possible to obtain sum 8 using 3 and 5.
     *     </p>
     *     <p>
     *         A = 21   B = [9, 10, 7, 10, 9, 1, 5, 1, 5]
     *         O/p: 0,
     *     </p>
     * @param A First argument A is the Target sum
     * @param B second argument is the array B
     * @return Return an integer value 1 if there exists such pair, else return 0
     */
    public static int checkPairSum(int A, int[] B){
        HashMap<Integer, Integer>hm = new HashMap<>();
        int N = B.length;
        for(int i = 0; i<B.length; i++) {  // Create the hashmap
            if(hm.containsKey(B[i])) {
                Integer value = hm.get(B[i]);
                //System.out.println("Value is incremented:"+value);
                hm.replace(B[i], value+1);  // increase the value part
            } else {
                hm.put(B[i], 1); //Insert the key-value pair in Hashmap
            }
            // System.out.println(map);
        }
        for(int i= 0; i<N; i++) {
            int a = B[i];
            int r = A -a;
            if (a == r && hm.get(a) > 1) {
                return 1;
            }
            if (a != r && hm.containsKey(r) == true) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Q3. Distinct Numbers in Window
     * <p>
     *     You are given an array of N integers, A1, A2 ,..., AN and an integer B.
     *     Return the of count of distinct numbers in all windows of size B.
     *     Formally, return an array of size N-B+1 where i'th element in this array
     *     contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
     * NOTE: if B > N, return an empty array.
     * </p>
     * <p>
     *      A = [1, 2, 1, 3, 4, 3]
     *      B = 3,
     *      Output 1: [2, 3, 3, 2]
     *      All windows of size B are
     *  [1, 2, 1]
     *  [2, 1, 3]
     *  [1, 3, 4]
     *  [3, 4, 3]
     *  So, we return an array [2, 3, 3, 2].
     * </p>
     *
     * @param A is an integer array A
     * @param B is an integer B.
     * @return Return an integer array.
     */
    public static ArrayList<Integer> distinctNumberInArray(ArrayList<Integer> A, int B){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<B-1;i++)
            map.put(A.get(i), map.getOrDefault(A.get(i),0)+1);
        int j=0;
        for(int i=B-1;i<A.size();i++)
        {
            map.put(A.get(i), map.getOrDefault(A.get(i),0)+1);
            arr.add(map.size());
            int freq = map.get(A.get(j));
            if(freq == 1)
                map.remove(A.get(j));
            else
                map.put(A.get(j), freq-1);
            j++;
        }
        return arr;
    }

    /**
     * convert Integer Array to List
     * @param A
     * @return
     */
    public ArrayList<Integer> convertToArrayList(Integer[] A) {
        ArrayList<Integer> myList = new ArrayList<Integer>(Arrays.asList(A));
        return myList;
    }
    public static void main(String[] args) {
        /* int[] A = {1, -2, 1, 2};
        System.out.println(findLongestSubarrayZeroSum(A)); */
        /*
        //int A = 0;  int[] B = {3, 5, 1, 2, 1, 2};
        //int A = 21; int[] B = {9, 10, 7, 10, 9, 1, 5, 1, 5};
        int A = 35; int[] B={39, 57, 50, 11, 5, 34, 9, 60, 80, 16};
        System.out.println(checkPairSum(A, B)); */
        day_22_DSA_Hashing_2 obj = new day_22_DSA_Hashing_2();

        Integer[] A = {1, 2, 1, 3, 4, 3}; int B = 3;

        System.out.println(distinctNumberInArray(obj.convertToArrayList(A),B));
    }
}
