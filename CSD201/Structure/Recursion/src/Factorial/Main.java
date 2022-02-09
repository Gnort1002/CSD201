
package Factorial;

public class Main {
    public static long Fac(long n) {
        if (n <= 1) return 1;
        return n*Fac(n-1);
    }
    
    public static void main(String[] args) {
        System.out.println(Fac(14));
    }
}
