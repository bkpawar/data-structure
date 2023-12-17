package sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class day60_merge_sort {
    public static int[] mergeSortedArray(final int[] A, final int[] B) {
        int m = A.length;
        int n = B.length;
        int[] C = new int[m+n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }
        while(i < m) {
            C[k++] = A[i++];
        }
        while(j < n) {
            C[k++] = B[j++];
        }
        return C;
    }
    public static int[] mergeSort(int[] Arr, int start, int end ) {
        if (start == end) {
            int[] breq = new int [1];
            breq[0] = Arr[start];
            return breq;
        }
        int mid = (start+end)/2;
        int[] A = mergeSort(Arr, start, mid);
        int[] B = mergeSort(Arr, mid+1, end);
        int[] C = mergeSortedArray(A, B);
        return C;
    }

    public static void main(String[] args) {
        int[]A = {1, 4, 10, 2, 1, 5};
        int[]C = mergeSort(A, 0, A.length-1);
        System.out.println(C);
    }
}
