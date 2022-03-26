package Person_string;

import Person_int.*;

public class Node {
    Person info;
    Node left;
    Node right;
    
    public Node(){
        
    }
    
    public Node(int key, String name, int age){
        this.info.key = key;
        this.info.name = name;
        this.info.age = age;
        this.left = null;
        this.right = null;
    }
    
    public Node(Person info, Node left, Node right){
        this.info = info;
        this.left = left;
        this.right = right;        
    }
    
    public Node(Person info){
        this.info = info;
        this.left = null;
        this.right = null;        
    }    

}
