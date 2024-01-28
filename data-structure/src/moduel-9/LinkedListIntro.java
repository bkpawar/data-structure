class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) {
          val = x; next = null;
      }
 }
class LinkedListIntro {
    /**
     * Merge two sorted linked lists, A and B, and return it as a new list.
     * The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
     * @param A
     * @param B
     * @return
     */
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(-1);
        ListNode dtail = head;

        while(A!= null && B != null) {
            if(A.val < B.val) {
                dtail.next = A;
                A = A.next;
                dtail = dtail.next;
            } else {
                dtail.next = B;
                B = B.next;
                dtail = dtail.next;
            }
            if (A!=null) {
                dtail.next = A;
            }
            if (B!=null){
                dtail.next = B;
            }
        }
        return head.next;

    }
    /**
     * You are given a singly linked list having head node A.
     * You have to reverse the linked list and return the head node of that reversed list.
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head; // If the list is empty or has only one node, that node is the middle
        }

        ListNode slow = head;
        ListNode fast = head.next;

        // Move 'fast' two steps and 'slow' one step at a time
        // Since there are only two elements, 'slow' will end up at the middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode reverseList(ListNode A) {
        ListNode curr = A;
        ListNode prev = null;

        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    public static int areEqual(ListNode p1, ListNode p2) {
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return 0;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return 1;
    }

    /**
     * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0,
     * denoting if it's a palindrome or not, respectively.
     *
     * @param A
     */
    public static int isPalindormLinkedList(ListNode A) {
        // find middle of linked list to divide into two halfs
        // reverse the second half
        // check if first half is equal to second half
        ListNode T1 = A;
        ListNode middle = middleNode(T1);
        ListNode reverSe = reverseList(middle);

        int ret = areEqual(T1, reverSe);
        return ret;
    }

    public static void main(String[] args) {
        ListNode A1 = new ListNode(1);
        ListNode A2 = new ListNode(1);
        //ListNode A3 = new ListNode(1);
        A1.next = A2;
        //A2.next = A3;
        System.out.println(isPalindormLinkedList(A1));
    }
}
