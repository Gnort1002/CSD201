package Person;

import java.util.ArrayList;
import java.util.Collections;

public class MyPL {
    private Person head, tail;
    private int size;

    public MyPL() {
        head = tail = null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void addFirst(int id, String name, int age) {
        Person n = new Person(id, name, age);
        if (isEmpty()) head = tail = n;
        else {
            head.pre = n;
            n.next = head;
            head = n;
        }
        ++size;
    }
    
    public void addFirst(Person p) {
        addFirst(p.id, p.name, p.age);
    }
    
    public void addLast(int id, String name, int age) {
        Person n = new Person(id, name, age);
        if (isEmpty()) head = tail = n;
        else {
            tail.next = n;
            n.pre = tail;
            tail = n;
        }
        ++size;
    }
    
    public void addLast(Person p) {
        addLast(p.id, p.name, p.age);
    }
    
    // Add after the i-th index
    public void addIndex(int index, int id, String name, int age) {
        Person cur;
        Person n = new Person(id, name, age);
        if (index <= 0) {
            addFirst(id, name, age);
            return;
        }
        if (index >= size) {
            addLast(id, name, age);
            return;
        }
        if (index <= size/2) {
            cur = head;
            for (int i = 1; i < index; i++) {
                cur = cur.next;
            }
            n.next = cur.next;
            cur.next.pre = n;
            n.pre = cur;
            cur.next = n;            
        }
        else {
            cur = tail;
            for (int i = 1; i < size-index; i++) {
                cur = cur.pre;
            }
            n.next = cur;
            n.pre = cur.pre;
            cur.pre.next = n;
            cur.pre = n;
        }
        ++size;
    }
    
    public void addIndex(int index, Person p) {
        addIndex(index, p.id, p.name, p.age);
    }
    
    public void deleteFirst() {
        if (isEmpty()) return;
        head = head.next;
        head.pre = null;
        --size;
    }
    
    public void deleteLast() {
        if (isEmpty()) return;
        tail = tail.pre;
        tail.next = null;
        --size;
    }
    
    // Delete the i-th index
    public void deleteIndex(int index) {
        Person cur;
        if (index <= 1) {
            deleteFirst();
            return;
        }
        if (index >= size) {
            deleteLast();
            return;
        }
        if (index <= size/2) {
            cur = head;
            for (int i = 1; i < index-1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            cur.next.pre = cur;
        }
        else {
            cur = tail;
            for (int i = 1; i < size-index; i++) {
                cur = cur.pre;
            }
            cur.pre = cur.pre.pre;
            cur.pre.next = cur;
        }
        --size;
    }
    
    public void display() {
        if (isEmpty()) return;
        Person cur = head;
        while (cur != null) {
            if (cur.next != null) System.out.print(cur + ", ");
            else System.out.println(cur);
            cur = cur.next;
        }
    }
    
    // a.
    public void addFirstwithCon(int id, String name, int age) {
        if ("aeiou".contains((name.charAt(0) + "").toLowerCase())) return;
        addFirst(id, name, age);
    }
    
    // b.
    public void deleteAllVowel() {
        Person cur = head; char s;
        if (isEmpty()) return;
        while (cur != null) {
            s = cur.name.charAt(cur.name.length()-1);
            if (Character.isAlphabetic(s) && !"aeiou".contains((s + "").toLowerCase())) {
                if (cur == head) deleteFirst();
                else if (cur.next == null) deleteLast();
                else {
                    cur = cur.pre;
                    cur.next = cur.next.next;
                    cur.next.pre = cur;
                }
            }
            cur = cur.next;
        }
    }
    
    // c.
    public ArrayList sort() {
        if (isEmpty()) return null;
        ArrayList<Person> ar = new ArrayList<>();
        Person cur = head;
        while (cur != null) {
            ar.add(cur);
            cur = cur.next;
        }
        Collections.sort(ar, (Person o1, Person o2) -> {
            if (o1.name.equals(o2.name)) return o1.id - o2.id;
            return o1.name.compareTo(o2.name);
        });
        return ar;
    }
    
    // d.
    public Person findanddelete() {
        if (isEmpty()) return null;
        Person cur = head, p = null;
        int pos = 1, max_age = cur.age, max_pos = 1;
        while (cur != null) {
            if (cur.age > max_age) {
                max_age = cur.age;
                max_pos = pos;
                p = cur;
            }
            ++pos;
            cur = cur.next;
        }
        deleteIndex(max_pos);
        return p;
    }
    
    // e.
    public double averageAge() {
        if (isEmpty()) return 0;
        int sum = 0;
        Person cur = head;
        while (cur != null) {
            sum += cur.age;
            cur = cur.next;
        }
        return sum * 1.0 / size;
    }
}
