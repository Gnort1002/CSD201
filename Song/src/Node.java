public class Node {
    Song info;
    Node next;
    Node(){}
    Node(String name, String artist, int rated){
        info.name = name;
        info.artist = artist;
        info.rated = rated;
    }
    Node(String name, String artist, int rated, Node p){
        info.name = name;
        info.artist = artist;
        info.rated = rated;
        next = p;
    }
    
    Node(Song s){
        info = s;
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

