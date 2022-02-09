/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class MyList {

  Node head, tail;

  MyList() {
    head = tail = null;
  }

  boolean isEmpty() {
    return (head == null);
  }

  void clear() {
    head = tail = null;
  }

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if (p != null) {
      f.writeBytes(p.info + " ");
    }
  }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while (p != null) {
      fvisit(p, f); // You will use this statement to write information of the node p to the file
      p = p.next;
    }
    f.writeBytes("\r\n");
  }

  void loadData(int k) { //do not edit this function
    String[] a = Lib.readLineToStrArray("data.txt", k);
    int[] b = Lib.readLineToIntArray("data.txt", k + 1);
    int[] c = Lib.readLineToIntArray("data.txt", k + 2);
    int n = a.length;
    for (int i = 0; i < n; i++) {
      addLast(a[i], b[i], c[i]);
    }
  }

  //===========================================================================
  //(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
  /* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
  void addLast(String xPlace, int xDepth, int xType) {
    //You should write here appropriate statements to complete this function.
    if (xPlace.charAt(0) == 'A') {
      return;
    }
    Node node = new Node(new Castor(xPlace, xDepth, xType));
    if (isEmpty()) {
      head = tail = node;
    }
    tail.next = node;
    tail = node;
  }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
    clear();
    loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    f.close();
  }

  //==================================================================
  void f2() throws Exception {
    clear();
    loadData(5);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    Castor x, y;
    x = new Castor("X", 1, 2);
    y = new Castor("Y", 3, 4);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node node = new Node(y);
    if (isEmpty()) {
      head = tail = node;
      return;
    }
    int count = 0;
    node.next = head;
    head = node;
    Node node1 = new Node(x);
    Node cur = head;
    for (int i = 0; i < 3 - 1; i++) {
      cur = cur.next;
    }
    node1.next = cur.next;
    cur.next = node1;
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node cur = head;
    int max = 0;
    while (cur != null) {
      if (cur.info.type > max) {
        max = cur.info.type;
      }
      cur = cur.next;
    }
    cur = head;
    while (cur != null) {
      if (cur.info.type == max) {
        cur.info.place = "YY";
        break;
      }
      cur = cur.next;
    }
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }

  //==================================================================
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if (g123.exists()) {
      g123.delete();
    }
    RandomAccessFile f = new RandomAccessFile(fname, "rw");
    ftraverse(f);
    //------------------------------------------------------------------------------------
    /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node cur1 = head, cur2 = head;
    Node pre;
    int index = 0;
    Castor tmp;
    for (int i = 0; cur1 != null; cur1 = cur1.next, i++) {
      cur2 = head;
      for (int j = 0; cur2.next != null; cur2 = cur2.next, j++) {
        if (cur2.info.type > cur2.next.info.type && j >= 2 && j < 5) {
          tmp = cur2.info;
          cur2.info = cur2.next.info;
          cur2.next.info = tmp;
        }
      }
      index++;
    }
    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
  }
}
