public class Node {
    Person info;
    Node next;
    Node(){}
    Node(String name, int age){
        info.name = name;
        info.age = age;
    }
    Node(String name, int age, Node p){
        info.name = name;
        info.age = age;
        next = p;
    }
    
    Node(Person person){
        info = person;
        next = null;
    }
//    Node (int x, Node n, Node p ){
//        info = x;
//        next = n;
//        pre = p;
//    }
    
    String display(){
        return info + " -> " + next.info;
    }
}
