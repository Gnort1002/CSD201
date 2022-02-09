public class Node {
    int info;
    Node next, pre;
    Node(){}
    Node(int x){
        info = x;
    }
    Node(int x, Node p){
        info = x;
        next = p;
    }
    Node (int x, Node n, Node p ){
        info = x;
        next = n;
        pre = p;
    }
    
    String display(){
        return info + " ->" + next.info;
    }
}
