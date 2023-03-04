import java.util.ArrayList;
import java.util.Stack;
//import org.apache.commons.lang3.StringUtils;
/**
 * Recursion: a function call itself.
 * It helps to solve a problem by solving some sub-problems.
 * <p>
 * In general, loops are faster than recursion for most types of problems, because they do not require the overhead of
 * maintaining a call stack and recursively calling function. However, the performance of a loop versus recursion can
 * depend on the specific problem and the implementation. For example, when the number of iterations is known in advance,
 * a for loop can be more efficient than recursion, because the number of iterations can be determined at compile time.
 * On the other hand, if the number of iterations is not known in advance, a while loop can be more efficient than recursion,
 * as the number of iterations can be determined at run time.
 * However, if the problem can be broken down into smaller subproblems that are similar in nature and can be solved independently.
 * Recursion can be more elegant and readable than using loop and also it can be more efficient in certain cases,
 * for example when the problem can be solved using a divide-and-conquer strategy.
 * </p>
 * <p>
 * In summary, the choice between using a loop or recursion depends on the specific problem, the implementation, and
 * the specific requirements of the application. In general, loops are faster than recursion, but recursion can be more
 * elegant and easier to understand in certain cases.
 * </p>
 */
public class day39_advDSA_recursion {
    /**
     * Problem: Find sum of first N natural numbers
     * @param N input as Natural number
     * N(N+1)/2
     * sum(N) = N + sum(N-1)
     * <p>
     *     1. Determine what the function should do.
     * </p>
     * <p>
     *     2. Build the logic on how to use subproblems to solve current problem
     * </p>
     * <p>
     *     3. Base case, smallest sub-problem, for which we know the ans.
     * </p>
     *     Tc: O(N),
     *     S(C): O(N) -> Multiple calls on stacks
     *
     */
    public static int getSumOfNaturalNo(int N){
        /*
        sum(5) = 5 + sum(4)...4+sum(3)............. 2+sum(1) [base case]
        sum(1) = 1
         */
        if (N == 1){
            return 1;
        }
        return N+getSumOfNaturalNo(N-1);
    }

    /**
     * Fibonacci Series: The current value is sum of previous two values.
     * @param N
     * @return
     * Tc: O(2^N), Sc: O(N).
     * Observation: at each moment, just one branch is active
     */
    public static int getFibonaccciSeries(int N){
        /*
         * F(i) = F(i-1)+F(i-2), i>=2
         * F(i) = i, i < 2;
         */
        if (N <2)
            return N;
        return getFibonaccciSeries(N-1)+getFibonaccciSeries(N-2);
    }

    /**
     * Print in Normal order
     * @param N
     */
    public static void simpleOrderPrint(int N){
       if (N == 0){
           return;
       }
        System.out.println(N);
        simpleOrderPrint(N-1);
    }

    /** Print the series in reverse order for given N
     *
     * @param N
     */
    public static void reverseOrderPrint(int N){
        if (N == 0){
            return;
        }
        reverseOrderPrint(N-1);
        System.out.println(N);
    }

    /**
     * Famous problem: Tower of Hanoi.
     * <p>
     *     The Tower of Hanoi is a classic problem in computer science and mathematics, often used to illustrate the power and elegance of recursion.
     *     The problem consists of three rods and a number of disks of different sizes, which can slide onto any rod.
     *     The puzzle starts with the disks in a neat stack in ascending order of size on one rod, the smallest at the top
     *     and the largest at the bottom. The goal of the puzzle is to move the entire stack to another rod,
     *     obeying the following simple rules: Only one disk can be moved at a time.
     *     </p>
     *     <p>
     *         Each move consists of taking the upper disk from one of the rods and sliding it onto another rod,
     *         on top of the other disks that may already be present on that rod. No disk may be placed on top of a smaller disk.
     *          The solution to the Tower of Hanoi problem can be implemented using recursion. The basic idea is to divide the problem into smaller subproblems. The first step is to move the top n-1 disks from the starting rod to an auxiliary rod, using the destination rod as a temporary holding place. Next, move the nth disk from the starting rod to the destination rod.
     *          Finally, move the n-1 disks from the auxiliary rod to the destination rod, using the starting rod as a temporary
     *          holding place. The time complexity of a recursive algorithm for the Tower of Hanoi problem is O(2^n),
     *          where n is the number of disks. This is because for each disk, the algorithm calls itself twice,
     *          once for the top n-1 disks, and once for the bottom disk.
     *          </p>
     *          <p>
     *          In summary, the Tower of Hanoi problem is a classic example of how recursion can be used to solve a
     *          problem by breaking it down into smaller subproblems. The recursive solution to the
     *          Tower of Hanoi problem has a time complexity of O(2^n).
     *     </p>
     * @param N
     */
    public static void towerOfhanoi(int N, int As, int Cd, int Bh){
        if (N == 1){
            System.out.print(1+"As->Cd");
            return;
        }
        // sub problem 1: move N-1, A->B using c
        towerOfhanoi(N-1, As, Bh, Cd);
        System.out.print(N+"A->C");
        // sub problem 2: move N-1 from B->C using A
        towerOfhanoi(N-1, Bh, Cd, As);

    }

    /**
     * Problem:  Generate all Parentheses II
     * <p>
     *     Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.
     *
     * </p>
     * @param A First and only argument is integer A.
     * @return Return a sorted list of all possible parenthesis.
     *<p>
     *     A = 3
     *     [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
     *</p>
     */
    ArrayList<String> generateParenthesisAns = new ArrayList<>();
    public  ArrayList<String> generateParenthesis(int A) {
        recursionMethod("", 0, 0, A);
        return generateParenthesisAns;
    }
    private String removeLastChar(String s)
    {
        //returns the string after removing the last character
        if (s.length() > 0)
            return s.substring(0, s.length() - 1);
        else
            return null;
    }
    void recursionMethod(String curr, int openBr, int closeBr, int A){
        if ((openBr == A) && (closeBr == A)){
            generateParenthesisAns.add(curr);
            return; // found the seq
        }
        if (openBr == A) {
            recursionMethod(curr+")", openBr, closeBr+1, A);
            return;
        }
        if (openBr == closeBr) {
            //first element
            recursionMethod(curr+"(", openBr+1, closeBr, A);
        }

        if (openBr > closeBr ) {
            recursionMethod(curr+"(", openBr+1, closeBr, A);
            recursionMethod(curr+")", openBr, closeBr+1, A);
        }
        return;
    }
    public static void main(String[] args) {
        //System.out.println("sum of natural no:"+getSumOfNaturalNo(5));
        //System.out.println("Febonacci series sum:"+getFibonaccciSeries(4));
        //simpleOrderPrint(3);
        //reverseOrderPrint(3);
        day39_advDSA_recursion obj = new day39_advDSA_recursion();
        System.out.println(obj.generateParenthesis(2));
    }
}
