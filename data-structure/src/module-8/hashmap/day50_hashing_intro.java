/**
 * Hashmap is a key value pair
 */
import java.lang.annotation.IncompleteAnnotationException;
import java.util.*;

class test1 {
    int val;
    void test1Print() {
        System.out.println("test1Print");
    }
}
class test2 extends test1 {
    void test1Print() {
        System.out.println("in test2: test1Print");
    }
}
public  class day50_hashing_intro {
    public static HashMap<String, Integer> map = new HashMap<>();
    public static void hash_map_example(){
        map.put("India", 100);
        map.put("New India", 101);
    }
    public static void display_map(){
        System.out.println(map.size());
        for(String key: map.keySet()){
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }
    /**
     * Given an integer array A of size N, find the first repeating element in it.
     * We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
     * If there is no repeating element, return -1.
     *  A = [10, 5, 3, 4, 3, 5, 6], output: 5
     */
    static int firstRepeatedNumber(int[] A) {
        int minidx = -1;
        HashSet<Integer>map = new HashSet<>();
        for(int i=A.length-1; i>=0; i--) {
            int ele = A[i];
            if (map.contains(ele)) {
                minidx = i;
                System.out.println(minidx);
            } else {
                map.add(ele);
            }
        }
        if(minidx != -1) {
            return A[minidx];
        }
        return minidx;
    }
    /** Given an array A. You have some integers given in the array B.
     * For the i-th number, find the frequency of B[i] in the array A
     * and return a list containing all the frequencies.
     */
    static int[] frequencyOfArray(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //fill the freq
        for(int i=0; i<A.length; i++) {
            int ele = A[i];
            if (map.containsKey(ele)) {
                int freq = map.get(ele);
                map.put(ele, freq+1);
            } else {
                map.put(ele, 1);
            }
        }
        System.out.println(map);
        //fetch the freq
        int[]ans = new int[B.length];
        for(int i = 0; i<B.length;i++) {
            int freq = 0;
            if (map.containsKey(B[i])) {
                freq = map.get(B[i]);
              }
            ans[i] = freq;
        }
        return ans;

    }

    /**
     * Given an array of integers A, find and return whether the given array contains a
     * non-empty subarray with a sum equal to 0.
     * If the given array contains a sub-array with sum zero return 1, else return 0.
     * @param args
     */
    public static int findSubArraySumZero(int [] A) {
        int prefixSum = 0;
        HashSet<Integer>map = new HashSet<>();
        for (int i:A) {
            prefixSum = (prefixSum+ i);
            System.out.println("prefix:"+prefixSum);
            if(map.contains(prefixSum)) {
                return 1;
            } else if (prefixSum == 0) {
                return 1;
            } else {
                map.add(prefixSum);
            }
            System.out.println(prefixSum);
        }
        return 0;
    }
    public static void main(String[]args){
        //hash_map_example();
        //display_map();
        int[]A = {10, 5, 3, 4, 3, 5, 6};
        int[]B={1, 1, 6, 6, 7, 7, 4, 9};
        /** int[]Ans = frequencyOfArray(A, B);
        for(int i:Ans){
            System.out.println(i);
        } */
        int[] C = {-1, 1};
        System.out.println(findSubArraySumZero(C));
        test1 obj = new test2();
        obj.test1Print();
    }
}
