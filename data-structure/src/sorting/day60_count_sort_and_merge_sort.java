package sorting;

public class day60_count_sort_and_merge_sort {
    static  int max = 0;
    static int min = 0;
    public static int[] frequncyArray(int []A) {
        max = A[0];
        min = A[0];
        for (int i=0; i<A.length; i++) {
            if (A[i] > max) {
                max = A[i];
            } else if (A[i] < min) {
                min = A[i];
            }
        }
        int n = max-min+1;
        int[] fq = new int[n];
        System.out.println("fq size:"+n);
        // create frequency array
        for (int i=0; i<A.length; i++) {
            int m = A[i];
            int k= m-min;
            //System.out.println(":"+k);
            fq[k] =  fq[k]+1;
        }
        return fq;
    }

    /**
     * Given an array A. Sort this array using Count Sort Algorithm and return the sorted array
     * @param A
     * @return
     */
    public static int[] countSort(int[] A) {
        int[]fq = frequncyArray(A);
        int n = 0;
        for(int j=0; j<fq.length; j++) {
            int k = fq[j];
            while(k>0){
                A[n++] = j+min;
                k--;
            }
        }
        return A;

    }
    public static void main(String[] args) {
        int[]A={10, 9, 1, 8};
        countSort(A);
        System.out.println();
    }
}
