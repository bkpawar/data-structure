import java.lang.*;
import java.util.*;

public class day76_advDSA4_DP1 {
    static int getFb(int N, int[]dp) {
        if (N <= 1) {
            return N;
        }
        if (dp[N] != -1) {
            return dp[N];
        }
        return dp[N]=getFb(N-1, dp)+getFb(N-2, dp);
    }
    /*
    You are climbing a staircase and it takes A steps to reach the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    Return the number of distinct ways modulo 1000000007
     */
    public static int climbStairs(int A) {
        if (A <= 1) {
            return A;
        }
        int a = 1;
        int b = 2;
        int c = b;

        for(int i = 3; i<=A; i++) {
            //dp[i] = dp[i - 1] + dp[i - 2];
            c = (a + b)%1000000007;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     *Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A
     * A = 6
     * Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
     * Minimum count of numbers, sum of whose squares is 6 is 3.
     * @param A
     * @return
     */
    public static int countMinSquares(int A) {
        int[]dp = new int[A+1];
        for (int i=1; i<= A; i++) {
            dp[i]=i;
            for(int x=1; x*x<=i; x++){
                dp[i] = min(dp[i], dp[i-(x*x)]+1);
            }
        }
        return dp[A];
    }
    public static int min(int A, int B){
        if (A<B) return A;
        else
            return B;
    }
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if (a < 1) {
            System.out.print(a);
        }
        int[]dp = new int[a+1];
        for (int i = 0; i <= a; i++){
            dp[i] = -1;
        }
        System.out.print(getFb(a, dp));
        */
        //System.out.println(climbStairs(9));
        System.out.println(countMinSquares(12));
    }
}
