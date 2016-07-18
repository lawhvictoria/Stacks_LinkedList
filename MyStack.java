import java.util.EmptyStackException;

/**
 *
 * @author Victoria
 * vhlaw@calpoly.edu
 * January 21, 2016
 * Project 1
 */
public class MyStack<T> {
    private Node front;
    
    private class Node{
        private T item;
        private Node next;
        
        public Node(T item, Node next)
        {
            this.item = item;
            this.next = next;
        }
    }
    
    public MyStack()
    {
        front = null;
    }
    
    public void push(T item)
    {
        Node n = new Node(item, front);
        front = n;
    }
    
    public T pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        
        T old = front.item;
        front = front.next;
        return old;
    }
    
    public T peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
            return front.item;        
    }
    
    public boolean isEmpty()
    {
        return front == null;
    }
}
