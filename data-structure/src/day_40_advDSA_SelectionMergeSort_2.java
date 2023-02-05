import java.util.*;

public class day_40_advDSA_SelectionMergeSort_2 {
    /**
     * Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
     * Input 1:
     * A = [4, 7, 9 ]
     * B = [2, 11, 19 ]
     * Output 1:
     * [2, 4, 7, 9, 11, 19]
     */
    public static ArrayList<Integer> MergeTwoSortedArray(final List<Integer> A, final List<Integer> B) {

        int i = 0;
        int j = 0;
        int n = A.size()+B.size();
        ArrayList<Integer>res = new ArrayList<>();
        for(int k=0 ; k<n; k++){
            if (i == A.size() ) { // end of A
                res.add(k, B.get(j));
                j++;
            } else if (j == B.size()) { // end of B
                res.add(k, A.get(i));
                i++;
            } else if (A.get(i) < B.get(j)) {
                res.add(k, A.get(i));
                i++;
            } else {
                res.add(k, B.get(j));
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] A = {3, 9, 15, 19};
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(A));
        Integer[] B = {2, 4, 10};
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(B));
        System.out.println(MergeTwoSortedArray(list, list1));
    }
}
