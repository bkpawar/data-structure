import java.util.Arrays;

/**
 * @author Bhupendra Pawar
 * Topic: Selection Sort,
 * Find the largest element and move this to end of the index.
 * Repeat the same process till N-1 times
 */
public class day_40_advDSA_SelectionMergeSort {
    /**
     * SelectionSort
     * @<code></code>
     * for i->N-1 to 1
     * maxId = 0
         *  for j-> 1 to i
         *      if (A[j] > A[maxID])
         *          maxId = j
         *  }
         *  swap(A[i], A[maxId]);
     *
     * @param A
     * Tc: O(N^2), Sc: O(1)
     */
    public void SelectionSort(int[] A){

    }
    /**
     * Q> given an integer array where all odd elements are sorted
     * and all even elements are sorted.
     * A={3, 9, 2, 4, 15, 10, 19}
     * Ans={2, 3, 4, 9, 10, 15, 19}
     * Put all and odd elements in separate array.
     * use Two pointer approach. and merge the array in sorted order.
     * Tc: O(N)+O(N) = O(N)
     * Sc: O(N)
     * This is base idea behind merge sort. Merging two sorted array.
     * Merge sort -> Divide and Conquer
     */
    public static int[] SortEvenAndOddSortedArray(int[] B, int[] C){
        // merge the sorted array into one
        // assumption, I/P -> B[N], C[M] --> A[N+M]
        int i = 0; //B
        int j = 0; //C
        int N = B.length; int M = C.length;
        int A[] = new int [N+M];
        for (int k = 0; k< (N+M); k++) {
            if (i == N) { //end of the array B
                A[k] = C[j++]; // take from C
            } else if (j == M){ // end of the array C
                A[k] = B[i++]; // take from B
            } else if (B[i]<C[j]){
                A[k] = B[i++]; // take smaller number
            } else {
                A[k]  = C[j++];
            }
        }
        return A;
    }

    /**
     * Merge sort: divide the array to the min sub array of single array
     * Tc: O(NlogN)
     * Sc: O(logN), max height of tree, for merge O(N) so overall it is O(N)
     * @param args
     * Note; Not completed solution
     */
    int res = 0;
    public  int SortArray(int[] array, int st, int end){

        if (array.length <= 1) {
            return 0;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        SortArray(left, 0, mid);
        SortArray(right, mid+1, end);
        res = res + merge(array, left, right);
        return res;
    }

    private static int merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        int inc = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
                inc = inc + (left.length -i);
            }
        }
        while (i < left.length) {
            array[k++] = left[i++];
        }
        while (j < right.length) {
            array[k++] = right[j++];
            inc = inc + (left.length -i);

        }
        return inc;
    }

    /**
     * Return the Bth smallest element in given array.
     * @param A
     * @param B
     * @return
     */
    public static int kthsmallest(final int[] A, int B) {
        // first do the selection sort
        // pick
        int res = 0;
        int N = A.length;
        for (int i = 0; i < N; i++){
            for (int j = 0; j<N-1; j++) {
                if (A[j] < A[j + 1]) { // sort the array using selection sort method
                    int temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                }
            }
            if (i == B){ // reduce the time complexity to O(B*N)
                break;
            }
        }
        res = A[A.length-B];
        //System.out.println(+res);
        return res;
    }

    /**
     * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
     * Find the total number of inversions of A modulo (109 + 7).
     * A = [3, 4, 1, 2]
     * Output: 4
     * The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
     * The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
     * The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
     * The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]
     * @param args
     * Idea1: Brute force O(N^2)
     * Idea2: Merge sort (divide and conquer)
     *
     */
    public static int getInversionPairCount(int[] A) {
        int res = 0;

        return res;
    }
    public static void main(String[] args) {
        int[] A = {3, 9, 15, 19};
        int[] B = {2, 4, 10};
        //int[] C = SortEvenAndOddSortedArray(A, B);
        int[] D = { 45, 10, 15, 25, 50 };
        day_40_advDSA_SelectionMergeSort obj = new day_40_advDSA_SelectionMergeSort();
        System.out.println(obj.SortArray(D, 0, D.length));
        //int [] E = { 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
        //kthsmallest(E, 9);
    }
}
