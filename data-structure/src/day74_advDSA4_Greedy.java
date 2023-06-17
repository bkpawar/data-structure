import java.util.ArrayList;
import java.util.List;

public class day74_advDSA4_Greedy {
    /**
     * Whatever makes you uncomfortable is your biggest opportunity for growth.
     * <p>
     *     Greedy: It is approach to solve the problem, maximise the profit. It is not a
     *     DS or Algorithm.
     *     It is nothing but maximising/minimizing something. It may or may not work and that's
     *     where dynamic programming comes into picture.
     *
     *
     * </p>
     *
     *
     * @param args
     */
    /**
     * Q2. Permutations:
     * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
     * @param args
     */
    public static void backtrack(int[]A, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == A.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i<A.length; i++) {
                if (tempList.contains(A[i])) {
                    continue;
                }
                tempList.add(A[i]);
                backtrack(A, tempList, result);
                tempList.remove(tempList.size()-1);
            }
        }
    }
    public static int[][] permute(int[] A) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(A, new ArrayList<>(), result);
        int[][] permutations = new int[result.size()][A.length];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> tempList = result.get(i);
            for(int j = 0; j<tempList.size(); j++) {
                permutations[i][j] = tempList.get(j);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[][] permutations = permute(A);
        for (int[] permutation : permutations) {
            for (int num : permutation) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}
