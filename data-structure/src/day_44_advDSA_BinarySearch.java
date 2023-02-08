/**
 * Binary search: Best element to start with, in the array to compare with the target
 * value while using Binary search Algo is middle.
 */
public class day_44_advDSA_BinarySearch {
    /**
     * Q: given a sorted array of distinct elements, find the index of a given target.
     * A= {1,3,5,7,9,10,11,13,15,17,19,30,35,40}
     * I/P = 17
     * first find the mid-element, to continue this process until search space become 1
     * N -> N/2 -> N/4......1, Tc: log(N)
     */

    public static int binarySearch(int[]A, int target){
       int l = 0; int e = A.length-1;
        while (l <= e) {
            int mid = (l+e)/2;
            if (A[mid] == target)
                return mid;
            if (A[mid] < target) {
                l = mid + 1;
            } else {
              e = mid -1;
            }
        }
        return -1;
    }

    /**
     * Q: find the first index of a given array
     * A{ 2,3, 5, 5, 5, 5,, 8, 10, 10, 13, 13,13}
     * target= 5; ans = 2
     * <p>
     * soln1; Find any location of target and move toward the left to find first index
     * </p>
     * <p>
     *     soln2: do binary search
     *     l    r   mid
     *     0    11  5   --> A[mid] = 5 but A[mid-1]=5, go to left
     *     0    4   2   --> A[mid] =5 & A[mid-1]!=5, ans
     * </p>
     * @param args
     */
    public static int getFirstIndexofSortedArray(int[] A, int target){
        int l = 0; int r = A.length;
        while (l <= r){
            int mid = (l+r)/2;
            if ((A[mid] == target) && ((mid ==0) || (A[mid-1] != A[mid]))){ //if mid = 0; then doesnt need additional check
                return mid;
            }
            if (A[mid] < target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }

    /**
     * Q: given a sorted integer array where every element appears twice, except or one element
     * Find that unique element.
     * Soln1: XOR operation, TC: O(N), Sc: O(1)
     * Soln2: linear search, for each i, check A[i] != A[i-1] & A[i]!=A[i+1], Tc: O(N), Sc: O(1)
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] A = { 2, 3, 5, 5, 5, 5, 8, 10, 10, 13, 13};
        System.out.println(binarySearch(A, 10));
        System.out.println(getFirstIndexofSortedArray(A, 10));
    }
}
