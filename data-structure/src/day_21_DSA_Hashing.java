import java.util.HashMap;
import java.util.HashSet;

/*

 */
public class day_21_DSA_Hashing {
    /**
     * Problem Description
     * Given an array A. You have some queries given by the array B.
     * For the i-th query, find the frequency of B[i] in the array A.
     * Input Format
     * First argument A is an array of integers.
     * Second argument B is an array of integers denoting the queries.
     * Output Format
     * Return an array of integers answering each of the queries.
     * <p>
     * Input 1:
     * A = [1, 2, 1, 1]
     * B = [1, 2]
     * Input 2:
     * A = [2, 5, 9, 2, 8]
     * B = [3, 2]
     * Example Output
     * Output 1: The frequency of 1 in the array A is 3.
     * The frequency of 2 in the array A is 1.
     * [3, 1]
     * Output 2:
     * [0, 2]
     * </p>
     * @param A
     * @param B
     * @return
     */
    static int[] findArrayFrequency(int[] A, int[] B) {
        int[]result = new int[B.length];
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i<A.length; i++) {  // Create the hashmap
            if(map.containsKey(A[i])) {
                Integer value = map.get(A[i]);
                //System.out.println("Value is incremented:"+value);
                map.replace(A[i], value+1);  // increase the value part
            } else {
                map.put(A[i], 1); //Insert the key-value pair in Hashmap
            }
           // System.out.println(map);
        }
        for(int i = 0; i<B.length; i++) {
            if(map.containsKey(B[i])){
                Integer value = map.get(B[i]);
                result[i] = value;
            }
        }
        //System.out.println(map.get(0));
        return result;
    }

    /** Q2: First Repeating element
     * <p>
     * <b>Problem Description:</b>
     * Given an integer array A of size N, find the first repeating element in it.
     * We need to find the element that occurs more than once and whose index of the first occurrence
     * is the smallest. * If there is no repeating element, return -1.
     * </p>
     * <p>
     *     A = [10, 5, 3, 4, 3, 5, 6]
     *     5 is the first element that repeats
     *     A = [6, 10, 5, 4, 9, 120]
     *     There is no repeating element, output -1
     * </p>
     *
     * @param args
     */
    public int findFirstRepeatingElement(int[] A) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i<A.length; i++) {  // Create the hashmap
            if(map.containsKey(A[i])) {
                Integer value = map.get(A[i]);
                //System.out.println("Value is incremented:"+value);
                map.replace(A[i], value+1);  // increase the value part
            } else {
                map.put(A[i], 1); //Insert the key-value pair in Hashmap
            }
            // System.out.println(map);
        }
        // If the frequency of the Hashmap Key value is more than one return that key
        for(int i = 0; i<A.length; i++) {
            if(map.containsKey(A[i])){
                Integer value = map.get(A[i]);
                if(value > 1)
                    return A[i];
            }
        }
        // No element is repeated
        return -1;
    }

    /**
     * Q3: Sub-array with 0 sum
     * <p>
     * Given an array of integers A, find and return whether the given array contains a
     * non-empty subarray with a sum equal to 0. If the given array contains a sub-array with
     * sum zero return 1, else return 0.
     * </p>
     * <p>
     *      Input: A = [1, 2, 3, 4, 5]
     *      Output: No subarray has sum 0.
     *      Input: A = [-1, 1]
     *      The array has sum 0
     * </p>
     * @param A
     * @return
     */
    public static int findSubArraywithZeroSum(int[] A){
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

    /**
     * Q4: Count distinct elements
     * <p>
     *     Problem Description:  You are given an array A of N integers.
     *     You will have to return number of distinct elements of the array.
     * </p>
     * <p>
     *     I/p: A = [3, 4, 3, 6, 6]
     *     O/p: 3: The distinct elements of the array are 3, 4 and 6.
     *     I/p: A = [3, 3, 3, 9, 0, 1, 0]
     *     O/p: 4: The distinct elements of the array are 3, 9, 0 and 1.
     * </p>
     * @param A
     * @return
     */
    public static int countDistinctElements(int[] A){
        HashSet<Integer> myhash = new HashSet<>();
        for(int i=0; i< A.length; i++){
            myhash.add(A[i]);
        }
        return myhash.size();
    }
    public static void main(String[] args) {
        int[]A = new int[5];
        A[0] = 1;
        A[1] = 2;
        A[2] = 1;
        A[3] = 1;
        A[4] = 2;

        int[]B = new int[2];
        B[0] = 1;
        B[1] = 2;

        int[]c = findArrayFrequency(A, B);
        for(int i=0; i<c.length; i++)
            System.out.println(c[i]);
    }
}