package Person_string;

import Person_int.*;

public class Person {
    int key;
    String name;
    int age;
    
    public Person(int key, String name, int age){
        this.key = key;
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return "("+name + ", " + age + ")" + " ";
    }
}
