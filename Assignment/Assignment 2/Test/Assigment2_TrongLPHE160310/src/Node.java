public class Node {
    Song info;
    Node left;
    Node right;
    
    public Node(){
        
    }

    public Node(String id, String name, int rating){
        this.info.id = id;
        this.info.name = name;
        this.info.rating = rating;
        this.left = null;
        this.right = null;
    }    
    
    public Node(Song info, Node left, Node right){
        this.info = info;
        this.left = left;
        this.right = right;        
    }    
    
    public Node(Song info){
        this.info = info;
        this.left = null;
        this.right = null;        
    }      

    @Override
    public String toString() {
        return  info.toString();
    }
    
    
}
