import java.util.*;
class Node
  { public Object info;
    public Node  next;
    public Node(Object x, Node p)
      { info=x; next=p; }
    public Node(Object x)
      { this(x,null); }
  };

class MyStack{
    protected Node head;

    public MyStack() 
      { head = null; }

    public boolean isEmpty(){ return(head==null);}

    public void push(Object x){ head = new Node(x,head);}

    Object top() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        return(head.info);
      }

    public Object pop() throws EmptyStackException
      { if(isEmpty()) throw new EmptyStackException();
        Object x = head.info;
        head=head.next;
         return(x);
      }

    public void traversal()
      { System.out.println("Elements in the list are:");
        for(Node p=head;p!=null;p=p.next) System.out.print(p.info + "  ");
        System.out.println();
      }
}
