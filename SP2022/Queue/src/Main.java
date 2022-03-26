
public class Main {


    public static void main(String[] args) throws Exception {
        ArrayQueue aq = new ArrayQueue();
        
        aq.enQueue("String");
        aq.enQueue("is");
        aq.enQueue("in");
        aq.enQueue("a");
        aq.enQueue("queue");
        
        Object d = aq.deQueue();
        System.out.println(d);
        aq.traverse();        
    }
    
}
