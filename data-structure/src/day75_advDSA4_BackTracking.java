import java.util.ArrayList;

public class day75_advDSA4_BackTracking {

    /**
     * Problem: NQueens
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
     * such that no two queens attack each other.
     * Given an integer A, return all distinct solutions to the n-queens puzzle.
     *
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
     * both indicate a queen and an empty space respectively.
     * The final list should be generated in such a way that the indices of the queens in each list
     * should be in reverse lexicographical order.
     * @param args
     */
    static char[][] fill(int A){
        char[][] res = new char[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                res[i][j] = '.';
            }
        }
        return res;
    }
    static boolean isValid(char[][]res, int row, int column, int N) {
        int i = row;
        int j = column;
        for (i = 0; i < row; i++) {
            if (res[i][column] == 'Q')
                return false;
        }
        i = row;
        j = column;
        while(i >= 0 && j >= 0) {
            if (res[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        i = row;
        j = column;
        while(i >= 0 && j < N) {
            if (res[i][j] == 'Q')
                return false;
            i--;
            j++;
        }
        return true;
    }
    static void backTrack(ArrayList<ArrayList<String>> res, char[][]in, int N, int row) {
        if (row == N) {
            ArrayList<String> str = new ArrayList<>();
            for (int i = 0; i<N; i++) {
               // for (int j = 0; j < N; j++) {
                //    System.out.print(in[i][j] + " ");
                  str.add(new String(in[i]));
                //}
                //System.out.println();
            }
            res.add(str);
            //System.out.println();

        }
        for(int i = 0; i < N; i++) { // check every column
            if (isValid(in, row, i, N)) {
                in[row][i] = 'Q';
                backTrack(res, in, N, row+1); //goto next column
                in[row][i] = '.';
            }
        }
    }

    /**
     * Soduko Problem
     * @param args
     */
    static boolean backtracksudoko(int row, int column, char[][]mat) {
        if (column == 9) {
            row = row+1;
            column = 0;
        }
        if (row == 9){
            return true;
        }
        if (mat[row][column] > 0) {
            return backtracksudoko(row, column+1, mat); //move to next column
        }
        for (int i = 1; i<=9; i++) { //traverse each number
            char x = (char)('0'+i);
            if(isValidSudoku(row, column, x, mat)){
                mat[row][column] = x; //put the number
                if (backtracksudoko(row, column+1, mat))
                    return true;//move to next row
                mat[row][column] = 0; //remove the last one
            }
        }
        return false;
    }
    static boolean isValidSudoku(int row, int column, char x, char[][]mat){
        for(int i = 0; i<9; i++){
            if (mat[row][i] == x)
                return false;
        }
        for(int i = 0; i<9; i++){
            if (mat[i][column] == x)
                return false;
        }
        int r = row - (row%3);
        int c = column - (column%3);
        for (int i=0; i<3; i++){
            for (int j = 0; j<3; j++){
                if (mat[i+r][j+c]==x){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /*
        int A=4;
        char[][] in = fill(A);
        System.out.println(in.length);
        System.out.println(in[0].length);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        backTrack(result, in, A, 0);
        String[][]out = new String[result.size()][A];
        for (int i = 0; i< result.size(); i++) {
            String[] array = new String[A];
            for (int j = 0; j< result.get(i).size(); j++) {
                array[j] = result.get(i).get(j);
            }
            out[i] = array;
        }
        System.out.println(result);
        for (int i = 0; i< result.size(); i++) {
            for (int j=0; j<A; j++) {
                System.out.println(out[i][j]+" ");
            }
            System.out.println();
        }
         */
        char[][]A={
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        backtracksudoko(0, 0, A);
        System.out.println();
    }
}
