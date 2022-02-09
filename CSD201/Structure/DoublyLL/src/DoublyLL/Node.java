package DoublyLL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ratty
 */
public class Node {
    int value;
    Node next, pre;

    public Node() {
    }

    public Node(int value, Node next, Node pre) {
        this.value = value;
        this.next = next;
        this.pre = pre;
    }

    public Node(int value) {
        this.value = value;
        next = pre = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }
    
    @Override
    public String toString() {
        return "(" + value + ")";
    }
    
}
