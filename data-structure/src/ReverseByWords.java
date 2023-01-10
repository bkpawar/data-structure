/*
Problem Description
You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
Example Input
Input 1:
    A = "the sky is blue"
Input 2:
    A = "this is ib"


Example Output
Output 1:
    "blue is sky the"
Output 2:
    "ib is this"

The optimal approach tries to swap the words of the string from the beginning and end,
using a two-pointers-based approach, to reverse the string in constant space. The algorithm is as follows:

Convert the string into an array of strings, which will store the words.
Initialize the 2 pointers left and right to 0 and string.length() – 1 respectively.
While the left pointer does not exceed the right pointer, swap the elements at the left and right pointer,
move the left pointer forward and the right pointer backward by 1 place.
Finally, return the final calculated string.

 */
public class ReverseByWords {
    public static String reverseByWords(String s) {
        String[] words = s.split("\\s");
        int left = 0, right = words.length - 1;
        while (left <= right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left += 1;
            right -= 1;
        }
        String ans = String.join(" ", words);
        return ans;
    }

    public static void main(String[] args) {
        String name = new String("My Name is Bhupendra");
        System.out.println(reverseByWords(name));
    }
}
