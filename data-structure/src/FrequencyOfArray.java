import java.util.HashMap;

/*
Problem Description
Given an array A. You have some queries given by the array B.
For the i-th query, find the frequency of B[i] in the array A.


Input Format
First argument A is an array of integers.

Second argument B is an array of integers denoting the queries.

Output Format
Return an array of integers answering each of the queries.


Example Input
Input 1:
A = [1, 2, 1, 1]
B = [1, 2]
Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]

Example Output
Output 1:
[3, 1]
Output 2:
[0, 2]
 */
public class FrequencyOfArray {
    static int[] solve(int[] A, int[] B) {
        int[]result = new int[B.length];
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i<A.length; i++) {  // Create the hashmap
            if(map.containsKey(A[i])) {
                Integer value = map.get(A[i]);
                //System.out.println("Value is incremented:"+value);
                map.replace(A[i], value+1);  // increase the value part
            } else {
                map.put(A[i], 1); //Insert the key-value pair in Hashmap
            }
           // System.out.println(map);
        }
        for(int i = 0; i<B.length; i++) {
            if(map.containsKey(B[i])){
                Integer value = map.get(B[i]);
                result[i] = value;
            }
        }
        //System.out.println(map.get(0));
        return result;
    }
    public static void main(String[] args) {
        int[]A = new int[5];
        A[0] = 1;
        A[1] = 2;
        A[2] = 1;
        A[3] = 1;
        A[4] = 2;

        int[]B = new int[2];
        B[0] = 1;
        B[1] = 2;

        int[]c = solve(A, B);
        for(int i=0; i<c.length; i++)
            System.out.println(c[i]);
    }
}