
package Convert;

public class Main {
    
    public static String change(int n) {
        if (n < 10) return n + "";
        return (char)(n+55) + "";
    }
    
    public static String Decto(int n, int base) {
        if (n < base) return change(n);
        return Decto(n/base, base) + change(n%base);
    }
    
    public static void main(String[] args) {
        System.out.println(Decto(8, 2));
    }
}
