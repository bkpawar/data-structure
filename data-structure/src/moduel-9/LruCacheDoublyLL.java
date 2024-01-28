import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev, next;
    Node(int k, int v){
        key = k; value = v;
        prev = null; next = null;
    }
}
public class LruCacheDoublyLL {

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> hm = new HashMap<>();
    int cap = 0;

    public LruCacheDoublyLL(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }
    public void before_tail(Node nn) {
        Node t1 = tail.prev;
        tail.prev = nn;
        nn.prev = t1;
        t1.next = nn;
        nn.next = tail;
    }
    public void delete(Node t){
        Node t1 = t.prev;
        Node t2 = t.next;
        t1.next = t2;
        t2.prev = t1;
        t.next = null;
        t.prev = null;
    }
    public int get(int key) {
        if(hm.containsKey(key)){
            Node t = hm.get(key);
            delete(t);
            before_tail(t);
            return t.value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if(hm.containsKey(key)){
            Node tm = hm.get(key);
            delete(tm);
            before_tail(tm);
            tm.value = value;
        } else {
            if(hm.size()== cap){
                Node t = head.next;
                delete(t);
                hm.remove(t.key);
            }
            Node nn = new Node(key, value);
            before_tail(nn);
            hm.put(key, nn);
        }
    }

    public static void main(String[] args) {

    }
}
