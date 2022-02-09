public class MyCircularList {
    Node head;
    
    MyCircularList() {
        head=null;
    } 
    
    boolean isEmpty(){
        return(head==null);
    }
    void clear(){
        head=null;
    }
        
//    void addToHead(int x){
//        //tao notd chua du lieu x
//        Node p = new Node(x);
//        if (isEmpty()){
//            head = tail = p;
//        }
//        else{
//            link(p, head);
//            head = p;
//            link(tail, p);
//        }
//    }
    
    void traverse(){
        Node p = head;
        if (isEmpty()) {System.out.println("Empty list!"); return;}
        do
        {
            System.out.print(p.info + " -> ");
            p = p.next; 
        }
        while(p != head);
        
    }
    
//    void addToTail(int x){
//        Node p = new Node(x);
//        if (isEmpty()){
//            head = tail = p;
//        }
//        else{
//            tail.next = p;
//            p.pre = tail;
//            tail = p;
//            
//        }        
//    }
    //add a node with value x  after the node p.
    int addAfter(Node p, int x){
        Node newNode = new Node(x, null);
        if (isEmpty()) {head = newNode; newNode.next = head; return 0;}
        else{
            newNode.next = p.next;
            p.next = newNode;
        }
        return 0;
    }
    
//    void deleteFromHead(){
//        if (head == tail)
//            head = tail = null;
//        else
//            head.next.pre = null;
//            head = head.next;
//    }
    
//    void deleteFromTail(){
//        Node p = head;
//        if (head == tail)
//            head = tail = null;
//        else{
//            while (p.next != tail)
//                p=p.next;
//            tail.pre = null;
//            tail = p;
//            tail.next = null;
//        }   
//    }    
    int deleteAfter(Node p){
        if (isEmpty()) return 0;
        int result = p.next.info;
        p.next = p.next.next;
        return result;
    }
    //delele the first node whose info is equal to x.
    void deleBaseOnInfo(int info){
        if(isEmpty()) return;
        for (Node p = head; p!= null; p=p.next){
            if (p.next.info == info) deleteAfter(p);       
        }
    }
    //search and return the reference to the first node having info x.
    Node search(int info){
        Node p = head;
        while (p != null){
            if (p.info == info) break;
            p = p.next;
        }
        return p;
    }    
    
    
    int count(){
        if (isEmpty())
            return 0;
        int count = 0;
        Node p = head;
        do{
            p = p.next;
            count++;
        }
        while(p!=head);
        return count;
    }
    
    void deleBaseOnIndex(int i){
        Node p = head;
        int index = 1;
        if (isEmpty()) {System.out.println("Index does not exist!"); return;}
        do{
            p = p.next;
            index++;
            if ((index+1) == i) deleteAfter(p);       
        }
        while(p!=head);
    }
    //sort the list by ascending order of info.
    void sort(){
        Node i, j;
        int temp;
        for (i = head.next; i != head; i = i.next){
            for (j = head.next; j != head; j = j.next){
                if (j.info > j.next.info){
                    temp = j.info;
                    j.info = j.next.info;
                    j.next.info = temp;
                }                    
            }
        }        
    }
    
    void dele(Node p){
        if (isEmpty()) {System.out.println("Node does not exist!"); return;}
        Node h;
        h = head;
        do{
            h = h.next;
        }
        while(h.next != p && h != head);
        deleteAfter(h);       
    }
//  create and return array containing info of all nodes in the list.
    int [] toArray(){
        Node p;
        int index = 0;
        int[] arr = new int[count()];
        for (p = head.next; p!= head; p = p.next){
            arr[index] = p.info;
            index++;
        }
        return arr;
    }
//15. Merge two ordered singly linked lists of integers into one ordered list.
//  add a node with value x  before the node p.
    void addBefore(Node p, int x){
        if (isEmpty()) {System.out.println("Empty list!"); return;}
        Node h = head;
        if (p==head.next) deleteAfter(p);
        Node newNode = new Node(x, null);
        for (h=head.next; h.next != p && h != head; h = h.next){
            if (h==null) {System.out.println("Node does not exist!");return;}
        }
    }
//  Attach a singly linked list to the end of another singly linked list.
//    void attach(MyList list1, MyList list2){
//        if (list1.isEmpty()) {System.out.println("List 1 is empty!"); return;}
//        if (list2.isEmpty()) {System.out.println("List 2 is empty!"); return;}
//        link(list1.tail, list2.head);
//    }
//  find and return the maximum value in the list.        
    int max(){
        int max = head.info;
        for (Node p = head.next; p != head; p = p.next){
            if (max < p.info) max = p.info;
        }
        return max;
    } 
//  find and return the minimum value in the list.     
    int min(){
        int min = head.info;
        for (Node p = head.next; p != head; p = p.next){
            if (min > p.info) min = p.info;
        }
        return min;    
    }
//  return the sum of all values in the list.    
    int sum(){
        int sum = 0;
        for (Node p = head; p != head; p = p.next)
            sum += p.info;
        return sum;
    }
//  return the average of all values in the list.
    int avg(){
        int avg = sum() / count();        
        return avg;
    }

//  check and return true if the list is sorted, return false if the list is not sorted.
//    boolean sorted(){
//        Node p;
//        if (head.info <= head.next.info){
//            for (p = head.next; p.next != head; p = p.next){
//                if (p.info > p.next.info) return false;
//            }
//        }
//        else if(head.info > head.next.info){
//            for (p = head.next; p.next != head; p = p.next){
//                if (p.info < p.next.info) return false;
//            }            
//        }
//        return true;
//            
//    }
////  insert node with value x into sorted list so that the new list is sorted.
//    void insert(int x){
//        Node newNode = new Node(x, null);
//        if (isEmpty()) {System.out.println("Empty list!"); return;}
//        if (tail.info >= head.info){
//            for (Node p = head;  p != null; p = p.next) {
//                if (x <= p.info ) {addBefore(p, x); return;}
//                if (p.next == null) {addToTail(x); return;}
//            }
//        }
//        else{
//            for (Node p = head;  p != null; p = p.next) {
//                if (x >= p.info ) {addBefore(p, x); return;}
//                if (p.next == null) {addToTail(x); return;}
//            }            
//                
//        }
//    }
//    Reverse a singly linked list using only one pass through the list.
//    void reverse1(MyList list){
//        if (list.isEmpty()){System.out.println("Empty list!"); return;}
//        else{
//            MyList reversedList = new MyList();
//            for (Node p = list.head; p != null; p = p.next){
//                reversedList.addToHead(p.info);
//            }
//            list.clear();
//            for (Node p = reversedList.head; p != null; p = p.next){
//                list.addToHead(p.info);
//            }
//        }
//    }
//    void reverse2(){
//        Node newHead = tail;
//        Node newTail = head;
//        Node p;
//        if (isEmpty()){System.out.println("Empty list!"); return;}
//        for (p = head; p != tail; p = p.next){
//            addAfter(tail, p.info);
//            tail = newHead;
//            head = head.next;
//        }
//        tail = newTail;
//        head = newHead;
//        
//    }
//    Check whether two singly linked list have the same contents.
//    boolean SameContent(MyList list1, MyList list2){
//        Node p1 = list1.head, p2 = list2.head;
//        if (p1.info != p2.info) return false;
//        for (p1 = list1.head.next; p1 != null; p1 = p1.next){
//            p2 = p2.next;
//            if (p2.info != p1.info) return false;
//        }
//        if (p2.next != null) return false;
//        return true;
//    }
}    
