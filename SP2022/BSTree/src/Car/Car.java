package Car;

public class Car {
    String id;
    int price;

    public Car() {
    }

    public Car(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "(" + id + "," + price + ")";
    }
    
    
}
