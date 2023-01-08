public class ArrayModOperation {
        static long solve(int[] A, int B) {
            int n = A.length;
            int m = 1;
            long res = 0;
            System.out.println(B);
            for (int i=n-1; i>= 0; i--){
                System.out.println("i:"+i+"A[i]:"+A[i]+"B:"+B);
                res = (res+ (A[i]*m)%B)%B;
                m = m*10;
                //ans = (ans%B);
            }
            if (res < 0)
                res = res + B;
            return res;
        }
    public static void main(String[] args) {
        int[]A = new int[10];  // 4, 2, 1, 9, 5, 6, 3, 4, 4, 8
        A[0] = 4;
        A[1] = 2;
        A[2] = 1;
        A[3] = 9;
        A[4] = 5;
        A[5] = 6;
        A[6] = 3;
        A[7] = 4;
        A[8] = 4;
        A[9] = 8;

        System.out.println(solve(A, 5));

    }
}
