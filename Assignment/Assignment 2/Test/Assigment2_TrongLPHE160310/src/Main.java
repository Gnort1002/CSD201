
public class Main {


    public static void main(String[] args) throws Exception {
        MyTree tree = new MyTree();
        System.out.println("Q1.");
        tree.f1();
        tree.BreathFirstOrder();
        System.out.println("Q2.");
        tree.f2();
        System.out.println("Q3.");
        tree.f3();
        System.out.println("Q4.");
        MyTree tree2 = new MyTree();
        tree2.balance(tree.getArrayFromTree());
        tree2.BreathFirstOrder();
        
    }
    
}
