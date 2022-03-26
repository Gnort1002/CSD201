package Car;

public class Node {
    Car info;
    Node left;
    Node right;
    
    public Node(){
        
    }

    public Node(String id, int price){
        this.info.id = id;
        this.info.price = price;
        this.left = null;
        this.right = null;
    }    
    
    public Node(Car info, Node left, Node right){
        this.info = info;
        this.left = left;
        this.right = right;        
    }    
    
    public Node(Car info){
        this.info = info;
        this.left = null;
        this.right = null;        
    }      

    @Override
    public String toString() {
        return  info.toString();
    }
    
    
}
