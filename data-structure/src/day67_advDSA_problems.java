import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
public class day67_advDSA_problems {
    public static ArrayList<Integer> CodingMentorsolve(ArrayList<Integer> A) {
        Stack<Integer> ans = new Stack<Integer>();

        for(int i = 0; i < A.size(); i++ ) {
            int st_idx = A.get(i);
            for (int j = i+1; j<A.size(); j++) {
                if (st_idx < A.get(j)) {
                    ans.push(i);
                    st_idx = A.get(i);
                    continue;
                }
            }
            ans.push(-1);
        }
        ArrayList<Integer> out = new ArrayList<>(ans.size());
        for (int i = ans.size(); i > 0; i--) {
            out.add(i, ans.pop());
        }
        return out;
    }
    public static void main(String[] args) {
        Integer[] A = {17, 4, 12, 10, 5};
        ArrayList<Integer> array_list;

        day_22_DSA_Hashing_2 obj = new day_22_DSA_Hashing_2();

        array_list = new ArrayList<Integer>(obj.convertToArrayList(A));
        CodingMentorsolve(array_list);
    }
}
