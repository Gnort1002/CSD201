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
    
    // f1: n???u t??n Car b???t ?????u b???ng ch??? B ho???c gi?? >100 th?? kh??ng l??m g??. Ng?????c l???i th?? add new car v??o cu???i c???a list.
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
    
    // f2: Add new Car(name, price) v??o list ??? v??? tr?? ph??a sau ph???n t??? ?????u ti??n c?? gi?? nh??? h??n value ???? cho
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
        
    // f3:  S???p x???p number ph???n t??? nguy??n t??? ?????u ti??n theo 3 thu???t to??n kh??c nhau
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
    
    // f4: S???p x???p gi?? i ph???n t??? ?????u ti??n theo gi?? t??ng d???n 
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
    
    // f5: X??a b??? ph???n t??? Car th??? i trong list m?? c?? gi?? l?? s??? nguy??n t???: 
    public void deletePrime(int number) { // number: s??? nguy??n t??? th??? i trong d??y
        Car cur = head;
        int count = 0; // ?????m s??? l?????ng s??? nguy??n t???
        int pos = 1; // v??? tr?? c???a node
        while (cur.next != null && count < number) {
            if (isPrime(cur.price)) {
                ++count;
                if (count == number) {
                    deleteIndex(pos);
                    break;
                } 
            }           
            cur = cur.next; // ch???y ti???p d??y n???u kh??ng ph???i snt
            pos++;
        }
    }
    
    // f6: X??a b??? t??t c??? ph???n t??? Car trong list m?? c?? gi?? l?? s??? nguy??n t???: 
    public ArrayList<Car> deleteAllPrime() { // l??u c??c gi?? tr??? kh??ng ph???i snt v??o array m???i
        Car cur = head;
        ArrayList<Car> ar = new ArrayList<>();
        while (cur != null) {
            if (!isPrime(cur.price)) ar.add(cur);
            cur = cur.next;
        }
        return ar;
    }
          
    // f7: x??a b??? Car c?? gi??  l?? max r???i ????a Car c?? gi?? max ???? l??n ?????u (ho???c cu???i c??ng) c???a list
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
        Car maxi = get(max_pos); // l???y ra ph???n t??? max
        deleteIndex(max_pos); // xo?? ph???n t??? max kh???i d??y       
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
