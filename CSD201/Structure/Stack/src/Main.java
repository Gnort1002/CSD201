
import java.util.Scanner;


public class Main {
    public static void decToBin(int k) throws Exception {
        if (k < 0) throw new Exception("Only accept non-negative integer.");
        if (k == 0) {
            System.out.println("0 in binary is: 0");
            return;
        }
        System.out.print(k + " in binary is: ");
        MyStack s = new MyStack();
        while (k > 0) {
            s.push(k % 2);
            k /= 2;
        }        
        while (!s.isEmpty()) {
            System.out.print(s.pop());
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = Integer.parseInt(sc.nextLine());
        decToBin(n);
    }
}
