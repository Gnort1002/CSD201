
package Person_string;


public class Test {
    public static void main(String[] args) throws Exception {
        MyTree mytree = new MyTree();
        Person[] arr = {new Person(1, "Minh", 20), new Person(1, "Chi", 21), new Person(1, "Tung", 19), new Person(1, "Binh", 18), 
                        new Person(1, "Long", 10), new Person(1, "Lam", 30), new Person(1, "An", 27), new Person(1, "Trong", 16),
                        new Person(1, "Sy", 23), new Person(1, "Viet", 11), new Person(1, "Uyen", 32), new Person(1, "Ha", 40)};
        mytree.insertFromArray(arr);
        mytree.BreathFirstOrder();
        mytree.dele(mytree.root.info.name);
        mytree.BreathFirstOrder();
    }
}
