package DoublyLL;


public class Main {
    public static void main(String[] args) {
        MyDBList my = new MyDBList();
        for (int i = 5; i < 10; i++) {
            my.addLast(i);
        }
        for (int i = 4; i >= 1; i--) {
            my.addFirst(i);
        }
        my.display();
    }
}
