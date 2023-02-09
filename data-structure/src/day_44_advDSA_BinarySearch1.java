/**
 * Binary search: Best element to start with, in the array to compare with the target
 * value while using Binary search Algo is middle.
 */
public class day_44_advDSA_BinarySearch1 {
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
        int[]B = new int[2];
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
     * Soln3: Before the unique element the pair is even-odd but after that it is odd-even. check for previous and next
     * element if not equal to current number then it is not the answer.
     * Left side of unique no : Even - Odd indices
     * Right side of unique no: Odd - Even, Tc: O(longN), Sc: O(1)
     *
     * @param args
     */
    public static int getUniqueNoFromSortedArrayWhereElementsInPair(int[] A)
    {
        int l = 0; int r = A.length-1;
        while(l <=r) {
            int mid = (l+r)/2;
            if ((mid == 0) || (A[mid] != A[mid-1]) && ((mid == A.length-1) || (A[mid]!= A[mid+1]))) { //A = {2, 5, 5, 10, 10} boundary condition
                // answer
                return A[mid];
            } else { // where to go
                if (mid != 0 && A[mid] == A[mid-1]) {
                    if (mid % 2 == 0)
                        // if mid is odd even pattern then go to left
                        r = mid -1;
                    else
                        // go to right
                        l = mid+1;
                 } else {  // A[mid] != A[mid+1]
                     if (mid % 2 == 0) // go to right
                        l = mid+1 ;
                     else
                        r = mid -1;
                }
            }
        }
        return -1;
    }

    /**
     * Given a random array with distinct elements, find any one local minimum in the array.
     * A = { 1, 3, 8, 5, 2, 6, 4}
     * Ans: 2, you are smaller than previous and next element. like this 1, 2 and 4
     *
     * soln1: find smallest element
     * Tc: O(N), Sc: O(1)
     * soln2: Use binary search, this can be applied on unsorted data as well
     * Tc: O(logN)
     * Sc: O(1)
     */
    public static int getAnyGlobalMinimum(int []A){
        int l = 0;
        int r = A.length-1;
        while (l <= r) {
            int mid = (l+r)/2;
            if ((mid == 0 || A[mid] < A[mid-1]) &&
                    (mid == A.length-1 || A[mid]<A[mid+1])) { // check if mid is answer
                return A[mid];
            }
           // decide where to go
            if ((mid != 0) && A[mid]>A[mid-1]){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * Q: Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * A = [1, 3, 5, 6]
     * B = 5
     * The target value is present at index 2.
     * @param args
     */
    public static int getIndexofInput(int[] A, int B){
        int l = 0; int r = A.length-1;
        int mid = 0;
        if (B < A[0]) {
            return 0;
        } else if (B > A[r]) {
            return A.length;
        }
        while(l <= r) {
            mid = (l + r) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                l = mid +1;
            } else {
                r = mid -1;
            }
        }
        return l;
    }

    /**Q:
     * Given an array of integers A, find and return the peak element in it. An array element is peak if
     * it is NOT smaller than its neighbors. For corner elements, we need to consider only one neighbor.
     * We ensure that answer will be unique.
     * A = [5, 17, 100, 11]
     * 100 is the peak.
     * @param args
     */
    public static int getPeekArrayElement(int A[]){
        int l = 0; int r = A.length-1;
        int mid = 0;
        while (l <= r) {
            mid = (l + r)/2;
            if ((mid == 0 || A[mid] >= A[mid -1]) &&
                    (mid == A.length -1 || A[mid] >= A[mid+1])) {
                return A[mid];
            } else if ( (mid != 0) && A[mid] < A[mid -1]) {
                r = mid -1;
            } else {
                l = mid +1;
            }
        }
        return -1;
    }

    /**
     * Q:7 Given a sorted array of integers A (0-indexed) of size N, find the starting and the ending position of a given
     * integer B in array A. Your algorithm's runtime complexity must be in the order of O(log n).
     * Return an array of size 2, such that the first element = starting position of B in A and the second element = ending
     * position of B in A, if B is not found in A return [-1, -1].
     *
     * O/P:
     * Return an array of size 2, such that the first element = starting position of B in A and the second element = the
     * ending position of B in A. If B is not found in A return [-1, -1].
     *  A = [5, 7, 7, 8, 8, 10]
     *  B = 8
     *  O/P:  [3, 4]
     *
     * @param args
     */
    public static int getLastIndexofSortedArray(int[] A, int target){
        int l = 0; int r = A.length;
        while (l <= r){
            int mid = (l+r)/2;
            if ((A[mid] == target) && ((mid ==A.length-1) || (A[mid+1] != A[mid]))){ //if mid = 0; then doesnt need additional check
                return mid;
            }
            if (A[mid] <= target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }
    public static int[] getIndexStartAndEnd(int []A, int B) {
        int[] res = new int[2];
        res[0] = getFirstIndexofSortedArray(A, B);
        res[1] = getLastIndexofSortedArray(A, B);
        return res;
    }
    public static void main(String[] args) {
        //int[] A = { 2, 3, 5, 5, 5, 5, 8, 10, 10, 13, 13};
        //System.out.println(binarySearch(A, 10));
        //System.out.println(getFirstIndexofSortedArray(A, 10));
        //int []Arr = {12, 5, 5, 10, 10};
        //int[] Arr =  {1, 1, 2, 2, 3 };
        //System.out.println(getUniqueNoFromSortedArrayWhereElementsInPair(Arr));
        //int[] tArr = { 1, 3, 8, 5, 7, 6, 4, 3, 4};
        //System.out.println(getAnyGlobalMinimum(tArr));
        //int[] tA = {1, 3, 5, 7};
        //int B = 0;
        //System.out.println(getIndexofInput(tA, B));
        // int []ta = {5, 7,10, 100, 11};
        //int []ta = {1, 1000000000, 1000000000};
        //System.out.println(getPeekArrayElement(ta));
        //Q7 start
        int[] ta = {5, 7, 7, 8, 8, 10};
        int B = 8;
        int[] tr = getIndexStartAndEnd(ta, B);
        System.out.println(+tr[0]+":"+tr[1]);

        //end
    }
}
