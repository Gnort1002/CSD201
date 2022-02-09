package Car;

import java.util.ArrayList;
import java.util.Collections;

public class Main {    
    
    // Display ArrayList
    public static void display(ArrayList arr) {
        for (int i = 0; i < arr.size(); i++) {
            if (i < arr.size() - 1) System.out.print(arr.get(i) + ", ");
            else System.out.println(arr.get(i));
        }
    }
    
    public static ArrayList SelectionSort(ArrayList<Car> arr) {
        int min;
        for (int i = 0; i < arr.size() - 1; i++) {
            min = i;
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(j).getPrice() < arr.get(min).getPrice()) min = j;
            }
            Collections.swap(arr, min, i);
        }
        return arr;
    }
    
    public static ArrayList InsertionSort(ArrayList<Car> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = arr.size()-1; j > i; j--) {
                if (arr.get(j).getPrice() < arr.get(j-1).getPrice()) Collections.swap(arr, j, j-1);
            }
        }
        return arr;
    }
    
    public static ArrayList InterchangeSort(ArrayList<Car> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(j).getPrice() < arr.get(i).getPrice()) Collections.swap(arr, i, j);
            }
        }
        return arr;
    }
    
    public static void main(String[] args) {
        MyCar my = new MyCar();

        my.addLast("A", 20);
        my.addLast("C", 19);
        my.addLast("D", 30);
        my.addLast("F", 23);
        my.addLast("E", 25);
        my.addLast("Hung", 3);
        my.display();
        
        // f1: nếu tên Car bắt đầu bằng chữ B hoặc giá > 100 thì không làm gì.
        // Ngược lại thì add new car vào cuối của list.
//        my.addLastwithCon("B", 10);
//        my.addLastwithCon("C", 200);
//        my.addLastwithCon("Hung", 50);
//        my.display();
        
        // f2: Add new Car(name, price) vào list ở vị trí phía sau phần tử đầu tiên
        // có giá nhỏ hơn value đã cho
//        my.addIndexwithCon("F", 30, 16);
//        my.display();
        
        // f3: Sắp xếp number phần tử nguyên tố đầu tiên theo 3 thuật toán khác nhau
//        ArrayList<Integer> a1 = my.findPrimePos(3);
//        ArrayList<Car> a2 = my.findPrimePrice(3);
//        // Sorts
//        a2 = SelectionSort(a2);
//        //a2 = InsertionSort(a2);
//        //a2 = InterchangeSort(a2);
//        // Replace
//        for (int i = 0; i < a1.size(); i++) {
//            my.replaceIndex(a1.get(i), a2.get(i).getName(), a2.get(i).getPrice());
//        }
//        my.display();
               
        // f4 sắp xếp i phần tử ban đầu (i = 4)
//        ArrayList<Car> ar = my.findFirst(4); // tạo arraylist gồm 4 phần tử cần sx
//        Collections.sort(ar); // sx trong arraylist
//        for (int i = 0; i < ar.size(); i++) { // trả lại các phần tử đã sx vào linked list
//            my.replaceIndex(i+1, ar.get(i).getName(), ar.get(i).getPrice());
//        }
//        my.display();

        // f5 xoá phần tử Car thứ i (i = 2) có giá là số nguyên tố
//        my.deletePrime(2); // sẽ xoá số nguyên tố thứ 2 là (F, 23)
//        my.display();

        // f6 xoá tất cả các phần tử là snt
//        ArrayList<Car> ar1 = my.deleteAllPrime();
//        display(ar1);

        // f7 xoá phần tử có giá trị max rồi addFirst, addLast
//        Car maxi = my.deleteMaxPrice();
//        my.display();
//        my.addFirst(maxi.getName(), maxi.getPrice()); // lên đầu
//        my.display();
//        my.deleteFirst();
//        my.addLast(maxi.getName(), maxi.getPrice()); // xuống cuối
//        my.display();
    }   
}
