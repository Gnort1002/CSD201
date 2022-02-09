
package Car;

import Queue.MyQueue;

public class BSTree {
    Car root;
    
    public BSTree() {       
    }
    
    boolean isEmpty() {
        return root == null;
    }
    
    void add(String owner, int value) {
        Car node = new Car(owner, value);
        if (isEmpty()) {
            root = node;
            return;
        }
        Car cu = root;
        Car father = null;
        while (cu != null) {
            if (cu.value == value) {
                return;
            }
            father = cu;
            if (cu.value < value) cu = cu.right;
            else if (cu.value > value) cu = cu.left;
        }
        assert(father != null);
        if (father.value > value) father.left = node;
        else father.right = node;
    }
    
    void visit(Car p) {
        System.out.print(p + " ");
    }
    
    void preOrder(Car p) {
        if (p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    
    void preOrder() {
        preOrder(root);
        System.out.println();
    }
    
    void postOrder(Car p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    
    void postOrder() {
        postOrder(root);
        System.out.println();
    }
    
    void inOrder(Car p) {
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
    
    void BreathFirstOrder(Car p) throws Exception {
        MyQueue queue = new MyQueue();
        if (isEmpty()) return;
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Car node = (Car)queue.deQueue();
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
    void insert(String xOwner, int xPrice) {
        if (xOwner.charAt(0) == 'B' || xPrice > 100) return;
        add(xOwner, xPrice);
    }
    
    void f1() {
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
    }
    
    // Cau 2   
    void preOrder2(Car p) {
        if (p == null) return;
        if (p.value >= 3 && p.value <= 5) visit(p);
        preOrder2(p.left);
        preOrder2(p.right);
    }
    
    void f2() {
        preOrder(root);
        System.out.println();
        preOrder2(root);
        System.out.println();
    }
    
    void deleteByCopyL(Car p) {
        if (p == null) return;
        if (p.left == null) return;
        if (p.left.right == null) {
            p.value = p.left.value;
            p.left = p.left.left;
        }
        else {
            Car father = p.left;
            while (father.right.right != null) father = father.right;
            p.value = father.right.value;
            p.owner = father.right.owner;
            if (father.right.left == null) {
                father.right = null;
            }
            else father.right = father.right.left;
        }
    }
    
    Car getParent(Car p) {
        if (p == root) return null;
        Car father = null, cu = root;
        while (cu != null && cu.value != p.value) {
            father = cu;
            if (cu.value < p.value) cu = cu.right;
            else cu = cu.left;
        }
        if (cu == null) return null;
        return father;
    }
    
    Car findNode(String s, int key) {
        Car cu = root;
        while (cu != null) {
            if (cu.value == key && s.equals(cu.owner)) return cu;
            cu = cu.value < key ? cu.right : cu.left;
        }
        return null;
    }
    
    void deleteByMerging(Car p) {
        Car father = getParent(p);
        if (father == null) {
            if (p.value != root.value) {
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
            Car q = root.left;
            while (q.right != null) {
                q = q.right;
            }
            q.right = p.right;
            root = p.left;
            return;
        }
        if (p.left == null) {
            if (p.value < father.value) father.left = p.right;
            else father.right = p.right;
            return;
        }
        Car q = p.left;
        while (q.right != null) q = q.right;
        q.right = p.right;
        if (p.value < father.value) father.left = p.left;
        else father.right = p.left;
    }
    
    Car findNodeWithTwoChildren(Car p) throws Exception {
        MyQueue queue = new MyQueue();
        if (isEmpty()) return null;
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Car node = (Car)queue.deQueue();
            if (node.left != null && node.right != null && node.value < 7) return node;
            else {
                if (node.left != null) queue.enQueue((node.left));
                if (node.right != null) queue.enQueue((node.right));
            }
        }
        return null;
    }
    
    Car findNodeWithLeftChild(Car p) throws Exception {
        MyQueue queue = new MyQueue();
        if (isEmpty()) return null;
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Car node = (Car)queue.deQueue();
            if (node.left != null) {
                if (node.value < 7) return node;
                else queue.enQueue((node.left));
            }
            if (node.right != null) queue.enQueue((node.right));
        }
        return null;
    }
    
    void f3() throws Exception {
        Car p = findNodeWithTwoChildren(root);
        BreathFirstOrder();
        System.out.println();
        deleteByCopyL(p);
        BreathFirstOrder();
    }
    
    void rotateRight(Car p) {
        if (p == null || p.left == null) return;
        Car c = p.left;
        p.left = c.right;
        c.right = p;
        Car father = getParent(p);
        if (father == null) root = c;
        else {
            if (father.value > p.value) father.left = c;
            else father.right = c;
        }
    }
    
    void rotateLeft(Car p) {
        if (p == null || p.left == null) return;
        Car c = p.right;
        p.right = c.left;
        c.left = p;
        Car father = getParent(p);
        if (father == null) root = c;
        else {
            if (father.value > p.value) father.left = c;
            else father.right = c;
        }
    }
    
    void f4() throws Exception {
        BreathFirstOrder();
        Car p = findNodeWithLeftChild(root);
        rotateRight(p);
        System.out.println();
        BreathFirstOrder();
    }
}
