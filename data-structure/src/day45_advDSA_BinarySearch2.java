import java.util.List;

public class day45_advDSA_BinarySearch2 {
    /**
     * Q1:  Given a sorted array of integers A of size N and an integer B.
     * array A is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
     * You are given a target value B to search. If found in the array, return its index otherwise, return -1.
     * You may assume no duplicate exists in the array.
     * NOTE: Users are expected to solve this in O(log(N)) time.
     * <p>
     * Find the index of given element in a rotated sorted array
     * of distinct elements.
     * I/P: {8, 10, 15, 2, 4}
     * target: 10
     * Ans: {1}
     * IsArrayRoatated: if (A[0] > A[N-1]) then array is roatated
     * LargestElement:
     *  1. define search space -> l = 0; r = N-1
     *  2. check if mid-element is answer if (A[mid] > A[mid+1])
     *                                          return mid;
     * 3. Decide when to go right/left?
     *      a. look for mid-element and compare with A[0]
     *      if (A[mid]<A[0]) -> go to right r = mid -1
     *      else             -> l = mid+1
     * Tc: O(logN), Sc: O(1)
     * Find element in rotated array:
     * if (target < A[0]) -> binary search from index [the biggest element index +1 to N-1]</>
     * else
     * --> binary search from index 0 to [the biggest element index]
     * </p>
     * <p>
     * Approach2 doesn't need to find the Largest element.
     * A[mid] can be in first or second part
     * target can be in first or second part
     * target is in second part and A[mid] in first part then go right of the mid
     * target is in first part and A[mid] in first part then ignore second part and do binary search part in first part
     * Tc: O(logN), Sc: O(1)
     *  </p>
     */
    public static int findElementInSortedRotatedArray(int []A, int B) {
        int l = 0, r = A.length-1;
        int mid = 0;
        if (B == A[0]) return 0;
        while (l <= r) {
            mid = (l+r)/2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] >= A[l]) { //increasing array in first half
                if (A[l] < B && A[mid] > B) {// B is in the range
                    r = mid -1; //restrict to first half
                } else {
                    l = mid + 1; //Not in range, go to next half
                }
            } else { // go to next half
                if (A[mid] < B) {
                    l = mid + 1;
                } else {
                    r = mid -1;
                }
            }
        }
        return -1;
    }
    /**
     * Q2: Binary search on answers
     * <p>
     *     Find floor(sqrt(N)) without using internal functions; N>0
     *     ex N = 10 -> ans = 3
     *     N = 30 -> 5
     *     N = 49 -> 7
     * </p>
     *<p>
     *     Idea1: for i-> 1 to N {
     *              if (i*i == N) return i;
     *              if(i*i > N) return i-1;
     *             }
     *             Tc: O(Sqrt(N))
     *</p>
     * Idea2: Binary search
     * 1. Search space 1 to N
     * 2. check if given mid is answer if (mid * mid <= N && (mid+1)*(mid+1) > N)
     * 3. Decide when to go left or right
     * if (mid * mid >  N) -> go to left
     * else --> go to right
     * Tc: O(logN); Sc: O(1)
     * <p/>
     * <p>
     *Compute and return the square root of A.
     * If A is not a perfect square, return floor(sqrt(A)).
     * DO NOT USE SQRT FUNCTION FROM THE STANDARD LIBRARY.
     * NOTE: Do not use the sqrt function from the standard library.
     * Users are expected to solve this in O(log(A)) time.
     * </p>
     * <p>Input: 11 output 3, Input: 9 output; 3</p>
     * When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
     * When A = 9 which is a perfect square of 3, so we return 3.
     */
    public static int sqrt(int N){
        int l = 1, r = N;
        int ans = -1;
        if (N == 0) return 0;
        while (l <= r ){
            // mid = (l + r)/2;
            //avoid overflow
            int mid = l + (r - l)/2;
            if (mid <= N/mid) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        return ans;
    }
    public static int sqrt1(int N) {
        int l = 1, r = N;
        int mid = 0;
        if (N == 0) return 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if ((mid <= N / mid) && ((mid + 1) > N / (mid + 1))) {
                return mid;
            } else if (mid < N / mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    /**
     * Q3: Given 3 position integers -> N, x, y
     * find Nth number that is divisible by x or y or both.
     * N = 5, x = 10, y = 6
     *  array from x and y; {6, 10, 12, 18, 20}, ans: 20
     *
     *  <p>
     *      Create two seperate array with multiple of x and y.
     *      Use 2 pointer approach and create third array. Ideally need not to store the array
     *      Tc; O(N) Sc; O(1)
     *  </p>
     */
    public static int getMultipleofXYAndFindNthelement(int N, int x, int y) {
        int a = 0, b = 0, select = 0;
        for (int i = 1; i <= N; i++) {
            if(a+x < b+y) {
                select = a +x;
                a += x; // a+x, a+2x, a+3x
            } else if (a+x > b+y) {
                select = b+y;
                b += y; // b+y, b+2y,....
            } else { // a+x == b +y
                select = a+x; // b+y also is fine
                a += x;
                b += y;
            }
        }
        return select;
    }

    /**
     * optimized approach of above problem:
     * <b> Insight:</b>
     * GCD(20, 15) = 5 (greatest number can divide  both
     * LCM(Least common multiple) = a*b/gcd(a,b);
     * <p>
     *     count of multiple of x <
     * </p>
     *
     * @param N
     * @param x
     * @param y
     * @return
     */
    public static int getMultipleofXYAndFindNthelementOptimized(int N, int x, int y){
        return -1;

    }

    /**
     * Problem Description
     * There are two sorted arrays A and B of sizes N and M respectively.
     * Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
     * The overall run time complexity should be O(log(m+n)).
     * IF the number of elements in the merged array is even, then the median is the average of (n/2)th
     * and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
     * A = [1, 4, 5]  B = [2, 3]
     * The median of both the sorted arrays will be 3.0.
     * <p>
     * Idea1: User merge sort using two pointer approach and create the final sorted array than calculate
     * the median, if lenght is odd then n/2 otherwise (n+(n+1))/2.0;
     * Tc: O(n1+n2) & Sc: O(n1+n2)
     * </p>
     * <p>
     *     Idea2: use binary search as below implemented method @findMedianSortedArrays
     * @https://www.youtube.com/watch?v=NTop3VTjmxk
     * </p>
     */
    public static int max(int a, int b){
        if (a >= b)
            return a;
        else
            return b;
    }
    public static int min(int a, int b){
        if (a <= b)
            return a;
        else
            return b;
    }
    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (b.size() < a.size()) return findMedianSortedArrays(b, a);// smaller size array ready
        int n1 = a.size();
        int n2 = b.size();
        int low = 0, high = n1;

        while (low <= high) {
            int cut1 = (low+high) >> 1;
            int cut2 = (n1 + n2 + 1) / 2 - cut1; // works for odd and even both

            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a.get(cut1 - 1); // if not taking array element then make it minimum value
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b.get(cut2 -1);

            int right1 = cut1 == n1? Integer.MAX_VALUE : a.get(cut1); //if not taking array element then make it max value
            int right2 = cut2 == n2? Integer.MAX_VALUE : b.get(cut2);

            if (left1 <= right2 && left2 <= right1) {
                if ( (n1 + n2) % 2 == 0 )  // have correct cut1 and cut2
                    return (max(left1, left2) + min(right1, right2)) / 2.0;
                else
                    return max(left1, left2); // left1 and left2 are the middle elements

            } else if (left1 > right2) {
                high = cut1 - 1; //cut1 is nothing but mid,reduce the left1
            } else {
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        //System.out.println(sqrt(9)); //2147483647));
        //System.out.println(getMultipleofXYAndFindNthelement(5, 10 , 6));
        int[]A = {4, 5, 6, 7, 0, 1, 2, 3};
        System.out.println(findElementInSortedRotatedArray(A, 4));
    }
}
