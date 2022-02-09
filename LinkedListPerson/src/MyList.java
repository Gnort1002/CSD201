import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MyList{
    Node head,tail;
    MyList(){
        head=tail=null;
    } 
    
    boolean isEmpty(){
        return(head==null);
    }
    void clear(){
        head=tail=null;
    }
    
    boolean readFromFile(String filename){
        File f = new File(filename);
        if(!f.exists()) return false;
        try{
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr); 
            String line;    
            while((line = bf.readLine())!=null){
                //Process this line, format: Name | age)
                line = line.trim();
                if (line.length()>0){
                    StringTokenizer stk = new StringTokenizer(line, "|");
                    String name = stk.nextToken().trim();
                    int age = Integer.parseInt(stk.nextToken().trim());
                    Person p = new Person(name, age);
                    Node newNode = new Node(p);
                    if (isEmpty()){
                        addToHead(p);
                    }
                    else{
                        tail.next = newNode;
                        tail = newNode;
                    }
                }
            }
        }
        catch (Exception e){e.printStackTrace();}
        return true;        
    }
    
    boolean writeToFile(String filename){
        try{
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw); //for writing lines
            //Writing product to file
            for (Node p = head; p != null; p = p.next) pw.println(p.info.name + " | " + p.info.age);
            pw.close();
            fw.close();
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    void addToHead(Person person){
        //tao notd chua du lieu x
        Node p = new Node(person);
        if (isEmpty()){
            head = tail = p;
        }
        else{
            p.next = head;
            head = p;
        }
    }
    
    void traverse(){
        Node p = head;
        while (p.next != null)
        {
            System.out.print(p.info + " -> ");
            p = p.next; 
        }
        System.out.println(p.info);
    }
    
    void addToTail(Person person){
        Node p = new Node(person);
        if (isEmpty()){
            head = tail = p;
        }
        else{
            tail.next = p;
            tail = p;
        }        
    }
    //add a node with value x  after the node p.
    int addAfter(Node p, Person person){
        Node add = new Node(person);
        if (p==null) return 0;
        if (isEmpty()) System.out.println("List is empty!");
        add.next = p.next;
        p.next = add;
        if (p == tail) tail = add;
        return 0;
    }
    
    void deleteFromHead(){
        if (head == tail)
            head = tail = null;
        else
            head = head.next;
    }
    
    void deleteFromTail(){
        Node p = head;
        if (head == tail)
            head = tail = null;
        else{
            while (p.next != tail)
                p=p.next;
            tail = p;
            tail.next = null;
        }   
    }    
    void deleteAfter(Node p){
        
        if (p == tail){ System.out.println("Can not delete!"); return;}
        String result = p.next.info.toString();
        if (p.next == tail) tail = p;
        p.next = p.next.next;
        System.out.println(result);
    }
    //delele the first node whose info is equal to x.
    void deleBaseOnName(String name){
        if (search(name) == null) return;
        dele(search(name));
        
    }
    //search and return the reference to the first node having info x.
    Node search(String name){
        Node p = head;
        while (p != null){
            if (p.info.name.equals(name)) break;
            p = p.next;
        }
        return p;
    }    
    
    
    int count(){
        if (isEmpty())
            return 0;
        int count = 0;
        Node p = head;
        while(p != null){
            p = p.next;
            count++;
        }
        return count;
    }
    
    void deleBaseOnIndex(int i){
        Node p = head;
        int index = 1;
        if (isEmpty()) {System.out.println("Index does not exist!"); return;}
        if (i == 1) deleteFromHead();
        else{
            while(p != null){
                p = p.next;
                index++;
                if (index == i) dele(p);       
            }
        }
    }
    //sort the list by ascending order of info.
    void sortByName(){
        Node i, j;
        Person temp;
        for (i = head; i != tail; i = i.next){
            for (j = head; j != tail; j = j.next){
                if (j.info.name.compareTo(j.next.info.name) > 0){
                    temp = j.info;
                    j.info = j.next.info;
                    j.next.info = temp;
                }                    
            }
        }        
    }
    
    void sortByAge(){
        Node i, j;
        Person temp;
        for (i = head; i != tail; i = i.next){
            for (j = head; j != tail; j = j.next){
                if (j.info.age > j.next.info.age){
                    temp = j.info;
                    j.info = j.next.info;
                    j.next.info = temp;
                }                    
            }
        }        
    }
    
    void dele(Node p){
        if (isEmpty()) System.out.println("Node does not exist!");
        Node h;
        if (head == p ) deleteFromHead();
        else if (p == tail) deleteFromTail();
        else{
            h = head;
            while (h.next != p && h != null){
                h = h.next;
            }
            deleteAfter(h);
        }
            
    }
//  create and return array containing info of all nodes in the list.
    Person [] toArray(){
        Node p;
        int index = 0;
        Person[] arr = new Person[count()];
        for (p = head; p!= null; p = p.next){
            arr[index] = p.info;
            index++;
        }
        return arr;
    }
    
//    MyList mergeLists(MyList list1, MyList list2){
//        MyList newList = new MyList();
//        if (list1.head.info >= list1.tail.info){
//            while(!list1.isEmpty() || !list2.isEmpty()){
//                if (list1.head.info >= list2.head.info){
//                    newList.addToTail(list1.head.info);
//                    list1.deleteFromHead();
//                }
//                else{
//                    newList.addToTail(list2.head.info);
//                    list2.deleteFromHead();
//                }
//            }
//            if(!list1.isEmpty()){
//                for (Node p = list1.head; p!= null; p = p.next){
//                    newList.addToTail(p.info);
//                }
//                list1.clear();
//            }
//            else if (!list2.isEmpty()){
//                for (Node p = list1.head; p!= null; p = p.next){
//                    newList.addToTail(p.info);
//                }
//                list2.clear();
//            }                          
//        }
//        else{
//            while(!list1.isEmpty() || !list2.isEmpty()){
//                if (list1.head.info <= list2.head.info){
//                    newList.addToTail(list1.head.info);
//                    list1.deleteFromHead();
//                }
//                else{
//                    newList.addToTail(list2.head.info);
//                    list2.deleteFromHead();
//                }
//            }
//            if(!list1.isEmpty()){
//                for (Node p = list1.head; p!= null; p = p.next){
//                    newList.addToTail(p.info);
//                }
//                list1.clear();
//            }
//            else if (!list2.isEmpty()){
//                for (Node p = list1.head; p!= null; p = p.next){
//                    newList.addToTail(p.info);
//                }
//                list2.clear();
//            }                          
//        }
//        return newList;
//    }
//  add a node with value x  before the node p.
    void addBefore(Node p, Person x){
        if (p==null) return;
        if (isEmpty()) {System.out.println("Empty list!"); return;}
        if (p==head) {addToHead(x); return;}
        Node h;
        Node newNode = new Node(x);
        for (h=head; h.next != p && h != null; h = h.next){
            if (h==null) {System.out.println("Node does not exist!");return;}
        }
        newNode.next = p;
        h.next = newNode;
    }
//  Attach a singly linked list to the end of another singly linked list.
    void attach(MyList list1, MyList list2){
        if (list1.isEmpty()) {System.out.println("List 1 is empty!"); return;}
        if (list2.isEmpty()) {System.out.println("List 2 is empty!"); return;}
        list1.tail.next = list2.head;
    }
//  find and return the maximum value in the list.        
//    int max(){
//        int max = head.info;
//        for (Node p = head.next; p != tail; p = p.next){
//            if (max < p.info) max = p.info;
//        }
//        return max;
//    } 
////  find and return the minimum value in the list.     
//    int min(){
//        int min = head.info;
//        for (Node p = head.next; p != tail; p = p.next){
//            if (min > p.info) min = p.info;
//        }
//        return min;    
//    }
////  return the sum of all values in the list.    
//    int sum(){
//        int sum = 0;
//        for (Node p = head; p != tail; p = p.next)
//            sum += p.info;
//        return sum;
//    }
//  return the average of all values in the list.
//    int avg(){
//        int avg = sum() / count();        
//        return avg;
//    }

//  check and return true if the list is sorted, return false if the list is not sorted.
//    boolean sorted(){
//        Node p;
//        if (head.info <= head.next.info){
//            for (p = head; p.next != tail; p = p.next){
//                if (p.info > p.next.info) return false;
//            }
//        }
//        else if(head.info > head.next.info){
//            for (p = head; p.next != tail; p = p.next){
//                if (p.info < p.next.info) return false;
//            }            
//        }
//        return true;
//            
//    }
//  insert node with value x into sorted list so that the new list is sorted.
//    void insert(Person x){
//        Node newNode = new Node(x);
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
////    Check whether two singly linked list have the same contents.
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
