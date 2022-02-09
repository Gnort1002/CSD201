package Person;

public class Person {
    int id, age;
    String name;
    Person next, pre;

    public Person() {
    }

    public Person(int id, String name, int age, Person next, Person pre) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.next = next;
        this.pre = pre;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.next = null;
        this.pre = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getNext() {
        return next;
    }

    public void setNext(Person next) {
        this.next = next;
    }

    public Person getPre() {
        return pre;
    }

    public void setPre(Person pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + name + ", " + age + ")";
    }    
}
