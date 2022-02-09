package DoublyLL;


public class MyDBList {
    private Node head, tail;
    private int size;

    public MyDBList() {
        head = tail = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void addFirst(int value) {
        Node n = new Node(value);
        if (isEmpty()) head = tail = n;
        else {
            head.pre = n;
            n.next = head;
            head = n;
        }
        ++size;
    }
    
    public void addLast(int value) {
        Node n = new Node(value);
        if (isEmpty()) head = tail = n;
        else {
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
        ++size;
    }
    
    // Add after the i-th index
    public void addIndex(int index, int value) {
        Node cur;
        Node n = new Node(value);
        if (index <= 0) {
            addFirst(value);
            return;
        }
        if (index >= size) {
            addLast(value);
            return;
        }
        if (index <= size/2) {
            cur = head;
            for (int i = 1; i < index; i++) {
                cur = cur.next;
            }
            n.next = cur.next;
            cur.next.pre = n;
            n.pre = cur;
            cur.next = n;            
        }
        else {
            cur = tail;
            for (int i = 1; i < size-index; i++) {
                cur = cur.pre;
            }
            n.next = cur;
            n.pre = cur.pre;
            cur.pre.next = n;
            cur.pre = n;
        }
        ++size;
    }
    
    public void deleteFirst() {
        if (isEmpty()) return;
        head = head.next;
        head.pre = null;
        --size;
    }
    
    public void deleteLast() {
        if (isEmpty()) return;
        tail = tail.pre;
        tail.next = null;
        --size;
    }
    
    // Delete the i-th index
    public void deleteIndex(int index) {
        Node cur;
        if (index <= 1) {
            deleteFirst();
            return;
        }
        if (index >= size) {
            deleteLast();
            return;
        }
        if (index <= size/2) {
            cur = head;
            for (int i = 1; i < index-1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            cur.next.pre = cur;
        }
        else {
            cur = tail;
            for (int i = 1; i < size-index; i++) {
                cur = cur.pre;
            }
            cur.pre = cur.pre.pre;
            cur.pre.next = cur;
        }
        --size;
    }
    
    public void display() {
        if (isEmpty()) return;
        Node cur = head;
        while (cur != null) {
            if (cur.next != null) System.out.print(cur + ", ");
            else System.out.println(cur);
            cur = cur.next;
        }
    }
}
