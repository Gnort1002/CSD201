
import Queue.MyQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MyTree {
    Node root;
    
    public MyTree() {       
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    void insert(String id, String name, double rating){
        Song info = new Song(id, name, rating);
        if (isEmpty()){
            root = new Node(info);
            return;
        }
        Node p = root;
        Node parent = null;
        while(p != null){
            if (p.info.equals(info)){
                System.out.println( info + " already in tree");
                return;
            }
            parent = p;
            if (p.info.id.compareTo(info.id) > 0) p = p.left;
            else p = p.right;
            
        }
        if (parent.info.id.compareTo(info.id) > 0) parent.left = new Node(info);
        else parent.right = new Node(info);
    }
    
    void visit(Node p) {
        System.out.println("("+p.info.toString()+")");
    }
    
    void preOrder(Node p) {
        if (p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void preOrder() {
        preOrder(root);
        System.out.println();
    }
    
    void postOrder(Node p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    void postOrder() {
        postOrder(root);
        System.out.println();
    }
    
    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    
    void inOrder() {
        inOrder(root);
    }
    
    void clear() {
        root = null;
    }
    
    void BreathFirstOrder(Node p) throws Exception {
        MyQueue queue = new MyQueue();
        if (isEmpty()) return;
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node node = (Node) queue.deQueue();
            if (node.left != null) queue.enQueue((node.left));
            if (node.right != null) queue.enQueue((node.right));
            visit(node);
        }
    }
    
    void BreathFirstOrder() throws Exception {
        BreathFirstOrder(root);
    } 
    
    
    // Bai tap 2.1        
    // Cau 1
    void insertByCondition(String id, String name, double rating) {
        if (name.contains("Paris") || rating < 3) return;
        insert(id, name, rating);
    }
    
    boolean readFromFile(String filename){
        File f = new File(filename);
        if(!f.exists()) return false;
        try{
            FileReader fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr); 
            String line;    
            while((line = bf.readLine())!=null){
                line = line.trim();
                if (line.length()>0){
                    StringTokenizer stk = new StringTokenizer(line, "|");
                    String id = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    double rating = Double.parseDouble(stk.nextToken().trim());
                    insertByCondition(id, name, rating);
                }
            }
        }
        catch (Exception e){e.printStackTrace();}
        return true;      
    }
    void f1() throws Exception {
        if(readFromFile("src\\song.txt")){
            System.out.println("Added from file song.txt succesfully");
        }
        else System.out.println("Failed to add");;
        
    }
    
    //Cau 2 
    int getLevelUtil(Node node, String id, int level)
    {
        if (node == null)
            return 0;
 
        if (node.info.id.equals(id))
            return level;
 
        int downlevel
            = getLevelUtil(node.left, id, level + 1);
        if (downlevel != 0)
            return downlevel;
 
        downlevel
            = getLevelUtil(node.right, id, level + 1);
        return downlevel;
    }
 
    /* Returns level of given data value */
    int getLevel(Node node, String id)
    {
        return getLevelUtil(node, id, 1);
    }
    
    void inOrderWriteToFile(PrintWriter pw, Node p) {
        //Writing product to file
        if (p == null) return;
        inOrderWriteToFile(pw, p.left);
        if (p.info.rating >= 4){ 
            pw.println("("+p.info + "," + getLevel(root, p.info.id) + ")");
        } 
        inOrderWriteToFile(pw, p.right); 
 
    }
    
    void f2() {
        try{
            FileWriter fw = new FileWriter("src\\q2.out");
            PrintWriter pw = new PrintWriter(fw); //for writing lines
            //Writing product to file
            inOrderWriteToFile(pw, root);
            pw.close();
            fw.close();
            System.out.println("Write to file q2.out successfully");
        }
        catch (Exception e){
            System.out.println(e);
            return;
        }  
    }
    
    void dele(String id){
        if (isEmpty()) return;
        Node p = root;
        Node parent = null;
        while(p!=null){
            if (p.info.id.equals(id)) break;
            if (p.info.id.compareTo(id) > 0) {parent = p; p = p.left;}
            else {parent = p; p = p.right;}
            
        }
        //p = null, tuc la khong co x trong cay
        if (p == null) return;
        // p chua gia tri x
        
        //TH1: p khong co con
        if (p.left == null && p.right == null){
            if (parent == null){
                root = null;
                return;
            }
            if (parent.left == p) parent.left = null;
            else parent.right = null;
        }
        //TH2: p co 1 con
        if (p.left != null && p.right == null){
            if (parent == null){
                root = p.left;
                return;
            }
            if (parent.left == p) parent.left = p.left;
            else parent.right = p.left;
        }
        if (p.right != null && p.left == null){
            if (parent == null){
                root = p.right;
                return;
            }
            if (parent.left == p) parent.left = p.right;
            else parent.right = p.right;            
        }     
        
       //TH3: p co 2 con
        if (p.left != null && p.right != null){
            deleByCopying(p);

        }
    }
    
    void deleByCopying(Node p) {
        Node rm = p.left;
        Node parentRM = null;
        while (rm.right != null){
            parentRM = rm;
            rm = rm.right;
        }
        p.info = rm.info;
        if (parentRM == null)
            p.left = rm.left;
        else
            parentRM.right = rm.left;
    }
    
    void delebyMerging(Node parent, Node p){
        if (parent == null) {
            if (p.info != root.info) {
                return;
            }
            //         15                  10
            //     10      30   -->     5     30
            //  5       20   40       4  7  20  40
            //4   7
            if (root.left.right == null) {
                root.left.right = root.right;
                root = root.left;
                return;
            }
            Node q = root.left;
            //Tim node phai nhat cua root.l
            while (q.right != null) {
                q = q.right;
            }
            //Noi p.r voi not phai nhat
            q.right = p.right;
            root = p.left;
            return;
        }
        Node q = p.left;
        while (q.right != null) q = q.right;
        q.right = p.right;
        if (p.info.id.compareTo( parent.info.id) < 0) parent.left = p.left;
        else parent.right = p.left;        
    }
    
    Node getParent(Node p) {
        if (p == root) return null;
        Node father = null, cu = root;
        while (cu != null && !cu.info.id.equals(p.info.id)) {
            father = cu;
            if (cu.info.id.compareTo(p.info.id) < 0) cu = cu.right;
            else cu = cu.left;
        }
        if (cu == null) return null;
        return father;
    }
    
    
    int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;
 
        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }   
    
    Node findNodeWithTwoChildren(Node p, int pos) throws Exception {
        int count = 0;
        MyQueue queue = new MyQueue();
        if (isEmpty()) return null;
        queue.enQueue(p);
        while (!queue.isEmpty()) {
            Node node = (Node)queue.deQueue();
            if (node.left != null && node.right != null &&  height(node) < 5){
                count++;
                if (count == pos)
                    return node;
            }
            else {
                if (node.left != null) queue.enQueue((node.left));
                if (node.right != null) queue.enQueue((node.right));
            }
        }
        return null;
    }
    
    void BFSWriteToFile(PrintWriter pw, Node p) throws Exception {
        //Writing product to file
        MyQueue queue = new MyQueue();
        if (isEmpty()) return;
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node node = (Node) queue.deQueue();
            if (node.left != null) queue.enQueue((node.left));
            if (node.right != null) queue.enQueue((node.right));
            pw.println("("+node.info+ ")");
        }
    } 
    
    void f3() throws Exception {  
        Node p = findNodeWithTwoChildren(root, 1);
        String id = p.info.id;
        dele(id);        
        try{
            FileWriter fw = new FileWriter("src\\q3.txt");
            PrintWriter pw = new PrintWriter(fw); //for writing lines
            //Writing product to file
            BFSWriteToFile(pw, root);
            pw.close();
            fw.close();
            System.out.println("Write to file q3.txt successfully");
        }
        catch (Exception e){
            System.out.println(e);
            return;
        }          
    }
    
    
        Song[] sortAccById(Song[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].id.compareTo(arr[j+1].id) > 0)
                {
                    // swap arr[j+1] and arr[j]
                    Song temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
        return arr;
    }
    int count(Node p) throws Exception{
        if (isEmpty()) return 0;
        if (p == null) return 0;
        return 1 + count(p.left) + count(p.right);
    } 
    
    int count() throws Exception{
        return count(root);
    }
    
    Song[] getArrayFromTree() throws Exception{
        Song[] arr = new Song[count()];
        MyQueue queue = new MyQueue();
        if (isEmpty()) return null;
        queue.enQueue(root);
        int i = 0;
        while (!queue.isEmpty()) {
            Node node = (Node)queue.deQueue();
            if (node.left != null) queue.enQueue((node.left));
            if (node.right != null) queue.enQueue((node.right));
            arr[i] = node.info;
            i++;
        }
        return sortAccById(arr);
    }
    
    void insertByInfo(Song info){
        if (isEmpty()){
            root = new Node(info);
            return;
        }
        Node p = root;
        Node parent = null;
        while(p != null){
            if (p.info.equals(info)){
                System.out.println( info + " already in tree");
                return;
            }
            parent = p;
            if (p.info.id.compareTo(info.id) > 0) p = p.left;
            else p = p.right;
            
        }
        if (parent.info.id.compareTo(info.id) > 0) parent.left = new Node(info);
        else parent.right = new Node(info);
    }   
    
    public void balance(Song[] arr, int first, int last) {
        if (first <= last){
            int middle = (first + last)/2;
            insertByInfo(arr[middle]);
            balance(arr,first,middle-1);
            balance(arr,middle+1,last);
        }
    }
    
    public void balance(Song arr[]){
        balance(arr,0,arr.length-1);
    }
    
    
    
}
