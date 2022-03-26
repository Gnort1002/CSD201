package Car;

import Queue.MyQueue;

public class BSTree {
    Node root;

    public BSTree() {
        this.root = null;
    }
    
    boolean isEmpty(){
        return root == null;
    }
    
    void clear(){
        root = null;
    }

    Node search(String id){
        if (isEmpty()) return null;
        Node p = root;
        while(p != null){
            if (p.info.id.equals(id)) break;
            else{
                if (p.info.id.compareTo(id) > 0 ) p = p.left;
                else p = p.right;
            }
        }
        return p;
    }
    
    void insertByInfo(Car info){
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
        if (p.info.id.compareTo(info.id) > 0) parent.left = new Node(info);
        else parent.right = new Node(info);
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
    
    void preOrder(){
        preOrder(root);
        System.out.println("");
    }
    
    void preOrder(Node p){
        if (p == null) return;
        System.out.print(p.info + " ");
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void postOrder(Node p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        System.out.print(p.info + " ");        
    }
    
    void postOrder() {
        postOrder(root);
        System.out.println();
    }
    
    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        System.out.print(p.info + " ");        
        inOrder(p.right);
    }
    
    void BreathFirstOrder(Node p) throws Exception {
        MyQueue queue = new MyQueue();
        if (isEmpty()) return;
        queue.enQueue(p);
        while (!queue.isEmpty()) {
            Node node = (Node)queue.deQueue();
            if (node.left != null) queue.enQueue((node.left));
            if (node.right != null) queue.enQueue((node.right));
            System.out.print(node.info + " ");
        }
    }
    
    void BreathFirstOrder() throws Exception {
        BreathFirstOrder(root);
        System.out.println("");
    }
    
    void inOrder() {
        inOrder(root);
        System.out.println();
    }    
    
    int count(Node p) throws Exception{
        if (isEmpty()) return 0;
        if (p == null) return 0;
        return 1 + count(p.left) + count(p.right);
    } 
    
    int count() throws Exception{
        return count(root);
    }
    
    
    void deleteByCopyL(Node p) {
        if (p == null) return;
        if (p.left == null) return;
        if (p.left.right == null) {
            p.info = p.left.info;
            p.left = p.left.left;
        }
        else {
            Node father = p.left;
            while (father.right.right != null) father = father.right;
            p.info = father.right.info;
            
            if (father.right.left == null) {
                father.right = null;
            }
            else father.right = father.right.left;
        }
    }
    
    void deleteByCopy(Node x) {
        Node parent, p;
        parent = null;
        p = root;
        while (p != null) {
            if (p.info == x.info) break;
            parent = p;
            if (x.info.id.compareTo(p.info.id) < 0 ) p = p.left; else p = p.right;
            // x.value can be replaced to x.info.value. The same to p.value
        }
        if (p == null) return; // not found
        // p is a leaf node
        if (p.left == null && p.right == null) {
            if (parent == null) { // p==root
              root = null;
              return;
            }
            if (p == parent.left) parent.left = null;
            else parent.right = null;
        }
        // p has left son only
        if (p.left != null && p.right == null) {
            if (parent == null) { // p==root
              root = p.left;
              return;
            }
            if (p == parent.left) parent.left = p.left;
            else parent.right = p.left;
        }
        // p has right son only
        if (p.left == null && p.right != null) {
            if (parent == null) { // p==root
              root = p.right;
              return;
            }
            if (p == parent.left) parent.left = p.right;
            else parent.right = p.right;
        }
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            Node q = p.left;
            // find the right-most node in the left sub-tree
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
              frp = rp;
              rp = rp.right;
            }
            p.info = rp.info;
            // Can be replaced to p.info = rp.info
            if (frp == null) p.left = q.left;
            else frp.right = rp.left;
        }
    }    
    
    void deleteByMerging(Node p) {
        Node father = getParent(p);
        if (father == null) {
            if (p.info != root.info) {
                return;
            }
            if (root.left == null) {
                root = root.right;
                return;
            }
            if (root.left.right == null) {
                root.left.right = root.right;
                root = root.left;
                return;
            }
            Node q = root.left;
            while (q.right != null) {
                q = q.right;
            }
            q.right = p.right;
            root = p.left;
            return;
        }
        if (p.left == null) {
            if (p.info.id.compareTo(father.info.id) < 0) father.left = p.right;
            else father.right = p.right;
            return;
        }
        Node q = p.left;
        while (q.right != null) q = q.right;
        q.right = p.right;
        if (p.info.id.compareTo(father.info.id) < 0) father.left = p.left;
        else father.right = p.left;
    }    

    Node getParent(Node p) {
        if (p == root) return null;
        Node parent = null, cu = root;
        while (cu != null && cu.info != p.info) {
            parent = cu;
            if (cu.info.id.compareTo( p.info.id) < 0) cu = cu.right;
            else cu = cu.left;
        }
        if (cu == null) return null;
        return parent;
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
    
    boolean isBalanced(Node node)
    {
        int lh; /* for height of left subtree */
 
        int rh; /* for height of right subtree */

        if (node == null)
            return true;
 
        /* Get the height of left and right sub trees */
        lh = height(node.left);
        rh = height(node.right);
 
        if (Math.abs(lh - rh) <= 1
            && isBalanced(node.left)
            && isBalanced(node.right))
            return true;
 
        /* If we reach here then tree is not height-balanced */
        return false;
    }    
    
//    void insertFromArray(int[] arr){
//        for (int i = 0; i < arr.length; i++) {
//            insert(arr[i]);            
//        }
//    }
    
    int sum(Node p) throws Exception{
        int sum = 0;
        MyQueue queue = new MyQueue();
        if (isEmpty()) return 0;
        queue.enQueue(p);
        while (!queue.isEmpty()) {
            Node node = (Node)queue.deQueue();
            if (node.left != null) queue.enQueue((node.left));
            if (node.right != null) queue.enQueue((node.right));
            sum+=node.info.price;
        }
        return sum;        
    }
    
    int sum() throws Exception{
        if (isEmpty()) return 0;
        return sum(root);
    }
    
//    Node max(Node p) throws Exception{
//        Node max = p;
//        MyQueue queue = new MyQueue();
//        if (isEmpty()) return null;
//        queue.enQueue(p);
//        while (!queue.isEmpty()) {
//            Node node = (Node)queue.deQueue();
//            if (node.left != null) queue.enQueue((node.left));
//            if (node.right != null) queue.enQueue((node.right));
//            if (max.info < node.info) max = node;
//        }
//        return max;        
//    }
    
//    Node max() throws Exception{
//        if (isEmpty()) return null;
//        return max(root);
//    }
    
    Node max2(Node p) throws Exception{
        if (p.right == null) {
            return p;
        }
        return max2(p.left);
    }
    
//    Node min(Node p) throws Exception{
//        Node min = p;
//        MyQueue queue = new MyQueue();
//        if (isEmpty()) return null;
//        queue.enQueue(p);
//        while (!queue.isEmpty()) {
//            Node node = (Node)queue.deQueue();
//            if (node.left != null) queue.enQueue((node.left));
//            if (node.right != null) queue.enQueue((node.right));
//            if (min.info > node.info) min = node;
//        }
//        return min;        
//    }
//    
//    Node min() throws Exception{
//        if (isEmpty()) return null;
//        return min(root);
//    }  
    
    Node min2(Node p) throws Exception{
        if (p.left == null) {
            return p;
        }
        return min2(p.left);
    }
    
    Node min2() throws Exception{
        return min2(root);
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
    Car[] sortAccByValue(Car[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].price > arr[j+1].price)
                {
                    // swap arr[j+1] and arr[j]
                    Car temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        return arr;
    }
    
        Car[] sortAccById(Car[] arr){
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].id.compareTo(arr[j+1].id) > 0)
                {
                    // swap arr[j+1] and arr[j]
                    Car temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]= temp;
                }
        return arr;
    }
    
    Car[] getArrayFromTree() throws Exception{
        Car[] arr = new Car[count()];
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
        return sortAccByValue(arr);
    }
    
    public void balance(Car[] arr, int first, int last) {
        if (first <= last){
            int middle = (first + last)/2;
            insertByInfo(arr[middle]);
            balance(arr,first,middle-1);
            balance(arr,middle+1,last);
        }
    }
    
    public void balance(Car arr[]){
        balance(arr,0,arr.length-1);
    }
    
//    int findMaxSumPath(Node p){
//        if (isEmpty()) return 0;
//        if (p==null) return 0;
//        if (p.left == null && p.right == null) return p.info;
//        return p.info + Math.max(findMaxSumPath(p.left), findMaxSumPath(p.right));
//    }
//    
//    int findMaxSumPath(){
//        return findMaxSumPath(root);
//    }
    //Tim gia tri x
    //xoa node do bang cach thiet lap lai mqh voi parent cua no
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
            //delete by Copying
            //deleByCopying(p);
            //delete by Merging
            delebyMerging(getParent(p),p);
        }
    }
    // tim node phai nhat cua cay con trai
    //gan gia tri cua node phai nhat do vao p
    //xoa node phai nhat do
    //           p
    //   p.L           p.R
    //      r
    //       r
    //        .......
    //          parentRM
    //            RM   <- node phai nhat
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
        if (p.info.id.compareTo(parent.info.id) < 0) parent.left = p.left;
        else parent.right = p.left;        
    }      
}
