import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Sorting: Arranging the data in increasing or decreasing order based on parameter.
 * Best Time complexity: NlogN. N-> number of elements to sort. check day_40_advDSA_SelectionMergeSort
 */
public class day_19_Sorting {
    /**
     * Q1: elements removal, Given N elements, at every step remove an array element.
     * Cost to remove element = sum of array elements present in the array.
     * Find min cost to remove all elements.
     *  A[] = { 3, 6, 2, 4} , total sum = 15
     *  remove A[4] and A[6]
     *  remove (6) cost = 15, remove(4) cost = 9, remove(3) = 5, remove(2) = 2 Total : 31
     *  <p>
     *    Solution: Delete element by elem in decreasing order.
     *    A[] = {d, c, b, a}, sum = d*1 + c*2 + b*a + a*4  //keep min number at end, Desending order
     *  </p>
     */
    public static int calcMinCost(int[] A){
        int n = A.length;
        //sort(a, DESC);  // refer to prog language Tc; NlogN
        Arrays.sort(A);
        reverse(A);
        int c = 0;
        for(int i = 0; i<n; i++){ //Tc: O(N)
          // remove a[i]
          // how many times it appears in total cost : (i+1) times
          c = c+ A[i]*(i+1);
        }
        return c;
        //Tc: O(N) + NlogNN = NlogN
        //Sc: O(1)
    }
    public static void reverse(int[] A) {
        int n = A.length;
        for(int i=0; i<n/2; i++){
            int temp = A[i];
            A[i] = A[n-i-1];
            A[n-i-1] = temp;
        }
    }
    /**
     * Q2: Noble Integers: Data is distinct
     * Given N elements, calculate number of noble integers.
     * A[i] is Noble integer if,
     *  no of elements less than Ai] = A[i]
     *  ex: {-1, -5, 3, 5, -10, 4}
     *  less{ 2,  1, 3, 5, 0  , 4} Noble integers: 3, 5, 4
     *  <p>
     *      Observation: Negative values can not be Nobel
     *  </p>
     *  <p>
     *      Idea1: Go through array and for every element get the no of element
     *      smaller than current element, if index and count is same it is Noble.
     *      int ans = 0
     *      for(i = 0; i<N; i++)
     *          int c = 0
     *          for(int j = 0; j<N; j++)
     *              if(arr[i]>arr[j])
     *                  c = c+1
     *          if(arr[i]==c)
     *              ans++ //Noble value
     *       return ans;
     *       Tc: O(N^2), Sc: O(1)
     *  </p>
     *  <p>
     *      Idea2: sort the array first in ascending order {-10, -5, -1, 3, 4, 5}
     *      if index and current value is equal it is Nobel integer.
     *      int Noble(int[] arr)
     *          int N = arr.length
     *          sort(arr, ASCE);
     *          int ans = 0;
     *          for(int i = 0; i<N; i++)
     *              if (arr[i] == i)
     *                  ans++
     *          }
     *          return ans;
     *          Tc: N(logN); Sc: O(1)
     *     <p>
     *         { -10, 1,1,1,4,4,4,7,10}, ans = 7
     *         There is issue if no is repeated, and that is nobel no.
     *         Obs1: if an element comes for first time #of elements < arr[i]==i
     *         Obs2: if an element repeats #of elements less than arr[i] remains same.
     *             int NobleRep(int[] arr)
     *      *          int N = arr.length
     *      *          sort(arr, ASCE);
     *      *          int ans = 0;
     *                  int less = 0; //no of elements lesss than arr[i]
     *                  if (arr[0] == 0) //check edge condition
     *                      ans = 1;
     *      *          for(int i = 1; i<N; i++) //i=0; out of boundary condition
     *                     //update less
     *                     if(arr[i] != arr[i-1]){
     *                          less = i;
     *                     } else { //repeating itself
     *                          // do nothing
     *                     }
     *                     //check for nobel
     *      *              if (arr[i] == less) {
     *      *                  ans++
     *                      }
     *      *          }
     *      *          return ans;
     *      *       Tc: N(logN); Sc: O(1)
     *
     *     </p>
     *  </p>
     * @param args
     */
    public static int NobleRep(int[] arr){
        int ans = 0;
        return ans;
    }
    /**
     * Sorting Algo:
     * arr[]: {3, 8, 6, 2, 4}
     * after 1 iteration -> last 1 element is correct position
     * after 2 -----//---- -> last 2 elements is correct position
     *
     * after n ----//----  -> last N-1 elements is in correct position
     *  Bubblesort(int[] arr), Tc: O(N^2)
     *  every step of the loop the biggest element will be pushed to end.
     *  like bubble,
     */
    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i = 1; i<n; i++) { // j = N-1
            for(int j = 0; j<n-1; j++){
                if (arr[j] > arr[j+1]) {//has the power to define the order, eg for descending order use < operator
                     int temp = arr[j+1];
                     arr[j+1] = arr[j];
                     arr[j] = temp;
                }
             }
         }
    }

    /**
     * You ca introduce your custom sorting order by changing if condition.
     * @param arr
     */
    public static void bubbleSortOptimized(int arr[]){
        int n = arr.length;
        for(int i = 1; i<n; i++) { // j = N-1
            for(int j = 0; j<n-1; j++){
                if (comp(arr[i], arr[j]) != 0) {//has the power to define the order, eg for descending order use < operator
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    /**
     * Comparator in Java
     * Comparator myCustomComp(Integer a, Integer b){
     *     // if you want a to come before b {return -1}
     *     // if you want a and b have same rank: {return 0}
     *     // if you want b to come before a {return 1}
     * }
     * sort(arr,my_custom_cm)
     * @param args
     */
    public static int comp(int a, int b){
        // implement my custom order
        // like xls different column sorting
        int fa = 0; //actors(a);
        int fb = 0; //factors(b);
        if (fa < fb) {
            // a should come before b
            return -1;
        } else if ((fa == fb) & (a<b)){
            // a should come after b
            return -1;
        } else {
            // b should come before
            return 1;
        }
    }

    /**
     * Q4: Gven N elements, sort them in increasing order of their No of factors.
     * Note: if elements have the same number of factor, element with less value should
     * come first.
     * Sc: O(1).
     * <p>
     *     Example: a[]={9, 3, 4, 8, 16, 37, 6, 13, 15}
     *       factors    {3, 2, 3, 4, 5, 2,   4, 2,  4}
     *      sortedOrder {3, 13, 37, 4, 9, 6, 8, 15, 16}
     *
     * </p>
     * Example
     * @param args
     */
    public void sortFactorArray(int []a){

    }

    /**
     * Q5: Given an array A of non-negative integers, arrange them such that they form the largest number.
     * Note: The result may be very large, so you need to return a string instead of an integer.
     * Example Input
     * Input 1: A = [3, 30, 34, 5, 9]
     * Input 2: A = [2, 3, 9, 0]
     * Example Output
     * Output 1: "9534330"
     * Output 2: "9320"
     * @param A : Input array[ // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY]
     */
    public String largestNumber(final int[] A) {
        /*
        To construct the largest number, we want to ensure that the most significant digits are occupied by the largest digits.
        First, we convert each integer to a string. Then, we sort the array of strings.

         */
        String[] asStr = new String[A.length];
        for(int i = 0; i<A.length; i++){
            asStr[i] = String.valueOf(A[i]); // Get input integers as strings.
        }
        // sort strings, according to custom operators.
        Arrays.sort(asStr, new LargerNumComparator());
        // If, after being sorted, the largest number is `0`, the entire number is zero.
        if (asStr[0].equals("0")) {
            return "0";
        }
        // Build largest number from sorted array.
        String largestNumber = new String();
        for(String numAsStr : asStr) {
            largestNumber +=numAsStr;
        }
        return largestNumber;
    }
    private class LargerNumComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }
    public static void main(String[] args) {
        int []arr = {4, 3, 6, 2};
        //day_19_Sorting obj = new day_19_Sorting();
        //bubbleSort(arr);
        //System.out.println("largestNumber output:" +obj.largestNumber(arr));
        int[] myArr = {3,6, 2, 4};
        System.out.println(calcMinCost(myArr));

    }
}
