package Person;



public class Person implements Comparable<Person> {
    int id, age;
    String name;
    Person next;

    public Person() {
    }

    public Person(int id, String name, int age, Person next) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.next = next;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.next = null;
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

    @Override
    public String toString() {
        return "(" + id + ", " + name + ", " + age + ")";
    }

    @Override
    public int compareTo(Person o) {
        if (name.equals(o.name)) return id - o.id;
        return name.compareTo(o.name);
    }
}
