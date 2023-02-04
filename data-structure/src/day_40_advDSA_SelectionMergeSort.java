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
    public static void SortArray(int[] A, int st, int end){
        if (st == end){
            return; // single element in a array
        }
        int mid = (st + end)/2;
        SortArray(A, st, mid);
        SortArray(A, mid+1, end);
        MergeArray(A, st, mid, end); // 2 pointer approach

    }

    /**
     *
     * @param B
     * @param st
     * @param mid
     * @param end
     * @return
     */

    public static int[] MergeArray(int[] B, int st, int mid, int  end) {
        // merge the sorted array into one
        // assumption, I/P -> B[N], C[M] --> A[N+M]
        int i = st; //B
        int j = mid; //C
        int N = end;
        int A[] = new int [N];
        for (int k = 0; k< (N); k++) {
            if (i == mid) { //end of the array B
                A[k] = B[j++]; // take from C
            } else if (j == N){ // end of the array C
                A[k] = B[i++]; // take from B
            } else if (B[i]<B[j]){
                A[k] = B[i++]; // take smaller number
            } else {
                A[k]  = B[j++];
            }
        }
        return A;
    }
    public static void main(String[] args) {
        int[] A = {3, 9, 15, 19};
        int[] B = {2, 4, 10};
        //int[] C = SortEvenAndOddSortedArray(A, B);
        int[] D = { 3, 2, 9, 4};
        SortArray(D, 0, D.length);
    }
}
