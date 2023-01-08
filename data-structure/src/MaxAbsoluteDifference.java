/*
Problem Description
You are given an array of N integers, A1, A2, .... AN.

Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is
defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

A = [1, 3, -1]
f(1, 1) = f(2, 2) = f(3, 3) = 0
f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5
So, we return 5.
1. A[i]>=A[j]
f(i, j) = |A[i] - A[j]| + |i - j|
        = (|A[i]|+i) - (|A[j]|+j)
        = Xi - Xj
 Identify Xmax - Xmin

2.
1. A[i]<A[j]
f(i, j) = |A[j] - A[i]| + |i - j|
        = (|A[j]|-j) - (|A[i]|-i)
        = Yj - Yi
Identify Ymax - Ymin

 */
public class MaxAbsoluteDifference {
    public static int max(int a, int b){
            if (a >= b){
                return a;
            } else {
                return b;
            }
        }
        public static int min(int a, int b){
            if (a <= b){
                return a;
            } else {
                return b;
            }
        }
        public static int maxArr(int[] A) {
            int xmin = A[0];
            int xmax = A[0];
            int ymin = A[0];
            int ymax = A[0];
            int sumy = 0;
            int sumx = 0;
            int ans = A[0];
            for (int i = 0; i<A.length; i++){
                sumx = i+A[i];
                xmin = min(xmin, sumx);
                xmax = max(xmax, sumx);

                sumy = A[i]-i;
                ymin = min(ymin, sumy);
                ymax = max(ymax, sumy);
            }
            ans = max(xmax-xmin, ymax-ymin);
            return ans;
    }

    public static void main(String[] args) {
        int[]A = new int[3];  // 4, 2, 1, 9, 5, 6, 3, 4, 4, 8
        A[0] = 1;
        A[1] = 3;
        A[2] = -1;
        System.out.println(maxArr(A));

    }
}
