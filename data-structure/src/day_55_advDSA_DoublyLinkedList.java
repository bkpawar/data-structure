public class day_55_advDSA_DoublyLinkedList {
    /**
     * Problem1: Check if given linked list is palindrome
     * <p>
     *     solution1: Reverse the entire linked list and compare with original
     *     This has Sc: O(N)
     * </p>
     * <p>
     *     solution2: 1. Find the middle element then O(N)
     *     2. reverse the second half, do this in place O(N)
     *     3. compare first half with second half, they shall match. O(N)
     *     Tc: O(N), Sc: O(1)
     * </p>
     */
    /**
     * Problem2: find the length of longest odd length palindromic list
     * in the given linked list.
     * <p>
     *     solution1: for every sublist, check if it is palindromic
     *     Tc: O(N2) * O(N) -> O(N3)
     * </p>
     * <p>
     *     solution2: Assume each element is middle of a palindrome linked list. Find length of
     *     palindrome and find max length.
     * </p>
     */
}
