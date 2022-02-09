
package TowerOfHanoi;

public class Main {
    public static StringBuilder ToH(int ele, String head, String mid, String tail) {
        if (ele <= 1) return new StringBuilder(head).append(tail);
        if (ele == 2) return new StringBuilder(head).append(mid).append(", ").append(head).append(tail).append(", ").append(mid).append(tail);
        return new StringBuilder(ToH(ele-1, head, tail, mid)).append(", ").append(head).append(tail).append(", ").append(ToH(ele-1, mid, head, tail));
    }
    
    public static StringBuilder ToH(int ele) {
        return ToH(ele, "A", "C", "B");
    }
            
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            System.out.println(ToH(i));
        }        
    }
}
