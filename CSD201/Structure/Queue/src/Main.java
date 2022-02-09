
public class Main {

    public static void main(String[] args) throws Exception {
        ArrayQueue aq = new ArrayQueue();
        PriorityQueue pq = new PriorityQueue();
        
        aq.enQueue(2);
        aq.enQueue(3);
        aq.enQueue(4);
        aq.enQueue(5);
        aq.enQueue(6);
        aq.enQueue(7);
        
        pq.enQueue(7);
        pq.enQueue(8);
        pq.enQueue(0);
        pq.enQueue(1);
        pq.enQueue(2);
        
        Object d = pq.deQueue();
        System.out.println(d);
        pq.display();
        
        Object f = pq.front();
        System.out.println(f);
        pq.display();
    }
    
}
