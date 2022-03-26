
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
                    if (name.endsWith("y")) continue;
                    String artist = stk.nextToken().trim();
                    int rated = Integer.parseInt(stk.nextToken().trim());
                    if (rated <= 1) continue;
                    Song p = new Song(name, artist, rated);
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
            for (Node p = head; p != null; p = p.next) pw.println(p.info.name + "|" + p.info.artist + "|" + p.info.rated);
            pw.close();
            fw.close();
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    void addToHead(Song s){
        Node p = new Node(s);
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
    
    void addToTail(Song s){
        Node p = new Node(s);
        if (isEmpty()){
            head = tail = p;
        }
        else{
            tail.next = p;
            tail = p;
        }        
    }
    //add a node with value x  after the node p.
    int addAfter(Node p, Song s){
        Node add = new Node(s);
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
        Song temp;
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
    
//    void sortByAge(){
//        Node i, j;
//        Song temp;
//        for (i = head; i != tail; i = i.next){
//            for (j = head; j != tail; j = j.next){
//                if (j.info.age > j.next.info.age){
//                    temp = j.info;
//                    j.info = j.next.info;
//                    j.next.info = temp;
//                }                    
//            }
//        }        
//    }
    
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
    Song [] toArray(){
        Node p;
        int index = 0;
        Song [] arr = new Song[count()];
        for (p = head; p!= null; p = p.next){
            arr[index] = p.info;
            index++;
        }
        return arr;
    }
    
    void addBefore(Node p, Song x){
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

    double average(){
        int sum = 0;
        for(Node p = head; p!= null; p = p.next){
            sum += p.info.rated;
        }
        return sum / count();
    }
    
    int findThird(){
        int first = head.info.rated;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        for (Node p = head.next; p != null; p = p.next){
            int cur = p.info.rated;
            if (cur > first){
                third = second;
                second = first;
                first = cur;
            }
            else if (cur > second){
                third = second;
                second = cur;
            }
            else if (cur > third){
                third = cur;
            }
        }
        return third;
    }
    
    void deleteThird(){
        for(Node p = head; p!=null; p = p.next){
            if (p.info.rated == findThird()){
                dele(p);
            }
        }
    }

    MyList getSet(){
        boolean inSet;
        MyList newSet = new MyList();
        for (Node p = head; p != null; p = p.next){
            inSet = false;
            if (newSet.isEmpty()) {newSet.addToHead(p.info); continue;}
            for (Node h = newSet.tail; h != null; h = h.next){
                if (h.info.name.equals(p.info.name)) inSet = true;
            }
            if (!inSet) newSet.addToTail(p.info);
        }
        return newSet;
    }
    
    void removeDuplicatedSong(){
        MyList mySet = getSet();
        int[] arr = new int[mySet.count()];
        int i = 0;
        for (Node p = mySet.head; p != mySet.tail; p = p.next){
            int max = Integer.MIN_VALUE;
            for (Node h = head; h != tail; h = h.next){
                if (h.info.name.equals(p.info.name) && h.info.rated > max)
                    max = h.info.rated;
            }
            arr[i] = max;
            i++;
        }
        i = 0;
        for(Node p = mySet.head; p != mySet.tail; p = p.next){
            if (p == null) break;
            for (Node h = head; h != tail; h = h.next){
                if (h == null || p == null || i == mySet.count()) break;
                else if (h.info.name.equals(p.info.name) && h.info.rated < arr[i])
                    dele(h);
            i++;
//            if (i == mySet.count()) break;            
            }
        }
    }

}
    

