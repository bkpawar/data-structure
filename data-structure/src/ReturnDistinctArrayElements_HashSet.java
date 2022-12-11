import java.util.HashSet;

public class ReturnDistinctArrayElements_HashSet {
    static int solve(int[] A) {
       // int result = 0;
        HashSet<Integer> myhash = new HashSet<>();
        for(int i=0; i< A.length; i++){
            myhash.add(A[i]);
        }
        return myhash.size();
    }

    public static void main(String[] args) {
        int[]A = new int[5];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 4;
        A[4] = 1;


        int c = solve(A);
        System.out.println(c);
    }
}
