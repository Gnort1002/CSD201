package Car;

import Queue.MyQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BSTree_Exercises {
    Node root;
    
    public BSTree_Exercises() {       
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    void insert(String id, int price){
        Car info = new Car(id, price);
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
        System.out.print(p.info.toString());
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
    void insertByCondition(String xOwner, int xPrice) {
        if (xOwner.charAt(0) == 'B' || xPrice > 20) return;
        insert(xOwner, xPrice);
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
                    String id = stk.nextToken().trim();
                    int price = Integer.parseInt(stk.nextToken().trim());
                    insertByCondition(id, price);
                }
            }
        }
        catch (Exception e){e.printStackTrace();}
        return true;      
    }
    void f1() throws Exception {
        readFromFile("src\\Car\\car.txt");
        BreathFirstOrder();
    }
    
    // Cau 2   
    void preOrderWriteToFile(PrintWriter pw, Node p) {
        //Writing product to file
        if (p == null) return;
        if (p.info.price >= 5 && p.info.price <= 9){ 
            pw.println(p.info.toString());
            System.out.print(p.info);
        }  
        postOrderWriteToFile(pw, p.left);
        postOrderWriteToFile(pw, p.right);         
    }

    void postOrderWriteToFile(PrintWriter pw, Node p) {
        //Writing product to file
        if (p == null) return;
        postOrderWriteToFile(pw, p.left);
        postOrderWriteToFile(pw, p.right); 
        if (p.info.price >= 5 && p.info.price <= 9){ 
            pw.print(p.info.toString());
            System.out.print(p.info);
        }  
    }
    
    void f2() {
        try{
            FileWriter fw = new FileWriter("src\\Car\\q2.out");
            PrintWriter pw = new PrintWriter(fw); //for writing lines
            //Writing product to file
            postOrderWriteToFile(pw, root);
            pw.close();
            fw.close();
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
            if (node.left != null && node.right != null &&  height(node) > 4){
                if (count == pos)
                    return node;
                else count++;
            }
            else {
                if (node.left != null) queue.enQueue((node.left));
                if (node.right != null) queue.enQueue((node.right));
            }
        }
        return null;
    }
    
    Node findNodeWithLeftChild(Node p) throws Exception {
        MyQueue queue = new MyQueue();
        if (isEmpty()) return null;
        queue.enQueue(p);
        while (!queue.isEmpty()) {
            Node node = (Node)queue.deQueue();
            if (node.left != null) {
                if (node.info.price < 7) return node;
                else queue.enQueue((node.left));
            }
            if (node.right != null) queue.enQueue((node.right));
        }
        return null;
    }
    
    void f3() throws Exception {
        Node p = findNodeWithTwoChildren(root, 2);
        String id = p.info.id;
        dele(id);
        BreathFirstOrder();
    }
    
    void rotateLeft(Node p) {
        if (p == null || p.right == null) return;
        Node c = p.right;
        p.right = c.left;
        c.left = p;
        Node parent = getParent(p);
        if (parent == null) root = c;
        else {
            if (parent.info.id.compareTo(p.info.id) > 0) parent.left = c;
            else parent.right = c;
        }
    }    
    
    void rotateRight(Node p){
        if (p == null || p.left == null) return;
        Node c = p.left;
        p.left = c.right;
        c.right = p;
        Node parent = getParent(p);
        if (parent == null) root = c;
        else {
            if (parent.info.id.compareTo(p.info.id) > 0) parent.left = c;
            else parent.right = c;
        }
    }
    
    void f4() throws Exception {
        if (root.right != null) rotateLeft(root);
        preOrder();
    }
}
    
