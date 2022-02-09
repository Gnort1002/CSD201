
package Tree;

public class Main {

    public static void main(String[] args) {
        MyTree my = new MyTree();
        my.add(30);
        my.add(15);
        my.add(31);
        my.add(11);
        my.add(16);
        my.add(41);
        my.add(9);
        my.add(12);
        my.add(40);
        Node p = my.findNode(30);
        my.deleteByMerging(p);
        my.preOrder();
        
    }
}
