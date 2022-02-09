package Car;

public class Car implements Comparable{
    protected String name;
    protected int price;
    protected Car next;

    public Car() {
    }

    public Car(String name, int price, Car next) {
        this.name = name;
        this.price = price;
        this.next = next;
    }
        
    public Car(String name, int price) {
        this.name = name;
        this.price = price;
        this.next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Car getNext() {
        return next;
    }

    public void setNext(Car next) {
        this.next = next;
    }
     
    @Override
    public String toString() {
        return "(" + name + "," + price + ")";
    }

    @Override
    public int compareTo(Object o) {
        return price - ((Car)o).price;
    }
}