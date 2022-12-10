/*
Problem Description
You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
 */
public class ReversetStringbyWord {
    public static String solve(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder buf = new StringBuilder();

        for(int i = s.length()-1; i>=0; i--)
        {
            char c = s.charAt(i);
            if(c!=' ') buf.append(c);
            else create(res, buf);
        }

        create(res, buf);
        return res.toString();
    }

    private static void create(StringBuilder res, StringBuilder buf)
    {
        int i = buf.length()-1;

        while(i>=0){
            if(i==buf.length()-1 && res.length()>0) res.append(' ');
            res.append(buf.charAt(i));
            i--;
        }
        buf.setLength(0);
    }
    public static void main(String[] args) {
        String hi = "scaler is good";
        System.out.println(solve(hi));
    }
}
