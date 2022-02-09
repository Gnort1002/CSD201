
package ReverseString;

public class Main {
    public static String rev(String a) {
        if (a.length() <= 1) return a;
        return rev(a.substring(1)) + a.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(rev("abcde"));
    }
}
