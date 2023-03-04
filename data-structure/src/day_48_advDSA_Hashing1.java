import java.util.*;

public class day_48_advDSA_Hashing1 {
    /**
     * Q1. Longest Consecutive Sequence
     * <p>
     *     Given an unsorted integer array A of size N.
     *     Find the length of the longest set of consecutive elements from array A.
     *     Return an integer denoting the length of the longest set of consecutive elements from the array A.
     * A = [100, 4, 200, 1, 3, 2]
     * output: 4, The set of consecutive elements will be [1, 2, 3, 4].
     * </p>
     * <p>
     *     Idea1: Traverse all array and check how long I can form a array.
     *     Tc: O(N^3) Sc: O(1)
     * </p>
     * <p>
     *     Idea2: Sort the array.
     *     traverse the array from 1->1 to (n-1)
     *      if (A[i+1]-A[i] == 1)
     *          count++;
     *      else {
     *          ma = max(ma,count);
     *          count = 0;
     *      }
     *     }
     *     ma = max(count, ma);
     *     ans = ma;
     *     Tc; O(n*logn), Sc: O(1)
     * </p>
     * <p>
     *     Idea3; reduce the no of loops in brute force solution
     *     find the start of sub seq. if (A[i]-1) value is not in array.
     *     map our elements and then, if consecutive are present or not.
     *     Tc: O(N); Sc: O(N)
     * </p>
     */
    public static int longestConsecutive(final List<Integer> A) {
        int res = -1;
        int count = 0;
        int N = A.size();
    /*
    A = [100, 4, 200, 1, 3, 2]
    100 can be start of new consecutive seq as 99 is not present.
    map the elements and check if consecutive is present or not.
     */
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i = 0; i<N; i++) {
            hm.put(A.get(i),hm.getOrDefault(A.get(i),0)+1);
        }
        for(int i = 0; i<N; i++) {
            int isFirstSeq = A.get(i);
            if(!hm.containsKey(isFirstSeq-1)) { //this can be first seq
                while(hm.containsKey(isFirstSeq)){
                    count++;
                    isFirstSeq++;
                }
                res = Math.max(res, count);
                count = 0;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    /**
     * Q2. Sub-array with 0 sum
     * <p>
     *     Given an array of integers A, find and return whether the given array contains a non-empty
     *     subarray with a sum equal to 0. If the given array contains a sub-array with sum zero return 1,
     *     else return 0.
     * </p>
     * <p>
     *     A = [1, 2, 3, 4, 5], output: 0
     *     A = [-1, 1], output: 1
     * </p>
     * @param A The only argument given is the integer array A.
     * @return whether the given array contains a subarray with a sum equal to 0.
     */
    public static int isSubArrayWithZeroSum(ArrayList<Integer> A) {
        HashSet<Long>hs = new HashSet<Long>();
        int N = A.size();
        Long pf = (long) A.get(0);
        for(int i = 1; i< N; i++) {
            pf += (long) A.get(i); //calculate the prefix sum, it may oveflow
            if (pf == 0) {
                return 1; //sum is zero
            }
            if (hs.contains(pf)) {
                // already have the pf so array sum is zero
                return 1;
            } else {
                hs.add(pf);
            }
        }
        return 0;
    }

    /**
     * Q3: Shaggy and distances
     * <p>
     *     Shaggy has an array A consisting of N elements. We call a pair of distinct indices in
     *     that array a special if elements at those indices in the array are equal. Shaggy wants you
     *     to find a special pair such that the distance between that pair is minimum.
     *     Distance between two indices is defined as |i-j|. If there is no special pair in the array,
     *     then return -1.
     * </p>
     * <p>
     *     A = [7, 1, 3, 4, 1, 7]
     *     Here we have 2 options:
     * 1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
     * 2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
     * Therefore the minimum possible distance is 3.
     * </p>
     * @param A The first and only argument is an integer array A.
     * @return Return one integer corresponding to the minimum possible distance between a special pair.
     * Tc: O(N); Sc: O(N)
     */
    public static int getSpecialPairDistanceShagy(ArrayList<Integer>A) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int N = A.size();
        int d = -1;
        for(int i = 0; i< N; i++) {
            if (hm.containsKey(A.get(i))) {  // if value is already present
                d = i - (Integer) hm.get(A.get(i)); // find the difference
                res = Math.min(res, d);
            }
            hm.put(A.get(i), i); //add the last found index
        }
        return (Math.min(res, d));
    }

    /**
     * Q4. Flip and Find Nearest
     * <p>
     * Given a binary string A of size N. There are Q queries given by the array B of size Q*2.
     * Each query is given by :-
     * 1 X :- Flip the bit of the X-th position in A
     * 2 X :- Find the index of the nearest '1' from X. If there are multiple such indexes,
     * return the one with the lower index. Return -1 if there are no '1's in A
     * Note :- We use 1-based indexing
     * </p>
     *<p>
     *     Input 1:
     * A = "10010"
     * B = [[1, 2]
     *      [2, 3]]
     *output: [2]
     * After first query, A = "11010".
     * For second query, X = 3. Both index 2 and index 4 are at the same
     * distance but we choose the lower index.
     *</p>
     * <p>
     *     Input 2:
     * A = "010000100"
     * B = [[2, 5]
     *      [1, 7]
     *      [2, 9]]
     *      output2; [7, 2]
     *      For first query, the index 2 is at a distance 3 and index 7 is at a distance 2. So we choose
     * index 7.   * After second query, A = "010000000"
     * For third query, the only index with '1' is 2.
     *
     * </p>
     * @param A First argument A is a string.
     * @param B Second argument B is a 2D array of integers describing the queries.
     * @return Return an array of integers denoting the answers to each query of type 2.
     */
    public static int[] flipAndfindNearest(String A, int[][] B) {
        char[] C = A.toCharArray();
        int k = 0, index = -1;
        int p1 = -1, p2 = -1;
        int n = B.length;
        int[] result = new int[n];

        for(int j = 0; j<n; j++) {
            if (B[j][0] == 1) {
                // first query, flipt the Xth bit
                int l = B[j][1]-1;
                C[l] = (char)((int)((C[l] - '0')^1)+ '0'); // toggle the bit
            } else {
                p2 = p1 = B[j][1]-1; // second query; two ponter approach
                index = findNearestOne(C, p1, p2);
                result[k++] = index;
            }
        }
        int count=0;
        for(int i=0;i<result.length;i++){
            if(result[i]!=0)
                count++;
        }
        int[] res = new int[count]; int l=0;
        for(int i=0;i<result.length;i++){
            if(result[i]!=0)
                res[l++] = result[i];
        }
        return res;
    }
    static int findNearestOne(char[] C,int p1,int p2){
        int li=-1,ri=-1,iniVal = p1;

        while(p1>=0 || p2<C.length){
            if(p1>=0) {
                if(C[p1] != '1'){
                    p1--;
                }else{
                    li=p1;
                    return li+1;
                }
            }
            if(p2<C.length) {
                if(C[p2] != '1'){
                    p2++;
                }else{
                    ri=p2;
                    return ri+1;
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        /* Integer[] A = {100, 4, 200, 1, 3, 2, 5};
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(A));
        System.out.println(longestConsecutive(B)); */
        /* Integer[]A = { 2, 1, -3};
        ArrayList<Integer>myA = new ArrayList<>(Arrays.asList(A));
        System.out.println(isSubArrayWithZeroSum(myA)); */
        Integer[] A = {7, 1, 3, 4, 1, 7};
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(A));
        System.out.println(getSpecialPairDistanceShagy(B));
    }
}
