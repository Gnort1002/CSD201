public class Main {


    public static void main(String[] args) {
        MyList list = new MyList();
        MyDoubleList list2 = new MyDoubleList();
        if (list.isEmpty()) System.out.println("List is empty. Please create a new node!");
        list.addToHead(45);
        list.addToHead(13);
        list.addToHead(10);
        list.addToHead(66);
        list.addToTail(77);
        list.addToTail(33);
        list.addToHead(55);
        list.addAfter(list.search(77), 99);
        list.traverse();
        list.deleteAfter(list.search(45));
        list.traverse();
        list.addAfter(list.search(33), 77);
        list.traverse();
        System.out.println("The number of elements in list: "+ list.count());
        System.out.println("Avg: " + list.avg());
        System.out.println("Sum: " + list.sum());
        System.out.println("Is sorted?: " + list.sorted());
        System.out.println("Max: " + list.max());
        System.out.println("Min: " + list.min());
        if (list.search(4) == null) System.out.println("Node does not exist!");
        System.out.println("Node has info 10: " + list.search(10).display());
        System.out.print("Unsorted list: "); list.traverse();
        list.sort();
        System.out.print("Sorted list: ");
        list.traverse();
        System.out.println("Delete the node has index 2 in list: ");
        list.deleBaseOnIndex(2);
        list.traverse();
        list.deleteFromTail();
        list.deleteFromHead();
        list.dele(list.search(99));
        list.traverse();
        System.out.println("Delete node has info (44) in list");
        list.deleBaseOnInfo(44);
        list.traverse();
        System.out.println("Delete node has info (45) in list");
        list.deleBaseOnInfo(45);
        list.traverse();
        System.out.println("Reverse the list: ");
        list.reverse2();
        list.traverse();
    }
    
}
