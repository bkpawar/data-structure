import java.util.List;

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
    public int longestConsecutive(final List<Integer> A) {
        int res = -1;

        return res;
    }

    public static void main(String[] args) {

    }
}
