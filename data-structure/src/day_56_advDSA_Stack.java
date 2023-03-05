import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Stack: LIFO --> Last In First Out.
 * books on the table, stacks of plates are real life examples.
 * Recursion calling stack. options like undo and redo & browsing history also stack implementation.
 * <p>
 *     Operations: 1> push(x): insert x a top of stack.
 *     2> pop(): remove top element from stack.
 *     3> top()/peek(): get top element from stack, don't remove.
 *     4> isEmpty(): check if stack is empty
 * </p>
 */
class mStack {
    private char[] items;
    private int top; // Index of the top element in the stack
    private int capacity;

    public mStack(int capacity) {
        this.capacity = capacity;
        this.items = new char[capacity];
        this.top = -1;
    }

    public void push(char item) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        items[top] = item;
    }

    public char pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return 0;
        }
        char item = items[top];
        items[top] = 0x00;
        top--;
        return item;
    }

    public char peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return 0;
        }
        return items[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return (top + 1);
    }
}
public class day_56_advDSA_Stack {
    /**
     * Q1: Implement stack using linked list.
     * @param args
     */
    /**
     * Q2: algorithm to solve the parenthesis problem using a stack.
     * <p>
     * 1. Create an empty stack.
     * 2. Traverse the string from left to right, character by character.
     * 3. If the current character is an opening parenthesis (i.e., '(' or '{' or '['), push it onto the stack.
     * 4. If the current character is a closing parenthesis (i.e., ')' or '}' or ']'), check if the stack is empty.
     * If the stack is empty, return false (since we can't have a closing parenthesis without an opening one).
     * Otherwise, pop the top element from the stack and check if it matches the current closing parenthesis.
     * If it doesn't match, return false. If it matches, continue with the next character.
     * 5. After traversing the entire string, check if the stack is empty. If it is empty,
     * the string is balanced. Otherwise, it is unbalanced.
     * </p>
     *
     * @param args
     */
    public int isBalancedParanthesis(String A) {
        int len = A.length();
        mStack mystack = new mStack(len);
        char oldPush = 0;
        for (int i = 0; i < len; i++) {
            char tmp = A.charAt(i);

            //System.out.println(tmp);
            switch (tmp) {
                case '{':
                case '(':
                case '[':
                    mystack.push(tmp);
                    oldPush = tmp;
                    break;
                case '}':
                case ')':
                case ']':
                    char tmp1 = mystack.pop();
                    if (!((tmp == ']' && tmp1 == '[') || (tmp == ')' && tmp1 == '(') || (tmp == '}' && tmp1 == '{'))) {
                        return 0;
                    }
            }
        }
        if (mystack.isEmpty()) {
            System.out.println("Balanced parantehsis");
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Problem: Double Character Trouble
     * <p>
     * You are given a string A.
     * <p>
     * An operation on the string is defined as follows:
     * Remove the first occurrence of the same consecutive characters. eg for a string "abbcd",
     * the first occurrence of same consecutive characters is "bb".
     * Therefore the string after this operation will be "acd".
     * Keep performing this operation on the string until there are no more occurrences of the
     * same consecutive characters and return the final string.
     * </p>
     * <p>
     * Tc: O(N)
     * Sc; O(no of parenthesis)
     * </p>
     *
     * @param A
     * @return
     */
    public String doubleCharacterTrouble(String A) {
        int len = A.length();
        mStack mystack = new mStack(len);
        for (int i = len - 1; i >= 0; i--) {
            char tmp = A.charAt(i);
            if (tmp != mystack.peek()) {
                mystack.push(tmp);
            } else {
                mystack.pop();
            }
        }
        if (mystack.isEmpty())
            return null;
        StringBuilder ans = new StringBuilder(); // for large size, String will not work Time limit issue.
        //Because Strings are immutable in java.
        //So for every addition of character new String is being made.

        int cnt = mystack.size();
        for (int i = 0; i <= cnt; i++) {
            ans.append(mystack.pop());
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        /* mStack mystack = new Stack(5);
        mystack.push('(');
        mystack.push('}');
        System.out.println(mystack.pop());
        System.out.println(mystack.isEmpty());
        System.out.println(mystack.pop());
        System.out.println(mystack.isEmpty());
         */
        /*
        day_56_advDSA_Stack obj = new day_56_advDSA_Stack();
        System.out.println(obj.isBalancedParanthesis("{([])}"));
        System.out.println(obj.isBalancedParanthesis("({)}"));
        System.out.println(obj.isBalancedParanthesis("))))))))"));
        */

        /*
        day_56_advDSA_Stack obj = new day_56_advDSA_Stack();
        //System.out.println(obj.doubleCharacterTrouble("abccbc"));
        System.out.println(obj.doubleCharacterTrouble("aba"));
         */
        StandardStack obj = new StandardStack();
       /*
        ArrayList<String>myList = new ArrayList<String>();
        myList.add("2");myList.add("1");myList.add("+");myList.add("3");myList.add("*");
        System.out.println(obj.evalRPN(myList)); */
        //Q4
        Integer[] Arr = {86, 63, 60, 0, 47, 0, 99, 9, 0, 0};
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.stream(Arr).toList());


        System.out.println(obj.passTheBall(10, 23, C));
    }
}
    /**
     * Q3. Evaluate Expression
     * <p>
     *     An arithmetic expression is given by a string array A of size N.
     *     Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are +, -, *, /. Each string may be an integer or an operator.
     * </p>
     * <p>
     *     Input 1:   *     A =   ["2", "1", "+", "3", "*"]
     *     Explaination 1:
     *     starting from backside:
     *     * : () * ()
     *     3 : () * (3)
     *     + : (() + ()) * (3)
     *     1 : (() + (1)) * (3)
     *     2 : ((2) + (1)) * (3)
     *     ((2) + (1)) * (3) = 9
     * </p>
     * @param A: The only argument given is string array A.
     * @return; Return the value of arithmetic expression formed using reverse Polish Notation.
     */
class StandardStack {
        public int evalRPN(ArrayList<String> A) {
            int n = A.size();
            Stack<Integer> mystack = new Stack<Integer>();
            int a, b;
            for (int i = 0; i < n; i++) {
                if (A.get(i).equals("+")) {
                    a = mystack.pop();
                    b = mystack.pop();
                    mystack.push(a + b);
                } else if (A.get(i).equals("-")) {
                    a = mystack.pop();
                    b = mystack.pop();
                    mystack.push(b - a);
                } else if (A.get(i).equals("*")) {
                    a = mystack.pop();
                    b = mystack.pop();
                    mystack.push(a * b);
                } else if (A.get(i).equals("/")) {
                    a = mystack.pop();
                    b = mystack.pop();
                    mystack.push(b / a);
                } else {
                    mystack.push(Integer.parseInt(A.get(i)));
                }
            }
            return mystack.pop();
        }

        /**
         * Q4. Passing game
         * <p>
         *     There is a football event going on in your city. In this event,
         *     you are given A passes and players having ids between 1 and 106
         *     Initially, some player with a given id had the ball in his possession. You have to make a program to
         *     display the id of the player who possessed the ball after exactly A passes.
         *     There are two kinds of passes: 1) ID 2) 0
         *     For the first kind of pass, the player in possession of the ball passes the ball "forward"
         *     to the player with id = ID. For the second kind of pass, the player in possession of the ball
         *     passes the ball back to the player who had forwarded the ball to him.
         *     In the second kind of pass "0" just means Back Pass.
         *     Return the ID of the player who currently possesses the ball.
         * </p>
         * <p>
         *      A = 10 B = 23 C = [86, 63, 60, 0, 47, 0, 99, 9, 0, 0]
         *    Initially, Player having  id = 23  posses ball.
         *  After pass  1,  Player having  id = 86  posses ball.
         *  After pass  2,  Player having  id = 63  posses ball.
         *  After pass  3,  Player having  id = 60  posses ball.
         *  After pass  4,  Player having  id = 63  posses ball.
         *  After pass  5,  Player having  id = 47  posses ball.
         *  After pass  6,  Player having  id = 63  posses ball.
         *  After pass  7,  Player having  id = 99  posses ball.
         *  After pass  8,  Player having  id = 9   posses ball.
         *  After pass  9,  Player having  id = 99  posses ball.
         *  After pass  10, Player having  id = 63   posses ball.
         * </p>
         * @param A
         * @param B
         * @param C
         * @return
         */
        public int passTheBall(int A, int B, ArrayList<Integer> C) {
            int n = C.size();
            Stack<Integer>myStack = new Stack<Integer>();
            myStack.push(B);
            for(int i = 0; i<n; i++) {
                int id = C.get(i);
                if(id != 0){
                    myStack.push(id);
                } else {
                    if (myStack.size() > 1)
                        myStack.pop();
                }
            }
            return myStack.pop();
        }
}
