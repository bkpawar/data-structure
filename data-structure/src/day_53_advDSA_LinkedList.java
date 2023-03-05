/**
 * Array is stored in contiguous memory that why accessing time is constant O(1).
 * Can not store the Array size which is available contiguous at that time.
 *
 * Data structure for linked list shown in class Node.
 */
class Node {
    int data;
    Node next;

    Node(int x) {
        this.data = x; //data
        this.next = null; // pointer to store the address of next node
    }

}
class LinkedList {
    Node head;
    int position;

    /**
     * return the Node address if data is available in Linked List.
     *
     * @param data
     * @return
     */
    public boolean IsDataInLinkedList(int data) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == data)
                return true;
            temp = temp.next;
        }
        return false;
    }

    void InsertNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {  // go to end of linked list
                current = current.next;
            }
            // insert the element at last
            current.next = newNode;
        }
    }

    public void printList(Node head) {
        Node current = head;
        while (current.next != null) {  // go to end of linked list
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(current.data);
    }

    /**
     * Problem: You are given a singly linked list having head node A.
     * You have to reverse the linked list and return the head node of that reversed list.
     * Input 1: A = 1 -> 2 -> 3 -> 4 -> 5 -> NULL
     * Output 1: 5 -> 4 -> 3 -> 2 -> 1 -> NULL
     * <p>
     * Use three pointer approach. prev, current and next.
     * </p>
     *
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        Node prev = null; // make first node.next to null
        Node curr = head;
        while (curr.next != null) {
            Node next = curr.next; // store next node
            curr.next = prev; // reverse the current node next
            prev = curr; // update the previous
            curr = next; // update the current

        }
        curr.next = prev; // end node
        return curr; // return the head
    }

    public void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        Node newNode = new Node(value);
        if (head == null || position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            int cnt = 2;
            Node curr = head;
            while (cnt < position && curr.next != null) {
                curr = curr.next;
                cnt++;
            }
            if (cnt == position) {
                newNode.next = curr.next;
                curr.next = newNode;
            }
        }
    }

    public void delete_node(int position) {
        // @params position, integer
        if (position == 1) {
            head = head.next;
        } else {
            int cnt = 2;
            Node curr = head;
            while (cnt < position && curr.next != null) {
                curr = curr.next;
                cnt++;
            }
            if (cnt == position) {
                if (curr.next != null )
                    curr.next = curr.next.next;
            }
        }
    }
}
public class day_53_advDSA_LinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        //System.out.println(list.IsDataInLinkedList(1));
        list.InsertNode(1);
        list.InsertNode(2);
        list.InsertNode(3);
        list.InsertNode(4);
        list.InsertNode(5);
        list.printList(list.head);
        System.out.println(list.IsDataInLinkedList(1));
        //Node head = list.reverseList(list.head);
        list.insert_node(6, 6);
        list.printList(list.head);
        list.delete_node(6);
        list.printList(list.head);

    }
}
