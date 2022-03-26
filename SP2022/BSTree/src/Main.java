
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        MyTree myTree = new MyTree();
        MyTree myTree2 = new MyTree();
        int [] arr = {8, 5, 3, 15, 7, 6, 11, 20};        
        myTree.insertFromArray(arr);
        myTree.preOrder();
        myTree.inOrder();
        myTree.postOrder();
        myTree.BreathFirstOrder();
        myTree.dele(8);
        myTree.BreathFirstOrder();        
        System.out.println(myTree.sum());
        System.out.println(myTree.max());
        System.out.println(myTree.height(myTree.search(5)));
        System.out.println(myTree.isBalanced(myTree.root));
        System.out.println(myTree.findMaxSumPath());
        myTree2.balance(myTree.getArrayFromTree());
        myTree2.BreathFirstOrder();
        System.out.println(myTree2.isBalanced(myTree2.root));
        System.out.println(myTree2.findMaxSumPath());
//                  8                                   8
//              5       15     - 7RR + 5RL ->       6       15
//            3   7   11  20                      5   7
//               6                               3              
        myTree.rotateRight(myTree.search(7));        
        myTree.BreathFirstOrder();
        myTree.rotateLeft(myTree.search(5));
        myTree.BreathFirstOrder();
        //BT
        //Rotate:   
        //  - Duyet theo preOrder, tim node dau tien (khac root) co 2 con, xoay trai node nay
        //  - Duyet theo inOrder, tim node dau tien khac root co height < 3, xoay trai node
        //Xoa:
        //  - Duyệt preOrder/breadth/postOrder/inOrder, tìm node đầu tiên (khác root) có 2 con
        //  - Xoa node nay
//        Node q = new Node();
//        Node z = myTree.preOrderNode(myTree.root, q);
//        if (z == null) System.out.println("Can not find!");
//        else myTree.rotateLeft(z);
//        myTree.BreathFirstOrder();
        
    }   
}
