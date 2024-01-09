import java.util.Stack;

public class day_57_advDSA_Stacks2 {
    /**
     * Q1: Nearest Smaller Element
     * <p>
     * Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the
     * element has an index smaller than i.
     * <p>
     * A = [4, 5, 2, 10, 8]
     * o/p = [-1, 4, -1, 2, 2]
     *
     * </p>
     * index 1: No element less than 4 in left of 4, G[1] = -1
     * index 2: A[1] is only element less than A[2], G[2] = A[1]
     * index 3: No element less than 2 in left of 2, G[3] = -1
     * index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
     * index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
     * </p>
     */
    static public int[] prevSmaller(int[] A) {
        Stack<Integer>myStack = new Stack<>();
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++){
            while (!myStack.isEmpty() && A[myStack.peek()] >= A[i]) {
                myStack.pop();
            }
            if (myStack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = A[myStack.peek()];
            }
            myStack.push(i);
        }
        return ans;
    }
    public int[] nextSmaller(int[] A) {
        int[]res = new int[A.length];
        int n = A.length;
        Stack<Integer>st = new Stack<>();
        for (int i = A.length-1; i >= 0; i--) {
            while(st.size() > 0 && st.peek() >= A[i]) {
                st.pop();
            }
            if(st.size() == 0) {
                res[i] = n;
            } else  {
                res[i] = st.peek();
            }

            st.push(i);
        }
        return res;
    }

    /**
     *Q2. Largest Rectangle in Histogram
     * <p>
     *  Given an array of integers A.
     *  A represents a histogram i.e A[i] denotes the height of the ith histogram's bar.
     *  Width of each bar is 1.
     *  Find the area of the largest rectangle formed by the histogram.
     * </p>
     * <p>
     *     A = [2, 1, 5, 6, 2, 3], Ans: 10
     *     The largest rectangle has area = 10 unit. Formed by A[3] to A[4]
     * </p>
     * @param A: The only argument given is the integer array A.
     * @return Return the area of the largest rectangle in the histogram.
     */
    public static int largestRectangleArea(int[] A) {
        int[]prevSmaller = prevSmaller(A);
        int[]nextSmaller = nextSmaller(A);
        int gans = A[1];
        for(int i = 0; i< A.length; i++) {
            int h = A[i];
            int w = nextSmaller[i]-prevSmaller[i]-1;
            int ans = h * w;
            if (ans > gans) {
                gans = ans;
            }
        }
        return gans;
    }
    public static void main(String[] args) {
        int[]A = {1};
        System.out.println(largestRectangleArea(A));
    }
}
