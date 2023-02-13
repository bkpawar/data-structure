public class day_46_advDSA_BinarySearch3 {
    /**
     * Q; Painter problem
     * Given N boards with length of each board.
     * a> A painter takes T units of time to paint 1 count of len
     * b> A board can be painted by only 1 painter
     * c> A painter can only paint boards placed next to each other (ie continuous segments)
     * Q; find min no of painters required to paint all the boards in X unit of time.
     * Return -1 if not possible
     *
     */
    public int painterProblem(int X, int T, int[] A) {
        int cnt = 1, time = X;
        for (int i = 0; i < A.length-1; i++) {
            if ((A[i] * T) > X)) // painting one board itself takes more time
                return -1;
            if (A[i] * T <= X) {
                //assign to current painter
                time -= A[i]*T; // reduce the total time
            } else {
                cnt++;
                time = X - (A[i]*T);
            }
        }
        return cnt;
    } //Tc: O(N); Sc;O(1)

/**
 * Q: find min time to paint all boards if P painters are available.
 */
    public int getMinimumTimeofPainting(int X, int P, int[]A){
        // binary search
        //1> define search space

    }
}
