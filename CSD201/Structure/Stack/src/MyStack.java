
import java.util.ArrayList;

public class MyStack {
    ArrayList h;
    
    public MyStack() {
        h = new ArrayList();
    }
    
    public boolean isEmpty() {
        return h.isEmpty();
    }
    
    public void push(Object x) {
        h.add(x);
    }
    
    public Object pop() {
        if (isEmpty()) return null;
        return h.remove(h.size() - 1);
    }
}
