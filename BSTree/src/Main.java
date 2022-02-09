
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
        myTree.dele(15);
        myTree.BreathFirstOrder();        
//        System.out.println(myTree.sum());
//        System.out.println(myTree.max());
//        System.out.println(myTree.height(myTree.search(12)));
//        System.out.println(myTree.isBalanced(myTree.root));
//        System.out.println(myTree.findMaxSumPath());
//        myTree2.balance(myTree.getArrayFromTree());
//        myTree2.BreathFirstOrder();
//        System.out.println(myTree2.isBalanced(myTree2.root));
//        System.out.println(myTree2.findMaxSumPath());
//        System.out.println(myTree.findMaxPath(myTree2.root));
    }   
}
