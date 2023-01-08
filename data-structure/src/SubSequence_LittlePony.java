/*
Little Ponny has been given a string A, and he wants to find out the lexicographically minimum
subsequence from it of size >= 2. Can you help him?

A string a is lexicographically smaller than string b, if the first different letter in
a and b is smaller in a. For example, "abc" is lexicographically smaller than "acc" because
the first different letter is 'b' and 'c' which is smaller in "abc".

 */
public class SubSequence_LittlePony {

    public static String SubSequence_LittlePony(String A) {
        char minchar = 'z';
        int idx = Integer.MAX_VALUE; //1000000000;
        for(int i = 0; i < A.length() - 1; i++){
            if(A.charAt(i) < minchar) {
                minchar = A.charAt(i);  //scsecugqsb, idx will be 0 here
                idx = i;
            }
        }
        System.out.println("idx = "+idx);
        char minChar2 = 'z';
        for(int i = idx+1; i<A.length(); i++){
            if (A.charAt(i)<minChar2) {
                minChar2 = A.charAt(i);
            }
        }
        String ans = String.valueOf(minchar) + String.valueOf(minChar2);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(SubSequence_LittlePony("scsecugqsb"));
    }
}