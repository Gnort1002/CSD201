
package Car;

public class Car {
    String owner;
    int value;
    Car left;
    Car right;

    public Car() {
    }

    public Car(String owner, int value, Car left, Car right) {
        this.owner = owner;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Car(String owner, int value) {
        this.owner = owner;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Car getLeft() {
        return left;
    }

    public void setLeft(Car left) {
        this.left = left;
    }

    public Car getRight() {
        return right;
    }

    public void setRight(Car right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + owner + ", " + value + ")";
    }
}
