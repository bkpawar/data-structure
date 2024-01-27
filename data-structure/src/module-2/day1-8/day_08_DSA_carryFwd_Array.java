import java.util.ArrayList;
public class day_08_DSA_carryFwd_Array {
    /**
     * Q1: You have given a string A having Uppercase English letters.
     * You have to find how many times subsequence "AG" is there in the given string.
     * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
     * Input 1:
     *  A = "ABCGAG"  //Subsequence "AG" is 3 times in given string
     *  Output 1:
     *  3
     *  Input 2:
     *  A = "GAB"  // There is no subsequence "AG" in the given string.
     *  Output 2:
     *  0
     */
    public static int subsequenceStringOccurance(String A) {
        int res = 0;
        int cnt_g = 0;
        int MOD=1000000007;
        //System.out.println(A.length());
        for(int i = A.length()-1; i>= 0; i--){
            //System.out.println(i);
            //System.out.println(A.charAt(i));
            if(A.charAt(i) == 'G'){
                //System.out.println("G found");
                cnt_g++;
            } else if(A.charAt(i) == 'A') {
                res = (res +cnt_g)%MOD;
            }
        }
        return res;
    }

    /**
     * Problem Description
     * Given an integer array A containing N distinct integers, you have to find all the leaders in array A.
     * An element is a leader if it is strictly greater than all the elements to its right side.
     * NOTE: The rightmost element is always a leader.
     * Problem Constraints
     *
     * 1 <= N <= 105
     * 1 <= A[i] <= 108
     * Input Format
     * There is a single input argument which a integer array A
     * Output Format
     * Return an integer array denoting all the **leader elements** of the array.
     * NOTE: Ordering in the output doesn't matter.
     *
     * Example Input
     *  A = [16, 17, 4, 3, 5, 2]
     * Example Output
     *  [17, 2, 5]
     * Example Explanation
     *
     *  Element 17 is strictly greater than all the elements on the right side to it.
     *  Element 2 is strictly greater than all the elements on the right side to it.
     *  Element 5 is strictly greater than all the elements on the right side to it.
     *  So we will return this three elements i.e [17, 2, 5], we can also return [2, 5, 17] or [5, 2, 17] or any other ordering.
     * @param A
     * @return
     */
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int max_val = A.get(A.size()-1);
        result.add(max_val);
        int res = 1;
        for(int i=A.size()-1; i>= 0 ; i--){
            if(A.get(i) > max_val){
                res++;
                max_val = A.get(i);
                result.add(max_val);
            }
        }
        return result;
    }

    /**
     * Problem Description
     * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the
     * maximum value of the array and at least one occurrence of the minimum value of the array.
     * Problem Constraints
     * 1 <= |A| <= 2000
     * Input Format
     * First and only argument is vector A
     * Output Format
     * Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
     * Example Input
     * Input 1:
     * A = [1, 3]
     * Input 2:
     * A = [2]
     * Example Output
     * Output 1:
     *  2
     * Output 2:
     *  1
     * Example Explanation
     * Explanation 1:
     *  Only choice is to take both elements.
     * Explanation 2:
     *  Take the whole array.
     * @param A
     * @return
     */
    public int smallestSubArraywithMaxMin(ArrayList<Integer> A) {
        int res = 0;
        int gres = -1;
        int min = 0;
        int max = 0;
        int min_index = -1;
        int max_index = -1;

        res = A.get(0);
        min = res;
        max = res;

        //System.out.println("min:"+min+" max:"+max);
        //System.out.println(A);
        for (int i = 1; i <= A.size() - 1; i++) {
            if (A.get(i) < min) {
                min = A.get(i);
            } else if (A.get(i) > max) {
                max = A.get(i);
            }
            //System.out.println("min:"+min+" max:"+max+" i:"+A.get(i));
        }
        //System.out.println("min:" + min + " max:" + max);

        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) == max) {
                max_index = i;
                if (min_index != -1) {
                    if(max_index > min_index) {
                        res = max_index - min_index + 1;
                    } else {
                        res = min_index - max_index +1;
                    }
                    if (gres == -1)
                        gres = res;
                    if (res < gres)
                        gres = res;
                    //System.out.println("max res:"+res+" min_id:"+min_index+" max_id:"+max_index);
                }
            }
            if (A.get(i) == min) {
                min_index = i;
                if (max_index != -1) {
                    if(max_index > min_index) {
                        res = max_index - min_index + 1;
                    } else {
                        res = min_index - max_index +1;
                    }
                    if (gres == -1)
                        gres = res;
                    if (res < gres)
                        gres = res;
                    //System.out.println("min res:"+res+" min_id:"+min_index+" max_id:"+max_index);
                }
            }


        }
        return gres;
    }

    public static void main(String[] args) {

    }
}
