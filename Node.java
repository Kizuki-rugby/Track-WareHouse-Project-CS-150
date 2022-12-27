
/**
 * Node class that can be used for LinkedList. 
 * Generic class allow user to choose which type to excute. 
 *
 * @Kizuki Koyasu
 * @Ver.1
 */
public class Node<E>
{
    // instance variables - replace the example below with your own
    public Node<E> next;
    public E val;

    /**
     * Constructor for objects of class Node
     */
    public Node()
    {
        next = null;
        val = null;
    }

    public Node(E val){
        this.val = val;
        next = null;
    }
}
