
/**
 * Since the shipment loading unloading is Last-in, First-out fashion, 
 * we will be using Stack to load or unload between trucks and warehouses. 
 *
 * @author Kizuki Koyasu 
 * @version Ver.1
 */
public class Stack<E>
{
    Node head;
    public Stack(){
        head = null;
    }

    /**
     * Tests if stack is empty
     */
    public boolean empty(){
        if( head == null) return true;
        else{
            return false;
        }
    }

    /**
     * Looks at the object at the top of the stack without
    removing it.
     */
    public E peek(){
        if(head == null)return null;
        else if( head.next == null) return (E) head.val;
        else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next; 
            }
            return (E)curr.val;
        }
    }

    /**
     * Removes the object at the top of the stack and returns
    the object as the value of this function.
     */
    public E remove(){
        if(head == null)return null;
        else{
            Node curr = head;
            while( curr.next != null){
                curr = curr.next;
            }
            E result = (E)curr.val;
            curr = null;
            return result;
        }
    }

    /**
     * Pushes an item onto the top of the stack.
     */
    public E add(E item){
        if(head == null){ 
            head = new Node(item);
            return (E)head.val;
        }else{
            Node curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node(item);
            return (E)curr.next.val;
        }
    }

    /**
     * Returns the distance from the top of the
    stack of the occurrence that is nearest the 
    top of the stack. The topmost item is considered 
    to be at distance 1; the next item is at distance 2; etc.
     */
    public int search(Object o){
        if(head == null)return -1;
        else{
            int length = 1;
            int counter = 0;
            Node curr = head;
            while( curr.next != null){
                curr = curr.next;
                ++length;
            }
            curr = head;
            while(curr != null){
                if(o.equals(curr.val)){
                    return length - counter;
                }
                curr = curr.next;
                counter++;
            }
            return -1;
        }
    }
}
