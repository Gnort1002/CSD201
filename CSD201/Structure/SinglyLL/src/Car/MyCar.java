package Car;

import java.util.ArrayList;

public class MyCar {
    
    private Car head, tail;
    private int size;
    
    public MyCar() {
        head = tail = null;
        size = 0;
    }
    
    private boolean isEmpty() {
        return head == null;
    }
    
    public void display() {
        if (isEmpty()) return;
        Car cur = head;
        while (cur != null) {
            if (cur.next == null) System.out.print(cur);
            else System.out.print(cur + ", ");
            cur = cur.next;
        }
        System.out.println();
    }
    
    public void addLast(String name, int price) {
        Car c = new Car(name, price);
        if (head == null) {
            head = tail = c;
        }
        else {
            tail.next = c;
            tail = c;
        }
        ++size;
    }
    
    public void addFirst(String name, int value) {
	Car node = new Car(name, value);
	if (isEmpty()) {
            head = tail = node;
	}
	else {
            node.next = head;
            head = node;
	}
	size++;
    }

    // Add node after a specific node
    public void addIndex(String name, int value, int index) {
	if (index <= 0) {
            addFirst(name, value);
            return;
	}
	if (index >= size) {
            addLast(name, value);
            return;
	}
	int count = 0;
	Car cur = head;
	while (cur != null && count != index-1) {
            count++;
            cur = cur.next;
	}
	if (cur == null) {}
        else {
            Car node = new Car(name, value);
            node.next = cur.next;
            cur.next = node;
            size++;
	}
    }
    
    public void deleteFirst() {
        if (isEmpty()) return;
        if (size == 1) {
            head = tail = null;
        }
        else {
            head = head.next;
        }
    }
    
    public void deleteLast() {
        if (isEmpty()) return;
        if (size == 1) {
            head = tail = null;
        }
        else {
            Car cur = head;
            while (cur.next.next != null)
                cur = cur.next;
            tail = cur;
            tail.next = null;
        }
    }
    
    public void deleteIndex(int index) {
        if (index <= 1) {
            deleteFirst();
	}
        else if (index >= size) {
            deleteLast();
	}
        else {
            int count = 1;
            Car cur = head;
            while (cur.next != null && count != index-1) {
                count++;
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }	
    }
    
    // f1: nếu tên Car bắt đầu bằng chữ B hoặc giá >100 thì không làm gì. Ngược lại thì add new car vào cuối của list.
    public void addLastwithCon(String name, int price) {
        Car c = new Car(name, price);
        if (c.getName().startsWith("B") || c.getPrice() > 100) return;
        if (head == null) {
            head = tail = c;
        }
        else {
            tail.next = c;
            tail = c;
        }
        ++size;
    }
    
    // f2: Add new Car(name, price) vào list ở vị trí phía sau phần tử đầu tiên có giá nhỏ hơn value đã cho
    public void addIndexwithCon(String name, int price, int value) {
        if (isEmpty()) return;
        
        Car cur = head;
        Car c = new Car(name, price);
        
        while (cur.getPrice() > value && cur.next != null) {
            cur = cur.next; 
        }
        
        if (cur.getPrice() > value) return;
        c.next = cur.next;
        cur.next = c;
        ++size;
    }
        
    // f3:  Sắp xếp number phần tử nguyên tố đầu tiên theo 3 thuật toán khác nhau
    public ArrayList<Integer> findPrimePos(int number) { 
        ArrayList<Integer> arr = new ArrayList();
        Car cur = head;
        int count = 0;
        int pos = 1;
        while (cur != null && count < number) {
            if (isPrime(cur.price)) {
                arr.add(pos);
                count++;
            }
            cur = cur.next;
            pos++;
        }
        return arr;
    }
    
    // Get value of all prime number
    public ArrayList<Car> findPrimePrice(int number) { 
        ArrayList<Car> arr = new ArrayList();
        Car cur = head;
        int count = 0;
        while (cur != null && count < number) {
            if (isPrime(cur.price)) {
                arr.add(cur);
                count++;
            }
            cur = cur.next;
        }
        return arr;
    }
    
    // check prime number
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    
    // f4: Sắp xếp giá i phần tử đầu tiên theo giá tăng dần 
    public ArrayList<Car> findFirst(int number) {
        if (number > size) number = size;
        
        ArrayList<Car> arr = new ArrayList();
        Car cur = head;
        int count = 0;
        while (cur.next != null && count < number) {
            arr.add(cur);
            count++;
            cur = cur.next;
        }
        return arr;
    }
    
    // f5: Xóa bỏ phần tử Car thứ i trong list mà có giá là số nguyên tố: 
    public void deletePrime(int number) { // number: số nguyên tố thứ i trong dãy
        Car cur = head;
        int count = 0; // đếm số lượng số nguyên tố
        int pos = 1; // vị trí của node
        while (cur.next != null && count < number) {
            if (isPrime(cur.price)) {
                ++count;
                if (count == number) {
                    deleteIndex(pos);
                    break;
                } 
            }           
            cur = cur.next; // chạy tiếp dãy nếu không phải snt
            pos++;
        }
    }
    
    // f6: Xóa bỏ tât cả phần tử Car trong list mà có giá là số nguyên tố: 
    public ArrayList<Car> deleteAllPrime() { // lưu các giá trị không phải snt vào array mới
        Car cur = head;
        ArrayList<Car> ar = new ArrayList<>();
        while (cur != null) {
            if (!isPrime(cur.price)) ar.add(cur);
            cur = cur.next;
        }
        return ar;
    }
          
    // f7: xóa bỏ Car có giá  là max rồi Đưa Car có giá max đó lên đầu (hoặc cuối cùng) của list
    public Car deleteMaxPrice() {
        int pos = 1, max_pos = 1, max_price = -999;
        Car cur = head;
        while (cur != null) {
            if (max_price == -999) {
                max_pos = pos;
                max_price = cur.price;
            }
            else if (max_price < cur.price) {
                max_pos = pos;
                max_price = cur.price;
            }
            pos++;
            cur = cur.next;
        }
        Car maxi = get(max_pos); // lấy ra phần tử max
        deleteIndex(max_pos); // xoá phần tử max khỏi dãy       
        return maxi;
    }   
        
    // Replace index with a new Car object
    public void replaceIndex(int index, String name, int price) {  
        deleteIndex(index);
        addIndex(name, price, index-1);
    }
    
    // Get Car by index
    public Car get(int index) {
        if (isEmpty() || index < 1) return null;
        int pos = 1;
        Car cur = head;
        while (cur.next != null) {
            if (pos == index) return cur;
            else {
                ++pos;
                cur = cur.next;
            }
        }
        return null;
    }
}
