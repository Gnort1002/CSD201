package Person;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    
    public static void display(ArrayList ar) {
        for (int i = 0; i < ar.size(); i++) {
            if (i < ar.size()-1) System.out.print(ar.get(i) + ", ");
            else System.out.println(ar.get(i));
        }
    }
    
    public static void main(String[] args) {
        MyPL my = new MyPL();
        Random rd = new Random();
        
        System.out.println("Current List:");
        my.addLast(4, "J", rd.nextInt(10)+18);
        my.addLast(5, "A", rd.nextInt(10)+18);
        my.addLast(6, "J", rd.nextInt(10)+18);
        my.addFirst(3, "P", rd.nextInt(10)+18);
        my.addFirst(2, "E", rd.nextInt(10)+18);
        my.addFirst(1, "P", rd.nextInt(10)+18);
        my.display();
        my.deleteLast();
        my.display();
        
//        System.out.println("After addFirst (0, Alpha, 15):");
//        my.addFirstwithCon(0, "Alpha", 15);
//        my.display();
        
//        System.out.println("After addFirst (0, Hung, 20):");
//        my.addFirstwithCon(0, "Hung", 20);
//        my.display();
        
//        System.out.println("After delete all node ends with a vowel:");
//        my.deleteAllVowel();
//        my.display();
        
//        System.out.println("After sorting (saved in an ArrayList):");
//        ArrayList ar = my.sort();
//        display(ar);
        
//        System.out.println("Find person with maximum age:");
//        Person p = my.findAndDelete();
//        System.out.println(p);
//        System.out.println("Add First:");
//        my.addFirst(p);
//        my.display();
//        System.out.println("Add Last:");
//        my.deleteFirst();
//        my.addLast(p);
//        my.display();
        
//        System.out.println("Average age:");
//        System.out.println(my.averageAge());
    }
}
