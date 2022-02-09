/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree {

  Node root;

  BSTree() {
    root = null;
  }

  boolean isEmpty() {
    return (root == null);
  }

  void clear() {
    root = null;
  }

  void visit(Node p) {
    System.out.print("p.info: ");
    if (p != null) {
      System.out.println(p.info + " ");
    }
  }

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if (p != null) {
      f.writeBytes(p.info + " ");
    }
  }

  void breadth(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      fvisit(r, f);
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }
  }

  void preOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    fvisit(p, f);
    preOrder(p.left, f);
    preOrder(p.right, f);
  }

  void inOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    inOrder(p.left, f);
    fvisit(p, f);
    inOrder(p.right, f);
  }

  void postOrder(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    postOrder(p.left, f);
    postOrder(p.right, f);
    fvisit(p, f);
  }

  void loadData(int k) { //do not edit this function
    String[] a = Lib.readLineToStrArray("data.txt", k);
    int[] b = Lib.readLineToIntArray("data.txt", k + 1);
    int[] c = Lib.readLineToIntArray("data.txt", k + 2);
    int n = a.length;
    for (int i = 0; i < n; i++) {
      insert(a[i], b[i], c[i]);
    }
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  //===========================================================================
  void insert(String xPlace, int xDepth, int xType) {
    //You should insert here statements to complete this function
    Node node = new Node(new Castor(xPlace, xDepth, xType));
    if (isEmpty()) {
      root = node;
      return;
    }

    Node cur = root;
    Node father = null;

    while (cur != null) {
      if (cur.info.depth == node.info.depth) {
        return;
      }

      father = cur;
      if (cur.info.depth < node.info.depth) {
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }
    if (father.info.depth < node.info.depth) {
      father.right = node;
    } else {
      father.left = node;
    }
  }

  //Do not edit this function. Your task is to complete insert function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    inOrder(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  void postOrder2(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    postOrder2(p.left, f);
    postOrder2(p.right, f);
    if (p.info.type < 7) {
      fvisit(p, f);
    }
  }

  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    postOrder(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    postOrder2(root, f);
    //------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  Node findNode(int key) { // tim node bat ky de xoa
    Node cur = root;

    while (cur != null) {
      if (cur.info.depth == key) {
        return cur;
      }
      cur = cur.info.depth < key ? cur.right : cur.left;
    }

    return null;
  }

  public void deleteByCopy(int x) {
    Node p = findNode(x);
    if (p == null) {
      return;
    }
    //find f is father of p
    Node f = null, q = root;
    while (q != p) {
      f = q;
      if (q.info.depth > p.info.depth) {
        q = q.left;
      } else {
        q = q.right;
      }
    }
    //1.p has no child
    if (p.left == null && p.right == null) {
      if (f == null) {
        root = null;
      } else if (f.left == p) {
        f.left = null;
      } else {
        f.right = null;
      }
    } //2.p has left child only
    else if (p.left != null && p.right == null) {
      if (f == null) {
        root = p.left;
      } else if (f.left == p) {
        f.left = p.left;
      } else {
        f.right = p.left;
      }
    } //3.p has right child only
    else if (p.left == null && p.right != null) {
      if (f == null) {
        root = p.right;
      } else if (f.left == p) {
        f.left = p.right;
      } else {
        f.right = p.right;
      }
    } //4.p has both child
    else if (p.left != null && p.right != null) {
      //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
      //cua con trai cua p
      q = p.left;
      f = null;
      while (q.right != null) {
        f = q;
        q = q.right;
      }
      p.info = q.info;
      //delete q
      if (f == null) {
        p.left = q.left;
      } else {
        f.right = q.left;
      }
    }
  }

  void breadth2(Node p, RandomAccessFile f) throws Exception {
    int maxDepth = 0;
    int count = 0;
    Node tmp = p;
    if (p == null) {
      return;
    }
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      if (r.left != null) {
        count++;
        if (count == 2) {
          tmp = r;
          break;
        }
      }
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }
    breadth3(findNode(tmp.info.depth), f);
  }

  void breadth3(Node p, RandomAccessFile f) throws Exception {
    int maxDepth = 0;
    int count = 0;
    Node tmp;
    if (p == null) {
      return;
    }
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      if (r.info.depth > maxDepth) {
        maxDepth = r.info.depth;
      }
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }
    deleteByCopy(maxDepth);
  }

  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    breadth2(root, f);
    //------------------------------------------------------------------------------------
    breadth(root, f);
    f.writeBytes("\r\n");
    f.close();
  }

  //=============================================================
  Node getParent(Node p) {
    if (p == null) {
      return null;
    }
    if (p == root) {
      return null;
    }
    Node father = null, cur = root;

    while (cur != null && cur.info.depth != p.info.depth) {
      father = cur;

      if (cur.info.depth < p.info.depth) {
        cur = cur.right;
      } else {
        cur = cur.left;
      }
    }

    if (cur == null) { // khong tim thay p trong tree
      return null;
    }
    return father;
  }

  Node rotateRight(Node p) {
    if (p == null || p.left == null) {
      return null;
    }
    Node parent = getParent(p);
    Node child = p.left;
    p.left = child.right;
    child.right = p;

    if (parent == null) {
      root = child;
    } else {
      parent.left = child;
    }
    return child;
  }

  void breadth4(Node p, RandomAccessFile f) throws Exception {
    if (p == null) {
      return;
    }
    int count = 0;
    Node tmp = p;
    Queue q = new Queue();
    q.enqueue(p);
    Node r;
    while (!q.isEmpty()) {
      r = q.dequeue();
      if (r.left != null) {
        count++;
        if (count == 2) {
          tmp = r;
          break;
        }
      }
      if (r.left != null) {
        q.enqueue(r.left);
      }
      if (r.right != null) {
        q.enqueue(r.right);
      }
    }
    rotateRight(tmp);
  }

  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    breadth(root, f);
    f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
      Your task is to insert statements here, just after this comment,
      to complete the question in the exam paper.*/
    breadth4(root, f);
    //------------------------------------------------------------------------------------
    breadth(root, f);
    f.writeBytes("\r\n");
    f.close();
  }
}
