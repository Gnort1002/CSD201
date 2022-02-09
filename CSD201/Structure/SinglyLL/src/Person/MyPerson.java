package Person;

import java.util.ArrayList;
import java.util.Collections;

public class MyPerson {
    private Person head, tail;
    private int size;
    
    public MyPerson() {
        head = tail = null;
        size = 0;
    }
    
    private boolean isEmpty() {
        return head == null;
    }
    
    public void display() {
        if (isEmpty()) return;
        Person cur = head;
        while (cur != null) {
            if (cur.next == null) System.out.print(cur);
            else System.out.print(cur + ", ");
            cur = cur.next;
        }
        System.out.println();
    }
    
    public void addLast(int id, String name, int age) {
        Person c = new Person(id, name, age);
        if (head == null) {
            head = tail = c;
        }
        else {
            tail.next = c;
            tail = c;
        }
        ++size;
    }
    
    public void addFirst(int id, String name, int age) {
	Person node = new Person(id, name, age);
	if (isEmpty()) {
            head = tail = node;
	}
	else {
            node.next = head;
            head = node;
	}
	size++;
    }
    
    public void addFirst(Person p) {
        addFirst(p.id, p.name, p.age);
    }

    public void addLast(Person p) {
        addLast(p.id, p.name, p.age);
    }

    // Add node after a specific node
    public void addIndex(int index, int id, String name, int age) {
	if (index <= 0) {
            addFirst(id, name, age);
            return;
	}
	if (index >= size) {
            addLast(id, name, age);
            return;
	}
	int count = 0;
	Person cur = head;
	while (cur != null && count != index-1) {
            count++;
            cur = cur.next;
	}
	if (cur == null) {}
        else {
            Person node = new Person();
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
            Person cur = head;
            while (cur.next.next != null)
                cur = cur.next;
            tail = cur;
            tail.next = null;
        }
    }
    
    // Delete the i-th index
    public void deleteIndex(int index) {
        if (index <= 1) {
            deleteFirst();
	}
        else if (index >= size) {
            deleteLast();
	}
        else {
            int count = 1;
            Person cur = head;
            while (cur.next != null && count != index-1) {
                cur = cur.next;
                count++;
            }
            cur.next = cur.next.next;
        }	
    }
    
    // a.
    public void addFirstwithCon(int id, String name, int age) {
        if (isEmpty()) return;
        if ("aeiou".contains((name.charAt(0) + "").toLowerCase())) return;
        addFirst(id, name, age);
    }
    
    // b.
    public void deleteAllVowel() {
        Person cur = head;
        int pos = 1;
        char s;
        while (cur != null) {
            s = cur.name.charAt(cur.name.length()-1);
            if (Character.isAlphabetic(s) && !"aeiou".contains((s + "").toLowerCase())) {
                cur = cur.next;
                deleteIndex(pos);
            }
            else {
                cur = cur.next;
                ++pos;
            }
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
        Collections.sort(ar);
        return ar;
    }
    
    // d.
    public Person findAndDelete() {
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
